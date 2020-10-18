package com.htdatlichkbbv.datlichkb.entities;

import java.sql.*;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

import javax.validation.constraints.NotNull;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.htdatlichkbbv.datlichkb.entities.Chitietdichvu;
import org.hibernate.annotations.Nationalized;

@Entity(name = "Dichvu")
@Table(name = "dichvu")
@NamedQueries({
        @NamedQuery(name = Dichvu.FIND_ALL, query = "SELECT a FROM Dichvu a")
        , @NamedQuery(name = Dichvu.FIND_BY_TENDV, query = "SELECT a FROM Dichvu a WHERE a.tendv = :tendv")
        , @NamedQuery(name = Dichvu.FIND_BY_TENDV_CONTAINING, query = "SELECT a FROM Dichvu a WHERE a.tendv like :tendv")
        , @NamedQuery(name = Dichvu.FIND_BY_DONGIA, query = "SELECT a FROM Dichvu a WHERE a.dongia = :dongia")
})

public class Dichvu implements Serializable {
    public static final String FIND_ALL = "Dichvu.findAll";
    public static final String FIND_BY_TENDV = "Dichvu.findByTendv";
    public static final String FIND_BY_TENDV_CONTAINING = "Dichvu.findByTendvContaining";
    public static final String FIND_BY_DONGIA = "Dichvu.findByDongia";
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "MaDV", length = 10)
    private String madv;

    @Column(name = "TenDV", length = 500, nullable = false, unique = false)
    @Nationalized
    private String tendv;

    @Column(name = "DonGia", precision = 8, scale = 2, nullable = false, unique = false)
    private java.math.BigDecimal dongia;

    @JsonIgnore
    @ManyToOne (fetch=FetchType.LAZY )
    @JoinColumn(name="MaBS", referencedColumnName = "MaBS" ,
            nullable=true , unique=false , insertable=false, updatable=false)
    private Bacsi mabs;

    @Column(name="MaBS" , length=10 ,
            nullable=true , unique=false, insertable=true, updatable=true)
    private String mabs_;

    /**
     * Default constructor
     */
    public Dichvu() {
    }

    /**
     * All field constructor
     */
    public Dichvu(
            String madv,
            String tendv,
            java.math.BigDecimal dongia,
            String mabs) {
        this(
                madv,
                tendv,
                dongia,
                mabs
                ,true);
    }

    public Dichvu(
            String madv,
            String tendv,
            java.math.BigDecimal dongia,
            String mabs
            , boolean setRelationship) {
        //primary keys
        setMadv (madv);
        //attributes
        setTendv (tendv);
        setDongia (dongia);
        //parents
        if (setRelationship && mabs!=null) {
            this.mabs = new Bacsi();
            this.mabs.setMabs(mabs);
            setMabs_ (mabs);
        }
    }

    public Dichvu flat() {
        return new Dichvu(
                getMadv(),
                getTendv(),
                getDongia(),
                getMabs_()
                , false
        );
    }

    public String getMadv() {
        return madv;
    }

    public void setMadv(String madv) {
        this.madv = madv;
    }

    public String getTendv() {
        return tendv;
    }

    public void setTendv(String tendv) {
        this.tendv = tendv;
    }

    public java.math.BigDecimal getDongia() {
        return dongia;
    }

    public void setDongia(java.math.BigDecimal dongia) {
        this.dongia = dongia;
    }

    public Bacsi getMabs () {
        return mabs;
    }

    public void setMabs (Bacsi mabs) {
        this.mabs = mabs;
    }

    public String getMabs_() {
        return mabs_;
    }

    public void setMabs_ (String mabs) {
        this.mabs_ =  mabs;
    }
}

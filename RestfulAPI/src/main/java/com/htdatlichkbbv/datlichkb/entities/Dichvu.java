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
    private String tendv;

    @Column(name = "DonGia", precision = 8, scale = 2, nullable = false, unique = false)
    private java.math.BigDecimal dongia;

    @JsonIgnore
    @OneToMany(targetEntity = com.htdatlichkbbv.datlichkb.entities.Chitietdichvu.class,
            fetch = FetchType.LAZY, mappedBy = "chitietdichvuId__.madv", cascade = CascadeType.REMOVE)
    private Set<Chitietdichvu> chitietdichvuDichvuViaMadv = new HashSet<Chitietdichvu>();

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
            java.math.BigDecimal dongia) {
        this(
                madv,
                tendv,
                dongia
                , true);
    }

    public Dichvu(
            String madv,
            String tendv,
            java.math.BigDecimal dongia
            , boolean setRelationship) {
        //primary keys
        setMadv(madv);
        //attributes
        setTendv(tendv);
        setDongia(dongia);
        //parents
    }

    public Dichvu flat() {
        return new Dichvu(
                getMadv(),
                getTendv(),
                getDongia()
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

    public Set<Chitietdichvu> getChitietdichvuDichvuViaMadv() {
        if (chitietdichvuDichvuViaMadv == null) {
            chitietdichvuDichvuViaMadv = new HashSet<Chitietdichvu>();
        }
        return chitietdichvuDichvuViaMadv;
    }

    public void setChitietdichvuDichvuViaMadv(Set<Chitietdichvu> chitietdichvuDichvuViaMadv) {
        this.chitietdichvuDichvuViaMadv = chitietdichvuDichvuViaMadv;
    }

    public void addChitietdichvuDichvuViaMadv(Chitietdichvu element) {
        getChitietdichvuDichvuViaMadv().add(element);
    }
}

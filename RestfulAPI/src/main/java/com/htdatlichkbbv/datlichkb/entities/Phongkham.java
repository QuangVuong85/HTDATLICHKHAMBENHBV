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
import com.htdatlichkbbv.datlichkb.entities.Bacsi;
import com.htdatlichkbbv.datlichkb.entities.Khoa;
import com.htdatlichkbbv.datlichkb.entities.PhongkhamId;

@Entity(name = "Phongkham")
@Table(name = "phongkham")
@NamedQueries({
        @NamedQuery(name = Phongkham.FIND_ALL, query = "SELECT a FROM Phongkham a")
        , @NamedQuery(name = Phongkham.FIND_BY_SOPHONG, query = "SELECT a FROM Phongkham a WHERE a.sophong = :sophong")
        , @NamedQuery(name = Phongkham.FIND_BY_SOPHONG_CONTAINING, query = "SELECT a FROM Phongkham a WHERE a.sophong like :sophong")
})

public class Phongkham implements Serializable {
    public static final String FIND_ALL = "Phongkham.findAll";
    public static final String FIND_BY_SOPHONG = "Phongkham.findBySophong";
    public static final String FIND_BY_SOPHONG_CONTAINING = "Phongkham.findBySophongContaining";
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    public PhongkhamId phongkhamId__;

    @Column(name = "SoPhong", length = 10, nullable = true, unique = false)
    private String sophong;

    @JsonIgnore
    @MapsId("MaBS")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "MaBS", referencedColumnName = "MaBS",
            nullable = false, unique = false, insertable = true, updatable = true)
    private Bacsi mabs;

    @JsonIgnore
    @Column(name = "MaBS", length = 10, nullable = false,
            unique = false, insertable = false, updatable = false)
    private String mabs_;

    @JsonIgnore
    @MapsId("MaKhoa")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "MaKhoa", referencedColumnName = "MaKhoa",
            nullable = false, unique = false, insertable = true, updatable = true)
    private Khoa makhoa;

    @JsonIgnore
    @Column(name = "MaKhoa", length = 10, nullable = false,
            unique = false, insertable = false, updatable = false)
    private String makhoa_;

    /**
     * Default constructor
     */
    public Phongkham() {
    }

    /**
     * All field constructor
     */
    public Phongkham(
            String mabs,
            String makhoa,
            String sophong) {
        this(
                mabs,
                makhoa,
                sophong
                , true);
    }

    public Phongkham(
            String mabs,
            String makhoa,
            String sophong
            , boolean setRelationship) {
        //primary keys
        this.phongkhamId__ = new PhongkhamId();
        //attributes
        setSophong(sophong);
        //parents
        if (setRelationship && mabs != null) {
            this.mabs = new Bacsi();
            this.mabs.setMabs(mabs);
            setMabs_(mabs);
        }
        if (setRelationship && makhoa != null) {
            this.makhoa = new Khoa();
            this.makhoa.setMakhoa(makhoa);
            setMakhoa_(makhoa);
        }
    }

    public Phongkham flat() {
        return new Phongkham(
                getPhongkhamId__().getMabs(),
                getPhongkhamId__().getMakhoa(),
                getSophong()
                , false
        );
    }


    public PhongkhamId getPhongkhamId__() {
        if (phongkhamId__ == null) phongkhamId__ = new PhongkhamId();
        return phongkhamId__;
    }

    public void setPhongkhamId__(PhongkhamId phongkhamId__) {
        this.phongkhamId__ = phongkhamId__;
    }

    public String getSophong() {
        return sophong;
    }

    public void setSophong(String sophong) {
        this.sophong = sophong;
    }

    public Bacsi getMabs() {
        return mabs;
    }

    public void setMabs(Bacsi mabs) {
        this.mabs = mabs;
    }

    public String getMabs_() {
        return mabs_;
    }

    public void setMabs_(String mabs) {
        this.mabs_ = mabs;
    }

    public Khoa getMakhoa() {
        return makhoa;
    }

    public void setMakhoa(Khoa makhoa) {
        this.makhoa = makhoa;
    }

    public String getMakhoa_() {
        return makhoa_;
    }

    public void setMakhoa_(String makhoa) {
        this.makhoa_ = makhoa;
    }
}

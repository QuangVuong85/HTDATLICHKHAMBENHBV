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
import com.htdatlichkbbv.datlichkb.entities.Lichhen;
import com.htdatlichkbbv.datlichkb.entities.Phongkham;
import com.htdatlichkbbv.datlichkb.entities.Khoa;
import com.htdatlichkbbv.datlichkb.entities.Nguoidung;

@Entity(name = "Bacsi")
@Table(name = "bacsi")
@NamedQueries({
        @NamedQuery(name = Bacsi.FIND_ALL, query = "SELECT a FROM Bacsi a")
        , @NamedQuery(name = Bacsi.FIND_BY_TENBS, query = "SELECT a FROM Bacsi a WHERE a.tenbs = :tenbs")
        , @NamedQuery(name = Bacsi.FIND_BY_TENBS_CONTAINING, query = "SELECT a FROM Bacsi a WHERE a.tenbs like :tenbs")
        , @NamedQuery(name = Bacsi.FIND_BY_CHUCVU, query = "SELECT a FROM Bacsi a WHERE a.chucvu = :chucvu")
        , @NamedQuery(name = Bacsi.FIND_BY_CHUCVU_CONTAINING, query = "SELECT a FROM Bacsi a WHERE a.chucvu like :chucvu")
        , @NamedQuery(name = Bacsi.FIND_BY_HINHANH, query = "SELECT a FROM Bacsi a WHERE a.hinhanh = :hinhanh")
        , @NamedQuery(name = Bacsi.FIND_BY_HINHANH_CONTAINING, query = "SELECT a FROM Bacsi a WHERE a.hinhanh like :hinhanh")
})

public class Bacsi implements Serializable {
    public static final String FIND_ALL = "Bacsi.findAll";
    public static final String FIND_BY_TENBS = "Bacsi.findByTenbs";
    public static final String FIND_BY_TENBS_CONTAINING = "Bacsi.findByTenbsContaining";
    public static final String FIND_BY_CHUCVU = "Bacsi.findByChucvu";
    public static final String FIND_BY_CHUCVU_CONTAINING = "Bacsi.findByChucvuContaining";
    public static final String FIND_BY_HINHANH = "Bacsi.findByHinhanh";
    public static final String FIND_BY_HINHANH_CONTAINING = "Bacsi.findByHinhanhContaining";
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "MaBS", length = 10)
    private String mabs;

    @Column(name = "TenBS", length = 100, nullable = true, unique = false)
    private String tenbs;

    @Column(name = "ChucVu", length = 100, nullable = true, unique = false)
    private String chucvu;

    @Column(name = "HinhAnh", length = 500, nullable = true, unique = false)
    private String hinhanh;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MaKhoa", referencedColumnName = "MaKhoa",
            nullable = true, unique = false, insertable = false, updatable = false)
    private Khoa makhoa;

//    @JsonIgnore
    @Column(name = "MaKhoa", length = 10, nullable = true,
            unique = false, insertable = true, updatable = true)
    private String makhoa_;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MaTK", referencedColumnName = "MaTK",
            nullable = true, unique = true, insertable = false, updatable = false)
    private Nguoidung matk;

//    @JsonIgnore
    @Column(name = "MaTK", length = 10, nullable = true,
            unique = true, insertable = true, updatable = true)
    private String matk_;

    @JsonIgnore
    @OneToMany(targetEntity = com.htdatlichkbbv.datlichkb.entities.Lichhen.class,
            fetch = FetchType.LAZY, mappedBy = "mabs", cascade = CascadeType.REMOVE)
    private Set<Lichhen> lichhenBacsiViaMabs = new HashSet<Lichhen>();

    @JsonIgnore
    @OneToMany(targetEntity = com.htdatlichkbbv.datlichkb.entities.Phongkham.class,
            fetch = FetchType.LAZY, mappedBy = "phongkhamId__.mabs", cascade = CascadeType.REMOVE)
    private Set<Phongkham> phongkhamBacsiViaMabs = new HashSet<Phongkham>();

    /**
     * Default constructor
     */
    public Bacsi() {
    }

    /**
     * All field constructor
     */
    public Bacsi(
            String mabs,
            String tenbs,
            String chucvu,
            String hinhanh,
            String makhoa,
            String matk) {
        this(
                mabs,
                tenbs,
                chucvu,
                hinhanh,
                makhoa,
                matk
                , true);
    }

    public Bacsi(
            String mabs,
            String tenbs,
            String chucvu,
            String hinhanh,
            String makhoa,
            String matk
            , boolean setRelationship) {
        //primary keys
        setMabs(mabs);
        //attributes
        setTenbs(tenbs);
        setChucvu(chucvu);
        setHinhanh(hinhanh);
        //parents
        if (setRelationship && makhoa != null) {
            this.makhoa = new Khoa();
            this.makhoa.setMakhoa(makhoa);
            setMakhoa_(makhoa);
        }
        if (setRelationship && matk != null) {
            this.matk = new Nguoidung();
            this.matk.setMatk(matk);
            setMatk_(matk);
        }
    }

    public Bacsi flat() {
        return new Bacsi(
                getMabs(),
                getTenbs(),
                getChucvu(),
                getHinhanh(),
                getMakhoa_(),
                getMatk_()
                , false
        );
    }

    public String getMabs() {
        return mabs;
    }

    public void setMabs(String mabs) {
        this.mabs = mabs;
    }

    public String getTenbs() {
        return tenbs;
    }

    public void setTenbs(String tenbs) {
        this.tenbs = tenbs;
    }

    public String getChucvu() {
        return chucvu;
    }

    public void setChucvu(String chucvu) {
        this.chucvu = chucvu;
    }

    public String getHinhanh() {
        return hinhanh;
    }

    public void setHinhanh(String hinhanh) {
        this.hinhanh = hinhanh;
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

    public Nguoidung getMatk() {
        return matk;
    }

    public void setMatk(Nguoidung matk) {
        this.matk = matk;
    }

    public String getMatk_() {
        return matk_;
    }

    public void setMatk_(String matk) {
        this.matk_ = matk;
    }

    public Set<Lichhen> getLichhenBacsiViaMabs() {
        if (lichhenBacsiViaMabs == null) {
            lichhenBacsiViaMabs = new HashSet<Lichhen>();
        }
        return lichhenBacsiViaMabs;
    }

    public void setLichhenBacsiViaMabs(Set<Lichhen> lichhenBacsiViaMabs) {
        this.lichhenBacsiViaMabs = lichhenBacsiViaMabs;
    }

    public void addLichhenBacsiViaMabs(Lichhen element) {
        getLichhenBacsiViaMabs().add(element);
    }

    public Set<Phongkham> getPhongkhamBacsiViaMabs() {
        if (phongkhamBacsiViaMabs == null) {
            phongkhamBacsiViaMabs = new HashSet<Phongkham>();
        }
        return phongkhamBacsiViaMabs;
    }

    public void setPhongkhamBacsiViaMabs(Set<Phongkham> phongkhamBacsiViaMabs) {
        this.phongkhamBacsiViaMabs = phongkhamBacsiViaMabs;
    }

    public void addPhongkhamBacsiViaMabs(Phongkham element) {
        getPhongkhamBacsiViaMabs().add(element);
    }
}

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
import com.htdatlichkbbv.datlichkb.entities.Benhnhan;
import com.htdatlichkbbv.datlichkb.entities.Nhomngdung;

@Entity(name = "Nguoidung")
@Table(name = "nguoidung")
@NamedQueries({
        @NamedQuery(name = Nguoidung.FIND_ALL, query = "SELECT a FROM Nguoidung a")
        , @NamedQuery(name = Nguoidung.FIND_BY_TENTK, query = "SELECT a FROM Nguoidung a WHERE a.tentk = :tentk")
        , @NamedQuery(name = Nguoidung.FIND_BY_TENTK_CONTAINING, query = "SELECT a FROM Nguoidung a WHERE a.tentk like :tentk")
        , @NamedQuery(name = Nguoidung.FIND_BY_MATKHAU, query = "SELECT a FROM Nguoidung a WHERE a.matkhau = :matkhau")
        , @NamedQuery(name = Nguoidung.FIND_BY_MATKHAU_CONTAINING, query = "SELECT a FROM Nguoidung a WHERE a.matkhau like :matkhau")
})

public class Nguoidung implements Serializable {
    public static final String FIND_ALL = "Nguoidung.findAll";
    public static final String FIND_BY_TENTK = "Nguoidung.findByTentk";
    public static final String FIND_BY_TENTK_CONTAINING = "Nguoidung.findByTentkContaining";
    public static final String FIND_BY_MATKHAU = "Nguoidung.findByMatkhau";
    public static final String FIND_BY_MATKHAU_CONTAINING = "Nguoidung.findByMatkhauContaining";
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "MaTK", length = 10)
    private String matk;

    @Column(name = "TenTK", length = 20, nullable = true, unique = false)
    private String tentk;

    @Column(name = "MatKhau", length = 50, nullable = true, unique = false)
    private String matkhau;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MaNhomND", referencedColumnName = "MaNhomND",
            nullable = true, unique = false, insertable = false, updatable = false)
    private Nhomngdung manhomnd;

    @Column(name = "MaNhomND", length = 10, nullable = true,
            unique = false, insertable = true, updatable = true) // edit unique = false
    private String manhomnd_;

    @JsonIgnore
    @OneToMany(targetEntity = com.htdatlichkbbv.datlichkb.entities.Bacsi.class,
            fetch = FetchType.LAZY, mappedBy = "matk", cascade = CascadeType.REMOVE)
    private Set<Bacsi> bacsiNguoidungViaMatk = new HashSet<Bacsi>();

    @JsonIgnore
    @OneToMany(targetEntity = com.htdatlichkbbv.datlichkb.entities.Benhnhan.class,
            fetch = FetchType.LAZY, mappedBy = "matk", cascade = CascadeType.REMOVE)
    private Set<Benhnhan> benhnhanNguoidungViaMatk = new HashSet<Benhnhan>();

    /**
     * Default constructor
     */
    public Nguoidung() {
    }

    /**
     * All field constructor
     */
    public Nguoidung(
            String matk,
            String tentk,
            String matkhau,
            String manhomnd) {
        this(
                matk,
                tentk,
                matkhau,
                manhomnd
                , true);
    }

    public Nguoidung(
            String matk,
            String tentk,
            String matkhau,
            String manhomnd
            , boolean setRelationship) {
        //primary keys
        setMatk(matk);
        //attributes
        setTentk(tentk);
        setMatkhau(matkhau);
        //parents
        if (setRelationship && manhomnd != null) {
            this.manhomnd = new Nhomngdung();
            this.manhomnd.setManhomnd(manhomnd);
            setManhomnd_(manhomnd);
        }
    }

    public Nguoidung flat() {
        return new Nguoidung(
                getMatk(),
                getTentk(),
                getMatkhau(),
                getManhomnd_()
                , false
        );
    }

    public String getMatk() {
        return matk;
    }

    public void setMatk(String matk) {
        this.matk = matk;
    }

    public String getTentk() {
        return tentk;
    }

    public void setTentk(String tentk) {
        this.tentk = tentk;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    public Nhomngdung getManhomnd() {
        return manhomnd;
    }

    public void setManhomnd(Nhomngdung manhomnd) {
        this.manhomnd = manhomnd;
    }

    public String getManhomnd_() {
        return manhomnd_;
    }

    public void setManhomnd_(String manhomnd) {
        this.manhomnd_ = manhomnd;
    }

    public Set<Bacsi> getBacsiNguoidungViaMatk() {
        if (bacsiNguoidungViaMatk == null) {
            bacsiNguoidungViaMatk = new HashSet<Bacsi>();
        }
        return bacsiNguoidungViaMatk;
    }

    public void setBacsiNguoidungViaMatk(Set<Bacsi> bacsiNguoidungViaMatk) {
        this.bacsiNguoidungViaMatk = bacsiNguoidungViaMatk;
    }

    public void addBacsiNguoidungViaMatk(Bacsi element) {
        getBacsiNguoidungViaMatk().add(element);
    }

    public Set<Benhnhan> getBenhnhanNguoidungViaMatk() {
        if (benhnhanNguoidungViaMatk == null) {
            benhnhanNguoidungViaMatk = new HashSet<Benhnhan>();
        }
        return benhnhanNguoidungViaMatk;
    }

    public void setBenhnhanNguoidungViaMatk(Set<Benhnhan> benhnhanNguoidungViaMatk) {
        this.benhnhanNguoidungViaMatk = benhnhanNguoidungViaMatk;
    }

    public void addBenhnhanNguoidungViaMatk(Benhnhan element) {
        getBenhnhanNguoidungViaMatk().add(element);
    }
}

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
import com.htdatlichkbbv.datlichkb.entities.Nguoidatlich;
import com.htdatlichkbbv.datlichkb.entities.Nguoidung;

@Entity(name = "Benhnhan")
@Table(name = "benhnhan")
@NamedQueries({
        @NamedQuery(name = Benhnhan.FIND_ALL, query = "SELECT a FROM Benhnhan a")
        , @NamedQuery(name = Benhnhan.FIND_BY_HOTEN, query = "SELECT a FROM Benhnhan a WHERE a.hoten = :hoten")
        , @NamedQuery(name = Benhnhan.FIND_BY_HOTEN_CONTAINING, query = "SELECT a FROM Benhnhan a WHERE a.hoten like :hoten")
        , @NamedQuery(name = Benhnhan.FIND_BY_GIOITINH, query = "SELECT a FROM Benhnhan a WHERE a.gioitinh = :gioitinh")
        , @NamedQuery(name = Benhnhan.FIND_BY_SODT, query = "SELECT a FROM Benhnhan a WHERE a.sodt = :sodt")
        , @NamedQuery(name = Benhnhan.FIND_BY_SODT_CONTAINING, query = "SELECT a FROM Benhnhan a WHERE a.sodt like :sodt")
        , @NamedQuery(name = Benhnhan.FIND_BY_EMAIL, query = "SELECT a FROM Benhnhan a WHERE a.email = :email")
        , @NamedQuery(name = Benhnhan.FIND_BY_EMAIL_CONTAINING, query = "SELECT a FROM Benhnhan a WHERE a.email like :email")
        , @NamedQuery(name = Benhnhan.FIND_BY_DIACHI, query = "SELECT a FROM Benhnhan a WHERE a.diachi = :diachi")
        , @NamedQuery(name = Benhnhan.FIND_BY_DIACHI_CONTAINING, query = "SELECT a FROM Benhnhan a WHERE a.diachi like :diachi")
})

public class Benhnhan implements Serializable {
    public static final String FIND_ALL = "Benhnhan.findAll";
    public static final String FIND_BY_HOTEN = "Benhnhan.findByHoten";
    public static final String FIND_BY_HOTEN_CONTAINING = "Benhnhan.findByHotenContaining";
    public static final String FIND_BY_GIOITINH = "Benhnhan.findByGioitinh";
    public static final String FIND_BY_SODT = "Benhnhan.findBySodt";
    public static final String FIND_BY_SODT_CONTAINING = "Benhnhan.findBySodtContaining";
    public static final String FIND_BY_EMAIL = "Benhnhan.findByEmail";
    public static final String FIND_BY_EMAIL_CONTAINING = "Benhnhan.findByEmailContaining";
    public static final String FIND_BY_DIACHI = "Benhnhan.findByDiachi";
    public static final String FIND_BY_DIACHI_CONTAINING = "Benhnhan.findByDiachiContaining";
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "MaBN", length = 10)
    private String mabn;

    @Column(name = "HoTen", length = 100, nullable = true, unique = false)
    private String hoten;

    @Column(name = "GioiTinh", nullable = false, unique = false)
    private Short gioitinh;

    @Column(name = "SoDT", length = 10, nullable = true, unique = false)
    private String sodt;

    @Column(name = "Email", length = 50, nullable = true, unique = false)
    private String email;

    @Column(name = "DiaChi", length = 500, nullable = true, unique = false)
    private String diachi;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MaTK", referencedColumnName = "MaTK",
            nullable = true, unique = false, insertable = false, updatable = false)
    private Nguoidung matk;

//    @JsonIgnore
    @Column(name = "MaTK", length = 10, nullable = true, unique = true, insertable = true, updatable = true)
    private String matk_;

    @JsonIgnore
    @OneToMany(targetEntity = com.htdatlichkbbv.datlichkb.entities.Lichhen.class, fetch = FetchType.LAZY,
            mappedBy = "mabn", cascade = CascadeType.REMOVE)
    private Set<Lichhen> lichhenBenhnhanViaMabn = new HashSet<Lichhen>();

    @JsonIgnore
    @OneToMany(targetEntity = com.htdatlichkbbv.datlichkb.entities.Nguoidatlich.class,
            fetch = FetchType.LAZY, mappedBy = "mabn", cascade = CascadeType.REMOVE)
    private Set<Nguoidatlich> nguoidatlichBenhnhanViaMabn = new HashSet<Nguoidatlich>();

    /**
     * Default constructor
     */
    public Benhnhan() {
    }

    /**
     * All field constructor
     */
    public Benhnhan(
            String mabn,
            String hoten,
            Short gioitinh,
            String sodt,
            String email,
            String diachi,
            String matk) {
        this(
                mabn,
                hoten,
                gioitinh,
                sodt,
                email,
                diachi,
                matk
                , true);
    }

    public Benhnhan(
            String mabn,
            String hoten,
            Short gioitinh,
            String sodt,
            String email,
            String diachi,
            String matk
            , boolean setRelationship) {
        //primary keys
        setMabn(mabn);
        //attributes
        setHoten(hoten);
        setGioitinh(gioitinh);
        setSodt(sodt);
        setEmail(email);
        setDiachi(diachi);
        //parents
        if (setRelationship && matk != null) {
            this.matk = new Nguoidung();
            this.matk.setMatk(matk);
            setMatk_(matk);
        }
    }

    public Benhnhan flat() {
        return new Benhnhan(
                getMabn(),
                getHoten(),
                getGioitinh(),
                getSodt(),
                getEmail(),
                getDiachi(),
                getMatk_()
                , false
        );
    }

    public String getMabn() {
        return mabn;
    }

    public void setMabn(String mabn) {
        this.mabn = mabn;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public Short getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(Short gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getSodt() {
        return sodt;
    }

    public void setSodt(String sodt) {
        this.sodt = sodt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
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

    public Set<Lichhen> getLichhenBenhnhanViaMabn() {
        if (lichhenBenhnhanViaMabn == null) {
            lichhenBenhnhanViaMabn = new HashSet<Lichhen>();
        }
        return lichhenBenhnhanViaMabn;
    }

    public void setLichhenBenhnhanViaMabn(Set<Lichhen> lichhenBenhnhanViaMabn) {
        this.lichhenBenhnhanViaMabn = lichhenBenhnhanViaMabn;
    }

    public void addLichhenBenhnhanViaMabn(Lichhen element) {
        getLichhenBenhnhanViaMabn().add(element);
    }

    public Set<Nguoidatlich> getNguoidatlichBenhnhanViaMabn() {
        if (nguoidatlichBenhnhanViaMabn == null) {
            nguoidatlichBenhnhanViaMabn = new HashSet<Nguoidatlich>();
        }
        return nguoidatlichBenhnhanViaMabn;
    }

    public void setNguoidatlichBenhnhanViaMabn(Set<Nguoidatlich> nguoidatlichBenhnhanViaMabn) {
        this.nguoidatlichBenhnhanViaMabn = nguoidatlichBenhnhanViaMabn;
    }

    public void addNguoidatlichBenhnhanViaMabn(Nguoidatlich element) {
        getNguoidatlichBenhnhanViaMabn().add(element);
    }
}

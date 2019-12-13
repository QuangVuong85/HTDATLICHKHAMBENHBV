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
import com.htdatlichkbbv.datlichkb.entities.Benhnhan;

@Entity(name = "Nguoidatlich")
@Table(name = "nguoidatlich")
@NamedQueries({
        @NamedQuery(name = Nguoidatlich.FIND_ALL, query = "SELECT a FROM Nguoidatlich a")
        , @NamedQuery(name = Nguoidatlich.FIND_BY_HOTEN, query = "SELECT a FROM Nguoidatlich a WHERE a.hoten = :hoten")
        , @NamedQuery(name = Nguoidatlich.FIND_BY_HOTEN_CONTAINING, query = "SELECT a FROM Nguoidatlich a WHERE a.hoten like :hoten")
        , @NamedQuery(name = Nguoidatlich.FIND_BY_SODT, query = "SELECT a FROM Nguoidatlich a WHERE a.sodt = :sodt")
        , @NamedQuery(name = Nguoidatlich.FIND_BY_SODT_CONTAINING, query = "SELECT a FROM Nguoidatlich a WHERE a.sodt like :sodt")
        , @NamedQuery(name = Nguoidatlich.FIND_BY_EMAIL, query = "SELECT a FROM Nguoidatlich a WHERE a.email = :email")
        , @NamedQuery(name = Nguoidatlich.FIND_BY_EMAIL_CONTAINING, query = "SELECT a FROM Nguoidatlich a WHERE a.email like :email")
})

public class Nguoidatlich implements Serializable {
    public static final String FIND_ALL = "Nguoidatlich.findAll";
    public static final String FIND_BY_HOTEN = "Nguoidatlich.findByHoten";
    public static final String FIND_BY_HOTEN_CONTAINING = "Nguoidatlich.findByHotenContaining";
    public static final String FIND_BY_SODT = "Nguoidatlich.findBySodt";
    public static final String FIND_BY_SODT_CONTAINING = "Nguoidatlich.findBySodtContaining";
    public static final String FIND_BY_EMAIL = "Nguoidatlich.findByEmail";
    public static final String FIND_BY_EMAIL_CONTAINING = "Nguoidatlich.findByEmailContaining";
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "MaNguoiDat", length = 10)
    private String manguoidat;

    @Column(name = "HoTen", length = 100, nullable = false, unique = false)
    private String hoten;

    @Column(name = "SoDT", length = 10, nullable = false, unique = false)
    private String sodt;

    @Column(name = "Email", length = 50, nullable = false, unique = false)
    private String email;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MaBN", referencedColumnName = "MaBN",
            nullable = true, unique = false, insertable = false, updatable = false)
    private Benhnhan mabn;

//    @JsonIgnore
    @Column(name = "MaBN", length = 10, nullable = true, unique = false, insertable = true, updatable = true)
    private String mabn_;

    /**
     * Default constructor
     */
    public Nguoidatlich() {
    }

    /**
     * All field constructor
     */
    public Nguoidatlich(
            String manguoidat,
            String hoten,
            String sodt,
            String email,
            String mabn) {
        this(
                manguoidat,
                hoten,
                sodt,
                email,
                mabn
                , true);
    }

    public Nguoidatlich(
            String manguoidat,
            String hoten,
            String sodt,
            String email,
            String mabn
            , boolean setRelationship) {
        //primary keys
        setManguoidat(manguoidat);
        //attributes
        setHoten(hoten);
        setSodt(sodt);
        setEmail(email);
        //parents
        if (setRelationship && mabn != null) {
            this.mabn = new Benhnhan();
            this.mabn.setMabn(mabn);
            setMabn_(mabn);
        }
    }

    public Nguoidatlich flat() {
        return new Nguoidatlich(
                getManguoidat(),
                getHoten(),
                getSodt(),
                getEmail(),
                getMabn_()
                , false
        );
    }

    public String getManguoidat() {
        return manguoidat;
    }

    public void setManguoidat(String manguoidat) {
        this.manguoidat = manguoidat;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
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

    public Benhnhan getMabn() {
        return mabn;
    }

    public void setMabn(Benhnhan mabn) {
        this.mabn = mabn;
    }

    public String getMabn_() {
        return mabn_;
    }

    public void setMabn_(String mabn) {
        this.mabn_ = mabn;
    }
}

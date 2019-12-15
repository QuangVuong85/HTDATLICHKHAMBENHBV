package com.htdatlichkbbv.datlichkb.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.sql.*;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

import javax.validation.constraints.NotNull;

import java.io.Serializable;
import javax.persistence.*;

@Entity(name = "Goikham")
@Table(name = "goikham")
@NamedQueries({
        @NamedQuery(name = Goikham.FIND_ALL, query = "SELECT a FROM Goikham a")
        , @NamedQuery(name = Goikham.FIND_BY_TENGK, query = "SELECT a FROM Goikham a WHERE a.tengk = :tengk")
        , @NamedQuery(name = Goikham.FIND_BY_TENGK_CONTAINING, query = "SELECT a FROM Goikham a WHERE a.tengk like :tengk")
        , @NamedQuery(name = Goikham.FIND_BY_DONGIA, query = "SELECT a FROM Goikham a WHERE a.dongia = :dongia")
})

public class Goikham implements Serializable {
    public static final String FIND_ALL = "Goikham.findAll";
    public static final String FIND_BY_TENGK = "Goikham.findByTengk";
    public static final String FIND_BY_TENGK_CONTAINING = "Goikham.findByTengkContaining";
    public static final String FIND_BY_DONGIA = "Goikham.findByDongia";
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "MaGK", length = 10)
    private String magk;

    @Column(name = "TenGK", length = 500, nullable = false, unique = false)
    private String tengk;

    @Column(name = "DonGia", precision = 8, scale = 2, nullable = false, unique = false)
    private java.math.BigDecimal dongia;

    @JsonIgnore
    @OneToMany(targetEntity = com.htdatlichkbbv.datlichkb.entities.Chitietdichvu.class,
            fetch = FetchType.LAZY, mappedBy = "chitietdichvuId__.magk", cascade = CascadeType.ALL)
    private Set<Chitietdichvu> chitietdichvuGoikhamViaMagk = new HashSet<Chitietdichvu>();

    /**
     * Default constructor
     */
    public Goikham() {
    }

    /**
     * All field constructor
     */
    public Goikham(
            String magk,
            String tengk,
            java.math.BigDecimal dongia) {
        this(
                magk,
                tengk,
                dongia
                , true);
    }

    public Goikham(
            String magk,
            String tengk,
            java.math.BigDecimal dongia
            , boolean setRelationship) {
        //primary keys
        setMagk(magk);
        //attributes
        setTengk(tengk);
        setDongia(dongia);
        //parents
    }

    public Goikham flat() {
        return new Goikham(
                getMagk(),
                getTengk(),
                getDongia()
                , false
        );
    }

    public String getMagk() {
        return magk;
    }

    public void setMagk(String magk) {
        this.magk = magk;
    }

    public String getTengk() {
        return tengk;
    }

    public void setTengk(String tengk) {
        this.tengk = tengk;
    }


    public java.math.BigDecimal getDongia() {
        return dongia;
    }

    public void setDongia(java.math.BigDecimal dongia) {
        this.dongia = dongia;
    }

    public Set<Chitietdichvu> getChitietdichvuGoikhamViaMagk() {
        if (chitietdichvuGoikhamViaMagk == null) {
            chitietdichvuGoikhamViaMagk = new HashSet<Chitietdichvu>();
        }
        return chitietdichvuGoikhamViaMagk;
    }

    public void setChitietdichvuGoikhamViaMagk(Set<Chitietdichvu> chitietdichvuGoikhamViaMagk) {
        this.chitietdichvuGoikhamViaMagk = chitietdichvuGoikhamViaMagk;
    }

    public void addChitietdichvuGoikhamViaMagk(Chitietdichvu element) {
        getChitietdichvuGoikhamViaMagk().add(element);
    }
}

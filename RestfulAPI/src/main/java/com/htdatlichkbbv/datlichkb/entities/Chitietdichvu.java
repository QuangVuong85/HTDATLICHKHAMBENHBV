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
import com.htdatlichkbbv.datlichkb.entities.Dichvu;
import com.htdatlichkbbv.datlichkb.entities.Lichhen;
import com.htdatlichkbbv.datlichkb.entities.ChitietdichvuId;

@Entity(name = "Chitietdichvu")
@Table(name = "chitietdichvu")
@NamedQueries({
        @NamedQuery(name = Chitietdichvu.FIND_ALL, query = "SELECT a FROM Chitietdichvu a")
        , @NamedQuery(name = Chitietdichvu.FIND_BY_THOIGIANDAT, query = "SELECT a FROM Chitietdichvu a WHERE a.thoigiandat = :thoigiandat")
        , @NamedQuery(name = Chitietdichvu.FIND_BY_GHICHU, query = "SELECT a FROM Chitietdichvu a WHERE a.ghichu = :ghichu")
        , @NamedQuery(name = Chitietdichvu.FIND_BY_GHICHU_CONTAINING, query = "SELECT a FROM Chitietdichvu a WHERE a.ghichu like :ghichu")
})

public class Chitietdichvu implements Serializable {
    public static final String FIND_ALL = "Chitietdichvu.findAll";
    public static final String FIND_BY_THOIGIANDAT = "Chitietdichvu.findByThoigiandat";
    public static final String FIND_BY_GHICHU = "Chitietdichvu.findByGhichu";
    public static final String FIND_BY_GHICHU_CONTAINING = "Chitietdichvu.findByGhichuContaining";
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    public ChitietdichvuId chitietdichvuId__;

    @Column(name = "ThoiGianDat", nullable = false, unique = false)
    private Timestamp thoigiandat;

    @Column(name = "GhiChu", length = 500, nullable = true, unique = false)
    private String ghichu;

    @JsonIgnore
    @MapsId("MaDV")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "MaDV", referencedColumnName = "MaDV",
            nullable = false, unique = false, insertable = true, updatable = true)
    private Dichvu madv;

    @JsonIgnore
    @Column(name = "MaDV", length = 10, nullable = false,
            unique = false, insertable = false, updatable = false)
    private String madv_;

    @JsonIgnore
    @MapsId("MaLichHen")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "MaLichHen", referencedColumnName = "MaLichHen",
            nullable = false, unique = false, insertable = true, updatable = true)
    private Lichhen malichhen;

    @JsonIgnore
    @Column(name = "MaLichHen", length = 10, nullable = false,
            unique = false, insertable = false, updatable = false)
    private String malichhen_;

    /**
     * Default constructor
     */
    public Chitietdichvu() {
    }

    /**
     * All field constructor
     */
    public Chitietdichvu(
            String madv,
            String malichhen,
            Timestamp thoigiandat,
            String ghichu) {
        this(
                madv,
                malichhen,
                thoigiandat,
                ghichu
                , true);
    }

    public Chitietdichvu(
            String madv,
            String malichhen,
            Timestamp thoigiandat,
            String ghichu
            , boolean setRelationship) {
        //primary keys
        this.chitietdichvuId__ = new ChitietdichvuId();
        //attributes
        setThoigiandat(thoigiandat);
        setGhichu(ghichu);
        //parents
        if (setRelationship && madv != null) {
            this.madv = new Dichvu();
            this.madv.setMadv(madv);
            setMadv_(madv);
        }
        if (setRelationship && malichhen != null) {
            this.malichhen = new Lichhen();
            this.malichhen.setMalichhen(malichhen);
            setMalichhen_(malichhen);
        }
    }

    public Chitietdichvu flat() {
        return new Chitietdichvu(
                getChitietdichvuId__().getMadv(),
                getChitietdichvuId__().getMalichhen(),
                getThoigiandat(),
                getGhichu()
                , false
        );
    }


    public ChitietdichvuId getChitietdichvuId__() {
        if (chitietdichvuId__ == null) chitietdichvuId__ = new ChitietdichvuId();
        return chitietdichvuId__;
    }

    public void setChitietdichvuId__(ChitietdichvuId chitietdichvuId__) {
        this.chitietdichvuId__ = chitietdichvuId__;
    }

    public Timestamp getThoigiandat() {
        return thoigiandat;
    }

    public void setThoigiandat(Timestamp thoigiandat) {
        this.thoigiandat = thoigiandat;
    }

    public String getGhichu() {
        return ghichu;
    }

    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }


    public Dichvu getMadv() {
        return madv;
    }

    public void setMadv(Dichvu madv) {
        this.madv = madv;
    }

    public String getMadv_() {
        return madv_;
    }

    public void setMadv_(String madv) {
        this.madv_ = madv;
    }

    public Lichhen getMalichhen() {
        return malichhen;
    }

    public void setMalichhen(Lichhen malichhen) {
        this.malichhen = malichhen;
    }

    public String getMalichhen_() {
        return malichhen_;
    }

    public void setMalichhen_(String malichhen) {
        this.malichhen_ = malichhen;
    }

    @PrePersist
    public void prePersist_() {
    }

    @PreUpdate
    public void preUpdate_() {
    }

}

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
import com.htdatlichkbbv.datlichkb.entities.Bacsi;
import com.htdatlichkbbv.datlichkb.entities.Benhnhan;
import org.hibernate.annotations.Nationalized;

@Entity(name = "Lichhen")
@Table(name = "lichhen")
@NamedQueries({
        @NamedQuery(name = Lichhen.FIND_ALL, query = "SELECT a FROM Lichhen a")
        , @NamedQuery(name = Lichhen.FIND_BY_THOIGIAN, query = "SELECT a FROM Lichhen a WHERE a.thoigian = :thoigian")
        , @NamedQuery(name = Lichhen.FIND_BY_THOIGIAN_CONTAINING, query = "SELECT a FROM Lichhen a WHERE a.thoigian like :thoigian")
        , @NamedQuery(name = Lichhen.FIND_BY_NGAYKHAM, query = "SELECT a FROM Lichhen a WHERE a.ngaykham = :ngaykham")
        , @NamedQuery(name = Lichhen.FIND_BY_NGAYKHAM_CONTAINING, query = "SELECT a FROM Lichhen a WHERE a.ngaykham like :ngaykham")
        , @NamedQuery(name = Lichhen.FIND_BY_GHICHU, query = "SELECT a FROM Lichhen a WHERE a.ghichu = :ghichu")
        , @NamedQuery(name = Lichhen.FIND_BY_GHICHU_CONTAINING, query = "SELECT a FROM Lichhen a WHERE a.ghichu like :ghichu")
        , @NamedQuery(name = Lichhen.FIND_BY_TRANGTHAI, query = "SELECT a FROM Lichhen a WHERE a.trangthai = :trangthai")
})

public class Lichhen implements Serializable {
    public static final String FIND_ALL = "Lichhen.findAll";
    public static final String FIND_BY_THOIGIAN = "Lichhen.findByThoigian";
    public static final String FIND_BY_THOIGIAN_CONTAINING = "Lichhen.findByThoigianContaining";
    public static final String FIND_BY_NGAYKHAM = "Lichhen.findByNgaykham";
    public static final String FIND_BY_NGAYKHAM_CONTAINING = "Lichhen.findByNgaykhamContaining";
    public static final String FIND_BY_GHICHU = "Lichhen.findByGhichu";
    public static final String FIND_BY_GHICHU_CONTAINING = "Lichhen.findByGhichuContaining";
    public static final String FIND_BY_TRANGTHAI = "Lichhen.findByTrangthai";
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "MaLichHen", length = 10)
    private String malichhen;

    @Column(name = "ThoiGian", length = 5, nullable = true, unique = false)
    private String thoigian;

    @Column(name = "NgayKham", length = 10, nullable = true, unique = false)
    private String ngaykham;

    @Column(name = "GhiChu", length = 500, nullable = true, unique = false)
    @Nationalized
    private String ghichu;

    @Column(name = "TrangThai", nullable = false, unique = false)
    private Short trangthai;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MaBS", referencedColumnName = "MaBS",
            nullable = true, unique = true, insertable = false, updatable = false)
    private Bacsi mabs;

//    @JsonIgnore
    @Column(name = "MaBS", length = 10, nullable = true,
            unique = false, insertable = true, updatable = true)
    private String mabs_;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MaBN", referencedColumnName = "MaBN", nullable = true,
            unique = true, insertable = false, updatable = false)
    private Benhnhan mabn;

//    @JsonIgnore
    @Column(name = "MaBN", length = 10, nullable = true,
            unique = false, insertable = true, updatable = true)
    private String mabn_;

    @JsonIgnore
    @OneToMany(targetEntity = com.htdatlichkbbv.datlichkb.entities.Chitietdichvu.class,
            fetch = FetchType.LAZY, mappedBy = "chitietdichvuId__.malichhen", cascade = CascadeType.REMOVE)
    private Set<Chitietdichvu> chitietdichvuLichhenViaMalichhen = new HashSet<Chitietdichvu>();

    /**
     * Default constructor
     */
    public Lichhen() {
    }

    /**
     * All field constructor
     */
    public Lichhen(
            String malichhen,
            String thoigian,
            String ngaykham,
            String ghichu,
            Short trangthai,
            String mabs,
            String mabn) {
        this(
                malichhen,
                thoigian,
                ngaykham,
                ghichu,
                trangthai,
                mabs,
                mabn
                , true);
    }

    public Lichhen(
            String malichhen,
            String thoigian,
            String ngaykham,
            String ghichu,
            Short trangthai,
            String mabs,
            String mabn
            , boolean setRelationship) {
        //primary keys
        setMalichhen(malichhen);
        //attributes
        setThoigian(thoigian);
        setNgaykham(ngaykham);
        setGhichu(ghichu);
        setTrangthai(trangthai);
        //parents
        if (setRelationship && mabs != null) {
            this.mabs = new Bacsi();
            this.mabs.setMabs(mabs);
            setMabs_(mabs);
        }
        if (setRelationship && mabn != null) {
            this.mabn = new Benhnhan();
            this.mabn.setMabn(mabn);
            setMabn_(mabn);
        }
    }

    public Lichhen flat() {
        return new Lichhen(
                getMalichhen(),
                getThoigian(),
                getNgaykham(),
                getGhichu(),
                getTrangthai(),
                getMabs_(),
                getMabn_()
                , false
        );
    }

    public String getMalichhen() {
        return malichhen;
    }

    public void setMalichhen(String malichhen) {
        this.malichhen = malichhen;
    }

    public String getThoigian() {
        return thoigian;
    }

    public void setThoigian(String thoigian) {
        this.thoigian = thoigian;
    }

    public String getNgaykham() {
        return ngaykham;
    }

    public void setNgaykham(String ngaykham) {
        this.ngaykham = ngaykham;
    }

    public String getGhichu() {
        return ghichu;
    }

    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }

    public Short getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(Short trangthai) {
        this.trangthai = trangthai;
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

    public Set<Chitietdichvu> getChitietdichvuLichhenViaMalichhen() {
        if (chitietdichvuLichhenViaMalichhen == null) {
            chitietdichvuLichhenViaMalichhen = new HashSet<Chitietdichvu>();
        }
        return chitietdichvuLichhenViaMalichhen;
    }

    public void setChitietdichvuLichhenViaMalichhen(Set<Chitietdichvu> chitietdichvuLichhenViaMalichhen) {
        this.chitietdichvuLichhenViaMalichhen = chitietdichvuLichhenViaMalichhen;
    }

    public void addChitietdichvuLichhenViaMalichhen(Chitietdichvu element) {
        getChitietdichvuLichhenViaMalichhen().add(element);
    }
}

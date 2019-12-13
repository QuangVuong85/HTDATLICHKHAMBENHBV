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
import com.htdatlichkbbv.datlichkb.entities.Nguoidung;

@Entity(name = "Nhomngdung")
@Table(name = "nhomngdung")
@NamedQueries({
        @NamedQuery(name = Nhomngdung.FIND_ALL, query = "SELECT a FROM Nhomngdung a")
        , @NamedQuery(name = Nhomngdung.FIND_BY_TENNHOMND, query = "SELECT a FROM Nhomngdung a WHERE a.tennhomnd = :tennhomnd")
        , @NamedQuery(name = Nhomngdung.FIND_BY_TENNHOMND_CONTAINING, query = "SELECT a FROM Nhomngdung a WHERE a.tennhomnd like :tennhomnd")
})

public class Nhomngdung implements Serializable {
    public static final String FIND_ALL = "Nhomngdung.findAll";
    public static final String FIND_BY_TENNHOMND = "Nhomngdung.findByTennhomnd";
    public static final String FIND_BY_TENNHOMND_CONTAINING = "Nhomngdung.findByTennhomndContaining";
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "MaNhomND", length = 10)
    private String manhomnd;

    @Column(name = "TenNhomND", length = 100, nullable = true, unique = false)
    private String tennhomnd;

    @JsonIgnore
    @OneToMany(targetEntity = com.htdatlichkbbv.datlichkb.entities.Nguoidung.class, fetch = FetchType.LAZY,
            mappedBy = "manhomnd", cascade = CascadeType.ALL)
    private Set<Nguoidung> nguoidungNhomngdungViaManhomnd = new HashSet<Nguoidung>();

    /**
     * Default constructor
     */
    public Nhomngdung() {
    }

    /**
     * All field constructor
     */
    public Nhomngdung(
            String manhomnd,
            String tennhomnd) {
        this(
                manhomnd,
                tennhomnd
                , true);
    }

    public Nhomngdung(
            String manhomnd,
            String tennhomnd
            , boolean setRelationship) {
        //primary keys
        setManhomnd(manhomnd);
        //attributes
        setTennhomnd(tennhomnd);
        //parents
    }

    public Nhomngdung flat() {
        return new Nhomngdung(
                getManhomnd(),
                getTennhomnd()
                , false
        );
    }

    public String getManhomnd() {
        return manhomnd;
    }

    public void setManhomnd(String manhomnd) {
        this.manhomnd = manhomnd;
    }

    public String getTennhomnd() {
        return tennhomnd;
    }

    public void setTennhomnd(String tennhomnd) {
        this.tennhomnd = tennhomnd;
    }

    public Set<Nguoidung> getNguoidungNhomngdungViaManhomnd() {
        if (nguoidungNhomngdungViaManhomnd == null) {
            nguoidungNhomngdungViaManhomnd = new HashSet<Nguoidung>();
        }
        return nguoidungNhomngdungViaManhomnd;
    }

    public void setNguoidungNhomngdungViaManhomnd(Set<Nguoidung> nguoidungNhomngdungViaManhomnd) {
        this.nguoidungNhomngdungViaManhomnd = nguoidungNhomngdungViaManhomnd;
    }

    public void addNguoidungNhomngdungViaManhomnd(Nguoidung element) {
        getNguoidungNhomngdungViaManhomnd().add(element);
    }
}

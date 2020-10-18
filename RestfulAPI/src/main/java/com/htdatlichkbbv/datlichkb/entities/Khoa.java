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
import com.htdatlichkbbv.datlichkb.entities.Phongkham;
import org.hibernate.annotations.Nationalized;

@Entity(name = "Khoa")
@Table(name = "khoa")
@NamedQueries({
        @NamedQuery(name = Khoa.FIND_ALL, query = "SELECT a FROM Khoa a")
        , @NamedQuery(name = Khoa.FIND_BY_TENKHOA, query = "SELECT a FROM Khoa a WHERE a.tenkhoa = :tenkhoa")
        , @NamedQuery(name = Khoa.FIND_BY_TENKHOA_CONTAINING, query = "SELECT a FROM Khoa a WHERE a.tenkhoa like :tenkhoa")
        , @NamedQuery(name = Khoa.FIND_BY_SODT, query = "SELECT a FROM Khoa a WHERE a.sodt = :sodt")
        , @NamedQuery(name = Khoa.FIND_BY_SODT_CONTAINING, query = "SELECT a FROM Khoa a WHERE a.sodt like :sodt")
})

public class Khoa implements Serializable {
    public static final String FIND_ALL = "Khoa.findAll";
    public static final String FIND_BY_TENKHOA = "Khoa.findByTenkhoa";
    public static final String FIND_BY_TENKHOA_CONTAINING = "Khoa.findByTenkhoaContaining";
    public static final String FIND_BY_SODT = "Khoa.findBySodt";
    public static final String FIND_BY_SODT_CONTAINING = "Khoa.findBySodtContaining";
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "MaKhoa", length = 10)
    private String makhoa;

    @Column(name = "TenKhoa", length = 100, nullable = true, unique = false)
    @Nationalized
    private String tenkhoa;

    @Column(name = "SoDT", length = 10, nullable = true, unique = false)
    private String sodt;

    @JsonIgnore
    @OneToMany(targetEntity = com.htdatlichkbbv.datlichkb.entities.Bacsi.class,
            fetch = FetchType.LAZY, mappedBy = "makhoa", cascade = CascadeType.REMOVE)
    private Set<Bacsi> bacsiKhoaViaMakhoa = new HashSet<Bacsi>();

    @JsonIgnore
    @OneToMany(targetEntity = com.htdatlichkbbv.datlichkb.entities.Phongkham.class,
            fetch = FetchType.LAZY, mappedBy = "phongkhamId__.makhoa", cascade = CascadeType.REMOVE)
    private Set<Phongkham> phongkhamKhoaViaMakhoa = new HashSet<Phongkham>();

    /**
     * Default constructor
     */
    public Khoa() {
    }

    /**
     * All field constructor
     */
    public Khoa(
            String makhoa,
            String tenkhoa,
            String sodt) {
        this(
                makhoa,
                tenkhoa,
                sodt
                , true);
    }

    public Khoa(
            String makhoa,
            String tenkhoa,
            String sodt
            , boolean setRelationship) {
        //primary keys
        setMakhoa(makhoa);
        //attributes
        setTenkhoa(tenkhoa);
        setSodt(sodt);
        //parents
    }

    public Khoa flat() {
        return new Khoa(
                getMakhoa(),
                getTenkhoa(),
                getSodt()
                , false
        );
    }

    public String getMakhoa() {
        return makhoa;
    }

    public void setMakhoa(String makhoa) {
        this.makhoa = makhoa;
    }

    public String getTenkhoa() {
        return tenkhoa;
    }

    public void setTenkhoa(String tenkhoa) {
        this.tenkhoa = tenkhoa;
    }


    public String getSodt() {
        return sodt;
    }

    public void setSodt(String sodt) {
        this.sodt = sodt;
    }

    public Set<Bacsi> getBacsiKhoaViaMakhoa() {
        if (bacsiKhoaViaMakhoa == null) {
            bacsiKhoaViaMakhoa = new HashSet<Bacsi>();
        }
        return bacsiKhoaViaMakhoa;
    }

    public void setBacsiKhoaViaMakhoa(Set<Bacsi> bacsiKhoaViaMakhoa) {
        this.bacsiKhoaViaMakhoa = bacsiKhoaViaMakhoa;
    }

    public void addBacsiKhoaViaMakhoa(Bacsi element) {
        getBacsiKhoaViaMakhoa().add(element);
    }

    public Set<Phongkham> getPhongkhamKhoaViaMakhoa() {
        if (phongkhamKhoaViaMakhoa == null) {
            phongkhamKhoaViaMakhoa = new HashSet<Phongkham>();
        }
        return phongkhamKhoaViaMakhoa;
    }

    public void setPhongkhamKhoaViaMakhoa(Set<Phongkham> phongkhamKhoaViaMakhoa) {
        this.phongkhamKhoaViaMakhoa = phongkhamKhoaViaMakhoa;
    }

    public void addPhongkhamKhoaViaMakhoa(Phongkham element) {
        getPhongkhamKhoaViaMakhoa().add(element);
    }
}

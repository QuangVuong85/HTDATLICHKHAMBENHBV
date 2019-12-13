package com.htdatlichkbbv.datlichkb.entities;

import java.io.*;
import java.sql.*;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

import javax.persistence.*;

@Embeddable
public class PhongkhamId implements Serializable {


    @Column(name = "MaBS", length = 10, nullable = false)
    private String mabs;

    @Column(name = "MaKhoa", length = 10, nullable = false)
    private String makhoa;

    public String getMabs() {
        return mabs;
    }

    public void setMabs(String mabs) {
        this.mabs = mabs;
    }

    public String getMakhoa() {
        return makhoa;
    }

    public void setMakhoa(String makhoa) {
        this.makhoa = makhoa;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        return obj.toString().equals(this.toString());
    }

    @Override
    public int hashCode() {
        return toString().hashCode();
    }

    @Override
    public String toString() {
        return "PhongkhamId:"
                + ":" + makhoa
                ;
    }

}

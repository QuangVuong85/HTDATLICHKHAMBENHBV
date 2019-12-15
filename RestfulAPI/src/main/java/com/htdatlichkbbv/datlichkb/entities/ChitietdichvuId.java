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
public class ChitietdichvuId implements Serializable {


    @Column(name="MaGK" ,length=10 ,nullable=false)
    private String magk;

    @Column(name = "MaLichHen", length = 10, nullable = false)
    private String malichhen;

    public String getMagk() {
        return magk;
    }

    public void setMagk (String magk) {
        this.magk = magk;
    }

    public String getMalichhen() {
        return malichhen;
    }

    public void setMalichhen(String malichhen) {
        this.malichhen = malichhen;
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
        return "ChitietdichvuId:"
                + ":" + malichhen
                ;
    }

}

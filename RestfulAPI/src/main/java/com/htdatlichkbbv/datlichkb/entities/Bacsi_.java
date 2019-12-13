package com.htdatlichkbbv.datlichkb.entities;

import java.sql.*;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import javax.persistence.metamodel.SetAttribute;

import com.htdatlichkbbv.datlichkb.entities.Lichhen;
import com.htdatlichkbbv.datlichkb.entities.Phongkham;
import com.htdatlichkbbv.datlichkb.entities.Khoa;
import com.htdatlichkbbv.datlichkb.entities.Nguoidung;

@StaticMetamodel(Bacsi.class)
public class Bacsi_ {

    public static volatile SingularAttribute<Bacsi, String> mabs;

    public static volatile SingularAttribute<Bacsi, String> tenbs;
    public static volatile SingularAttribute<Bacsi, String> chucvu;
    public static volatile SingularAttribute<Bacsi, String> hinhanh;
    public static volatile SingularAttribute<Bacsi, Khoa> makhoa;
    public static volatile SingularAttribute<Bacsi, String> makhoa_;
    public static volatile SingularAttribute<Bacsi, Nguoidung> matk;
    public static volatile SingularAttribute<Bacsi, String> matk_;

    public static volatile SetAttribute<Bacsi, Lichhen> lichhenBacsiViaMabs;
    public static volatile SetAttribute<Bacsi, Phongkham> phongkhamBacsiViaMabs;


}

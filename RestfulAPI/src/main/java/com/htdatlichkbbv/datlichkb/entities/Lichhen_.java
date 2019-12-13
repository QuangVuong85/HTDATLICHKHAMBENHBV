package com.htdatlichkbbv.datlichkb.entities;

import java.sql.*;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import javax.persistence.metamodel.SetAttribute;

import com.htdatlichkbbv.datlichkb.entities.Chitietdichvu;
import com.htdatlichkbbv.datlichkb.entities.Bacsi;
import com.htdatlichkbbv.datlichkb.entities.Benhnhan;

@StaticMetamodel(Lichhen.class)
public class Lichhen_ {

    public static volatile SingularAttribute<Lichhen, String> malichhen;

    public static volatile SingularAttribute<Lichhen, String> thoigian;
    public static volatile SingularAttribute<Lichhen, String> ngaykham;
    public static volatile SingularAttribute<Lichhen, String> ghichu;
    public static volatile SingularAttribute<Lichhen, Short> trangthai;
    public static volatile SingularAttribute<Lichhen, Bacsi> mabs;
    public static volatile SingularAttribute<Lichhen, String> mabs_;
    public static volatile SingularAttribute<Lichhen, Benhnhan> mabn;
    public static volatile SingularAttribute<Lichhen, String> mabn_;

    public static volatile SetAttribute<Lichhen, Chitietdichvu> chitietdichvuLichhenViaMalichhen;


}

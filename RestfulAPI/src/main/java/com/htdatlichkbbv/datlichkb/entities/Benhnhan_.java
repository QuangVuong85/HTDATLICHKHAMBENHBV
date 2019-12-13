package com.htdatlichkbbv.datlichkb.entities;

import java.sql.*;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import javax.persistence.metamodel.SetAttribute;

import com.htdatlichkbbv.datlichkb.entities.Lichhen;
import com.htdatlichkbbv.datlichkb.entities.Nguoidatlich;
import com.htdatlichkbbv.datlichkb.entities.Nguoidung;

@StaticMetamodel(Benhnhan.class)
public class Benhnhan_ {

    public static volatile SingularAttribute<Benhnhan, String> mabn;

    public static volatile SingularAttribute<Benhnhan, String> hoten;
    public static volatile SingularAttribute<Benhnhan, Short> gioitinh;
    public static volatile SingularAttribute<Benhnhan, String> sodt;
    public static volatile SingularAttribute<Benhnhan, String> email;
    public static volatile SingularAttribute<Benhnhan, String> diachi;
    public static volatile SingularAttribute<Benhnhan, Nguoidung> matk;
    public static volatile SingularAttribute<Benhnhan, String> matk_;

    public static volatile SetAttribute<Benhnhan, Lichhen> lichhenBenhnhanViaMabn;
    public static volatile SetAttribute<Benhnhan, Nguoidatlich> nguoidatlichBenhnhanViaMabn;


}

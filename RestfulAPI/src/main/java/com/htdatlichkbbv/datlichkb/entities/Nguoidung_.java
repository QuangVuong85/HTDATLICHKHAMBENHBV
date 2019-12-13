package com.htdatlichkbbv.datlichkb.entities;

import java.sql.*;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import javax.persistence.metamodel.SetAttribute;

import com.htdatlichkbbv.datlichkb.entities.Bacsi;
import com.htdatlichkbbv.datlichkb.entities.Benhnhan;
import com.htdatlichkbbv.datlichkb.entities.Nhomngdung;

@StaticMetamodel(Nguoidung.class)
public class Nguoidung_ {

    public static volatile SingularAttribute<Nguoidung, String> matk;

    public static volatile SingularAttribute<Nguoidung, String> tentk;
    public static volatile SingularAttribute<Nguoidung, String> matkhau;
    public static volatile SingularAttribute<Nguoidung, Nhomngdung> manhomnd;
    public static volatile SingularAttribute<Nguoidung, String> manhomnd_;

    public static volatile SetAttribute<Nguoidung, Bacsi> bacsiNguoidungViaMatk;
    public static volatile SetAttribute<Nguoidung, Benhnhan> benhnhanNguoidungViaMatk;


}

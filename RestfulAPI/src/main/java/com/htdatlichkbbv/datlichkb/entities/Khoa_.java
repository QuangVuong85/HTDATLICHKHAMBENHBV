package com.htdatlichkbbv.datlichkb.entities;

import java.sql.*;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import javax.persistence.metamodel.SetAttribute;

import com.htdatlichkbbv.datlichkb.entities.Bacsi;
import com.htdatlichkbbv.datlichkb.entities.Phongkham;

@StaticMetamodel(Khoa.class)
public class Khoa_ {

    public static volatile SingularAttribute<Khoa, String> makhoa;

    public static volatile SingularAttribute<Khoa, String> tenkhoa;
    public static volatile SingularAttribute<Khoa, String> sodt;

    public static volatile SetAttribute<Khoa, Bacsi> bacsiKhoaViaMakhoa;
    public static volatile SetAttribute<Khoa, Phongkham> phongkhamKhoaViaMakhoa;


}

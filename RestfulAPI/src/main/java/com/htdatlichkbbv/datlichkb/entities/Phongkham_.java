package com.htdatlichkbbv.datlichkb.entities;

import java.sql.*;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import javax.persistence.metamodel.SetAttribute;

import com.htdatlichkbbv.datlichkb.entities.Bacsi;
import com.htdatlichkbbv.datlichkb.entities.Khoa;
import com.htdatlichkbbv.datlichkb.entities.PhongkhamId;

@StaticMetamodel(Phongkham.class)
public class Phongkham_ {

    public static volatile SingularAttribute<Phongkham, PhongkhamId> phongkhamId__;

    public static volatile SingularAttribute<Phongkham, String> sophong;
    public static volatile SingularAttribute<Phongkham, Bacsi> mabs;
    public static volatile SingularAttribute<Phongkham, String> mabs_;
    public static volatile SingularAttribute<Phongkham, Khoa> makhoa;
    public static volatile SingularAttribute<Phongkham, String> makhoa_;


}

package com.htdatlichkbbv.datlichkb.entities;

import java.sql.*;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import javax.persistence.metamodel.SetAttribute;

import com.htdatlichkbbv.datlichkb.entities.Nguoidung;

@StaticMetamodel(Nhomngdung.class)
public class Nhomngdung_ {

    public static volatile SingularAttribute<Nhomngdung, String> manhomnd;

    public static volatile SingularAttribute<Nhomngdung, String> tennhomnd;

    public static volatile SetAttribute<Nhomngdung, Nguoidung> nguoidungNhomngdungViaManhomnd;


}

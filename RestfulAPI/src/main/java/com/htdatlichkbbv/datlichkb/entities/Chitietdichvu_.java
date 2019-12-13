package com.htdatlichkbbv.datlichkb.entities;

import java.sql.*;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import javax.persistence.metamodel.SetAttribute;

import com.htdatlichkbbv.datlichkb.entities.Dichvu;
import com.htdatlichkbbv.datlichkb.entities.Lichhen;
import com.htdatlichkbbv.datlichkb.entities.ChitietdichvuId;

@StaticMetamodel(Chitietdichvu.class)
public class Chitietdichvu_ {

    public static volatile SingularAttribute<Chitietdichvu, ChitietdichvuId> chitietdichvuId__;

    public static volatile SingularAttribute<Chitietdichvu, Timestamp> thoigiandat;
    public static volatile SingularAttribute<Chitietdichvu, String> ghichu;
    public static volatile SingularAttribute<Chitietdichvu, Dichvu> madv;
    public static volatile SingularAttribute<Chitietdichvu, String> madv_;
    public static volatile SingularAttribute<Chitietdichvu, Lichhen> malichhen;
    public static volatile SingularAttribute<Chitietdichvu, String> malichhen_;


}

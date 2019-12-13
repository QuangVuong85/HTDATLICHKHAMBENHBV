package com.htdatlichkbbv.datlichkb.entities;

import java.sql.*;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import javax.persistence.metamodel.SetAttribute;

import com.htdatlichkbbv.datlichkb.entities.Chitietdichvu;

@StaticMetamodel(Dichvu.class)
public class Dichvu_ {

    public static volatile SingularAttribute<Dichvu, String> madv;

    public static volatile SingularAttribute<Dichvu, String> tendv;
    public static volatile SingularAttribute<Dichvu, java.math.BigDecimal> dongia;

    public static volatile SetAttribute<Dichvu, Chitietdichvu> chitietdichvuDichvuViaMadv;


}

package com.htdatlichkbbv.datlichkb.entities;

import java.sql.*;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import javax.persistence.metamodel.SetAttribute;

import com.htdatlichkbbv.datlichkb.entities.Benhnhan;

@StaticMetamodel(Nguoidatlich.class)
public class Nguoidatlich_ {

    public static volatile SingularAttribute<Nguoidatlich, String> manguoidat;

    public static volatile SingularAttribute<Nguoidatlich, String> hoten;
    public static volatile SingularAttribute<Nguoidatlich, String> sodt;
    public static volatile SingularAttribute<Nguoidatlich, String> email;
    public static volatile SingularAttribute<Nguoidatlich, Benhnhan> mabn;
    public static volatile SingularAttribute<Nguoidatlich, String> mabn_;


}

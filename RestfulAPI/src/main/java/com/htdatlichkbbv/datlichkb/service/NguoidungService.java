package com.htdatlichkbbv.datlichkb.service;

import com.htdatlichkbbv.datlichkb.entities.Nguoidung;
import com.htdatlichkbbv.datlichkb.entities.context.LoginContext;
import com.htdatlichkbbv.datlichkb.entities.context.LoginResBNContext;
import com.htdatlichkbbv.datlichkb.entities.context.LoginResBSContext;
import com.htdatlichkbbv.datlichkb.entities.context.LoginResContext;

import java.util.List;
import java.util.Optional;

public interface NguoidungService {
    List<Nguoidung> findAll();
    Optional<Nguoidung> findById(String id);
    Nguoidung save(Nguoidung nd);
    void deleteById(String id);
    Nguoidung update(Nguoidung nd);

    List<String> getByNamePasswordTK(LoginContext loginContext);
    List<LoginResBNContext> getInfoBenhNhan(String matk);
    List<LoginResBSContext> getInfoBacSi(String matk);
}

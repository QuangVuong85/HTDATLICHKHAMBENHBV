package com.htdatlichkbbv.datlichkb.service;

import com.htdatlichkbbv.datlichkb.entities.Nguoidung;

import java.util.List;
import java.util.Optional;

public interface NguoidungService {
    List<Nguoidung> findAll();
    Optional<Nguoidung> findById(String id);
    Nguoidung save(Nguoidung nd);
    void deleteById(String id);
    Nguoidung update(Nguoidung nd);
}

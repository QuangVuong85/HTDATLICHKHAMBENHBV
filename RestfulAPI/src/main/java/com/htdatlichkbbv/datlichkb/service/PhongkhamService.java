package com.htdatlichkbbv.datlichkb.service;

import com.htdatlichkbbv.datlichkb.entities.Phongkham;
import com.htdatlichkbbv.datlichkb.entities.PhongkhamId;

import java.util.List;
import java.util.Optional;

public interface PhongkhamService {
    List<Phongkham> findAll();
    Optional<Phongkham> findById(PhongkhamId phongkhamId);
    Phongkham save(Phongkham phongkham);
    void deleteById(PhongkhamId phongkhamId);
    Phongkham update(Phongkham phongkham);
}

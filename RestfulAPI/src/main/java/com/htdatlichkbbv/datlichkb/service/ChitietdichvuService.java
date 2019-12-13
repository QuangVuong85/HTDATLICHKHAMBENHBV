package com.htdatlichkbbv.datlichkb.service;

import com.htdatlichkbbv.datlichkb.entities.Chitietdichvu;
import com.htdatlichkbbv.datlichkb.entities.ChitietdichvuId;

import java.util.List;
import java.util.Optional;

public interface ChitietdichvuService {
    List<Chitietdichvu> findAll();
    Optional<Chitietdichvu> findById(ChitietdichvuId chitietdichvuId);
    Chitietdichvu save(Chitietdichvu chitietdichvu);
    void deleteById(ChitietdichvuId chitietdichvuId);
    Chitietdichvu update(Chitietdichvu chitietdichvu);
}

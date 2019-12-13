package com.htdatlichkbbv.datlichkb.service;

import com.htdatlichkbbv.datlichkb.entities.Dichvu;

import java.util.List;
import java.util.Optional;

public interface DichvuService {
    List<Dichvu> findAll();
    Optional<Dichvu> findById(String id);
    Dichvu save(Dichvu dichvu);
    void deleteById(String id);
    Dichvu update(Dichvu dichvu);
}

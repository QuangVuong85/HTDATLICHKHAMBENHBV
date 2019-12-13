package com.htdatlichkbbv.datlichkb.service;

import com.htdatlichkbbv.datlichkb.entities.Benhnhan;

import java.util.List;
import java.util.Optional;

public interface BenhnhanService {
    List<Benhnhan> findAll();
    Optional<Benhnhan> findById(String id);
    Benhnhan save(Benhnhan benhnhan);
    void deleteById(String id);
    Benhnhan update(Benhnhan benhnhan);
}

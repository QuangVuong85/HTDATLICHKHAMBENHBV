package com.htdatlichkbbv.datlichkb.service;

import com.htdatlichkbbv.datlichkb.entities.Goikham;

import java.util.List;
import java.util.Optional;

public interface GoikhamService {
    List<Goikham> findAll();
    Optional<Goikham> findById(String id);
    Goikham save(Goikham goikham);
    void deleteById(String id);
    Goikham update(Goikham goikham);
}

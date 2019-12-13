package com.htdatlichkbbv.datlichkb.service;

import com.htdatlichkbbv.datlichkb.entities.Khoa;

import java.util.List;
import java.util.Optional;

public interface KhoaService {
    List<Khoa> findAll();
    Optional<Khoa> findById(String id);
    Khoa save(Khoa khoa);
    void deleteById(String id);
    Khoa update(Khoa khoa);
}

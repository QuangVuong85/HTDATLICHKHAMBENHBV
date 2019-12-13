package com.htdatlichkbbv.datlichkb.service;

import com.htdatlichkbbv.datlichkb.entities.Bacsi;

import java.util.List;
import java.util.Optional;

public interface BacsiService {
    List<Bacsi> findAll();
    Optional<Bacsi> findById(String id);
    Bacsi save(Bacsi khoa);
    void deleteById(String id);
    Bacsi update(Bacsi khoa);
}

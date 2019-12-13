package com.htdatlichkbbv.datlichkb.service;

import com.htdatlichkbbv.datlichkb.entities.Nguoidatlich;

import java.util.List;
import java.util.Optional;

public interface NguoidatlichService {
    List<Nguoidatlich> findAll();
    Optional<Nguoidatlich> findById(String id);
    Nguoidatlich save(Nguoidatlich nguoidatlich);
    void deleteById(String id);
    Nguoidatlich update(Nguoidatlich nguoidatlich);
}

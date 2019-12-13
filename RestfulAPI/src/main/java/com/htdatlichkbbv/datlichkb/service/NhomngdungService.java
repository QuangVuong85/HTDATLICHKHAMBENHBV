package com.htdatlichkbbv.datlichkb.service;

import com.htdatlichkbbv.datlichkb.entities.Nhomngdung;

import java.util.List;
import java.util.Optional;

public interface NhomngdungService {
    List<Nhomngdung> findAll();
    Optional<Nhomngdung> findById(String id);
    Nhomngdung save(Nhomngdung nd);
    void deleteById(String id);
    Nhomngdung update(Nhomngdung nd);
}

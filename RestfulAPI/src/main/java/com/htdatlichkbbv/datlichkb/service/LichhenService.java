package com.htdatlichkbbv.datlichkb.service;

import com.htdatlichkbbv.datlichkb.entities.Lichhen;

import java.util.List;
import java.util.Optional;

public interface LichhenService {
    List<Lichhen> findAll();
    Optional<Lichhen> findById(String id);
    Lichhen save(Lichhen dichvu);
    void deleteById(String id);
    Lichhen update(Lichhen dichvu);
    void updateLichHenOld(String malichhen, String mabn, Short trangthai, String ghichu);

    List<Lichhen> findByMaBS(String id);

    List<Lichhen> DanhSachLichHenCuaBacSi(String mabs);
}

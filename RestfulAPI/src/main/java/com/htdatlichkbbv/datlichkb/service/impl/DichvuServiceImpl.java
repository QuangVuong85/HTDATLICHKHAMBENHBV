package com.htdatlichkbbv.datlichkb.service.impl;

import com.htdatlichkbbv.datlichkb.entities.Dichvu;
import com.htdatlichkbbv.datlichkb.repository.DichvuRepository;
import com.htdatlichkbbv.datlichkb.service.DichvuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DichvuServiceImpl implements DichvuService {

    @Autowired
    private DichvuRepository dichvuRepository;

    @Override
    public List<Dichvu> findAll() {
        return this.dichvuRepository.findAll();
    }

    @Override
    public Optional<Dichvu> findById(String id) {
        return this.dichvuRepository.findById(id);
    }

    @Override
    public Dichvu save(Dichvu dichvu) {
        this.dichvuRepository.save(dichvu);
        return dichvu;
    }

    @Override
    public void deleteById(String id) {
        this.dichvuRepository.deleteById(id);
    }

    @Override
    public Dichvu update(Dichvu dichvu) {
        this.dichvuRepository.save(dichvu);
        return dichvu;
    }
    @Override
    public List<Dichvu> DanhSachDichVuCuaBacSi(String mabacsi){
        return this.dichvuRepository.DichVuCuaBacSi(mabacsi);
    }
}

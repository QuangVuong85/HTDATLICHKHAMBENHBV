package com.htdatlichkbbv.datlichkb.service.impl;

import com.htdatlichkbbv.datlichkb.entities.Chitietdichvu;
import com.htdatlichkbbv.datlichkb.entities.ChitietdichvuId;
import com.htdatlichkbbv.datlichkb.repository.ChitietdichvuRepository;
import com.htdatlichkbbv.datlichkb.service.ChitietdichvuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChitietdichvuServiceImpl implements ChitietdichvuService {

    @Autowired
    private ChitietdichvuRepository chitietdichvuRepository;

    @Override
    public List<Chitietdichvu> findAll() {
        return this.chitietdichvuRepository.findAll();
    }

    @Override
    public Optional<Chitietdichvu> findById(ChitietdichvuId chitietdichvuId) {
        return this.chitietdichvuRepository.findById(chitietdichvuId);
    }

    @Override
    public Chitietdichvu save(Chitietdichvu chitietdichvu) {
        this.chitietdichvuRepository.save(chitietdichvu);
        return chitietdichvu;
    }

    @Override
    public void deleteById(ChitietdichvuId chitietdichvuId) {
        this.chitietdichvuRepository.deleteById(chitietdichvuId);
    }

    @Override
    public Chitietdichvu update(Chitietdichvu chitietdichvu) {
        this.chitietdichvuRepository.save(chitietdichvu);
        return chitietdichvu;
    }
}

package com.htdatlichkbbv.datlichkb.service.impl;

import com.htdatlichkbbv.datlichkb.entities.Nhomngdung;
import com.htdatlichkbbv.datlichkb.repository.NhomngdungRepository;
import com.htdatlichkbbv.datlichkb.service.NhomngdungService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NhomngdungServiceImpl implements NhomngdungService {

    @Autowired
    private NhomngdungRepository nhomngdungRepository;

    @Override
    public List<Nhomngdung> findAll() {
        List<Nhomngdung> list = nhomngdungRepository.findAll();
        return list;
    }

    @Override
    public Optional<Nhomngdung> findById(String id) {
        return this.nhomngdungRepository.findById(id);
    }

    @Override
    public Nhomngdung save(Nhomngdung nd) {
        this.nhomngdungRepository.save(nd);
        return nd;
    }

    @Override
    public void deleteById(String id) {
        this.nhomngdungRepository.deleteById(id);
    }

    @Override
    public Nhomngdung update(Nhomngdung nd) {
        this.nhomngdungRepository.save(nd);
        return nd;
    }
}

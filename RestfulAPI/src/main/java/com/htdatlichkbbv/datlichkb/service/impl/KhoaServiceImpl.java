package com.htdatlichkbbv.datlichkb.service.impl;

import com.htdatlichkbbv.datlichkb.entities.Khoa;
import com.htdatlichkbbv.datlichkb.repository.KhoaRepository;
import com.htdatlichkbbv.datlichkb.service.KhoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KhoaServiceImpl implements KhoaService {

    @Autowired
    private KhoaRepository khoaRepository;

    @Override
    public List<Khoa> findAll() {
        return this.khoaRepository.findAll();
    }

    @Override
    public Optional<Khoa> findById(String id) {
        return this.khoaRepository.findById(id);
    }

    @Override
    public Khoa save(Khoa khoa) {
        this.khoaRepository.save(khoa);
        return khoa;
    }

    @Override
    public void deleteById(String id) {
        this.khoaRepository.deleteById(id);
    }

    @Override
    public Khoa update(Khoa khoa) {
        this.khoaRepository.save(khoa);
        return khoa;
    }
}

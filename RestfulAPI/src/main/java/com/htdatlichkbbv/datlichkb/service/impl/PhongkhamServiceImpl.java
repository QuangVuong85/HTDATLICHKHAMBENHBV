package com.htdatlichkbbv.datlichkb.service.impl;

import com.htdatlichkbbv.datlichkb.entities.Phongkham;
import com.htdatlichkbbv.datlichkb.entities.PhongkhamId;
import com.htdatlichkbbv.datlichkb.repository.PhongkhamRepository;
import com.htdatlichkbbv.datlichkb.service.PhongkhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PhongkhamServiceImpl implements PhongkhamService {

    @Autowired
    private PhongkhamRepository phongkhamRepository;

    @Override
    public List<Phongkham> findAll() {
        return this.phongkhamRepository.findAll();
    }

    @Override
    public Optional<Phongkham> findById(PhongkhamId phongkhamId) {
        return this.phongkhamRepository.findById(phongkhamId);
    }

    @Override
    public Phongkham save(Phongkham phongkham) {
        this.phongkhamRepository.save(phongkham);
        return phongkham;
    }

    @Override
    public void deleteById(PhongkhamId phongkhamId) {
        this.phongkhamRepository.deleteById(phongkhamId);
    }

    @Override
    public Phongkham update(Phongkham phongkham) {
        this.phongkhamRepository.save(phongkham);
        return phongkham;
    }
}

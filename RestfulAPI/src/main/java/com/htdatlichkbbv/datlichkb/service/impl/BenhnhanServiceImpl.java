package com.htdatlichkbbv.datlichkb.service.impl;

import com.htdatlichkbbv.datlichkb.entities.Benhnhan;
import com.htdatlichkbbv.datlichkb.repository.BenhnhanRepository;
import com.htdatlichkbbv.datlichkb.service.BenhnhanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BenhnhanServiceImpl implements BenhnhanService {

    @Autowired
    private BenhnhanRepository benhnhanRepository;

    @Override
    public List<Benhnhan> findAll() {
        return this.benhnhanRepository.findAll();
    }

    @Override
    public Optional<Benhnhan> findById(String id) {
        return this.benhnhanRepository.findById(id);
    }

    @Override
    public Benhnhan save(Benhnhan benhnhan) {
        this.benhnhanRepository.save(benhnhan);
        return benhnhan;
    }

    @Override
    public void deleteById(String id) {
        this.benhnhanRepository.deleteById(id);
    }

    @Override
    public Benhnhan update(Benhnhan benhnhan) {
        this.benhnhanRepository.save(benhnhan);
        return benhnhan;
    }

    @Override
    public Benhnhan findBenhnhanByMatk_(String matk) {
        return this.benhnhanRepository.findBenhnhanByMatk_(matk);
    }
}

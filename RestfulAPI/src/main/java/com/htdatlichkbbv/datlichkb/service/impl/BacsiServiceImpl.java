package com.htdatlichkbbv.datlichkb.service.impl;

import com.htdatlichkbbv.datlichkb.entities.Bacsi;
import com.htdatlichkbbv.datlichkb.repository.BacsiRepository;
import com.htdatlichkbbv.datlichkb.service.BacsiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BacsiServiceImpl implements BacsiService {

    @Autowired
    private BacsiRepository bacsiRepository;

    @Override
    public List<Bacsi> findAll() {
        return this.bacsiRepository.findAll();
    }

    @Override
    public Optional<Bacsi> findById(String id) {
        return this.bacsiRepository.findById(id);
    }

    @Override
    public Bacsi save(Bacsi bs) {
        this.bacsiRepository.save(bs);
        return bs;
    }

    @Override
    public void deleteById(String id) {
        this.bacsiRepository.deleteById(id);
    }

    @Override
    public Bacsi update(Bacsi bs) {
        this.bacsiRepository.save(bs);
        return bs;
    }
}

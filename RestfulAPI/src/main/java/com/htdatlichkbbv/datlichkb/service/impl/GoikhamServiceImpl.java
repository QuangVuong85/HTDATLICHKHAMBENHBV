package com.htdatlichkbbv.datlichkb.service.impl;

import com.htdatlichkbbv.datlichkb.entities.Goikham;
import com.htdatlichkbbv.datlichkb.repository.GoikhamRepository;
import com.htdatlichkbbv.datlichkb.service.GoikhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GoikhamServiceImpl implements GoikhamService {

    @Autowired
    private GoikhamRepository goikhamRepository;

    @Override
    public List<Goikham> findAll() {
        return this.goikhamRepository.findAll();
    }

    @Override
    public Optional<Goikham> findById(String id) {
        return this.goikhamRepository.findById(id);
    }

    @Override
    public Goikham save(Goikham goikham) {
        return this.goikhamRepository.save(goikham);
    }

    @Override
    public void deleteById(String id) {
        this.goikhamRepository.deleteById(id);
    }

    @Override
    public Goikham update(Goikham goikham) {
        return this.goikhamRepository.save(goikham);
    }
}

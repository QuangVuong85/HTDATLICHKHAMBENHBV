package com.htdatlichkbbv.datlichkb.service.impl;

import com.htdatlichkbbv.datlichkb.entities.Nguoidatlich;
import com.htdatlichkbbv.datlichkb.entities.Nguoidung;
import com.htdatlichkbbv.datlichkb.repository.NguoidatlichRepository;
import com.htdatlichkbbv.datlichkb.repository.NguoidungRepository;
import com.htdatlichkbbv.datlichkb.service.NguoidatlichService;
import com.htdatlichkbbv.datlichkb.service.NguoidungService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NguoidatlichServiceImpl implements NguoidatlichService {

    @Autowired
    private NguoidatlichRepository nguoidatlichRepository;

    @Override
    public List<Nguoidatlich> findAll() {
        return this.nguoidatlichRepository.findAll();
    }

    @Override
    public Optional<Nguoidatlich> findById(String id) {
        return this.nguoidatlichRepository.findById(id);
    }

    @Override
    public Nguoidatlich save(Nguoidatlich nguoidatlich) {
        this.nguoidatlichRepository.save(nguoidatlich);
        return nguoidatlich;
    }

    @Override
    public void deleteById(String id) {
        this.nguoidatlichRepository.deleteById(id);
    }

    @Override
    public Nguoidatlich update(Nguoidatlich nguoidatlich) {
        this.nguoidatlichRepository.save(nguoidatlich);
        return nguoidatlich;
    }
}

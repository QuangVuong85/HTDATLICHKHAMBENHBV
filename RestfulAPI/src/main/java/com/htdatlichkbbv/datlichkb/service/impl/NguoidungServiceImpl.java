package com.htdatlichkbbv.datlichkb.service.impl;

import com.htdatlichkbbv.datlichkb.entities.Nguoidung;
import com.htdatlichkbbv.datlichkb.entities.context.LoginContext;
import com.htdatlichkbbv.datlichkb.entities.context.LoginResBNContext;
import com.htdatlichkbbv.datlichkb.entities.context.LoginResBSContext;
import com.htdatlichkbbv.datlichkb.entities.context.LoginResContext;
import com.htdatlichkbbv.datlichkb.repository.NguoidungRepository;
import com.htdatlichkbbv.datlichkb.service.NguoidungService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NguoidungServiceImpl implements NguoidungService {

    @Autowired
    private NguoidungRepository nguoidungRepository;

    @Override
    public List<Nguoidung> findAll() {
        return this.nguoidungRepository.findAll();
    }

    @Override
    public Optional<Nguoidung> findById(String id) {
        return this.nguoidungRepository.findById(id);
    }

    @Override
    public Nguoidung save(Nguoidung nd) {
        nguoidungRepository.save(nd);
        return nd;
    }

    @Override
    public void deleteById(String id) {
        nguoidungRepository.deleteById(id);
    }

    @Override
    public Nguoidung update(Nguoidung nd) {
        return nguoidungRepository.save(nd);
    }

    @Override
    public List<String> getByNamePasswordTK(LoginContext loginContext) {
        List<String> list = this.nguoidungRepository.getByNamePasswordTK(
                loginContext.getTentk(), loginContext.getMatkhau());
        return list;
    }

    @Override
    public List<LoginResBNContext> getInfoBenhNhan(String matk) {
        return this.nguoidungRepository.getInfoBenhNhan(matk);
    }

    @Override
    public List<LoginResBSContext> getInfoBacSi(String matk) {
        return this.nguoidungRepository.getInfoBacSi(matk);
    }
}

package com.htdatlichkbbv.datlichkb.service.impl;

import com.htdatlichkbbv.datlichkb.entities.Lichhen;
import com.htdatlichkbbv.datlichkb.entities.context.ITKLichHenBSContext;
import com.htdatlichkbbv.datlichkb.entities.context.TKLichHenBSContext;
import com.htdatlichkbbv.datlichkb.repository.LichhenReponsitory;
import com.htdatlichkbbv.datlichkb.service.LichhenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LichhenServiceImpl implements LichhenService {

    @Autowired
    private LichhenReponsitory lichhenReponsitory;

    @Override
    public List<Lichhen> findAll() {
        return this.lichhenReponsitory.findAll();
    }

    @Override
    public Optional<Lichhen> findById(String id) {
        return this.lichhenReponsitory.findById(id);
    }

    @Override
    public Lichhen save(Lichhen dichvu) {
        this.lichhenReponsitory.save(dichvu);
        return dichvu;
    }

    @Override
    public void deleteById(String id) {
        this.lichhenReponsitory.deleteById(id);
    }

    @Override
    public Lichhen update(Lichhen dichvu) {
        this.lichhenReponsitory.save(dichvu);
        return dichvu;
    }

    @Override
    public void updateLichHenOld(String malichhen, String mabn, Short trangthai, String ghichu) {
        this.lichhenReponsitory.updateLichHenOld(malichhen, mabn, trangthai, ghichu);
    }

    @Override
    public List<Lichhen> findByMaBS(String id) {
        return this.lichhenReponsitory.findAllByMabs(id);
    }

    @Override
    public List<Lichhen> DanhSachLichHenCuaBacSi(String mabacsi){
        return this.lichhenReponsitory.LichHenCuaBacSi(mabacsi);
    }

    @Override
    public List<TKLichHenBSContext> tkLichHenBS(){
        if (this.lichhenReponsitory.tkLichHenBS().size() == 0) {
            return null;
        }

        List<TKLichHenBSContext> tk = new ArrayList<>();
        List<ITKLichHenBSContext> ls =  this.lichhenReponsitory.tkLichHenBS();
        for (ITKLichHenBSContext l : ls) {
            TKLichHenBSContext tmp = new TKLichHenBSContext();
            tmp.setMabs(l.getMabs());
            tmp.setTenbs(l.getTenbs());
            tmp.setNgaykham(l.getNgaykham());
            tmp.setTrangthai(l.getTrangthai());
            tmp.setSoluong(l.getSoluong());
            tk.add(tmp);
            System.out.println(tmp);
        }

        return tk;
    }
}

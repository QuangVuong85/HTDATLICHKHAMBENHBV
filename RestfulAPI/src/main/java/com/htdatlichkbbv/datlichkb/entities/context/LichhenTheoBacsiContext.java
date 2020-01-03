package com.htdatlichkbbv.datlichkb.entities.context;

import com.htdatlichkbbv.datlichkb.entities.Bacsi;
import com.htdatlichkbbv.datlichkb.entities.Lichhen;

import java.util.List;

public class LichhenTheoBacsiContext {
    public Bacsi bs;
    public List<Lichhen> lichhenList;

    public Bacsi getBs() {
        return bs;
    }

    public void setBs(Bacsi bs) {
        this.bs = bs;
    }

    public List<Lichhen> getLichhenList() {
        return lichhenList;
    }

    public void setLichhenList(List<Lichhen> lichhenList) {
        this.lichhenList = lichhenList;
    }
}

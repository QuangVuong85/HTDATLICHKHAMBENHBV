package com.htdatlichkbbv.datlichkb.entities.context;

import com.htdatlichkbbv.datlichkb.entities.Bacsi;
import com.htdatlichkbbv.datlichkb.entities.Dichvu;
import com.htdatlichkbbv.datlichkb.entities.Lichhen;

import java.util.List;

public class LichHenCuaBacSiContext {
    public Bacsi bacsi;
    public List<Lichhen> listLichHen;
    public List<Dichvu> listDichVu;

    public List<Dichvu> getListDichVu() {
        return listDichVu;
    }

    public void setListDichVu(List<Dichvu> listDichVu) {
        this.listDichVu = listDichVu;
    }

    public Bacsi getBacsi() {
        return bacsi;
    }

    public void setBacsi(Bacsi bacsi) {
        this.bacsi = bacsi;
    }

    public List<Lichhen> getListLichHen() {
        return listLichHen;
    }

    public void setListLichHen(List<Lichhen> listLichHen) {
        this.listLichHen = listLichHen;
    }


}

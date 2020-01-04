package com.htdatlichkbbv.datlichkb.entities.context;

import com.htdatlichkbbv.datlichkb.entities.Bacsi;
import com.htdatlichkbbv.datlichkb.entities.Benhnhan;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


public class LoginResContext {
    private String matk;
    private String ma_nhomnd;
    private Benhnhan bn;
    private Bacsi bs;

    public String getMatk() {
        return matk;
    }

    public void setMatk(String matk) {
        this.matk = matk;
    }

    public String getMa_nhomnd() {
        return ma_nhomnd;
    }

    public void setMa_nhomnd(String ma_nhomnd) {
        this.ma_nhomnd = ma_nhomnd;
    }

    public Benhnhan getBn() {
        return bn;
    }

    public void setBn(Benhnhan bn) {
        this.bn = bn;
    }

    public Bacsi getBs() {
        return bs;
    }

    public void setBs(Bacsi bs) {
        this.bs = bs;
    }
}

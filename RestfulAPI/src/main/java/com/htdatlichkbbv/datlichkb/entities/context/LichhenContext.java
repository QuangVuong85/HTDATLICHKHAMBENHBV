package com.htdatlichkbbv.datlichkb.entities.context;

public class LichhenContext {
    private String malichhen;
    private String mabn;
    private Short trangthai;
    private String ghichu;

    public LichhenContext(String malichhen, String mabn, Short trangthai, String ghichu) {
        this.malichhen = malichhen;
        this.mabn = mabn;
        this.trangthai = trangthai;
        this.ghichu = ghichu;
    }

    public LichhenContext() {
    }

    @Override
    public String toString() {
        return "LichhenContext{" +
                "malichhen='" + malichhen + '\'' +
                ", mabn='" + mabn + '\'' +
                ", trangthai=" + trangthai +
                ", ghichu='" + ghichu + '\'' +
                '}';
    }

    public String getMalichhen() {
        return malichhen;
    }

    public void setMalichhen(String malichhen) {
        this.malichhen = malichhen;
    }

    public String getMabn() {
        return mabn;
    }

    public void setMabn(String mabn) {
        this.mabn = mabn;
    }

    public Short getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(Short trangthai) {
        this.trangthai = trangthai;
    }

    public String getGhichu() {
        return ghichu;
    }

    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }
}

package com.htdatlichkbbv.datlichkb.entities.context;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginResBSContext {
    private String matk;
    private String ma_nhomnd;
    private String mabs;
    private String chuc_vu;
    private String hinh_anh;
    private String hoc_vi;
    private String ma_khoa;
    private String tenbs;
}

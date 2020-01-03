package com.htdatlichkbbv.datlichkb.entities.context;

import com.htdatlichkbbv.datlichkb.entities.Bacsi;
import com.htdatlichkbbv.datlichkb.entities.Benhnhan;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginResBNContext {
    private String matk;
    private String ma_nhomnd;
    private String mabn;
    private String dia_chi;
    private String email;
    private Short gioi_tinh;
    private String ho_ten;
    private String sodt;
}

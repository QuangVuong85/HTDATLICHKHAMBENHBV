package com.htdatlichkbbv.datlichkb.entities.context;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TKLichHenBSContext {
    private String mabs;
    private String tenbs;
    private String ngaykham;
    private String trangthai;
    private Integer soluong;
}

package com.htdatlichkbbv.datlichkb.entities.context;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginResContext {
    private String matk;
    private String ma_nhomnd;
}

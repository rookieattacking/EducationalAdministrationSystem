package org.lanqiao.educationaladministrationsystem.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseUtil<T> {
    private Integer code;
    private String msg;
    private T data;

    public ResponseUtil(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}

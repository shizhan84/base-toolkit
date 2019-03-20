package cn.okcoming.areacode.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class Area implements Serializable {
    private Long id;

    private String code;

    private String parentCode;

    private String name;

}
package com.shop.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class BoardDto {

    private Long seq;

    private String name;

    private String title;

    private String content;

    private Date createDate;

    private Long cnt;
}

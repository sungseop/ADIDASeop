package com.shop.dto;


import lombok.Data;

import java.util.Date;

@Data
public class AnswerDto {

    private Long aSeq;

    private String aContent;

    private Date aCreateDate;

    private Long aBoardSeq;

    public AnswerDto() {

    }

    public AnswerDto(Long aSeq, String aContent, Date aCreateDate, Long aBoardSeq) {
        super();
        this.aSeq = aSeq;
        this.aContent = aContent;
        this.aCreateDate = aCreateDate;
        this.aBoardSeq = aBoardSeq;
    }
}

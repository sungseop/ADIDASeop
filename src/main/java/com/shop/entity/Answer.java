package com.shop.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="answer")
@Getter
@Setter
@ToString()
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="a_seq")
    private Long aSeq;

    private String aContent;

    private Long aBoardSeq;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(updatable = false)
    private Date aCreateDate = new Date();
}

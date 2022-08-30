package com.shop.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="board")
@Getter
@Setter
@ToString()
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="seq")
    private Long seq;

    private String name;

    private String title;

    private String content;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(updatable = false)
    private Date createDate = new Date();

    @Column(updatable = false)
    private Long cnt = 0L;

}

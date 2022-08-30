package com.shop.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MainItemDto {

    private Long id;

    private String itemNm;

    private String itemDetail;

    private String imgUrl;

    private Integer price;

    private String type1;

    private String type2;

    private String type3;

    private String trendItem;

    private String bestItem;

    @QueryProjection
    public MainItemDto(Long id, String itemNm, String itemDetail, String imgUrl,Integer price, String trendItem,
                       String bestItem, String type1, String type2, String type3){
        this.id = id;
        this.itemNm = itemNm;
        this.itemDetail = itemDetail;
        this.imgUrl = imgUrl;
        this.price = price;
        this.type1 = type1;
        this.type2 = type2;
        this.type3 = type3;
        this.trendItem = trendItem;
        this.bestItem = bestItem;
    }

}
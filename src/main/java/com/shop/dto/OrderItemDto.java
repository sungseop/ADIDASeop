package com.shop.dto;

import com.shop.entity.OrderItem;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderItemDto {

    public OrderItemDto(OrderItem orderItem, String imgUrl){
        this.itemNm = orderItem.getItem().getItemNm();
        this.count = orderItem.getCount();
        this.orderPrice = orderItem.getOrderPrice();
        this.imgUrl = imgUrl;
        this.memberNm = orderItem.getOrder().getMember().getName();
        this.memberAddress = orderItem.getOrder().getMember().getAddress();
    }

    private String itemNm; //상품명
    private int count; //주문 수량

    private int orderPrice; //주문 금액
    private String imgUrl; //상품 이미지 경로

    private String memberNm; // 주문자 이름

    private String memberAddress; // 주문자 주소

}
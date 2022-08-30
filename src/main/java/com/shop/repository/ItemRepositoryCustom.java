package com.shop.repository;

import com.shop.dto.ItemSearchDto;
import com.shop.entity.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.shop.dto.MainItemDto;

public interface ItemRepositoryCustom {

    Page<Item> getAdminItemPage(ItemSearchDto itemSearchDto, Pageable pageable);

    Page<MainItemDto> getItemSearch(ItemSearchDto itemSearchDto, Pageable pageable);

    Page<MainItemDto> getTrendItem(ItemSearchDto itemSearchDto, Pageable pageable);

    Page<MainItemDto> getBestItem(ItemSearchDto itemSearchDto, Pageable pageable);

    Page<MainItemDto> getMenItem(ItemSearchDto itemSearchDto, Pageable pageable);

    Page<MainItemDto> getWomenItem(ItemSearchDto itemSearchDto, Pageable pageable);

    Page<MainItemDto> getKidsItem(ItemSearchDto itemSearchDto, Pageable pageable);

    Page<MainItemDto> getSportsItem(ItemSearchDto itemSearchDto, Pageable pageable);

    Page<MainItemDto> getMenShoesItem(ItemSearchDto itemSearchDto, Pageable pageable);

    Page<MainItemDto> getMenClothingItem(ItemSearchDto itemSearchDto, Pageable pageable);

    Page<MainItemDto> getMenSuppliesItem(ItemSearchDto itemSearchDto, Pageable pageable);

    Page<MainItemDto> getWomenShoesItem(ItemSearchDto itemSearchDto, Pageable pageable);

    Page<MainItemDto> getWomenClothingItem(ItemSearchDto itemSearchDto, Pageable pageable);

    Page<MainItemDto> getWomenSuppliesItem(ItemSearchDto itemSearchDto, Pageable pageable);

    Page<MainItemDto> getKidsShoesItem(ItemSearchDto itemSearchDto, Pageable pageable);

    Page<MainItemDto> getKidsClothingItem(ItemSearchDto itemSearchDto, Pageable pageable);

    Page<MainItemDto> getKidsSuppliesItem(ItemSearchDto itemSearchDto, Pageable pageable);

    Page<MainItemDto> getSportsRunningItem(ItemSearchDto itemSearchDto, Pageable pageable);

    Page<MainItemDto> getSportsFootballItem(ItemSearchDto itemSearchDto, Pageable pageable);

    Page<MainItemDto> getSportsGolfItem(ItemSearchDto itemSearchDto, Pageable pageable);
}
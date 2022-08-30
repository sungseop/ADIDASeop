package com.shop.service;

import com.shop.dto.*;
import com.shop.entity.Item;
import com.shop.entity.ItemImg;
import com.shop.repository.ItemImgRepository;
import com.shop.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Service
@Transactional
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    private final ItemImgService itemImgService;

    private final ItemImgRepository itemImgRepository;

    public Long saveItem(ItemFormDto itemFormDto, List<MultipartFile> itemImgFileList) throws Exception{

        //상품 등록
        Item item = itemFormDto.createItem();
        itemRepository.save(item);

        //이미지 등록
        for(int i=0;i<itemImgFileList.size();i++){
            ItemImg itemImg = new ItemImg();
            itemImg.setItem(item);

            if(i == 0)
                itemImg.setRepimgYn("Y");
            else
                itemImg.setRepimgYn("N");

            itemImgService.saveItemImg(itemImg, itemImgFileList.get(i));
        }

        return item.getId();
    }

    @Transactional(readOnly = true)
    public ItemFormDto getItemDtl(Long itemId){
        List<ItemImg> itemImgList = itemImgRepository.findByItemIdOrderByIdAsc(itemId);
        List<ItemImgDto> itemImgDtoList = new ArrayList<>();
        for (ItemImg itemImg : itemImgList) {
            ItemImgDto itemImgDto = ItemImgDto.of(itemImg);
            itemImgDtoList.add(itemImgDto);
        }

        Item item = itemRepository.findById(itemId)
                .orElseThrow(EntityNotFoundException::new);
        ItemFormDto itemFormDto = ItemFormDto.of(item);
        itemFormDto.setItemImgDtoList(itemImgDtoList);
        return itemFormDto;
    }

    public Long updateItem(ItemFormDto itemFormDto, List<MultipartFile> itemImgFileList) throws Exception {
        //상품 수정
        Item item = itemRepository.findById(itemFormDto.getId())
                .orElseThrow(EntityNotFoundException::new);
        item.updateItem(itemFormDto);
        List<Long> itemImgIds = itemFormDto.getItemImgIds();

        //이미지 등록
        for(int i=0;i<itemImgFileList.size();i++){
            itemImgService.updateItemImg(itemImgIds.get(i),
                    itemImgFileList.get(i));
        }

        return item.getId();
    }

    public void deleteItem(Item item) {
        itemRepository.deleteById(item.getId());
    }

    @Transactional(readOnly = true)
    public Page<Item> getAdminItemPage(ItemSearchDto itemSearchDto, Pageable pageable) {
        return itemRepository.getAdminItemPage(itemSearchDto, pageable);
    }

    @Transactional(readOnly = true)
    public Page<MainItemDto> getItemSearch(ItemSearchDto itemSearchDto, Pageable pageable) {
        return  itemRepository.getItemSearch(itemSearchDto, pageable);
    }

    @Transactional(readOnly = true)
    public Page<MainItemDto> getTrendItem(ItemSearchDto itemSearchDto, Pageable pageable) {
        return itemRepository.getTrendItem(itemSearchDto, pageable);
    }

    @Transactional(readOnly = true)
    public Page<MainItemDto> getBestItem(ItemSearchDto itemSearchDto, Pageable pageable) {
        return itemRepository.getBestItem(itemSearchDto, pageable);
    }

    @Transactional(readOnly = true)
    public Page<MainItemDto> getMenItem(ItemSearchDto itemSearchDto, Pageable pageable) {
        return itemRepository.getMenItem(itemSearchDto, pageable);
    }

    @Transactional(readOnly = true)
    public  Page<MainItemDto> getWomenItem(ItemSearchDto itemSearchDto, Pageable pageable) {
        return itemRepository.getWomenItem(itemSearchDto, pageable);
    }

    @Transactional(readOnly = true)
    public Page<MainItemDto> getKidsItem(ItemSearchDto itemSearchDto, Pageable pageable) {
        return itemRepository.getKidsItem(itemSearchDto, pageable);
    }

    @Transactional(readOnly = true)
    public Page<MainItemDto> getSportsItem(ItemSearchDto itemSearchDto, Pageable pageable) {
        return itemRepository.getSportsItem(itemSearchDto, pageable);
    }

    @Transactional(readOnly = true)
    public Page<MainItemDto> getMenShoesItem(ItemSearchDto itemSearchDto, Pageable pageable) {
        return itemRepository.getMenShoesItem(itemSearchDto, pageable);
    }

    @Transactional(readOnly = true)
    public Page<MainItemDto> getMenClothingItem(ItemSearchDto itemSearchDto, Pageable pageable) {
        return itemRepository.getMenClothingItem(itemSearchDto, pageable);
    }

    @Transactional(readOnly = true)
    public Page<MainItemDto> getMenSuppliesItem(ItemSearchDto itemSearchDto, Pageable pageable) {
        return  itemRepository.getMenSuppliesItem(itemSearchDto, pageable);
    }

    @Transactional(readOnly = true)
    public Page<MainItemDto> getWomenShoesItem(ItemSearchDto itemSearchDto, Pageable pageable) {
        return itemRepository.getWomenShoesItem(itemSearchDto, pageable);
    }

    @Transactional(readOnly = true)
    public Page<MainItemDto> getWomenClothingItem(ItemSearchDto itemSearchDto, Pageable pageable) {
        return itemRepository.getWomenClothingItem(itemSearchDto, pageable);
    }

    @Transactional(readOnly = true)
    public Page<MainItemDto> getWomenSuppliesItem(ItemSearchDto itemSearchDto, Pageable pageable) {
        return itemRepository.getWomenSuppliesItem(itemSearchDto, pageable);
    }

    @Transactional(readOnly = true)
    public Page<MainItemDto> getKidsShoesItem(ItemSearchDto itemSearchDto, Pageable pageable) {
        return itemRepository.getKidsShoesItem(itemSearchDto, pageable);
    }

    @Transactional(readOnly = true)
    public Page<MainItemDto> getKidsClothingItem(ItemSearchDto itemSearchDto, Pageable pageable) {
        return itemRepository.getKidsClothingItem(itemSearchDto, pageable);
    }

    @Transactional(readOnly = true)
    public Page<MainItemDto> getKidsSuppliesItem(ItemSearchDto itemSearchDto, Pageable pageable) {
        return itemRepository.getKidsSuppliesItem(itemSearchDto, pageable);
    }

    @Transactional(readOnly = true)
    public Page<MainItemDto> getSportsRunningItem(ItemSearchDto itemSearchDto, Pageable pageable) {
        return itemRepository.getSportsRunningItem(itemSearchDto, pageable);
    }

    @Transactional(readOnly = true)
    public Page<MainItemDto> getSportsFootballItem(ItemSearchDto itemSearchDto, Pageable pageable) {
        return itemRepository.getSportsFootballItem(itemSearchDto, pageable);
    }

    @Transactional(readOnly = true)
    public Page<MainItemDto> getSportsGolfItem(ItemSearchDto itemSearchDto, Pageable pageable) {
        return itemRepository.getSportsGolfItem(itemSearchDto, pageable);
    }

}
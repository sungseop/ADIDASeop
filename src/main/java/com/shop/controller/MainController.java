package com.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.shop.dto.ItemSearchDto;
import com.shop.dto.MainItemDto;
import com.shop.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final ItemService itemService;

    @GetMapping(value = "/")
    public String main(ItemSearchDto itemSearchDto, Optional<Integer> page, Model model) {

        Pageable pageable = PageRequest.of(page.isPresent() ? page.get() : 0, 6);
        Page<MainItemDto> trendItems = itemService.getTrendItem(itemSearchDto, pageable);
        Page<MainItemDto> bestItems = itemService.getBestItem(itemSearchDto, pageable);

        model.addAttribute("trendItem", trendItems);
        model.addAttribute("bestItem", bestItems);
        model.addAttribute("itemSearchDto", itemSearchDto);
        model.addAttribute("maxPage", 5);

        return "main";
    }

    @GetMapping(value = "/item/search")
    public String search(ItemSearchDto itemSearchDto, Optional<Integer> page, Model model) {

        Pageable pageable = PageRequest.of(page.isPresent() ? page.get() : 0, 6);
        Page<MainItemDto> Items = itemService.getItemSearch(itemSearchDto, pageable);

        model.addAttribute("Item", Items);
        model.addAttribute("itemSearchDto", itemSearchDto);
        model.addAttribute("maxPage", 5);

        return "item/itemList";
    }

    @GetMapping(value = "/item/men")
    public String men(ItemSearchDto itemSearchDto, Optional<Integer> page, Model model) {

        Pageable pageable = PageRequest.of(page.isPresent() ? page.get() : 0, 18);
        Page<MainItemDto> Items = itemService.getMenItem(itemSearchDto, pageable);

        model.addAttribute("Item", Items);
        model.addAttribute("itemSearchDto", itemSearchDto);
        model.addAttribute("category", "MEN");
        model.addAttribute("maxPage", 5);

        return "item/itemList";
    }

    @GetMapping(value = "/item/women")
    public String women(ItemSearchDto itemSearchDto, Optional<Integer> page, Model model) {

        Pageable pageable = PageRequest.of(page.isPresent() ? page.get() : 0, 18);
        Page<MainItemDto> Items = itemService.getWomenItem(itemSearchDto, pageable);

        model.addAttribute("Item", Items);
        model.addAttribute("itemSearchDto", itemSearchDto);
        model.addAttribute("category", "WOMEN");
        model.addAttribute("maxPage", 5);

        return "item/itemList";
    }

    @GetMapping(value = "/item/kids")
    public String kids(ItemSearchDto itemSearchDto, Optional<Integer> page, Model model) {

        Pageable pageable = PageRequest.of(page.isPresent() ? page.get() : 0, 18);
        Page<MainItemDto> Items = itemService.getKidsItem(itemSearchDto, pageable);

        model.addAttribute("Item", Items);
        model.addAttribute("itemSearchDto", itemSearchDto);
        model.addAttribute("category", "KIDS");
        model.addAttribute("maxPage", 5);

        return "item/itemList";
    }

    @GetMapping(value = "/item/sports")
    public String sports(ItemSearchDto itemSearchDto, Optional<Integer> page, Model model) {

        Pageable pageable = PageRequest.of(page.isPresent() ? page.get() : 0, 18);
        Page<MainItemDto> Items = itemService.getSportsItem(itemSearchDto, pageable);

        model.addAttribute("Item", Items);
        model.addAttribute("itemSearchDto", itemSearchDto);
        model.addAttribute("category", "SPORTS");
        model.addAttribute("maxPage", 5);

        return "item/itemList";
    }

    @GetMapping(value = "/item/men/shoes")
    public String menShoes(ItemSearchDto itemSearchDto, Optional<Integer> page, Model model) {

        Pageable pageable = PageRequest.of(page.isPresent() ? page.get() : 0, 18);
        Page<MainItemDto> Items = itemService.getMenShoesItem(itemSearchDto, pageable);

        model.addAttribute("Item", Items);
        model.addAttribute("itemSearchDto", itemSearchDto);
        model.addAttribute("category", "MEN / SHOES");
        model.addAttribute("maxPage", 5);

        return "item/itemList";
    }

    @GetMapping(value = "/item/men/clothing")
    public String menClothing(ItemSearchDto itemSearchDto, Optional<Integer> page, Model model) {

        Pageable pageable = PageRequest.of(page.isPresent() ? page.get() : 0, 18);
        Page<MainItemDto> Items = itemService.getMenClothingItem(itemSearchDto, pageable);

        model.addAttribute("Item", Items);
        model.addAttribute("itemSearchDto", itemSearchDto);
        model.addAttribute("category", "MEN / CLOTHING");
        model.addAttribute("maxPage", 5);

        return "item/itemList";
    }

    @GetMapping(value = "/item/men/supplies")
    public String menSupplies(ItemSearchDto itemSearchDto, Optional<Integer> page, Model model) {

        Pageable pageable = PageRequest.of(page.isPresent() ? page.get() : 0, 18);
        Page<MainItemDto> Items = itemService.getMenSuppliesItem(itemSearchDto, pageable);

        model.addAttribute("Item", Items);
        model.addAttribute("itemSearchDto", itemSearchDto);
        model.addAttribute("category", "MEN / SUPPLIES");
        model.addAttribute("maxPage", 5);

        return "item/itemList";
    }

    @GetMapping(value = "/item/women/shoes")
    public String womenShoes(ItemSearchDto itemSearchDto, Optional<Integer> page, Model model) {

        Pageable pageable = PageRequest.of(page.isPresent() ? page.get() : 0, 18);
        Page<MainItemDto> Items = itemService.getWomenShoesItem(itemSearchDto, pageable);

        model.addAttribute("Item", Items);
        model.addAttribute("itemSearchDto", itemSearchDto);
        model.addAttribute("category", "WOMEN / SHOES");
        model.addAttribute("maxPage", 5);

        return "item/itemList";
    }

    @GetMapping(value = "/item/women/clothing")
    public String womenClothing(ItemSearchDto itemSearchDto, Optional<Integer> page, Model model) {

        Pageable pageable = PageRequest.of(page.isPresent() ? page.get() : 0, 18);
        Page<MainItemDto> Items = itemService.getWomenClothingItem(itemSearchDto, pageable);

        model.addAttribute("Item", Items);
        model.addAttribute("itemSearchDto", itemSearchDto);
        model.addAttribute("category", "WOMEN / CLOTHING");
        model.addAttribute("maxPage", 5);

        return "item/itemList";
    }

    @GetMapping(value = "/item/women/supplies")
    public String womenSupplies(ItemSearchDto itemSearchDto, Optional<Integer> page, Model model) {

        Pageable pageable = PageRequest.of(page.isPresent() ? page.get() : 0, 18);
        Page<MainItemDto> Items = itemService.getWomenSuppliesItem(itemSearchDto, pageable);

        model.addAttribute("Item", Items);
        model.addAttribute("itemSearchDto", itemSearchDto);
        model.addAttribute("category", "WOMEN / SUPPLIES");
        model.addAttribute("maxPage", 5);

        return "item/itemList";
    }

    @GetMapping(value = "/item/kids/shoes")
    public String kidsShoes(ItemSearchDto itemSearchDto, Optional<Integer> page, Model model) {

        Pageable pageable = PageRequest.of(page.isPresent() ? page.get() : 0, 18);
        Page<MainItemDto> Items = itemService.getKidsShoesItem(itemSearchDto, pageable);

        model.addAttribute("Item", Items);
        model.addAttribute("itemSearchDto", itemSearchDto);
        model.addAttribute("category", "KIDS / SHOES");
        model.addAttribute("maxPage", 5);

        return "item/itemList";
    }

    @GetMapping(value = "/item/kids/clothing")
    public String kidsClothing(ItemSearchDto itemSearchDto, Optional<Integer> page, Model model) {

        Pageable pageable = PageRequest.of(page.isPresent() ? page.get() : 0, 18);
        Page<MainItemDto> Items = itemService.getKidsClothingItem(itemSearchDto, pageable);

        model.addAttribute("Item", Items);
        model.addAttribute("itemSearchDto", itemSearchDto);
        model.addAttribute("category", "KIDS / CLOTHING");
        model.addAttribute("maxPage", 5);

        return "item/itemList";
    }

    @GetMapping(value = "/item/kids/supplies")
    public String kidsSupplies(ItemSearchDto itemSearchDto, Optional<Integer> page, Model model) {

        Pageable pageable = PageRequest.of(page.isPresent() ? page.get() : 0, 18);
        Page<MainItemDto> Items = itemService.getKidsSuppliesItem(itemSearchDto, pageable);

        model.addAttribute("Item", Items);
        model.addAttribute("itemSearchDto", itemSearchDto);
        model.addAttribute("category", "KIDS / SUPPLIES");
        model.addAttribute("maxPage", 5);

        return "item/itemList";
    }

    @GetMapping(value = "/item/sports/running")
    public String sportsRunning(ItemSearchDto itemSearchDto, Optional<Integer> page, Model model) {

        Pageable pageable = PageRequest.of(page.isPresent() ? page.get() : 0, 18);
        Page<MainItemDto> Items = itemService.getSportsRunningItem(itemSearchDto, pageable);

        model.addAttribute("Item", Items);
        model.addAttribute("itemSearchDto", itemSearchDto);
        model.addAttribute("category", "SPORTS / RUNNING");
        model.addAttribute("maxPage", 5);

        return "item/itemList";
    }

    @GetMapping(value = "/item/sports/football")
    public String sportsFootball(ItemSearchDto itemSearchDto, Optional<Integer> page, Model model) {

        Pageable pageable = PageRequest.of(page.isPresent() ? page.get() : 0, 18);
        Page<MainItemDto> Items = itemService.getSportsFootballItem(itemSearchDto, pageable);

        model.addAttribute("Item", Items);
        model.addAttribute("itemSearchDto", itemSearchDto);
        model.addAttribute("category", "SPORTS / FOOTBALL");
        model.addAttribute("maxPage", 5);

        return "item/itemList";
    }

    @GetMapping(value = "/item/sports/golf")
    public String sportsGolf(ItemSearchDto itemSearchDto, Optional<Integer> page, Model model) {

        Pageable pageable = PageRequest.of(page.isPresent() ? page.get() : 0, 18);
        Page<MainItemDto> Items = itemService.getSportsGolfItem(itemSearchDto, pageable);

        model.addAttribute("Item", Items);
        model.addAttribute("itemSearchDto", itemSearchDto);
        model.addAttribute("category", "SPORTS / GOLF");
        model.addAttribute("maxPage", 5);

        return "item/itemList";
    }
}
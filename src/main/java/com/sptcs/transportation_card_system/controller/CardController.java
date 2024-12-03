package com.sptcs.transportation_card_system.controller;

import com.sptcs.transportation_card_system.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/card")
public class CardController {

    @Autowired
    private CardService cardService;

    @PostMapping("/add")
    public boolean addCard(@RequestParam Map<String, Object> requestMap) {
        return cardService.saveCardDetails( requestMap );
    }

}

package com.sptcs.transportation_card_system.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sptcs.transportation_card_system.model.Card;
import com.sptcs.transportation_card_system.model.User;
import com.sptcs.transportation_card_system.repository.CardRepository;
import com.sptcs.transportation_card_system.utils.AppConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.Map;

@Service
public class CardService {

    @Autowired
    private CardRepository cardRepository;


    public boolean saveCardDetails( Map<String, Object> requestMap ) {


        try {


            Long    userId              =          Long.parseLong( requestMap.get("userId").toString());
            Long    uid                 =          Long.parseLong( requestMap.get("uid").toString());
            Integer cardType            =          Integer.parseInt( requestMap.get("type").toString());

            //By Default the card balance should be 0.
            Double  balance             =          Double.valueOf("0.0");

            //Expiration will be after 5 years of registration.
            LocalDate    expirationDate =          LocalDate.now().plusYears(5);

            User         user           =          new User();
            user.setId( userId );

            Card         card           =          new Card( user, uid, cardType, balance, expirationDate,
                    AppConstants.CARD_TYPE_ACTIVE, "Admin");

            cardRepository.save( card );

            return true;

        } catch ( Exception e ) {

            e.printStackTrace();
            return false;

        }


    }
}

package com.sptcs.transportation_card_system.repository;

import com.sptcs.transportation_card_system.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {

}

package com.example.currencyexchangeservice.dao;

import com.example.currencyexchangeservice.model.ExchangeValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;

@Repository
public interface ExchangeValeRepository extends JpaRepository<ExchangeValue,Long> {


    public ExchangeValue findByFromAndTo(String from, String to);
}

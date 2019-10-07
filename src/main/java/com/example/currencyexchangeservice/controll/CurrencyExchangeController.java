package com.example.currencyexchangeservice.controll;

import com.example.currencyexchangeservice.dao.ExchangeValeRepository;
import com.example.currencyexchangeservice.model.ExchangeValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashMap;

@RestController
public class CurrencyExchangeController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private Environment environment;
    @Autowired
    private ExchangeValeRepository exchangeValeRepository;

    @GetMapping(path = "/currency-exchange/from/{from}/to/{to}")
    public ExchangeValue getCurrencyExchange(@PathVariable String from, @PathVariable String to){



        ExchangeValue exchangeValue = exchangeValeRepository.findByFromAndTo(from, to);
        exchangeValue.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
        logger.info("{}",exchangeValue);
        return exchangeValue;
    }


    public String getCurrencyExchange(@PathVariable String from){


        ExchangeValue exchangeValue = exchangeValeRepository.findByFromAndTo(from);
        exchangeValue.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
        logger.info("{}",exchangeValue);
        return null;
    }
}

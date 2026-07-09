package com.cognizant.ormlearn.service;

import com.cognizant.ormlearn.model.Stock;
import com.cognizant.ormlearn.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.time.LocalDate;


@Service
public class StockService {

    @Autowired
    private StockRepository stockRepository;

    public List<Stock> getAllStocks() {
        return stockRepository.findAll();
    }


    public List<Stock> getFacebookStocksForSeptember2019() {

        return stockRepository.findByCodeAndDateBetween(
                "FB",
                LocalDate.of(2019, 9, 1),
                LocalDate.of(2019, 9, 30)
        );

    }


    public List<Stock> getGoogleStocksAbove1250() {

        return stockRepository.findByCodeAndCloseGreaterThan(
                "GOOGL",
                1250
        );

    }


    public List<Stock> getTop3HighestVolumeStocks() {
        return stockRepository.findTop3ByOrderByVolumeDesc();
    }


    public List<Stock> getLowestNetflixStocks() {

        return stockRepository.findTop3ByCodeOrderByCloseAsc("NFLX");

    }
}
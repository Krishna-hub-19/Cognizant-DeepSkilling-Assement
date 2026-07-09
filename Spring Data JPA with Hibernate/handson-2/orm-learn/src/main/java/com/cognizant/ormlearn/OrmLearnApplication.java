package com.cognizant.ormlearn;

import com.cognizant.ormlearn.model.Stock;
import com.cognizant.ormlearn.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.time.LocalDate;

@SpringBootApplication
public class OrmLearnApplication implements CommandLineRunner {

    private final StockService stockService;

    public OrmLearnApplication(StockService stockService) {
        this.stockService = stockService;
    }


    public static void main(String[] args) {
        SpringApplication.run(OrmLearnApplication.class, args);
    }

    @Override
    public void run(String... args) {

        stockService
                .getGoogleStocksAbove1250()
                .forEach(System.out::println);

    }
}
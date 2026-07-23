package com.cognizant.springlearn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@SpringBootApplication
public class SpringLearnApplication {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(SpringLearnApplication.class);

    public static void main(String[] args) {

        SpringApplication.run(SpringLearnApplication.class, args);

        displayDate();

//        displayCountry();

        displayCountries();

    }

    public static void displayDate() {

        LOGGER.info("START");

        ApplicationContext context =
                new ClassPathXmlApplicationContext("date-format.xml");

        SimpleDateFormat format =
                context.getBean("dateFormat", SimpleDateFormat.class);

        try {

            Date date = format.parse("31/12/2018");

            LOGGER.debug("Date : {}", date);

        } catch (Exception e) {

            LOGGER.error("Exception occurred while parsing date", e);

        }

        LOGGER.info("END");
    }

    public static void displayCountry() {

        LOGGER.info("START");

        ApplicationContext context =
                new ClassPathXmlApplicationContext("country.xml");

        Country country =
                context.getBean("country", Country.class);

        Country anotherCountry =
                context.getBean("country", Country.class);

        LOGGER.debug("Country 1 : {}", country);
        LOGGER.debug("Country 2 : {}", anotherCountry);

        LOGGER.info("Same Object : {}", country == anotherCountry);

        LOGGER.info("END");
    }


    @SuppressWarnings("unchecked")
    public static void displayCountries() {

        LOGGER.info("START");

        ApplicationContext context =
                new ClassPathXmlApplicationContext("country.xml");

        ArrayList<Country> countryList =
                context.getBean("countryList", ArrayList.class);

        LOGGER.debug("Countries : {}", countryList);

        LOGGER.info("END");
    }
}
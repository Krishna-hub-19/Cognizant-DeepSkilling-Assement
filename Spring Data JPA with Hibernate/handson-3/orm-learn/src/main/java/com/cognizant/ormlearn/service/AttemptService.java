package com.cognizant.ormlearn.service;

import com.cognizant.ormlearn.model.Attempt;
import com.cognizant.ormlearn.repository.AttemptRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AttemptService {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(AttemptService.class);

    @Autowired
    private AttemptRepository attemptRepository;

    @Transactional
    public Attempt getAttemptDetail(int id) {

        LOGGER.info("Start");

        Attempt attempt = attemptRepository.getAttemptDetail(id);

        LOGGER.info("End");

        return attempt;
    }
}
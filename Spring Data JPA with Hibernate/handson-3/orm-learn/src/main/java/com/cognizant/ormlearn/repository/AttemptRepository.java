package com.cognizant.ormlearn.repository;

import com.cognizant.ormlearn.model.Attempt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AttemptRepository extends JpaRepository<Attempt, Integer> {

    // Using JOIN FETCH to retrieve the complete quiz attempt graph in a single query.
    @Query("""
           SELECT DISTINCT a
           FROM Attempt a
           LEFT JOIN FETCH a.user
           LEFT JOIN FETCH a.attemptQuestionList aq
           LEFT JOIN FETCH aq.question q
           LEFT JOIN FETCH q.optionList
           LEFT JOIN FETCH aq.attemptOptionList ao
           LEFT JOIN FETCH ao.option
           WHERE a.id = :attemptId
           """)
    Attempt getAttemptDetail(@Param("attemptId") int attemptId);

}
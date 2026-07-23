package com.cognizant.springlearn;

import com.cognizant.springlearn.controller.CountryController;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.junit.jupiter.api.Test;

@SpringBootTest
@AutoConfigureMockMvc
class SpringLearnApplicationTests {

    @Autowired
    private CountryController countryController;

    @Autowired
    private MockMvc mvc;

    @Test
    void contextLoads() {
        assertNotNull(countryController);
    }

    @Test
    void testGetCountry() throws Exception {

        ResultActions actions =
                mvc.perform(get("/country"));

        actions.andExpect(status().isOk());

        actions.andExpect(jsonPath("$.code").exists());

        actions.andExpect(jsonPath("$.code").value("IN"));

        actions.andExpect(jsonPath("$.name").exists());

        actions.andExpect(jsonPath("$.name").value("India"));
    }

    @Test
    void testGetCountryException() throws Exception {

        ResultActions actions =
                mvc.perform(get("/countries/az"));

        actions.andExpect(status().isNotFound());

        actions.andExpect(jsonPath("$.status").value(404));

        actions.andExpect(jsonPath("$.error").value("Not Found"));

        actions.andExpect(jsonPath("$.message").value("Country not found"));
    }
}
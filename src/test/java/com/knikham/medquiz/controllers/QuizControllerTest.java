package com.knikham.medquiz.controllers;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


public class QuizControllerTest extends BaseControllerTest {

    @Test
    public void getCategories() throws Exception {
       mockMvc.perform(get("/Categories"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void getQuestionByCategory() throws Exception {
        mockMvc.perform(get("/Quiz/{title}", "Cardiology"))
                .andExpect(status().isOk())
                .andDo(print());
    }

}
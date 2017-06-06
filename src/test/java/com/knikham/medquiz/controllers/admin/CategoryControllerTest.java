package com.knikham.medquiz.controllers.admin;

import com.knikham.medquiz.controllers.BaseControllerTest;
import org.hibernate.sql.Delete;
import org.junit.Test;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


public class CategoryControllerTest extends BaseControllerTest {

    @Test
    public void getCategories() throws Exception {
        mockMvc.perform(get("/Admin/Categories/"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void getCategoryByTitle() throws Exception {
        mockMvc.perform(get("/Admin/Categories/{title}", "Cardiology"))
                        .andExpect(status().isOk())
                        .andDo(print());
    }

    @Test
    public void createCategory() throws Exception {
        mockMvc.perform(post("/Admin/Categories/{title}", "surgery"))
                .andExpect(status().isCreated());

        mockMvc.perform(get("/Admin/Categories/"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void deleteCategory() throws Exception {
        mockMvc.perform(delete("/Admin/Categories/{title}", "Cardiology"))
                .andExpect(status().isOk());

        mockMvc.perform(get("/Admin/Categories/"))
                .andExpect(status().isNoContent());
    }

    @Test
    public void updateCategory() throws Exception {

        mockMvc.perform(put("/Admin/Categories/{title}/{newTitle}",
                "Cardiology", "Surgery"))
                .andExpect(status().isOk());

        mockMvc.perform(get("/Admin/Categories/"))
                .andExpect(status().isOk())
                .andDo(print());
    }

}
package com.tus.pointsstore.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.tus.pointsstore.Mapper.GiftMapper;
import com.tus.pointsstore.Model.Gift;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(GiftController.class)
class GiftControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper mapper;

    @MockBean
    GiftMapper giftMapper;
    Gift gift = new Gift(1, "", "", 1, 3, "");

    @Test
    void findAll() throws Exception {
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/AllGifts"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", is("")));
    }

    @Test
    void getUserById() throws Exception {
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/GetGift/" + 1))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", is("")));
    }

    @Test
    void insert() throws Exception {
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(gift);
        mockMvc.perform(MockMvcRequestBuilders
                        .post("/InsertGift")
                        .contentType(MediaType.APPLICATION_JSON).content(requestJson))
                .andExpect(status().isOk())
                //.andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$", is("")));
    }

    @Test
    void update() throws Exception {
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(gift);
        mockMvc.perform(MockMvcRequestBuilders
                        .post("/UpdateGift")
                        .contentType(MediaType.APPLICATION_JSON).content(requestJson))
                .andExpect(status().isOk())
                //.andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$", is("")));
    }

    @Test
    void deleteUser() throws Exception {
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        mockMvc.perform(MockMvcRequestBuilders
                        .delete("/deleteGift/" + 1))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", is("")));
    }
}
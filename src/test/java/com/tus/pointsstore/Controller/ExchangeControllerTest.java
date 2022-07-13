package com.tus.pointsstore.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.tus.pointsstore.Mapper.ExchangeMapper;
import com.tus.pointsstore.Model.Exchange_his;
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

@WebMvcTest(ExchangeController.class)
class ExchangeControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper mapper;

    @MockBean
    ExchangeMapper exchangeMapper;
    Exchange_his his = new Exchange_his(1, 1, 1, 1, 3, "", "", "");

    @Test
    void testfindAll() throws Exception {
        //Mockito.when(exchangeMapper.exchange(his)).thenReturn(true);

        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(his);
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/AllHis"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", is("")));
    }

    @Test
    void testExchange_his() throws Exception {
        //Mockito.when(exchangeMapper.exchange(his)).thenReturn(true);

        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(his);
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/GetHis/" + 1))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", is("")));
    }

    @Test
    void testinsert() throws Exception {
        //Mockito.when(exchangeMapper.exchange(his)).thenReturn(true);

        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(his);
        mockMvc.perform(MockMvcRequestBuilders
                        .post("/InsertHis")
                        .contentType(MediaType.APPLICATION_JSON).content(requestJson))
                .andExpect(status().isOk())
                //.andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$", is("")));
    }

    @Test
    void testDelete() throws Exception {
        //Mockito.when(exchangeMapper.exchange(his)).thenReturn(true);

        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        mockMvc.perform(MockMvcRequestBuilders
                        .delete("/deleteHis/" + 1))
                .andExpect(status().isOk())
                //.andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$", is("")));
    }

    @Test
    void testexchange() throws Exception {
        //Mockito.when(exchangeMapper.exchange(his)).thenReturn(true);

        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(his);
        mockMvc.perform(MockMvcRequestBuilders
                        .post("/Exchange")
                        .contentType(MediaType.APPLICATION_JSON).content(requestJson))
                .andExpect(status().isOk())
                //.andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$", is("")));
    }
}
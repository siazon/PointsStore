package com.tus.pointsstore.Service;

import com.tus.pointsstore.Mapper.ExchangeMapper;
import com.tus.pointsstore.Model.Exchange_his;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = ExchangeService.class)
public class ExchangeServiceTest {

    @Autowired
    ExchangeMapper exchangeMapper;

    Exchange_his his = new Exchange_his(1, 1, 1, 1, 3, "", "", "");

    @Test
    public void exchange() {
        //Mockito.when(exchangeMapper.exchange(his)).thenReturn(true);
    }
}
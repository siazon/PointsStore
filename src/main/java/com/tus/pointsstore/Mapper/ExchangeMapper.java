package com.tus.pointsstore.Mapper;

import com.tus.pointsstore.Model.Exchange_his;
import com.tus.pointsstore.Model.Exchange_info;

import java.util.List;

public interface ExchangeMapper {
    boolean insert(Exchange_his exchange_his);

    boolean exchange(List<Exchange_his> exchange_his);


    int update(Exchange_his exchange_his);

    int deleteById(int id);

    Exchange_his findById(int id);

    List<Exchange_his> findAll();

    List<Exchange_info> findAllInfo(String email);
}

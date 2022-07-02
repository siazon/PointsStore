package com.tus.pointsstore.Mapper;

import com.tus.pointsstore.Model.*;

import java.util.List;

public interface GiftMapper {
    Gift insert(Gift gift);

    int update(Gift gift);

    int deleteById(int id);

    Gift findById(int id);

    List<Gift> findAll();
}

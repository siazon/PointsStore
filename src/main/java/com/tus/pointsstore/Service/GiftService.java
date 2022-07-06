package com.tus.pointsstore.Service;

import com.tus.pointsstore.Mapper.GiftMapper;
import com.tus.pointsstore.Model.Gift;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * This class implements the methods in the GiftMapper interface to perform
 * operations which register, find, update, delete and login a Gift.
 **/

@Repository
public class GiftService implements GiftMapper {

    public Gift gift;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Gift insert(Gift gift) {
        jdbcTemplate.update(
                "insert into tb_gifts (name, info, price, stock, pic) " +
                        "values(?,?,?,?,?)",
                gift.getName(), gift.getInfo(), gift.getPrice(), gift.getStock(),
                gift.getPic());

        return gift;

    }

    @Override
    public int update(Gift gift) {
        return jdbcTemplate.update(
                "update tb_gifts set name = ?,info=?,price=?,stock=?,pic=? where id = ?",
                gift.getName(), gift.getInfo(), gift.getPrice(), gift.getStock(), gift.getPic(), gift.getId());
    }

    @Override
    public int deleteById(int id) {
        return jdbcTemplate.update("DELETE FROM tb_gifts WHERE id=?", id);
    }

    @Override
    public Gift findById(int id) {

        return jdbcTemplate.queryForObject("SELECT * FROM tb_gifts WHERE id=?", new Object[]{id}, (rs, rowNum) ->
                new Gift(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("info"),
                        rs.getInt("price"),
                        rs.getInt("stock"),
                        rs.getString("pic")

                ));

    }


    @Override
    public List<Gift> findAll() {
        return jdbcTemplate.query(
                "select * from tb_gifts",
                (rs, rowNum) ->
                        new Gift(
                                rs.getInt("id"),
                                rs.getString("name"),
                                rs.getString("info"),
                                rs.getInt("price"),
                                rs.getInt("stock"),
                                rs.getString("pic")

                        )
        );
    }


}


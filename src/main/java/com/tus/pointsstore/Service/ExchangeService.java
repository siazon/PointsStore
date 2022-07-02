package com.tus.pointsstore.Service;

import com.tus.pointsstore.Mapper.ExchangeMapper;
import com.tus.pointsstore.Model.Exchange_his;
import com.tus.pointsstore.Model.Exchange_info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * This class implements the methods in the GiftMapper interface to perform
 * operations which register, find, update, delete and login a Gift.
 **/

@Repository
public class ExchangeService implements ExchangeMapper {

    public Exchange_his exchange_his;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public boolean insert(Exchange_his exchange_his) {
        int res = jdbcTemplate.update(
                "insert into tb_exchange_his (gift_id, user_id, qty, time, address,delivery) " +
                        "values(?,?,?,?,?,?)",
                exchange_his.getGift_id(), exchange_his.getUser_id(), exchange_his.getQty(), exchange_his.getTime(),
                exchange_his.getAddress(), exchange_his.getDelivery());

        return res > 0;

    }

    @Override
    @Transactional
    public boolean exchange(List<Exchange_his> exchange_his) {
        int res = 0;
        for (Exchange_his his : exchange_his) {
            res = jdbcTemplate.update(
                    "UPDATE tb_user set points=points-? where id=? ;",
                    his.getAmount(), his.getUser_id());

            res += jdbcTemplate.update(
                    "UPDATE tb_gifts set stock=stock-? where id=?;",
                    his.getQty(), his.getGift_id());

            res += jdbcTemplate.update(
                    "insert into tb_exchange_his (gift_id, user_id, qty,amount, time, address,delivery) " +
                            "values(?,?,?,?,?,?,?)",
                    his.getGift_id(), his.getUser_id(), his.getQty(), his.getAmount(), his.getTime(),
                    his.getAddress(), his.getDelivery());
        }
        return res >= 3;
    }

    @Override
    public int update(Exchange_his exchange_his) {
        return jdbcTemplate.update(
                "update tb_gifts set name = ? where id = ?",
                exchange_his.getGift_id(), exchange_his.getUser_id());
    }

    @Override
    public int deleteById(int id) {
        return jdbcTemplate.update("DELETE FROM tb_gifts WHERE id=?", id);
    }

    @Override
    public Exchange_his findById(int id) {

        return jdbcTemplate.queryForObject("SELECT * FROM tb_gifts WHERE id=?", new Object[]{id}, (rs, rowNum) ->
                new Exchange_his(
                        rs.getInt("id"),
                        rs.getInt("gift_id"),
                        rs.getInt("user_id"),
                        rs.getInt("qty"),
                        rs.getInt("amount"),
                        rs.getString("time"),
                        rs.getString("address"),
                        rs.getString("delivery")

                ));

    }

    @Override
    public List<Exchange_info> findAllInfo(String email) {
        return jdbcTemplate.query(
                "SELECT a.id, gift_id,user_id,qty,amount,time,address,delivery,name,info,pic from tb_exchange_his a INNER JOIN tb_user b on a.user_id=b.id INNER JOIN tb_gifts c on a.gift_id=c.id where b.user_email=?",
                new Object[]{email}, (rs, rowNum) ->
                        new Exchange_info(
                                rs.getInt("id"),
                                rs.getInt("gift_id"),
                                rs.getInt("user_id"),
                                rs.getInt("qty"),
                                rs.getInt("amount"),
                                rs.getString("time"),
                                rs.getString("address"),
                                rs.getString("delivery"),
                                rs.getString("name"),
                                rs.getString("info"),
                                rs.getString("pic")
                        )
        );
    }

    @Override
    public List<Exchange_his> findAll() {
        return jdbcTemplate.query(
                "select * from tb_gifts",
                (rs, rowNum) ->
                        new Exchange_his(
                                rs.getInt("id"),
                                rs.getInt("gift_id"),
                                rs.getInt("user_id"),
                                rs.getInt("qty"),
                                rs.getInt("amount"),
                                rs.getString("time"),
                                rs.getString("address"),
                                rs.getString("delivery")

                        )
        );
    }


}


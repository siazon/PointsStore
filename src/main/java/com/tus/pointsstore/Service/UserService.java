package com.tus.pointsstore.Service;

import com.tus.pointsstore.Mapper.UserMapper;
import com.tus.pointsstore.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * This class implements the methods in the UserMapper interface to perform
 * operations which register, find, update, delete and login a user.
 **/

@Repository
public class UserService implements UserMapper {

    public User user;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * create a new user
     *
     * @param user
     * @return
     */
    @Override
    public User insert(User user) {
        jdbcTemplate.update(
                "insert into tb_user (user_name, user_email, user_phone, user_password, user_role,points) " +
                        "values(?,?,?,?,?,?)",
                user.getUser_name(), user.getUser_email(), user.getUser_phone(), user.getUser_password(),
                user.getUser_role(), user.getpoints());

        return user;

    }

    /**
     * update user
     *
     * @param user
     * @return the number of succese
     */
    @Override
    public int update(User user) {
        return jdbcTemplate.update(
                "update tb_user set user_name=?,user_email=?,user_phone=?,user_password=?,points=? where id=?",
                user.getUser_name(), user.getUser_email(), user.getUser_phone(), user.getUser_password(), user.getpoints(), user.getId());
    }

    /**
     * delete user by id
     *
     * @param id
     * @return
     */
    @Override
    public int deleteById(int id) {
        return jdbcTemplate.update("DELETE FROM tb_user WHERE id=?", id);
    }

    /**
     * get user by id
     *
     * @param id
     * @return user entity
     */
    @Override
    public User findById(int id) {

        return jdbcTemplate.queryForObject("SELECT * FROM tb_user WHERE id=?", new Object[]{id}, (rs, rowNum) ->
                new User(
                        rs.getInt("id"),
                        rs.getString("user_email"),
                        rs.getString("user_name"),
                        rs.getString("user_phone"),
                        rs.getString("user_password"),
                        rs.getString("user_role"),
                        rs.getInt("points")

                ));

    }

    /**
     * find by Email
     *
     * @param email
     * @return user entity
     */
    @Override
    public User findByEmail(String email) {

        return jdbcTemplate.queryForObject("SELECT * FROM tb_user WHERE user_email=?", new Object[]{email}, (rs, rowNum) ->
                new User(
                        rs.getInt("id"),
                        rs.getString("user_email"),
                        rs.getString("user_name"),
                        rs.getString("user_phone"),
                        rs.getString("user_password"),
                        rs.getString("user_role"),
                        rs.getInt("points")

                ));

    }

    /**
     * fileAll
     *
     * @return user list
     */
    @Override
    public List<User> findAll() {
        return jdbcTemplate.query(
                "select * from tb_user",
                (rs, rowNum) ->
                        new User(
                                rs.getInt("id"),
                                rs.getString("user_email"),
                                rs.getString("user_name"),
                                rs.getString("user_phone"),
                                rs.getString("user_password"),
                                rs.getString("user_role"),
                                rs.getInt("points")

                        )
        );
    }


}


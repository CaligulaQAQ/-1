package dao;

import pojo.User;

import java.sql.SQLException;

public interface UserDao {
    User selectByName(String username) throws SQLException;
}

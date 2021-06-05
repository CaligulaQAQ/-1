package service;

import pojo.User;

import java.sql.SQLException;

public interface UserService {
    boolean selectUserByName(User user) throws SQLException;
    boolean selectUserByName(String username) throws SQLException;
}

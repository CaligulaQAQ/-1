package service.impl;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import pojo.User;
import service.UserService;

import java.sql.SQLException;

public class UserServiceImpl implements UserService {
    UserDao userDao = new UserDaoImpl();
    @Override
    public boolean selectUserByName(User user)  {
        User u = null;
        try {
            u = userDao.selectByName(user.getUsername());
            if(u != null){
                if (u.getPassword().equals(user.getPassword())){
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
       return false;
    }

    @Override
    public boolean selectUserByName(String username) {
        try {
            User user = userDao.selectByName(username);
            if (user!= null){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}

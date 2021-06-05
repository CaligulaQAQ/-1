package dao.impl;

import dao.UserDao;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import pojo.User;
import util.JDBCUtils;

import java.sql.SQLException;

public class UserDaoImpl implements UserDao {
    @Override
    public User selectByName(String username) throws SQLException {
        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
        Object[] args = {username};
        return qr.query("select * from user where username =?",new BeanHandler<User>(User.class),username);
    }
}

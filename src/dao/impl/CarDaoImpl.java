package dao.impl;

import dao.CarDao;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import pojo.Car;
import util.JDBCUtils;

import java.sql.SQLException;
import java.util.List;

public class CarDaoImpl implements CarDao {
    @Override
    public List<Car> limit(Integer currentPage, Integer pageSize) throws SQLException {
        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
        String sql = "select * from car limit ?,?";
        Object[] args = {(currentPage-1)*pageSize,pageSize};
        return qr.query(sql,new BeanListHandler<Car>(Car.class),args);
    }

    @Override
    public int count() throws SQLException {
        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
        String sql = "select count(*) from car";
        return qr.query(sql,new ScalarHandler<Number>()).intValue();
    }
}

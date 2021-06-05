package dao.impl;

import dao.ParkuseDao;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import pojo.Parkuse;
import util.JDBCUtils;

import java.sql.SQLException;
import java.util.List;

public class ParkuseDaoimpl implements ParkuseDao {
    @Override
    public List<Parkuse> limit(Integer currentPage, Integer pageSize) throws SQLException {
        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
        String sql = "select * from parkuse limit ?,?";
        Object[] args = {(currentPage-1)*pageSize,pageSize};
        return qr.query(sql, new BeanListHandler<Parkuse>(Parkuse.class),args);
    }

    @Override
    public int count() throws SQLException {
        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
        String sql = "select count(*) from parkuse";
        return qr.query(sql,new ScalarHandler<Number>()).intValue();
    }
}

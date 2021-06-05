package dao.impl;

import dao.HouseDao;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import pojo.House;
import util.JDBCUtils;

import java.sql.SQLException;
import java.util.List;

public class HouseDaoImpl implements HouseDao {
    @Override
    public List<House> limit() throws SQLException {
        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
        String sql = "select * from house";
        return qr.query(sql,new BeanListHandler<House>(House.class));
    }
}

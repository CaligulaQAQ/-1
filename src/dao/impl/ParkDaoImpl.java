package dao.impl;

import dao.ParkDao;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import pojo.Park;
import util.JDBCUtils;

import java.sql.SQLException;
import java.util.List;

public class ParkDaoImpl implements ParkDao {
    @Override
    public List<Park> limit() throws SQLException {
        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
        String sql = "SELECT park.id,park.cname,park.parknum,park.parkname,park.createtime,parkuse.status FROM park LEFT JOIN parkuse ON park.parknum = parkuse.parknum";
        return qr.query(sql,new BeanListHandler<Park>(Park.class));
    }

}

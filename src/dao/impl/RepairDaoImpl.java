package dao.impl;

import dao.RepairDao;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import pojo.Repair;
import util.JDBCUtils;

import java.sql.SQLException;
import java.util.List;

public class RepairDaoImpl implements RepairDao {
    @Override
    public List<Repair> limit() throws SQLException {
        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
        String sql = "select * from repair";
        return qr.query(sql, new BeanListHandler<Repair>(Repair.class));
    }
}

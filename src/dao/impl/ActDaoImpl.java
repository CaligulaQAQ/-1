package dao.impl;

import dao.ActDao;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import pojo.Act;
import util.JDBCUtils;

import java.sql.SQLException;
import java.util.List;

public class ActDaoImpl implements ActDao {
    @Override
    public List<Act> limit() throws SQLException {
        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
        String sql = "select * from activity";
        return qr.query(sql,new BeanListHandler<Act>(Act.class));
    }
}

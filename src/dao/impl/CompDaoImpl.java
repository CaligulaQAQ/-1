package dao.impl;

import dao.CompDao;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import pojo.Comp;
import util.JDBCUtils;

import java.sql.SQLException;
import java.util.List;

public class CompDaoImpl implements CompDao {
    @Override
    public List<Comp> limit() throws SQLException {
        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
        String sql = "select * from complaint";
        return qr.query(sql,new BeanListHandler<Comp>(Comp.class));
    }
}

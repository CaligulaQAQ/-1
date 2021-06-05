package dao.impl;

import dao.PeopleDao;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import pojo.People;
import util.JDBCUtils;

import java.sql.SQLException;
import java.util.List;

public class PeopleDaoImpl implements PeopleDao {
    @Override
    public List<People> limit() throws SQLException {
        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
        String sql = "select * from people";
        return qr.query(sql,new BeanListHandler<People>(People.class));
    }
}

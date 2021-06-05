package dao.impl;

import dao.PetDao;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import pojo.Pet;
import util.JDBCUtils;

import java.sql.SQLException;
import java.util.List;

public class PetDaoImpl implements PetDao {
    @Override
    public List<Pet> limit(Integer currentPage, Integer pageSize) throws SQLException {
        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
            String sql = "select * from pet limit ?,?";
            Object[] args = {(currentPage-1)*pageSize,pageSize};
            return qr.query(sql,new BeanListHandler<Pet>(Pet.class),args);
    }

    @Override
    public int count() throws SQLException {
        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
            String sql = "select count(*) from pet";
            return qr.query(sql,new ScalarHandler<Number>()).intValue();
    }
}

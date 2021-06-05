package dao.impl;

import dao.ComDao;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import pojo.Com;
import util.JDBCUtils;

import java.sql.SQLException;
import java.util.List;

public  class ComDaoImpl implements ComDao {
    @Override
    public List<Com> selectAll() throws SQLException {
        QueryRunner qr =new QueryRunner(JDBCUtils.getDataSource());
        String sql = "select * from community";
        return qr.query(sql,new BeanListHandler<Com>(Com.class));
    }

    @Override
    public int deleteCom(int id) throws SQLException {
        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
        String sql = "delete from community where id = ?";
        Object[] args = {id};
        return qr.update(sql,args);
    }

    @Override
    public int addCom(Com com) throws SQLException {
        QueryRunner qr =new QueryRunner(JDBCUtils.getDataSource());
        String sql = "insert into community (cno, cname, caddress, area, numbuild, numfamily, greenrate, img, developer, company, createTime, status) values (?,?,?,?,?,?,?,?,?,?,?,?)";
        Object[] args = {com.getCno(),com.getCname(),com.getCaddress(),com.getArea(),com.getNumbuild(),com.getNumfamily(),com.getGreenrate(),com.getImg(),com.getDeveloper(),com.getCompany(),com.getCreateTime(),com.getStatus()};
        return qr.update(sql,args);
    }

    @Override
    public Com selectOne(int id) throws SQLException {
        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
        String sql = "select * from community where id = ?";
        Object[] args = {id};
        return qr.query(sql,new BeanHandler<Com>(Com.class),args);
    }

    @Override
    public int updateCom(Com com) throws SQLException {
        QueryRunner qr =new QueryRunner(JDBCUtils.getDataSource());
        String sql = "update community set cno=?, cname=?, caddress=?, area=?, numbuild=?, numfamily=?, greenrate=?, img=?, developer=?, company=?, createTime=?, status=? where id=?";
        Object[] args = {com.getCno(),com.getCname(),com.getCaddress(),com.getArea(),com.getNumbuild(),com.getNumfamily(),com.getGreenrate(),com.getImg(),com.getDeveloper(),com.getCompany(),com.getCreateTime(),com.getStatus(),com.getId()};
        return qr.update(sql,args);
    }

    public List<Com> searchCom(String cname) throws SQLException{
        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
        String sql = "select * from community where cname like ?";
        Object[] args = {"%"+cname+"%"};
        return qr.query(sql,new BeanListHandler<Com>(Com.class),args);
    }

    @Override
    public List<Com> limit(Integer currentPage, Integer pageSize, String cname) throws SQLException {
        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
        if (cname == null){
            String sql = "select * from community limit ?,?";
            Object[] args = {(currentPage-1)*pageSize,pageSize};
            return qr.query(sql,new BeanListHandler<Com>(Com.class),args);
        }else {
            String sql = "select * from community where cname like ? limit ?,?";
            Object[] args = {"%"+cname+"%",(currentPage-1)*pageSize,pageSize};
            return qr.query(sql,new BeanListHandler<Com>(Com.class),args);
        }
    }

    @Override
    public int count(String cname) throws SQLException {
        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
        if (cname == null){
            String sql = "select count(*) from community";
            return qr.query(sql,new ScalarHandler<Number>()).intValue();
        }else {
            String sql = "select count(*) from community where cname like ?";
            return qr.query(sql,new ScalarHandler<Number>(),"%"+cname+"%").intValue();

        }
    }

}

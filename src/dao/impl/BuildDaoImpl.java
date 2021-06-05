package dao.impl;

import dao.BuildDao;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import pojo.Build;
import util.JDBCUtils;

import java.sql.SQLException;
import java.util.List;

public class BuildDaoImpl implements BuildDao {
    @Override
    public List<Build> selectAll() throws SQLException {
        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
        String sql = "select * from build";
        return qr.query(sql,new BeanListHandler<Build>(Build.class));
    }

    @Override
    public int deleteBuild(int id) throws SQLException {
        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
        String sql = "delete from build where id = ?";
        Object[] args = {id};
        return qr.update(sql,args);
    }

    @Override
    public int addBuild(Build build) throws SQLException {
        QueryRunner qr =new QueryRunner(JDBCUtils.getDataSource());
        String sql = "insert into build (cname, buildnumber,buildname,population,discription,createtime) values (?,?,?,?,?,?)";
        Object[] args = {build.getCname(),build.getBuildnumber(),build.getBuildname(),build.getPopulation(),build.getDiscription(),build.getCreatetime()};
        return qr.update(sql,args);
    }

    @Override
    public Build selectOne(int id) throws SQLException {
        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
        String sql = "select * from build where id = ?";
        Object[] args = {id};
        return qr.query(sql,new BeanHandler<Build>(Build.class),args);
    }

    @Override
    public int updateBuild(Build build) throws SQLException {
        QueryRunner qr =new QueryRunner(JDBCUtils.getDataSource());
        String sql = "update build set cname=?, buildnumber=? ,buildname=?, population=?, discription=?, createtime=? where id=?";
        Object[] args = {build.getCname(),build.getBuildnumber(),build.getBuildname(),build.getPopulation(),build.getDiscription(),build.getCreatetime(),build.getId()};
        return qr.update(sql,args);
    }

    @Override
    public List<Build> searchBuild(String cname) throws SQLException {
        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
        String sql = "select * from build where cname like ?";
        Object[] args = {"%"+cname+"%"};
        return qr.query(sql,new BeanListHandler<Build>(Build.class),args);
    }

    @Override
    public List<Build> limit(Integer currentPage, Integer pageSize, String cname) throws SQLException {
        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
        if (cname == null){
            String sql = "select * from build limit ?,?";
            Object[] args = {(currentPage-1)*pageSize,pageSize};
            return qr.query(sql,new BeanListHandler<Build>(Build.class),args);
        }else {
            String sql = "select * from build where cname like ? limit ?,?";
            Object[] args = {"%"+cname+"%",(currentPage-1)*pageSize,pageSize};
            return qr.query(sql,new BeanListHandler<Build>(Build.class),args);
        }
    }

    @Override
    public int count(String cname) throws SQLException {
        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
        if (cname == null){
            String sql = "select count(*) from build";
            return qr.query(sql,new ScalarHandler<Number>()).intValue();
        }else {
            String sql = "select count(*) from build where cname like ?";
            return qr.query(sql,new ScalarHandler<Number>(),"%"+cname+"%").intValue();

        }
    }

    @Override
    public List<Build> selectName(String cname) throws SQLException {
        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
        String sql = "select buildname from build where cname=?";
        return qr.query(sql,new BeanListHandler<Build>(Build.class),cname);
    }
}

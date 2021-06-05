package dao;

import pojo.Build;

import java.sql.SQLException;
import java.util.List;

public interface BuildDao {
    List<Build> selectAll() throws SQLException;
    int deleteBuild(int id) throws SQLException;
    int addBuild(Build build) throws SQLException;
    Build selectOne(int id) throws SQLException;
    int updateBuild(Build com) throws SQLException;
    List<Build> searchBuild(String cname) throws SQLException;
    List<Build> limit(Integer currentPage,Integer pageSize,String cname) throws SQLException;
    int count(String cname) throws SQLException;
    List<Build> selectName(String cname) throws SQLException;
}

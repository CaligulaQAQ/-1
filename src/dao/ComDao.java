package dao;

import pojo.Com;

import java.sql.SQLException;
import java.util.List;

public interface ComDao {
    List<Com> selectAll() throws SQLException;
    int deleteCom(int id) throws SQLException;
    int addCom(Com com) throws SQLException;
    Com selectOne(int id) throws SQLException;
    int updateCom(Com com) throws SQLException;
    List<Com> searchCom(String cname) throws SQLException;
    List<Com> limit(Integer currentPage,Integer pageSize,String cname) throws SQLException;
    int count(String cname) throws SQLException;
}

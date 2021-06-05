package dao;

import pojo.Parkuse;

import java.sql.SQLException;
import java.util.List;

public interface ParkuseDao {
    List<Parkuse> limit(Integer currentPage, Integer pageSize) throws SQLException;
    int count() throws SQLException;
}

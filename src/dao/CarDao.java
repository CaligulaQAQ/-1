package dao;

import pojo.Car;

import java.sql.SQLException;
import java.util.List;

public interface CarDao {
    List<Car> limit(Integer currentPage, Integer pageSize) throws SQLException;
    int count() throws SQLException;
}

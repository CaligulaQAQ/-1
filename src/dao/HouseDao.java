package dao;

import pojo.House;

import java.sql.SQLException;
import java.util.List;

public interface HouseDao {
    List<House> limit() throws SQLException;
}

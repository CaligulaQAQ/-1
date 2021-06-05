package dao;

import pojo.Park;

import java.sql.SQLException;
import java.util.List;

public interface ParkDao {
    List<Park> limit() throws SQLException;
}

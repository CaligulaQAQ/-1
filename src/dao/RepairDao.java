package dao;

import pojo.Repair;

import java.sql.SQLException;
import java.util.List;

public interface RepairDao {
    List<Repair> limit() throws SQLException;
}

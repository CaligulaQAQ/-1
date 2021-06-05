package dao;

import pojo.Act;

import java.sql.SQLException;
import java.util.List;

public interface ActDao {
    List<Act> limit() throws SQLException;
}

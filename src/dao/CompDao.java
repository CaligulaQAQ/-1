package dao;

import pojo.Comp;

import java.sql.SQLException;
import java.util.List;

public interface CompDao {
    List<Comp> limit() throws SQLException;
}

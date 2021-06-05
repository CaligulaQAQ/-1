package dao;

import pojo.People;

import java.sql.SQLException;
import java.util.List;

public interface PeopleDao {
    List<People> limit() throws SQLException;
}

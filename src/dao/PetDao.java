package dao;

import pojo.Pet;

import java.sql.SQLException;
import java.util.List;

public interface PetDao {
    List<Pet> limit(Integer currentPage, Integer pageSize) throws SQLException;
    int count() throws SQLException;
}

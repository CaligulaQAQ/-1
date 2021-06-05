package service.impl;

import dao.HouseDao;
import dao.impl.HouseDaoImpl;
import pojo.DataResult;
import pojo.House;
import service.HouseService;

import java.sql.SQLException;
import java.util.List;

public class HouseServiceImpl implements HouseService {
    HouseDao houseDao = new HouseDaoImpl();
    @Override
    public DataResult limit() {
        try {
            List<House> limit = houseDao.limit();
            DataResult dataResult = new DataResult(0,"查询成功",limit);
            return dataResult;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DataResult dataResult = new DataResult(40000,"查询失败");
        return dataResult;
    }
}

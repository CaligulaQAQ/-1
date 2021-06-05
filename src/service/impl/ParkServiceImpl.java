package service.impl;

import dao.ParkDao;
import dao.impl.ParkDaoImpl;
import pojo.DataResult;
import pojo.Park;
import service.ParkService;

import java.sql.SQLException;
import java.util.List;

public class ParkServiceImpl implements ParkService {
    ParkDao parkDao = new ParkDaoImpl();
    @Override
    public DataResult limit() {
        try {
            List<Park> parkList = parkDao.limit();
            DataResult dataResult = new DataResult(0,"查询成功",parkList);
            return dataResult;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DataResult dataResult = new DataResult(0,"查询失败");
        return dataResult;
    }
}

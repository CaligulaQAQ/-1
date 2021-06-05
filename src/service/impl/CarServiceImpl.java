package service.impl;

import dao.CarDao;
import dao.impl.CarDaoImpl;
import pojo.Car;
import pojo.DataResult;
import service.CarService;

import java.sql.SQLException;
import java.util.List;

public class CarServiceImpl implements CarService {
    @Override
    public DataResult limit(String currentPage, String pageSize) {
        CarDao carDao = new CarDaoImpl();
        int c = 1;
        int p = 3;
        if (currentPage != null) {
            c = Integer.parseInt(currentPage);
        }
        if (pageSize != null) {
            p = Integer.parseInt(pageSize);
        }
        try {
            List<Car> carList = carDao.limit(c, p);
            DataResult dataResult = new DataResult(0, "查询成功", carList, carDao.count());
            return dataResult;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DataResult dataResult = new DataResult(40000, "查询失败");
        return dataResult;
    }
}

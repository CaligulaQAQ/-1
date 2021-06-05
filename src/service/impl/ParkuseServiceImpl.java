package service.impl;

import dao.ParkuseDao;
import dao.impl.ParkuseDaoimpl;
import pojo.DataResult;
import pojo.Parkuse;
import service.ParkuseService;

import java.sql.SQLException;
import java.util.List;

public class ParkuseServiceImpl implements ParkuseService {
    ParkuseDao parkuseDao = new ParkuseDaoimpl();

    @Override
    public DataResult limit(String currentPage, String pageSize) {
        int c = 1;
        int p = 3;
        if (currentPage != null) {
            c = Integer.parseInt(currentPage);
        }
        if (pageSize != null) {
            p = Integer.parseInt(pageSize);
        }
        try {
            List<Parkuse> parkuseList = parkuseDao.limit(c, p);
            DataResult dataResult = new DataResult(0, "查询成功", parkuseList, parkuseDao.count());
            return dataResult;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DataResult dataResult = new DataResult(40000, "接口数据错误");
        return dataResult;
    }
}


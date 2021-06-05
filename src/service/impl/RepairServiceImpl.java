package service.impl;

import dao.RepairDao;
import dao.impl.RepairDaoImpl;
import pojo.DataResult;
import pojo.Repair;
import service.RepairSerice;

import java.sql.SQLException;
import java.util.List;

public class RepairServiceImpl implements RepairSerice {
    @Override
    public DataResult limit() {
        RepairDao repairDao = new RepairDaoImpl();
        try {
            List<Repair> parkList = repairDao.limit();
            DataResult dataResult = new DataResult(0,"查询成功",parkList);
            return dataResult;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DataResult dataResult = new DataResult(0,"查询失败");
        return dataResult;
    }
}

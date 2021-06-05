package service.impl;

import dao.CompDao;
import dao.impl.CompDaoImpl;
import pojo.Comp;
import pojo.DataResult;
import service.CompService;

import java.sql.SQLException;
import java.util.List;

public class CompServiceImpl implements CompService {
    @Override
    public DataResult limit() {
        CompDao compDao = new CompDaoImpl();
        try {
            List<Comp> limit = compDao.limit();
            DataResult dataResult = new DataResult(0,"查询成功",limit);
            return dataResult;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DataResult dataResult = new DataResult(40000,"查询失败");
        return dataResult;
    }
}

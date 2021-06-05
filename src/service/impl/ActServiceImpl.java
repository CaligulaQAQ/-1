package service.impl;

import dao.ActDao;
import dao.impl.ActDaoImpl;
import pojo.Act;
import pojo.DataResult;
import service.ActService;

import java.sql.SQLException;
import java.util.List;

public class ActServiceImpl implements ActService {
    @Override
    public DataResult limit() {
        ActDao actDao = new ActDaoImpl();
        try {
            List<Act> limit = actDao.limit();
            DataResult dataResult = new DataResult(0,"查询成功",limit);
            return dataResult;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DataResult dataResult = new DataResult(40000,"查询失败");
        return dataResult;
    }
}

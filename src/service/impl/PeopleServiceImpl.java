package service.impl;

import dao.PeopleDao;
import dao.impl.PeopleDaoImpl;
import pojo.DataResult;
import pojo.People;
import service.PeopleService;

import java.sql.SQLException;
import java.util.List;

public class PeopleServiceImpl implements PeopleService {
    PeopleDao peopleDao = new PeopleDaoImpl();
    @Override
    public DataResult limit() {
        try {
            List<People> limit = peopleDao.limit();
            DataResult dataResult = new DataResult(0,"查询成功",limit);
            return dataResult;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DataResult dataResult = new DataResult(40000,"查询失败");
        return dataResult;
    }
}

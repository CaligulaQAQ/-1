package service.impl;

import dao.ComDao;
import dao.impl.ComDaoImpl;
import pojo.Com;
import pojo.DataResult;
import service.ComService;

import java.sql.SQLException;
import java.util.List;

public class ComServiceImpl implements ComService {
    ComDao comDao = new ComDaoImpl();
    @Override
    public List<Com> selectAll()  {
        try {
            return comDao.selectAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int deleteCom(String id) {
        int no = Integer.parseInt(id);
        try {
            return comDao.deleteCom(no);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int addCom(Com com) {
        try {
            return comDao.addCom(com);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public Com selectOne(String id) {
        int no = Integer.parseInt(id);
        try {
            return comDao.selectOne(no);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int updateCom(Com com) {
        try {
            return comDao.updateCom(com);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<Com> searchCom(String cname) {
        try {
            return comDao.searchCom(cname);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public DataResult limit(String currentPage, String pageSize, String cname) {
        int c = 1;
        int p = 3;
        if (currentPage != null){
           c = Integer.parseInt(currentPage);
        }
        if (pageSize != null){
            p = Integer.parseInt(pageSize);
        }
        try {
            List<Com> comList = comDao.limit(c, p, cname);
            DataResult dataResult = new DataResult(0,"查询成功",comList,comDao.count(cname));
            return dataResult;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DataResult dataResult = new DataResult(40000,"接口数据错误");
        return dataResult;
    }
}

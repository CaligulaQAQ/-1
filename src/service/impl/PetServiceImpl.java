package service.impl;

import dao.PetDao;
import dao.impl.PetDaoImpl;
import pojo.DataResult;
import pojo.Pet;
import service.PetService;

import java.sql.SQLException;
import java.util.List;

public class PetServiceImpl implements PetService {
    PetDao petDao = new PetDaoImpl();
    @Override
    public DataResult limit(String currentPage, String pageSize) {
        int c = 1;
        int p = 3;
        if (currentPage != null){
            c = Integer.parseInt(currentPage);
        }
        if (pageSize != null){
            p = Integer.parseInt(pageSize);
        }
        try {
            List<Pet> petList = petDao.limit(c,p);
            DataResult dataResult = new DataResult(0,"查询成功",petList,petDao.count());
            return dataResult;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DataResult dataResult = new DataResult(40000,"接口数据错误");
        return dataResult;
    }
}

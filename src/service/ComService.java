package service;

import pojo.Com;
import pojo.DataResult;

import java.util.List;

public interface ComService {
    List<Com> selectAll();
    int deleteCom(String id);
    int addCom(Com com);
    Com selectOne(String id);
    int updateCom(Com com);
    List<Com> searchCom(String cname);
    //分页
    DataResult limit(String currentPage, String pageSize, String cname);
}

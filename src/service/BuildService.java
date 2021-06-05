package service;

import pojo.Build;
import pojo.DataResult;

import java.util.List;

public interface BuildService {
    List<Build> selectAll();
    int deleteBuild(int id);
    int addBuild(Build build);
    //Excel导入数据
    int addAllBuild(List<String[]> data);
    Build selectOne(int id);
    int updateBuild(Build build);
    int deleteAllBuild(String[] ids);
    List<Build> searchBuild(String cname);
    //分页
    DataResult limit(String currentPage, String pageSize, String cname);
    //下拉框
    String[] selectCom();

    String[] selectName(String cname);
}

package service.impl;

import dao.BuildDao;
import dao.impl.BuildDaoImpl;
import pojo.Build;
import pojo.Com;
import pojo.DataResult;
import service.BuildService;
import service.ComService;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

public class BuildServiceImpl implements BuildService {
    BuildDao buildDao = new BuildDaoImpl();
    @Override
    public List<Build> selectAll() {
        try {
            return buildDao.selectAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
            return null;
    }

    @Override
    public int deleteBuild(int id) {
        try {
            return buildDao.deleteBuild(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int addBuild(Build build) {
        try {
            return buildDao.addBuild(build);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int addAllBuild(List<String[]> data)  {
       if (data == null || data.size() == 0){
           return 0;
       }
        for (String[] row : data) { //表示一行的数据
            Build build = new Build();
            build.setCname(row[0]);
            build.setBuildnumber(row[1]);
            build.setBuildname(row[2]);
            build.setPopulation(Integer.parseInt(row[3]));
            build.setDiscription(row[4]);
            try {
                build.setCreatetime(new SimpleDateFormat("yyyy-MM-dd").parse(row[5]));
            } catch (Exception e) {
                e.printStackTrace();
            }
            addBuild(build);
        }
        return data.size();
    }

    @Override
    public Build selectOne(int id) {
        try {
            return buildDao.selectOne(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int updateBuild(Build build) {
        try {
            return buildDao.updateBuild(build);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int deleteAllBuild(String[] ids) {
        //1.直接循环删除单个的方法
        for (String id : ids) {
            int count = deleteBuild(Integer.parseInt(id));
        }
        return ids.length;
    }

    @Override
    public List<Build> searchBuild(String cname) {
        try {
            return buildDao.searchBuild(cname);
        } catch (Exception e) {
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
            List<Build> buildList = buildDao.limit(c, p, cname);
            DataResult dataResult = new DataResult(0,"查询成功",buildList,buildDao.count(cname));
            return dataResult;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DataResult dataResult = new DataResult(40000,"接口数据错误");
        return dataResult;
    }

    @Override
    public String[] selectCom() {
        ComService comService = new ComServiceImpl();
        try {
            List<Com> buildList = comService.selectAll();
            String[] com = new String[buildList.size()];
            for (int i = 0; i < buildList.size(); i++) {
                com[i] = buildList.get(i).getCname();
            }
            return com;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String[] selectName(String cname) {
        try {
            List<Build> buildList = buildDao.selectName(cname);
            String[] buildname = new String[buildList.size()];
            for (int i = 0; i < buildList.size(); i++) {
                buildname[i] = buildList.get(i).getBuildname();
            }
            return buildname;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}

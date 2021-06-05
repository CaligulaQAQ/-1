package servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import pojo.Com;
import pojo.DataResult;
import service.ComService;
import service.impl.ComServiceImpl;
import util.FileUploadUtil;
import util.JDBCUtils;
import util.JsonToArray;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/com/*")
@MultipartConfig
public class ComServlet extends BaseServlet {
    public DataResult all(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //1.获取请求参数
        String page = request.getParameter("page");
        String limit = request.getParameter("limit");
        //获取模糊查询的数据
        String cname = request.getParameter("cname");
        //2.调用service层方法
        ComService comService = new ComServiceImpl();
        DataResult dataResult = comService.limit(page, limit, cname);
        return dataResult;
    }

    public DataResult del(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //1.获取请求参数
        String id = request.getParameter("id");
        //2.调用service层方法
        ComService comService = new ComServiceImpl();
        int count = comService.deleteCom(id);
        DataResult dataResult;
        if (count > 0) {
            dataResult = new DataResult(0, "删除成功");
        } else {
            dataResult = new DataResult(40000, "删除失败");
        }
        return dataResult;
    }

    public DataResult one(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //1.获取请求参数
        String id = request.getParameter("id");
        //2.调用service层方法
        ComService comService = new ComServiceImpl();
        Com com = comService.selectOne(id);
        DataResult dataResult = new DataResult(0, "查询成功", com);
        return dataResult;
    }

    public DataResult update(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //1.获取请求参数
        String info = request.getParameter("info");
        //将前端传递的json字符串转换成java对象
        ObjectMapper mapper = new ObjectMapper();
        Com com = mapper.readValue(info, Com.class);
        //2.调用service层方法
        ComService comService = new ComServiceImpl();
        int count = comService.updateCom(com);
        DataResult dataResult;
        if (count > 0) {
            dataResult = new DataResult(0, "修改成功");

        } else {
            dataResult = new DataResult(40000, "修改失败");
        }
        return dataResult;
    }

    public DataResult add(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //1.获取请求参数
        String info = request.getParameter("info");
        //将前端传递的json字符串转换成java对象
        ObjectMapper mapper = new ObjectMapper();
        Com com = mapper.readValue(info, Com.class);
        //2.调用service层方法
        ComService comService = new ComServiceImpl();
        int count = comService.addCom(com);
        DataResult dataResult;
        if (count > 0) {
            dataResult = new DataResult(0, "增加成功");

        } else {
            dataResult = new DataResult(40000, "增加失败");
        }
        return dataResult;
    }

    public DataResult upload(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //调用工具类上传文件
        DataResult dataResult;
        try {
            String sqlPath = FileUploadUtil.upload(request);
            //将地址返回给前端
            dataResult = new DataResult(0, "上传成功", sqlPath);
        } catch (Exception e) {
            e.printStackTrace();
            dataResult = new DataResult(40000, "上传失败");
        }
        return dataResult;
    }

    public DataResult delList(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ComService comService = new ComServiceImpl();
        //获取json字符串数组
        String info = request.getParameter("info");
        //将字符串转换成list集合
        List<Com> coms = JsonToArray.parseJSONArray(info, Com.class);
        int sum = 0;
        DataResult dataResult;
        JDBCUtils.start();
        for(int i = 0; i < coms.size();i++){
            Integer m = coms.get(i).getId();
            int count = comService.deleteCom(m.toString());
            sum = sum +count;
        }
        if (sum == coms.size()){
            dataResult = new DataResult(0,"删除成功");
            JDBCUtils.commit();
        }else {
            dataResult = new DataResult(40000,"删除失败");
            JDBCUtils.rollback();
        }
        return dataResult;
    }

    public Map echarts(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map<String,Object> map = new HashMap<>();
        ComService comService = new ComServiceImpl();
        List<Com> coms = comService.selectAll();
        String[] cname = new String[coms.size()];
        int[] num = new int[coms.size()];
        for (int i = 0; i < coms.size(); i++) {
            cname[i] = coms.get(i).getCname();
            num[i] = coms.get(i).getNumfamily();
        }
        map.put("code",0);
        map.put("xData",cname);
        map.put("yData",num);
        return map;
    }

}

package servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import pojo.Build;
import pojo.DataResult;
import service.BuildService;
import service.impl.BuildServiceImpl;
import util.ExcelUtils;
import util.FileUploadUtil;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/build/*")
@MultipartConfig
public class BuildServlet extends BaseServlet{
    public DataResult all(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //1.获取请求参数
        String page = request.getParameter("page");
        String limit = request.getParameter("limit");
        //获取模糊查询的数据
        String cname = request.getParameter("cname");
        //2.调用service层方法
        BuildService buildService = new BuildServiceImpl();
        DataResult dataResult = buildService.limit(page, limit, cname);
        return dataResult;
    }

    public DataResult del(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //1.获取请求参数
        String id = request.getParameter("id");
        //2.调用service层方法
        BuildService buildService = new BuildServiceImpl();
        int count = buildService.deleteBuild(Integer.parseInt(id));
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
        BuildService buildService = new BuildServiceImpl();
        Build build = buildService.selectOne(Integer.parseInt(id));
        DataResult dataResult = new DataResult(0, "查询成功", build);
        return dataResult;
    }

    public DataResult update(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //1.获取请求参数
        String info = request.getParameter("info");
        //将前端传递的json字符串转换成java对象
        ObjectMapper mapper = new ObjectMapper();
        Build build = mapper.readValue(info, Build.class);
        //2.调用service层方法
        BuildService buildService = new BuildServiceImpl();
        int count = buildService.updateBuild(build);
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
        Build build = mapper.readValue(info, Build.class);
        //2.调用service层方法
        BuildService buildService = new BuildServiceImpl();
        int count = buildService.addBuild(build);
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
       //1.获取请求参数
        String ids = request.getParameter("ids");
        //通过Jackson将json字符串转换成java对象
        ObjectMapper mapper = new ObjectMapper();
        String[] idArr = mapper.readValue(ids, String[].class);
        //2.调用service层方法
        BuildService buildService = new BuildServiceImpl();
        int count = buildService.deleteAllBuild(idArr);
        DataResult dataResult;
        if (count > 0){
            dataResult = new DataResult(0,"删除"+count+"条数据成功");
        }else {
            dataResult = new DataResult(40000,"删除失败");
        }
        return dataResult;
    }

    public DataResult uploadExcel(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //1.根据上传文件获取文件的输入流对象
        Part part = request.getPart("file");
        InputStream in = part.getInputStream();
        //2.获取上传文件的后缀名
        String fileName = part.getSubmittedFileName();
        String fileExt = fileName.substring(fileName.lastIndexOf(".")+1);
        //3.调用工具类中的导入方法
        List<String[]> data = ExcelUtils.importData(fileExt,in,1);
        //4.调用service方法，将数据插入到数据库
        BuildService buildService = new BuildServiceImpl();
        int count = buildService.addAllBuild(data);
        DataResult dataResult;
        if (count > 0){
            dataResult = new DataResult(0,"添加"+count+"条数据成功");
        }else {
            dataResult = new DataResult(40000,"删除失败");
        }
        return dataResult;
    }

    public void downloadExcel(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //1.获取所有的Build数据
        BuildService buildService = new BuildServiceImpl();
        List<Build> buildList = buildService.selectAll();
        //设置响应头，告知浏览器是下载操作
        response.setHeader("Content-Disposition","attachment;filename=table.xls");
        //设置MINE类型
        response.setContentType("application/vnd.ms-excel");
        //2.将buildlist转换成表格
        //定义表格头
        String[] titles = {"ID","所属小区","栋数编号","栋数名称","总户数","描述","创建时间"};
        //将buildlist转换成List<String[]>类型
        ExcelUtils.export(titles,toArray(buildList),response.getOutputStream());
    }

    public List<String[]> toArray(List<Build> buildList){
        List<String[]> data = new ArrayList<>();
        for (Build build : buildList) {
            String[] row = new String[7];
            row[0] = String.valueOf(build.getId());
            row[1] = build.getCname();
            row[2] = build.getBuildnumber();
            row[3] = build.getBuildname();
            row[4] = build.getPopulation()+"";
            row[5] = build.getDiscription();
            row[6] = new SimpleDateFormat("yyyy-MM-dd").format(build.getCreatetime());
            data.add(row);
        }
        return data;
    }

    public String[] sel(HttpServletRequest request, HttpServletResponse response)throws Exception{
        BuildService buildService = new BuildServiceImpl();
        return buildService.selectCom();
    }

    public String[] select(HttpServletRequest request, HttpServletResponse response)throws Exception{
        BuildService buildService = new BuildServiceImpl();
        String data = request.getParameter("data");
        String[] strings = buildService.selectName(data);
        return strings;
    }


}

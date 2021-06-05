package servlet;

import pojo.DataResult;
import service.ParkuseService;
import service.impl.ParkuseServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/parkuse/*")
public class ParkuseServlet extends BaseServlet {
    public DataResult all(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //1.获取请求参数
        String page = request.getParameter("page");
        String limit = request.getParameter("limit");

        //2.调用service层方法
        ParkuseService parkuseService = new ParkuseServiceImpl();
        DataResult dataResult = parkuseService.limit(page, limit);
        return dataResult;
    }
}

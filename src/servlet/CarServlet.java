package servlet;

import pojo.DataResult;
import service.CarService;
import service.impl.CarServiceImpl;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/car/*")
@MultipartConfig
public class CarServlet extends BaseServlet{
    public DataResult all(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //1.获取请求参数
        String page = request.getParameter("page");
        String limit = request.getParameter("limit");

        //2.调用service层方法
        CarService carService = new CarServiceImpl();
        DataResult dataResult = carService.limit(page, limit);
        return dataResult;
    }
}

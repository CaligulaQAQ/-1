package servlet;

import pojo.DataResult;
import service.ParkService;
import service.impl.ParkServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/park/*")
public class ParkServlet extends BaseServlet {
    public DataResult all(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //2.调用service层方法
        ParkService parkService = new ParkServiceImpl();
        DataResult dataResult = parkService.limit();
        return dataResult;
    }
}

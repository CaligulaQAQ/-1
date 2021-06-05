package servlet;

import pojo.DataResult;
import service.HouseService;
import service.impl.HouseServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/house/*")
public class HouseServlet extends BaseServlet{
    public DataResult all(HttpServletRequest request, HttpServletResponse response){
        HouseService houseService = new HouseServiceImpl();
        DataResult dataResult = houseService.limit();
        return dataResult;
    }
}

package servlet;

import pojo.DataResult;
import service.CompService;
import service.impl.CompServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/comp/*")
public class CompServlet extends BaseServlet {
    public DataResult all(HttpServletRequest request, HttpServletResponse response){
        CompService compService = new CompServiceImpl();
        DataResult dataResult = compService.limit();
        return dataResult;
    }
}

package servlet;

import pojo.DataResult;
import service.ActService;
import service.impl.ActServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/act/*")
public class ActServlet extends BaseServlet{
    public DataResult all(HttpServletRequest request, HttpServletResponse response){
        ActService actService = new ActServiceImpl();
        DataResult dataResult = actService.limit();
        return dataResult;
    }
}

package servlet;

import pojo.DataResult;
import service.PetService;
import service.impl.PetServiceImpl;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/pet/*")
@MultipartConfig
public class PetServlet extends  BaseServlet{
    public DataResult all(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //1.获取请求参数
        String page = request.getParameter("page");
        String limit = request.getParameter("limit");

        //2.调用service层方法
        PetService petService = new PetServiceImpl();
        DataResult dataResult = petService.limit(page, limit);
        return dataResult;
    }
}

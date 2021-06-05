package servlet;

import pojo.DataResult;
import service.PeopleService;
import service.impl.PeopleServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/people/*")
public class PeopleServlet extends BaseServlet{
    public DataResult all(HttpServletRequest request, HttpServletResponse response){
        PeopleService peopleService = new PeopleServiceImpl();
        DataResult limit = peopleService.limit();
        return limit;
    }
}

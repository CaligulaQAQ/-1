package servlet;

import pojo.DataResult;
import service.MailService;
import service.impl.MailServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mail/*")
public class MailServlet extends BaseServlet{
    public DataResult all(HttpServletRequest request, HttpServletResponse response){
        MailService mailService = new MailServiceImpl();
        DataResult dataResult = mailService.limit();
        return dataResult;
    }
}

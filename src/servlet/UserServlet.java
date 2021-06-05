package servlet;

import pojo.DataResult;
import pojo.User;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

@WebServlet("/user/*")
public class UserServlet extends BaseServlet{
    public DataResult login(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String code = request.getParameter("code");
        //调用service方法
        UserService userService = new UserServiceImpl();
        User user = new User(username, password);
        boolean flag = userService.selectUserByName(user);
        DataResult dataResult;
        if (flag) {
            HttpSession session = request.getSession();
            String text = (String) session.getAttribute("text");
            if (code!=null && code.equalsIgnoreCase(text)){
                dataResult = new DataResult(0,"登录成功",user);
                //登录成功将User对象存入到session中
                session.setAttribute("loginUser",user);
            }else {
                dataResult = new DataResult(40000,"验证码不正确");
            }
        }else {
            dataResult = new DataResult(40000,"账户或密码错误");
        }
        HttpSession session = request.getSession();
        session.removeAttribute("text");
        return dataResult;
    }
}

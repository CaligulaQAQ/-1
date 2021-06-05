package servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import pojo.DataResult;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;


public class BaseServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("application/json;charset=utf-8");
        //获取请求参数method
        String methodName = request.getParameter("method");
        if (methodName == null && methodName == ""){
            DataResult dataResult = new DataResult(0,"请求参数method错误");
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(dataResult);
            response.getWriter().write(json);
        }
        //利用放射调用方法
        Class<? extends BaseServlet> aClass = this.getClass(); //子类类对象
        try {
            Method method = aClass.getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            Object result = method.invoke(aClass.newInstance(), request, response);
            if (result != null){
                ObjectMapper mapper = new ObjectMapper();
                response.getWriter().write(mapper.writeValueAsString(result));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

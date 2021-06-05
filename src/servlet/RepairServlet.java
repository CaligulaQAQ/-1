package servlet;

import pojo.DataResult;
import service.RepairSerice;
import service.impl.RepairServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/repair/*")
public class RepairServlet extends BaseServlet {
    public DataResult all(HttpServletRequest request, HttpServletResponse response){
        RepairSerice repairSerice = new RepairServiceImpl();
        DataResult dataResult = repairSerice.limit();
        return dataResult;
    }
}

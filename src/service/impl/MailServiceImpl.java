package service.impl;

import dao.MailDao;
import dao.impl.MailDaoImpl;
import pojo.DataResult;
import pojo.Mail;
import service.MailService;

import java.sql.SQLException;
import java.util.List;

public class MailServiceImpl implements MailService {
    MailDao mailDao = new MailDaoImpl();
    @Override
    public DataResult limit() {
        try {
            List<Mail> parkList = mailDao.limit();
            DataResult dataResult = new DataResult(0,"查询成功",parkList);
            return dataResult;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DataResult dataResult = new DataResult(0,"查询失败");
        return dataResult;
    }
}

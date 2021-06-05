package dao.impl;

import dao.MailDao;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import pojo.Mail;
import util.JDBCUtils;

import java.sql.SQLException;
import java.util.List;

public class MailDaoImpl implements MailDao {
    @Override
    public List<Mail> limit() throws SQLException {
        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
        String sql = "select * from mailbox";
        return qr.query(sql,new BeanListHandler<Mail>(Mail.class));
    }
}

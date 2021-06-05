package dao;

import pojo.Mail;

import java.sql.SQLException;
import java.util.List;

public interface MailDao {
    List<Mail> limit() throws SQLException;
}

package util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCUtils {
    //定义数据库连接池对象
    private static DataSource dataSource;

    static {
        try {
            //1.创建properties对象
            Properties properties = new Properties();
            //通过类加载器获取classpath下的配置文件
            InputStream in = JDBCUtils.class.getClassLoader().getResourceAsStream("db.properties");
            //2.加载流中的内容到Properties对象中
            properties.load(in);
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //获取连接池对象
    public static DataSource getDataSource() {
            return dataSource;
    }
    //每个线程互不影响
    private static ThreadLocal<Connection> t1 = new ThreadLocal<>();

    //获取Connection的方法
    public static Connection getConn() {
        try {
            Connection conn = t1.get();
            if (conn == null){
                conn = dataSource.getConnection();
                t1.set(conn);
            }
            return conn;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    //3、关闭资源
    public static void closeAll(Connection conn, Statement stat, ResultSet rs){
        try {
            if(rs != null) {
                rs.close();
            }
            if(stat != null) {
                stat.close();
            }
            if(conn != null) {
                conn.close();//此时connection归还到连接池中，但是在ThreadLocal中还保存有Connection对象。
                t1.remove();//将Connection对象从ThreadLocal中移除（注意点）
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    //封装事务相关的操作
    //开启事务
    public static void start(){
        //1、获取Connection对象
        Connection conn = getConn();
        try {
            conn.setAutoCommit(false);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    //提交事务
    public static void commit(){
        //1、获取Connection对象
        Connection conn = getConn();
        try {
            //提交事务
            conn.commit();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            closeAll(conn,null,null);
        }
    }
    //回滚事务
    public static void rollback(){
        //1、获取Connection对象
        Connection conn = getConn();
        try {
            conn.rollback();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            closeAll(conn,null,null);
        }
    }
}


package cn.meng.dong.exercise;

import java.sql.*;
/**
 * @CopyRightBy zcy.qyg.cn
 * @Author DongQing
 * @Date 2019-01-19 22:17
 * @ClassName PostgresqlConnectTest
 * @Description TODO
 **/
public class PostgresqlConnectTest {
    public static void main(String[] args) {
        Connection c = null;
        Statement stmt = null;

        try {
            Class.forName("org.postgresql.Driver");

            c = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/menghaohao?currentSchema=razor","menghaohao", "postgres");
            c.setAutoCommit(false);
            stmt = c.createStatement();
            String sql = "SELECT * from tag ";

            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()) {

                System.out.println(rs.getString(5));
            }

            rs.close();
            stmt.close();
            c.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": " +e.getMessage());
            System.exit(0);
        }
        System.out.println("Opened database successfully");
    }
}

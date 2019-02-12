package org.buaa.nlp.cj.Utils;


import java.sql.*;

/**
 * Created by whisky on 15-4-20.
 */
public class DBUtil {
    private Connection conn;
    private final String mysqlDriverName = "com.mysql.jdbc.Driver";
    private final String mysqlUrl = "jdbc:mysql://localhost:3306/whisky?useUnicode=true&characterEncoding=UTF-8";
    private final String userName = "whisky";
    private final String passWord = "chenjiang";

    public Connection getConn() {
        try {
            Class.forName(mysqlDriverName);
            conn = DriverManager.getConnection(mysqlUrl, userName, passWord);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public ResultSet executeQuery(String sql, long index, long fetchNum) {
        Object[] params = {index, fetchNum};
        return executeQuery(sql, params);
    }

    public ResultSet executeQuery(String sql, Object[] params) {
        ResultSet result = null;

        conn = getConn();
        PreparedStatement pstm = null;

        try {
            pstm = conn.prepareCall(sql);
            if (params.length > 0) {
                for (int i = 0; i < params.length; i++) {
                    pstm.setObject(i+1, params[i]);
                }
            }
            System.out.println("query request: " + pstm.toString());
            result = pstm.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public void executeUpdate(String sql) {
        conn = getConn();
        Statement stmt = null;
        try {
            stmt = conn.createStatement();
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
//                conn.commit();
                if (stmt != null)
                    stmt.close();
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 根据 userId 和 msgId 从相应的表格获得微博消息
     * @param msgId
     * @return
     */
    public String qMsgByMsgId(String userId, String msgId) {
        String msg = "";
        long tableIndex = Long.parseLong(userId) % 10;

        String sql  = "select * from fifasim_weibo_by_user" +tableIndex+ " where message_id = '"+msgId+"';";
        String[] params = {};
        ResultSet rs = executeQuery(sql, params);
        try {
            while (rs.next()) {
                msg = rs.getString("repost_reason") + rs.getString("weibo_content");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.close();
        return msg;
    }

    public void close() {
        if (conn != null)
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }


    public static void main(String[] args) {
        DBUtil dbUtil = new DBUtil();
//        Connection connection = dbUtil.getConn();
        String sql = "select user_id, count(user_id) from fifasim_weibo_by_user6 where cast(time_Stamp as unsigned)> ? and cast(time_Stamp as unsigned)< ? group by user_id;";
        String[] params = {"1402502400", "1405184399"};
        ResultSet rs = dbUtil.executeQuery(sql, params);
        try {
            while (rs.next()) {
                System.out.println(rs.getString("user_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
//        System.out.println("*****" + connection);
    }
}

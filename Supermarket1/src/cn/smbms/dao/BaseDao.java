package cn.smbms.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;




import cn.smbms.tools.ConfigManager;

public class BaseDao {
	/**
	 * 获取数据库连接
	 * @return
	 */
	public static Connection getConnection(){
		Connection conn = null;
		String driver = ConfigManager.getInstance().getValue("driver");
		String url = ConfigManager.getInstance().getValue("url");
		String username = ConfigManager.getInstance().getValue("username");
		String password = ConfigManager.getInstance().getValue("password");
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	/**
	 * 查询操作
	 * @param conn
	 * @param ps
	 * @param rs
	 * @param sql
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public static ResultSet execute(Connection conn,PreparedStatement ps,ResultSet rs,
			String sql,Object... params)throws Exception{
		ps = conn.prepareStatement(sql);
		if(params!=null){
			for (int i = 0; i < params.length; i++) {
				ps.setObject(i+1, params[i]);
			}
		}
	
		rs = ps.executeQuery();
		return rs;
	}
    /**
     * 执行增删改操作
     * @param conn
     * @param ps
     * @param sql
     * @param params
     * @return
     * @throws Exception
     */
	public static int execute(Connection conn,PreparedStatement ps,
			String sql,Object[] params)throws Exception{
		int updateRows = 0;
		ps = conn.prepareStatement(sql);
		if(params!=null){
			for (int i = 0; i < params.length; i++) {
				ps.setObject(i+1, params[i]);
			}
		}
		updateRows = ps.executeUpdate();
		return updateRows;
	}
	/**
	 * 关闭资源
	 * @param conn
	 * @param ps
	 * @param rs
	 * @return
	 */
	public static boolean closeAll(Connection conn,PreparedStatement ps,ResultSet rs){
		boolean flag = true;
		if(rs != null){
			try {
				rs.close();
				rs = null;
			} catch (SQLException e) {
				e.printStackTrace();
				flag = false;
			}
		}
		if(ps != null){
			try {
				ps.close();
				ps = null;
			} catch (SQLException e) {
				e.printStackTrace();
				flag = false;
			}
		}
		if(conn != null){
			try {
				conn.close();
				conn = null;
			} catch (SQLException e) {
				e.printStackTrace();
				flag = false;
			}
		}
		return flag;
	}
}

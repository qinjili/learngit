package cn.smbms.dao.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import cn.smbms.dao.BaseDao;
import cn.smbms.pojo.User;
import cn.smbms.tools.Log;
@Repository
public class UserDaoImpl extends BaseDao implements UserDao{

	@Override
	public User login(String username, String password) {
		String sql = "SELECT * FROM `smbms_user` WHERE `userCode` = ? AND `userPassword` = ?";
		Connection conn = BaseDao.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		User user = null;
		try {
			rs = BaseDao.execute(conn, ps, rs, sql, username,password);
			if(rs.next()){
				Log.logger.debug("获取数据=================》");
				user = new User();
				user.setUserCode(rs.getString("userCode"));
				user.setUserName(rs.getString("userName"));
				user.setId(rs.getInt("id"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			BaseDao.closeAll(conn, ps, rs);
		}
		return user;
	}

	@Override
	public List<User> getUserList(String userName) {
		StringBuffer sql = new StringBuffer("SELECT `id`,`userCode`,`userName`,`gender`,`birthday`,`phone`,`userRole` FROM `smbms_user` WHERE 1=1 ");
		if(userName!=null&&userName!=""){
			sql.append("AND `userName` LIKE CONCAT('%','"+userName+"','%')");
		}
		Connection conn = BaseDao.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<User> list = new ArrayList<User>();
		User user = null;
		try {
			rs = BaseDao.execute(conn, ps, rs, sql.toString(), null);
			while(rs.next()){
				user = new User();
				user.setId(rs.getInt("id"));
				user.setUserCode(rs.getString("userCode"));
				user.setUserName(rs.getString("userName"));
				user.setBirthday(rs.getDate("birthday"));
				user.setPhone(rs.getString("phone"));
				user.setGender(rs.getInt("gender"));
				user.setUserRole(rs.getInt("userRole"));
				list.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			BaseDao.closeAll(conn, ps, rs);
		}
		return list;
	}

	@Override
	public boolean addUserSave(User user) {
		String sql = "INSERT INTO `smbms_user`(`userCode`,`userName`,`userPassword`,`gender`,`birthday`,`phone`,`address`,`userRole`,`createdBy`,`creationDate`,`idPicPath`,`workPicPath`)"
				+ "VALUE(?,?,?,?,?,?,?,?,?,?,?,?)";
		Connection conn = BaseDao.getConnection();
		PreparedStatement ps = null;
		int updateRows = 0;
		try {
			Object[] params = { user.getUserCode(),user.getUserName(),user.getUserPassword(),user.getGender(),user.getBirthday(),user.getPhone(),user.getAddress(),user.getUserRole(),user.getCreatedBy(),user.getCreationDate(),user.getIdPicPath(),user.getWorkPicPath()};
			updateRows = BaseDao.execute(conn, ps, sql,params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return updateRows>0?true:false;
	}

	@Override
	public User getUserByIdInfo(String id) {
		String sql = "SELECT * FROM `smbms_user` WHERE `id` = ?";
		Connection conn = BaseDao.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		User user = null;
		try {
			rs = BaseDao.execute(conn, ps, rs, sql, id);
			if(rs.next()){
				user = new User();
				user.setId(rs.getInt("id"));
				user.setUserCode(rs.getString("userCode"));
				user.setUserName(rs.getString("userName"));
				user.setGender(rs.getInt("gender"));
				user.setBirthday(rs.getDate("birthday"));
				user.setAge(rs.getInt("age"));
				user.setAddress(rs.getString("address"));
				user.setPhone(rs.getString("phone"));
				user.setUserRole(rs.getInt("userRole"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			BaseDao.closeAll(conn, ps, rs);
		}
		return user;
	}

	@Override
	public User selectUserCodeExist(String userCode) {
		String sql = "SELECT * FROM `smbms_user` WHERE `userCode` = ?";
		Connection conn = BaseDao.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		User user = null;
		try {
			rs = BaseDao.execute(conn, ps, rs, sql, userCode);
			if(rs.next()){
				user = new User();
				user.setUserCode(rs.getString("userCode"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			BaseDao.closeAll(conn, ps, rs);
		}
		return user;
	}

}

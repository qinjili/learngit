package cn.smbms.dao.user;

import java.util.List;

import cn.smbms.pojo.User;

public interface UserDao {
	/**
	 * 登录
	 * @param username
	 * @param password
	 * @return
	 */
	public User login(String username,String password);
	/**
	 * 查询所有用户信息
	 * @return
	 */
	public List<User> getUserList(String userName);
	/**
	 * 添加用户
	 * @param user
	 * @return
	 */
	public boolean addUserSave(User user);
	/**
	 * 根据用户id查询用户
	 * @param id
	 * @return
	 */
	public User getUserByIdInfo(String id);
	/**
	 * 验证用户名是否重复
	 * @param userCode
	 * @return
	 */
	public User selectUserCodeExist(String userCode);
}

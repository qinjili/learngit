package cn.smbms.service.user;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.smbms.dao.user.UserDao;
import cn.smbms.pojo.User;
@Service
public class UserServiceImpl implements UserService{
	@Resource
	private UserDao dao;
	@Override
	public User login(String username, String password) {
		return dao.login(username, password);
	}

	@Override
	public List<User> getUserList(String userName) {
		return dao.getUserList(userName);
	}

	@Override
	public boolean addUserSave(User user) {
		return dao.addUserSave(user);
	}

	@Override
	public User getUserByIdInfo(String id) {
		return dao.getUserByIdInfo(id);
	}

	@Override
	public User selectUserCodeExist(String userCode) {
		return dao.selectUserCodeExist(userCode);
	}

}

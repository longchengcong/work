package com.cn.hnust.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.hnust.dao.IUserDao;
import com.cn.hnust.pojo.User;
import com.cn.hnust.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {
	@Resource
	private IUserDao userDao;

	public User getUserById(int userId) {
		// TODO Auto-generated method stub
		return this.userDao.selectByPrimaryKey(userId);
	}

	@Override
	public int login_np(String sname,String spassword) {
		// TODO Auto-generated method stub
		return userDao.login_np(sname,spassword);
	}
	@Override
	public void sign_np(String sname,String spassword,String wx_id){
		userDao.sign_np(sname,spassword,wx_id);
	}
	@Override
	public int getUserID(String sname,String spassword){
		return userDao.getUserID(sname,spassword);
	}
	@Override
	public void changePass_ip(String userID,String spassword){
		userDao.changePass_ip(userID,spassword);
	}
	@Override
	public int select_ip(String userID,String spassword){
		return userDao.select_ip(userID,spassword);
	}
	@Override
	public int checkName_n(String userName){
		return userDao.checkName_n(userName);
	}
	
	@Override
	public void savePicture_np(String fileName,String path){
		userDao.savePicture_np(fileName,path);
	}
}

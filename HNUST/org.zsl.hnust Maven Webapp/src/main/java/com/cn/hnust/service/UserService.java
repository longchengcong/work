package com.cn.hnust.service;


import com.cn.hnust.pojo.User;

public interface UserService {
	public User getUserById(int userId);
	public int login_np(String sname,String spassword);
	public void sign_np(String sname,String spassword,String wx_id);
	public int getUserID(String sname,String spassword);
	public void changePass_ip(String userID,String spassword);
	public int select_ip(String userID,String spassword);
	public int checkName_n(String userName);
	public void savePicture_np(String fileName,String path);
	
}

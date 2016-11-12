package com.cn.hnust.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.UploadContext;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.zsl.testmybatis.TestMyBatis;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONCreator;
import com.cn.hnust.pojo.User;
import com.cn.hnust.service.UserService;
import com.cn.hnust.util.writeExcel;

@Controller
@RequestMapping("/user")
public class UserController {
	private static Logger logger = Logger.getLogger(UserController.class);
	@Resource
	private UserService userService;
	@RequestMapping("/showUser")
	public String showUser(HttpServletRequest request,Model model){
/*		int userId = Integer.parseInt(request.getParameter("id"));
		User user = this.userService.getUserById(userId);
		model.addAttribute("user", user);*/
		return "showUser";
	}
	@RequestMapping(value="/image")
	public ModelAndView image(HttpServletRequest request, HttpServletResponse response,Model model){
	return new ModelAndView("image");
	}
	@RequestMapping(value="/check2")
	public ModelAndView check2(HttpServletRequest request, HttpServletResponse response,Model model){
	return new ModelAndView("check2");
	}
	@RequestMapping(value="/check")
	public ModelAndView check(HttpServletRequest request, HttpServletResponse response,Model model){
	return new ModelAndView("check");
	}
	@RequestMapping(value="/check3")
	public ModelAndView check3(HttpServletRequest request, HttpServletResponse response,Model model){
	return new ModelAndView("check3");
	}
	@RequestMapping(value="/userlogin")
	@ResponseBody
	public int userlogin(String username,String pass,String wx_id,HttpSession hs){
		int i=userService.login_np(username,pass);
		
		if (i==1) {
			int id=userService.getUserID(username,pass);
			hs.setAttribute("userID", id);
			hs.setAttribute("oldPass", pass);
			hs.setAttribute("userName", username);
		}
		
		return i;
	}
	@RequestMapping(value="/userSign")
	@ResponseBody
	public int userSign(String username,String pass,String wx_id){
//		wx_id="456";
		userService.sign_np(username,pass,wx_id);
		int i=userService.login_np(username,pass);
		return i;
	}
	@RequestMapping(value="/password")
	public ModelAndView passowrd(HttpServletRequest request, HttpServletResponse response,Model model){
		return new ModelAndView("password");
	}
	
	@RequestMapping(value="/changePass")
	@ResponseBody
	public int changePass(String userID,String newPass){
		userService.changePass_ip(userID,newPass);
		int i=userService.select_ip(userID,newPass);
		return i;
	}
	
	@RequestMapping(value="/upload")
	public ModelAndView upload(HttpServletRequest request, HttpServletResponse response,Model model){
		return new ModelAndView("upload");
	}
	
	
	
	
	
	@RequestMapping(value="/result")
	@ResponseBody
	public ModelAndView upload(@RequestParam(value = "file", required = false) MultipartFile file, HttpServletRequest request, ModelMap model) {  		  
        System.out.println("开始");  
        String path = request.getSession().getServletContext().getRealPath("upload");  
//      String path = "/Users/caiyongjian/Dropbox/study/workspace/HNUST/org.zsl.hnust Maven Webapp/src/main/webapp/Static/pictures";  

//      String fileName = file.getOriginalFilename();  
        String fileName = new Date().getTime()+".jpg";  
        String fileUrl = request.getContextPath()+"/upload/"+fileName;
        userService.savePicture_np(fileName,fileUrl);
        
        System.out.println(path);  
        File targetFile = new File(path, fileName);  
        if(!targetFile.exists()){  
            targetFile.mkdirs();  
        }          
       //保存  
        try {  
            file.transferTo(targetFile);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        model.addAttribute("fileUrl", fileUrl);  
//        model.addAttribute("fileUrl", "/pictures/"+fileName);
  
		return new ModelAndView("result");
    }  
	
//	@RequestMapping("uploadPhoto")  
//	   @ResponseBody  
//	   public String uploadImage(HttpServletRequest request,  
//	           HttpServletResponse response, HttpSession session,  
//	           @RequestParam(value = "file", required = true) MultipartFile file)  
//	           throws IllegalStateException, IOException {  
//	       //String path = session.getServletContext().getRealPath("/upload");  
//	       String pic_path = "F:\\java_code\\picture\\";  
//	       System.out.println("real path: " + pic_path);  
//	       String fileName = file.getOriginalFilename();  
//	       System.out.println("file name: " + fileName);  
//	       File targetFile = new File(pic_path, fileName);  
//	       if (!targetFile.exists()) {  
//	           targetFile.mkdirs();  
//	       }  
//	       file.transferTo(targetFile);  
//	       String fileUrl = fileName;  
//	       return fileUrl;  
//	   }  
	
	@RequestMapping(value="/download")
	public ModelAndView download(HttpServletRequest request, HttpServletResponse response,Model model){
		return new ModelAndView("download");
	}
	
	@RequestMapping(value="/checkName")
	@ResponseBody
	public int checkName(String username){
		int i=userService.checkName_n(username);
		return i;
	}
	
	@RequestMapping(value="/index")
	public ModelAndView index(HttpServletRequest request, HttpServletResponse response,Model model){
	return new ModelAndView("flowlist");
	}
	
	@RequestMapping(value="/exit")
	public ModelAndView exit(HttpServletRequest request, HttpServletResponse response,Model model,HttpSession session){
		session.invalidate(); 
		return new ModelAndView("showUser");
		}  
}

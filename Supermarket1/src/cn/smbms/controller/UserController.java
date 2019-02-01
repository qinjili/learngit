package cn.smbms.controller;


import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.print.attribute.HashAttributeSet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;



import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONArray;
import com.mysql.jdbc.StringUtils;

import cn.smbms.pojo.User;
import cn.smbms.service.user.UserService;
import cn.smbms.tools.Constants;
import cn.smbms.tools.Log;

@Controller
@RequestMapping("/user")
public class UserController {
	@Resource
	private UserService userService;
	//登录
	@RequestMapping(value="/login.html")
	public String login(){
		Log.logger.debug("UserController welcome SMBMS==========>");
		return "login";
	}
	@RequestMapping(value="/dologin.html",method=RequestMethod.POST)
	public String doLogin(@RequestParam String userCode,
						  @RequestParam String password,
						  HttpSession session,
						  HttpServletRequest request ){
		User user = userService.login(userCode, password);
		if(user!=null){//登录成功
			session.setAttribute(Constants.USER_SESSION, user);
			return "redirect:/user/main.html";
		}else{
			request.setAttribute("error", "用户名或密码错误！");
			return "login";
		}
		
	}
	
	@RequestMapping(value="/main.html")
	public String main(HttpSession session){
		if(session.getAttribute(Constants.USER_SESSION)==null){
			return "redirect:/user/login.html";
		}
		return "frame";
	}
	//查询用户
	@RequestMapping(value="/userlist.html")
	public String getUserList(Model model,
							@RequestParam(value="name",required=false)String name){
		Log.logger.debug("userName=============>"+name);
		List<User> userList = null;
		userList = userService.getUserList(name);
		model.addAttribute("userList", userList);
		return "userList";
	}
	@RequestMapping(value="ucexist.html")
	@ResponseBody
	public Object userCodeExit(@RequestParam String userCode){
		Log.logger.info("userCode============>>"+userCode);
		HashMap<String, String> resultMap = new HashMap<String, String>();
		if(StringUtils.isNullOrEmpty(userCode)){
			resultMap.put("userCode", "exist");
		}else{
			User user = userService.selectUserCodeExist(userCode);
			if(user!=null){
				resultMap.put("userCode", "exist");
			}else{
				resultMap.put("userCode", "noexist");
			}
		}
		return JSONArray.toJSONString(resultMap);
	}
	//添加用户
	@RequestMapping(value="/useradd.html",method=RequestMethod.GET)
	public String addUser(@ModelAttribute("user") User user){
		return "userAdd";
	}
	@RequestMapping(value="/addsave.html",method=RequestMethod.POST)
	public String addUserSave(User user,
							HttpSession session,
							HttpServletRequest request,
							Model model,
							@RequestParam(value="attachs",required=false)MultipartFile[] attachs) throws Exception{
		
		String idPicPath = null;
		String workPicPath = null;
		String errorInfo = null;
		boolean flag = true;
		String path = request.getSession().getServletContext()
					  .getRealPath("statics"+File.pathSeparator+"uploadfiles");
		Log.logger.info("uploadfiles path ==========>"+path);
		
		for(int i = 0; i < attachs.length; i++){
			MultipartFile attach = attachs[i];
		
		//判断文件是否为空
		if(!attach.isEmpty()){
			if(i==0){
				errorInfo = "uploadFileError";
			}else if(i==1){
				errorInfo = "uploadWpError";
			}
			String oldFileName = attach.getOriginalFilename();//原文件名
			Log.logger.info("原文件名 >>>>>>"+oldFileName);
			String prefix = FilenameUtils.getExtension(oldFileName);//原文件后缀
			Log.logger.info("prefix >>>>>>>"+prefix);
			int filesize = 500000;
			Log.logger.info("file size >>>>>>>"+attach.getSize());
			
			if(attach.getSize()>filesize){//上传文件大小不得超过500kb
				Log.logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
				request.setAttribute(errorInfo, " * 上传文件不得超过500kb");
				model.addAttribute("user", user);
				flag = false;
				return "userAdd";
			}else if(prefix.equalsIgnoreCase("jpg")||
					prefix.equalsIgnoreCase("png")||
					prefix.equalsIgnoreCase("jpeg")||
					prefix.equalsIgnoreCase("pneg")){
				String fileName = System.currentTimeMillis()
								+ RandomUtils.nextInt(10000,99999)
								+ "_Personal.jpg";
				Log.logger.info("new fileName========"+attach.getName());
				File targetFile = new File(path,fileName);
				if(!targetFile.exists()){
					targetFile.mkdirs();
				}
				//保存
				try {
					attach.transferTo(targetFile);
				} catch (Exception e) {
					e.printStackTrace();
					request.setAttribute(errorInfo, " * 上传失败！");
					flag = false;
					return "userAdd";
				}
				if(i==0){
					idPicPath = path+File.separator+fileName;
				}else if(i==1){
					workPicPath = path+File.separator+fileName;
				}
				
			}else{//上传图片格式不正确
				request.setAttribute(errorInfo, " * 上传图片格式不正确");
				flag = false;
				return "userAdd";
			}
		}
		}
		if(flag){
			user.setCreatedBy(((User)session.getAttribute(Constants.USER_SESSION)).getId());
			user.setCreationDate(new Date());
			user.setIdPicPath(idPicPath);
			user.setWorkPicPath(workPicPath);
			if(userService.addUserSave(user)){
				return "redirect:/user/userlist.html";
			}
		}
		return "userAdd";
	}
	//CommonsMultipartResolver上传文件过大时抛出异常后导致响应无法返回
/*	@ExceptionHandler(Exception.class)
	@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR)
	public String handleException(Exception ex, HttpServletRequest request) {
		request.setAttribute("uploadFileError", " * 上传文件不得超过500kb");
		return "userAdd";
	}*/
	//修改用户和查看用户
	@RequestMapping(value="/userView.html",method=RequestMethod.GET)
	public String doView(HttpServletRequest request,Model model){
		String id = request.getParameter("userId");
		User user = null;
		user = userService.getUserByIdInfo(id);
		model.addAttribute("user", user);
		return "userView";
	}
	
	
}
package com.dsp.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dsp.pojo.MyResult;
import com.dsp.service.UserService;
import com.dsp.utils.KaptchaUtil;


@Controller
@RequestMapping("user")
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired 
	private MyResult myResult;
	
	//发送登录页面
	@RequestMapping("toLogin")
	public String toLogin() {
		System.out.println("123");
		return "redirect:/wjsp/clogin.jsp";
	}

	//获取验证码
	@RequestMapping(value="/getCode.action")
	public void getCode(HttpSession session,HttpServletResponse response) {
		try {
			Map<String, BufferedImage> imgMap = KaptchaUtil.captcha();
			String code = imgMap.keySet().iterator().next();
			session.setAttribute("code", code);
			ImageIO.write(imgMap.get(code), "jpg", response.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void hello() {
		
	}
//	//执行登录
//	@RequestMapping(value="/doLogin.action")
//	public @ResponseBody MyResult userinfo(HttpSession session,String account,String pwd ,String code) {
//		System.out.println("名字："+account);
//		if (code.equalsIgnoreCase((String)(session.getAttribute("code")))) {
//			String result = userService.findUserByAcAndPwd(account, pwd);
//			switch (result) {
//			case "use":
//				myResult.setMyresult("loginSuccess");
//				break;
//			case "forbid":
//				myResult.setMyresult("forbid");
//				break;
//			case "no":
//				myResult.setMyresult("loginFailed");
//				break;
//			}
//		}else {
//			myResult.setMyresult("codeerror");
//		}
//		return myResult;
//	}
	
	//执行登录
	@RequestMapping(value="/doLogin.action")
	public @ResponseBody MyResult userinfo(HttpSession session,String account,String pwd ,String code) {
		if (code.equalsIgnoreCase((String)(session.getAttribute("code")))) {
			String result = userService.findUserByAcAndPwd(account, pwd);
			switch (result) {
			case "use":
				myResult.setMyresult("loginSuccess");
				break;
			case "forbid":
				myResult.setMyresult("forbid");
				break;
			case "no":
				myResult.setMyresult("loginFailed");
				break;
			}
		}else {
			myResult.setMyresult("codeerror");
		}
		return myResult;
	}
	
	
	//测试注册
	@RequestMapping(value="/register.action")
	public @ResponseBody MyResult register() {
		System.out.println("注册成功");
		myResult.setMyresult("success");
		return myResult;
	}

	//去主页面
	@RequestMapping(value="/tomain.action")
	public String tomain() {
		return "client/main_log";
	}
	
	
	
	
//	@RequestMapping("login")
//	public String login(String account, String pwd, HttpSession session) {
//		
//		User user = userService.login(account, pwd);
//		
//		if (null != user) {
//			session.setAttribute("user", user);// 登录成功把user对象存进session里
//			return "index";
//		}
//		
//		return "login";
//	}
	
//	@RequestMapping(value="/user1.action", method=RequestMethod.POST, produces="application/json;charset=utf-8")
//	public @ResponseBody User userinfo3(String account, String pwd){
//		System.out.println(account + ":" + pwd);
//		User user = new User();
//		user.setAccount(account);
//		user.setPwd(pwd);
//		return user;
//	}
//		
//
//	@RequestMapping(value="/user2.action", method=RequestMethod.POST, consumes="application/json;charset=utf-8")
//	public @ResponseBody User userinfo4(@RequestBody User user){
//		System.out.println(user);
//		return user;
//	}
}

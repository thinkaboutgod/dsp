package com.dsp.service.impl;



import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsp.log.MyLog;
import com.dsp.mapper.UserMapper;
import com.dsp.pojo.User;
import com.dsp.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private HttpSession session;

	@Override
	@MyLog(operationDetail="用户登录",operationType="验证")
	public String findUserByAcAndPwd(String account, String pwd) {
		User user = userMapper.findUserByAcAndPwd(account, pwd);
		String result = "";
		if (null != user) {
			if ("启用".equals(user.getState())) {
				session.setAttribute("user", user);
				result = "use";
			} else {
				result = "forbidden";
			}
		} else {
			result = "no";
		}
		return result;
	}

	
}

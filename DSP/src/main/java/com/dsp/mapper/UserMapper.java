package com.dsp.mapper;

import com.dsp.pojo.User;

public interface UserMapper {

	User findUserByAcAndPwd(String account, String pwd);

	User findUserByid(Integer cuid);

	void updateScore(Integer newscore, Integer cuid);
	
}

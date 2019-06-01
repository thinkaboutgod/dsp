package com.dsp.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.dsp.mapper.FileMapper;
import com.dsp.mapper.UserMapper;
import com.dsp.pojo.FileType;
import com.dsp.pojo.Files;
import com.dsp.pojo.Fstate;
import com.dsp.pojo.User;
import com.dsp.service.FileService;

@Service
public class FilesServiceImpl implements FileService{
	@Autowired FileMapper fileMapper;
	@Autowired UserMapper userMapper;
	@Autowired HttpSession session;
	
	@Override
	public List<Files> searchAllFile() {
		List<Files> lFiles = fileMapper.findAllFiles();
		return lFiles;
	}
	
	@Override
	public String uploadFile(HttpServletRequest request,MultipartFile file,String filetitle,String score) {
		//获取操作人员的信息
		User user = (User) session.getAttribute("user");
		String fileFileName = file.getOriginalFilename();//获得文件名称
		String account = user.getAccount();
		String path2 = request.getContextPath();
		
		path2 = path2+"/upload/" + account;
		System.out.println("测试路径:"+path2);
		String path = request.getServletContext().getRealPath("/upload/" + account+"/");
		File newFile = new File(path);
		if (!newFile.exists()) {
			newFile.mkdirs();
		}
		try {
			file.transferTo(new File(path+fileFileName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String tname = fileFileName.substring(fileFileName.lastIndexOf(".") + 1);
		//Integer fid, User user, String fname, Date upTime, Integer deScore, Integer dtimes, FileType fileType,
		//Fstate fstate, String path
		FileType fType = fileMapper.findType(tname);// 获得该类型文件上传积分，和类型id
		Fstate fstate = new Fstate(1, "未审核");
		Files files = new Files(null, user, filetitle, null, Integer.valueOf(score), 0, fType, fstate, account + "/" + fileFileName);
		
		fileMapper.insertFile(files);
		
		int newscore = user.getScore() + fType.getTscore();
		userMapper.updateScore(newscore, user.getCuid());

		user = userMapper.findUserByid(user.getCuid());
		session.setAttribute("user", user);// 更新session中的user
		
		System.out.println("上传成功");
		return "uploadSuccess";
		
	}

}

package com.dsp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.dsp.pojo.Files;
import com.dsp.pojo.MyResult;
import com.dsp.service.FileService;



@Controller
public class FileController {
	
	@Autowired FileService fileService;
	@Autowired MyResult myResult;
	@Autow
	//查询所有文件
	@RequestMapping(value="allFile")
	public @ResponseBody Map<String, List<Files>> allFile(){
		List<Files> fList = fileService.searchAllFile();
		Map<String, List<Files>> map = new HashMap<>();
		map.put("data", fList);
		System.out.println("123");
		return map;
	}
	
	//文件上传
	@RequestMapping(value="/toUpload.action")
	public @ResponseBody MyResult toUpload(HttpServletRequest request,MultipartFile file,String filetitle,String score) {
		String result = fileService.uploadFile(request, file, filetitle, score);

		myResult.setMyresult(result);
		return myResult;
	}
	
}

package com.dsp.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.dsp.pojo.Files;


public interface FileService {
	
	public List<Files> searchAllFile();
	public String uploadFile(HttpServletRequest request,MultipartFile file,String filetitle,String score);

}

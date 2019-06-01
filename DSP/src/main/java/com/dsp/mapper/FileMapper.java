package com.dsp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.dsp.pojo.FileType;
import com.dsp.pojo.Files;

@Mapper
@Repository
public interface FileMapper {

	public List<Files> findAllFiles();
	
	public FileType findType(String tname);
	
	public int insertFile(Files files);
	
	
}

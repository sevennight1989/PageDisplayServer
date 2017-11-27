package com.zp.gossiptripe.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.zp.gossiptripe.model.RegistForm;

@Controller
@RequestMapping("/common")
public class RegistControler {
	
	@ResponseBody
	@RequestMapping(value = "/regist", method = RequestMethod.POST)
	public ModelMap regist(HttpServletRequest request,@ModelAttribute RegistForm registForm) {
		System.out.println("fileName = " + registForm.getFileName());
		ModelMap map = new ModelMap();
		Map<String,MultipartFile> fileMap = ((MultipartHttpServletRequest)request).getFileMap();
		for(MultipartFile file:fileMap.values()){
			System.out.println("fileName = " + file.getName()+"   fileSize = " + file.getSize());
			try {
				String pic_path = "D:\\upload\\";  
				
				byte content[] = file.getBytes();
				String path = pic_path + registForm.getFileName();
				File outFile = new File(path);
				if(!outFile.exists()){
					outFile.createNewFile();
				}
				FileOutputStream fos = new FileOutputStream(outFile);
				fos.write(content);
				fos.close();
				map.put("responseCode", "0");
				map.put("responseMessage", "上传成功");
				map.put("data", "");
			} catch (IOException e) {
				e.printStackTrace();
				map.put("responseCode", "1");
				map.put("responseMessage", "上传失败：" + e.getMessage());
			}
		}
		return map;
	
	}
}

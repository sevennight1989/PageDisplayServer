package com.tgb.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import com.tgb.model.DataBean;
import com.tgb.model.ImageBean;
import com.tgb.service.ImageService;
import com.tgb.service.impl.RedisCacheUtil;

@Controller
@RequestMapping("/img")
public class ImageDataController {
    private String imgUri = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1510200242711&di=0968ca3c8e24ea54efccc82270443b08&imgtype=0&src=http%3A%2F%2Fimg.zcool.cn%2Fcommunity%2F01027957a93b4a0000018c1b628e6f.jpg%401280w_1l_2o_100sh.jpg";
    private String imagePath = "www.baid.com";
	
	@ResponseBody
	@RequestMapping("/getAllImage")
	public ModelMap getAllUser(){
		ModelMap map = new ModelMap();
		List<ImageBean> lBeans = new ArrayList<ImageBean>();
		
		ImageBean bean1 = new ImageBean();
		bean1.setName("Type1");
		List<String> path1 = new ArrayList<String>();
		for(int i = 0 ;i < 5;i++){
			path1.add(imagePath);
		}
		bean1.setPaths(path1);
		lBeans.add(bean1);
		
		ImageBean bean2 = new ImageBean();
		bean2.setName("Type2");
		List<String> path2 = new ArrayList<String>();
		for(int i = 0 ;i < 3;i++){
			path2.add(imagePath);
		}
		bean2.setPaths(path2);
		lBeans.add(bean2);
		
		ImageBean bean3 = new ImageBean();
		bean3.setName("Type3");
		List<String> path3 = new ArrayList<String>();
		for(int i = 0 ;i < 2;i++){
			path3.add(imagePath);
		}
		bean3.setPaths(path3);
		lBeans.add(bean3);
		
		map.put("imageData", lBeans);
		return map;
	}
	
	@Autowired
	private ImageService imageService;
	
	@ResponseBody
	@RequestMapping("/getImageData")
	public ModelMap getImageData(){
		ModelMap map = new ModelMap();
		List<DataBean> dList ;

		redisCache.setCacheObject("myname", "Tom");
		try{
			dList = imageService.getImageData();
			map.put("responseCode", "0");
			map.put("responseMsg", "");
			map.put("data", dList);
		}catch (Exception e) {
			System.out.println(e.getMessage());
			map.put("responseCode", "1");
			map.put("responseMsg", "获取图片信息失败");
		}
		String value = redisCache.getCacheObject("myname");
		System.out.println("value = " + value);
		return map;
	}

	 @Autowired(required = true)
	    private RedisCacheUtil<Object> redisCache;
	 
	
}

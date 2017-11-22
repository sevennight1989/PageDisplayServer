package com.zp.gossiptripe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/common")
public class RegistControler {
	
	@ResponseBody
	@RequestMapping("/regist")
	public ModelMap regist() {
		ModelMap map = new ModelMap();
		map.put("responseCode", "0");
		map.put("responseMessage", "请求成功");
		return map;
	
	}
}

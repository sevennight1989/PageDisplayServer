package com.zp.gossiptripe.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.zp.gossiptripe.constant.Constant;
import com.zp.gossiptripe.form.LoginForm;
import com.zp.gossiptripe.model.RegistBean;
import com.zp.gossiptripe.model.SessionBean;
import com.zp.gossiptripe.model.UploadHeadForm;
import com.zp.gossiptripe.model.UserBaseInfoBean;
import com.zp.gossiptripe.service.ISessionService;
import com.zp.gossiptripe.service.IUserService;
import com.zp.gossiptripe.utils.AESUtils;
import com.zp.gossiptripe.utils.RedisUtils;

@Controller
@RequestMapping("/common")
public class RegistControler {

	@Autowired
	IUserService mUserService;
	@Autowired
	ISessionService mISessionService;

	/**
	 * 测试redis缓存
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/testredis")
	public ModelMap testRedis() {
		ModelMap map = new ModelMap();
		// RedisUtils.set("name", "Tom", 60);
		try {
			String name = RedisUtils.get("name").toString();
			map.put("name", name);
		} catch (Exception e) {
			map.put("name", "找不到缓存");
		}
		return map;
	}

	/**
	 * 注册
	 * 
	 * @param userName
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/regist")
	public ModelMap regist(@ModelAttribute RegistBean registBean) {
		ModelMap map = new ModelMap();

		String username = registBean.getUsername();
		String session;
		try {
			if (mUserService.userCount(username) > 0) {
				map.put("responseCode", "2");
				map.put("responseMessage", Constant.RESPONSE_MEG_2);
			} else {
				mUserService.saveUser(registBean);
				session = AESUtils.Encrypt(username, AESUtils.cKey);
				SessionBean sessionBean = new SessionBean();
				sessionBean.setSession(session);
				sessionBean.setUsername(username);
				mISessionService.saveSession(sessionBean);
				map.put("responseCode", "0");
				map.put(Constant.RESPONSE_MES_KEY, "请求成功");
				map.put("data", session);
			}
		} catch (Exception e) {
			e.printStackTrace();
			map.put("responseCode", "1");
			map.put(Constant.RESPONSE_MES_KEY, "请求失败 ");
		}
		return map;
	}

	/**
	 * 登录
	 * 
	 * @param loginForm
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/login")
	public ModelMap login(@ModelAttribute LoginForm loginForm) {
		ModelMap map = new ModelMap();
		System.out.println("入参: " + loginForm.toString());
		try {
			if (mUserService.userCount(loginForm.getUsername()) == 0) {
				map.put(Constant.RESPONSE_CODE_KEY, "3");
				map.put(Constant.RESPONSE_MES_KEY, Constant.RESPONSE_MEG_3);
				return map;
			}

			UserBaseInfoBean userBaseInfoBean = mUserService.getUserInfo(loginForm);
			if (userBaseInfoBean == null) {
				map.put(Constant.RESPONSE_CODE_KEY, "4");
				map.put(Constant.RESPONSE_MES_KEY, Constant.RESPONSE_MEG_4);
				return map;
			}
			System.out.println("出参: " + userBaseInfoBean.toString());
			map.put(Constant.RESPONSE_CODE_KEY, "0");
			map.put(Constant.RESPONSE_MES_KEY, "登录成功");
			map.put(Constant.RESPONSE_DATA_KEY, userBaseInfoBean);

		} catch (Exception e) {
			map.put(Constant.RESPONSE_CODE_KEY, "1");
			map.put(Constant.RESPONSE_MES_KEY, "请求失败");
			e.printStackTrace();
		}
		return map;
	}
	
	/**
	 * session登录
	 * 
	 * @param loginForm
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/sessionlogin")
	public ModelMap sessionlogin(@RequestParam(value = "session") String session) {
		ModelMap map = new ModelMap();
		System.out.println("入参: " + session);
		try {
			UserBaseInfoBean userBaseInfoBean = mUserService.getUserInfoBySession(session);
			if (userBaseInfoBean == null) {
				map.put(Constant.RESPONSE_CODE_KEY, "4");
				map.put(Constant.RESPONSE_MES_KEY, Constant.RESPONSE_MEG_4);
				return map;
			}
			System.out.println("出参: " + userBaseInfoBean.toString());
			map.put(Constant.RESPONSE_CODE_KEY, "0");
			map.put(Constant.RESPONSE_MES_KEY, "登录成功");
			map.put(Constant.RESPONSE_DATA_KEY, userBaseInfoBean);
		}catch (Exception e) {
			map.put(Constant.RESPONSE_CODE_KEY, "1");
			map.put(Constant.RESPONSE_MES_KEY, "请求失败");
			e.printStackTrace();
		}
		return map;
	}
		
		
	

	/**
	 * 上传头像
	 * 
	 * @param request
	 * @param uploadHeadForm
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/uploadHead", method = RequestMethod.POST)
	public ModelMap uploadHead(HttpServletRequest request,
			UploadHeadForm uploadHeadForm) {
		System.out.println("fileName = " + uploadHeadForm.getFileName());
		ModelMap map = new ModelMap();
		Map<String, MultipartFile> fileMap = ((MultipartHttpServletRequest) request)
				.getFileMap();
		for (MultipartFile file : fileMap.values()) {
			System.out.println("fileName = " + file.getName()
					+ "   fileSize = " + file.getSize());
			try {
				String session = uploadHeadForm.getSession();
				// 通过session查找userName
				String userName = "";
				String pic_dir = Constant.HEAD_IMAGE_DIR + userName + "\\";
				byte content[] = file.getBytes();
				String path = pic_dir + uploadHeadForm.getFileName();
				File outFile = new File(path);
				if (!outFile.exists()) {
					outFile.createNewFile();
				}
				FileOutputStream fos = new FileOutputStream(outFile);
				fos.write(content);
				fos.close();
				map.put(Constant.RESPONSE_CODE_KEY, "0");
				map.put(Constant.RESPONSE_MES_KEY, "上传成功");
				map.put(Constant.RESPONSE_DATA_KEY, "");
			} catch (IOException e) {
				e.printStackTrace();
				map.put(Constant.RESPONSE_CODE_KEY, "1");
				map.put(Constant.RESPONSE_MES_KEY, "上传失败");
			}
		}

		return map;
	}

}

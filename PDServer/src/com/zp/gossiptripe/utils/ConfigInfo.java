package com.zp.gossiptripe.utils;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;

public class ConfigInfo {

	HashMap<String, Object> map = new HashMap<String, Object>();
	public static void main(String args[]){
		ConfigInfo configInfo = new ConfigInfo();
		
	}
	
	public int getInteger(String key){
		return Integer.parseInt(map.get(key).toString());
	}

	public String getString(String key){
		return map.get(key).toString();
	}
	
	public long getLong(String key){
		return Long.parseLong(map.get(key).toString());
	}
	
	public boolean getBoolean(String key){
		return Boolean.parseBoolean(map.get(key).toString());
	}
	
	public ConfigInfo(){
		Properties pro = new Properties();
		try {
			InputStream ins = this.getClass().getResourceAsStream("/config/redis.properties");
			pro.load(ins);
			ins.close();
			
/*			redis.hostName=127.0.0.1
			redis.port=6379
			redis.timeout=15000
			redis.usePool=true
			redis.minEvictableIdleTimeMillis=300000
			redis.numTestsPerEvictionRun=3
			redis.timeBetweenEvictionRunsMillis=60000
			redis.pass=xx
			redis.maxIdle=300
			redis.host=127.0.0.1
			redis.maxActive=600
			redis.maxWait=1000
			redis.testOnBorrow=true
			redis.cacheSeconds=60*/
			map.put("redis.testOnBorrow", pro.getProperty("redis.testOnBorrow","true"));
			map.put("redis.maxActive", pro.getProperty("redis.maxActive"));
			map.put("redis.maxIdle", pro.getProperty("redis.maxIdle"));
			map.put("redis.maxWait", pro.getProperty("redis.maxWait"));
			map.put("redis.host", pro.getProperty("redis.host"));
			map.put("redis.port", pro.getProperty("redis.port"));
			map.put("redis.timeout", pro.getProperty("redis.timeout"));
			map.put("redis.usePool", pro.getProperty("redis.usePool"));
			map.put("redis.minEvictableIdleTimeMillis", pro.getProperty("redis.minEvictableIdleTimeMillis"));
			map.put("redis.numTestsPerEvictionRun", pro.getProperty("redis.numTestsPerEvictionRun"));
			map.put("redis.timeBetweenEvictionRunsMillis", pro.getProperty("redis.timeBetweenEvictionRunsMillis"));
			map.put("redis.cacheSeconds", pro.getProperty("redis.cacheSeconds"));
		
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
}

package cn.smbms.tools;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigManager {
	private static Properties properties;
	private static ConfigManager configManager;
	//私有构造器-读取配置文件
	private ConfigManager(){
		properties = new Properties();
		String configFile = "database.properties";
		InputStream is = ConfigManager.class.getClassLoader().getResourceAsStream(configFile);
		try {
			properties.load(is);
			is.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//静态内部类
	public static class ConfigManagerInner{
		private static final ConfigManager CONFIGMANAGER = new ConfigManager();
	}
	//全局访问点
	public static ConfigManager getInstance(){
		/*if(configManager == null){
			configManager = new ConfigManager();
		}
		return configManager;*/
		configManager = ConfigManagerInner.CONFIGMANAGER;
		return configManager;
	}

	public String getValue(String key){
		return properties.getProperty(key);
	}
}

package config;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadProperty {
	
	public static Properties prop;
	
	public static void loadData() throws IOException {
		prop = new Properties();
		File file = new File(System.getProperty("user.dir") + "/environment.properties");
		FileReader obj = new FileReader(file);
		prop.load(obj);
	}

	
	public String getKey(String key) throws IOException {
		loadData();
		key = prop.getProperty(key);
		return key;
		
	}


	
}

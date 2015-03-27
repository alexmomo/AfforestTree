package com.afforesttree.service.impl.system;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Properties;

import org.springframework.stereotype.Service;

import com.afforesttree.config.AppInitConstants;
import com.afforesttree.service.system.AppInitService;


@Service("appInitService")
public class AppInitServiceImpl implements AppInitService {
	private final String basePropertiesPath = "conf/AfforestTree.properties";

	public void putBasePropertiesList() {
		analysisProperties(basePropertiesPath);
	}


	private void analysisProperties(String filePath) {
		InputStream is = AppInitServiceImpl.class.getClassLoader().getResourceAsStream(filePath);
		Properties props = new Properties();
		try {
			props.load(is);
			Iterator<Object> it = props.keySet().iterator();
			while (it.hasNext()) {
				Object key = it.next();
				AppInitConstants.CONFIG_MAP.put(String.valueOf(key), String.valueOf(props.get(key)));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
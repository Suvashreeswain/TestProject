package com.demo.helper;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.Map;

import org.yaml.snakeyaml.Yaml;

/**
 * 
 * @author nimit.jain
 *
 */
@SuppressWarnings("unchecked")
public class YamlHandler {

	public String yamlFilesPath;
	public String dynamicYamlFilePath;
	static String tier;

	/**
	 * Constructor to set yaml file path
	 * 
	 * @param yamlPath
	 */
	public YamlHandler(String yamlPath) {
		yamlFilesPath = yamlPath;
	}


	public Map<String, Object> getYamlValues(String token) {
		Reader doc;
		try {
			doc = new FileReader(yamlFilesPath);
		} catch (FileNotFoundException ex) {
			System.out.println("File not valid or missing!!!");
			ex.printStackTrace();
			return null;
		}
		Yaml yaml = new Yaml();
		// TODO: check the type casting of object into the Map and create
		// instance in one place
		Map<String, Object> object = (Map<String, Object>) yaml.load(doc);
		return parseMap(object, token + ".");
	}


	private static Map<String, Object> parseMap(Map<String, Object> object, String token) {
		if (token.contains(".")) {
			String[] st = token.split("\\.");
			object = parseMap((Map<String, Object>) object.get(st[0]), token.replace(st[0] + ".", ""));
		}
		return object;
	}

}

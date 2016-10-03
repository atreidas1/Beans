package configuration.models;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import com.google.gson.Gson;

import configuration.beanfactory.BeanFactory;

public class Beans {
	private Gson gson = new Gson();
	private BeanFactory beanFactory;
	
	public Beans(String pathToFile) throws IOException {
		String beansFileContent = readFile(pathToFile);
		BeansModel beans = gson.fromJson(beansFileContent, BeansModel.class);
		beanFactory = new BeanFactory(beans);
	}

	private String readFile(String pathToFile) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(pathToFile)));
		String line;
		StringBuilder builder = new StringBuilder();
		while((line=bufferedReader.readLine()) != null) {
			builder.append(line);
		}
		return builder.toString();
	}
	
	public <T> T getBean(String beanId) throws Exception {
		return (T) beanFactory.getBean(beanId);
	}
}

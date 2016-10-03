package configuration.models;

import java.util.Iterator;
import java.util.List;

public class BeansModel {
	private List<BeanModel> beans;
	
	public List<BeanModel> getBeans() {
		return beans;
	}

	public void setBeans(List<BeanModel> beans) {
		this.beans = beans;
	}

	public BeanModel getBean(String beanId) {
		for (Iterator<BeanModel> iterator = beans.iterator(); iterator.hasNext();) {
			BeanModel beanModel = (BeanModel) iterator.next();
			if(beanModel.getId().equals(beanId)) {
				return beanModel;
			}
		}
		return null;
	}
}

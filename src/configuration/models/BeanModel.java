package configuration.models;

import java.util.List;
import java.util.Set;

public class BeanModel {
	private String id;
	private String description;
	private String type;
	private boolean singleton;
	private List<PropertyModel> properties;
	private List<ValueModel> list;
	private List<ValueModel> set;
	private List<EntryModel> map;
	private List<ValueModel> constructor_args;
	
	public BeanModel() {
		super();
		singleton = true;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public boolean isSingleton() {
		return singleton;
	}
	public void setSingleton(boolean singleton) {
		this.singleton = singleton;
	}

	public List<PropertyModel> getProperties() {
		return properties;
	}

	public void setProperties(List<PropertyModel> properties) {
		this.properties = properties;
	}

	public List<EntryModel> getMap() {
		return map;
	}

	public void setMap(List<EntryModel> map) {
		this.map = map;
	}

	public List<ValueModel> getList() {
		return list;
	}

	public void setList(List<ValueModel> list) {
		this.list = list;
	}

	public List<ValueModel> getSet() {
		return set;
	}

	public void setSet(List<ValueModel> set) {
		this.set = set;
	}

	public List<ValueModel> getConstructor_args() {
		return constructor_args;
	}

	public void setConstructor_args(List<ValueModel> constructor_args) {
		this.constructor_args = constructor_args;
	}
}

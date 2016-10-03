package configuration.models;

import java.util.List;

public class ValueModel {
	private String value;
	private String description;
	private String ref;
	private BeanModel bean;
	private String type;
	private List<ValueModel> list;
	private List<EntryModel> map;
	private List<ValueModel> set;
	
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getRef() {
		return ref;
	}
	public void setRef(String ref) {
		this.ref = ref;
	}
	public BeanModel getBean() {
		return bean;
	}
	public void setBean(BeanModel bean) {
		this.bean = bean;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public List<ValueModel> getList() {
		return list;
	}
	public void setList(List<ValueModel> list) {
		this.list = list;
	}
	public List<EntryModel> getMap() {
		return map;
	}
	public void setMap(List<EntryModel> map) {
		this.map = map;
	}
	public List<ValueModel> getSet() {
		return set;
	}
	public void setSet(List<ValueModel> set) {
		this.set = set;
	}
}

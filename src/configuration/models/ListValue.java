package configuration.models;

public class ListValue {
	private String value;
	private String ref;
	private BeanModel bean;
	private String type;
	
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getRef() {
		return ref;
	}
	public void setRef(String ref) {
		this.ref = ref;
	}
	public BeanModel getBeanModel() {
		return bean;
	}
	public void setBeanModel(BeanModel beanModel) {
		this.bean = beanModel;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
}

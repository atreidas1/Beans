package configuration.beanfactory;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import configuration.models.BeanModel;
import configuration.models.BeansModel;
import configuration.models.EntryModel;
import configuration.models.PropertyModel;
import configuration.models.ValueModel;

public class BeanFactory {
	private ClassUtils classUtils = new ClassUtils();
	private BeansModel beans;
	private Map<String, Object> createdBeans;

	public BeanFactory(BeansModel beans) {
		this.beans = beans;
		createdBeans = new HashMap<>();
	}

	public Object getBean(String beanId) throws Exception {
		BeanModel bean = beans.getBean(beanId);
		if(createdBeans.containsKey(beanId) && bean.isSingleton()) {
			return createdBeans.get(beanId);
		}
		Object object = createBean(bean);
		createdBeans.put(beanId, object);
		return object;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List createList(ValueModel propertyModel) throws Exception {
		List list = classUtils.instantiateClass(propertyModel.getType());
		Iterator<ValueModel> iterator = propertyModel.getList().iterator();
		while (iterator.hasNext()) {
			ValueModel listValue = iterator.next();
			Object value = createValue(listValue);
			list.add(value);
		}
 		return list;
	}

	public Object createValue(ValueModel model) throws Exception {
		Object value = null;
		if(model.getRef() != null) {
			value = getBean(model.getRef());
		} else if (model.getBean() != null) {
			value = createBean(model.getBean());
		} else if (model.getList() != null) {
			value = createList(model);
		} else if (model.getMap() != null) {
			value = createMap(model);
		} else if (model.getSet() != null) {
			value = createSet(model);
		} else if (model.getValue() != null && model.getType() != null) {
			value = classUtils
					.convertStringToPrimitive(model.getValue(), model.getType());
		} else if (model.getValue() != null) {
			value = model.getValue();
		} else {
			value = null;
		}
		return value;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private Object createSet(ValueModel model) throws Exception {
		Set set = classUtils.instantiateClass(model.getType());
		Iterator<ValueModel> iterator = model.getList().iterator();
		while (iterator.hasNext()) {
			ValueModel valueModel = iterator.next();
			Object value = createValue(valueModel);
			set.add(value);
		}
		return set;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private Map createMap(ValueModel model) throws Exception {
		Map map = classUtils.instantiateClass(model.getType());
		Iterator<EntryModel> iterator = model.getMap().iterator();
		while (iterator.hasNext()) {
			EntryModel entryModel = iterator.next();
			Object key = createValue(entryModel.getKey());
			Object value = createValue(entryModel.getValue());
			map.put(key, value);
		}
		return map;
	}

	private Object createBean(BeanModel beanModel) throws Exception {
		Object bean = null;
		if(beanModel.getList() != null) {
			ValueModel valueModel = new ValueModel();
			valueModel.setList(beanModel.getList());
			valueModel.setType(beanModel.getType());
			bean = createList(valueModel);
		} else if (beanModel.getMap() != null) {
			ValueModel valueModel = new ValueModel();
			valueModel.setType(beanModel.getType());
			valueModel.setMap(beanModel.getMap());
			bean = createMap(valueModel);
		} else if (beanModel.getSet() != null) {
			ValueModel valueModel = new ValueModel();
			valueModel.setType(beanModel.getType());
			valueModel.setSet(beanModel.getSet());
			bean = createSet(valueModel);
		} else {
			bean = createObject(beanModel);
		}
		return bean;
	}

	public void invokeSetter(Object object, Object arg, String name) throws Exception {
		classUtils.invokeSetter(object, arg, name);

	}

	@SuppressWarnings("rawtypes")
	public Object createObject(BeanModel bean) throws Exception {
		Object object = null;
		if(bean.getConstructor_args() != null) {
			List<ValueModel> constrArs = bean.getConstructor_args();
			int numberOfArgs = constrArs.size();
			String[] argsTypes = new String[numberOfArgs];
			Object[] args = new Object[numberOfArgs];
			for(int i=0; i< numberOfArgs; i++) {
				argsTypes[i] = constrArs.get(i).getType();
				args[i] = createValue(constrArs.get(i));
			}
			object = classUtils.instantiateClass(bean.getType(), args, argsTypes);
		} else {
			object = classUtils.instantiateClass(bean.getType());
		}
		if(bean.getProperties() != null) {
			Iterator<PropertyModel> iterator = bean.getProperties().iterator();
			while (iterator.hasNext()) {
				PropertyModel propertyModel = iterator.next();
				String propName = propertyModel.getName();
				String setterName = "set" + propName.substring(0, 1).toUpperCase() + propName.substring(1);
				Object arg;
				if(propertyModel.getValue() != null && propertyModel.getType() == null) {
					Method setter = classUtils.getMethodByName(object, setterName);
					Class argClass = classUtils.getSetterArgType(setter);
					propertyModel.setType(argClass.getName());
				}
				arg = createValue(propertyModel);
				classUtils.invokeSetter(object, arg, setterName);
			}
		}
		return object;
	}
}

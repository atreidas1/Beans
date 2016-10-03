package configuration.beanfactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;


public class ClassUtils {
	
	public Class loadClass(String className) throws ClassNotFoundException {
		ClassLoader classLoader = this.getClass().getClassLoader();
		Class loadedMyClass = classLoader.loadClass(className);
		return loadedMyClass;
	}
	
	@SuppressWarnings("unchecked")
	public <T> T instantiateClass(String className) throws Exception {
		@SuppressWarnings("rawtypes")
		Class loadedClass = loadClass(className);
		@SuppressWarnings({ "rawtypes" })
		Constructor constructor = loadedClass.getConstructor();
		Object object = constructor.newInstance();
		return (T) object;
	}
	
	public Object convertStringToPrimitive(String value, String typeName) throws Exception {
		switch (typeName) {
		case "int":
			return Integer.valueOf(value);
		case "byte":
			return Byte.valueOf(value);
		case "short":
			return Short.valueOf(value);
		case "long":
			return Long.valueOf(value);
		case "float":
			return Float.valueOf(value);
		case "double":
			return Double.valueOf(value);
		case "boolean":
			return Boolean.valueOf(value);
		case "java.lang.Class":
			return loadClass(value);
		}
		return value;
	}
	
	public Class getSetterArgType(Method method) {
		return method.getParameterTypes()[0];
	}

	public void invokeSetter(Object object, Object arg, String name) throws Exception {
		Method method = getMethodByName(object, name);
		method.invoke(object, arg);
	}
	
	public Method getMethodByName(Object object, String methodName){
		Method[] methods = object.getClass().getMethods();
		for (int i = 0; i < methods.length; i++) {
			if(methods[i].getName().equals(methodName)){
				return methods[i];
			}
		}
		throw new IllegalArgumentException("Method with name "+ methodName +"not found in " + object.getClass().getName());
	}
	
	@SuppressWarnings("unchecked")
	public <T> T instantiateClass(String className, Object[] args, String[] argsTypes) throws Exception {
		@SuppressWarnings("rawtypes")
		Class loadedClass = loadClass(className);
		@SuppressWarnings({ "rawtypes" })
		Constructor constructor = getConstructorByArgTypes(loadedClass, argsTypes);
		Object object = constructor.newInstance(args);
		return (T) object;
	}

	private Constructor getConstructorByArgTypes(Class loadedClass, String[] argsTypes) {
		Constructor[] constructors = loadedClass.getConstructors();
		for (int i = 0; i < constructors.length; i++) {
			Parameter[] parameters = constructors[i].getParameters();
			boolean isFinded = true;
			if(parameters.length == argsTypes.length) {
				for (int j = 0; j < parameters.length; j++) {
					Parameter parameter = parameters[j];
					if(!parameter.getType().getName().equals(argsTypes[j])){
						isFinded = false;
						break;
					}
				}
				if(isFinded) {
					return constructors[i];
				} 
			}
		}
		throw new IllegalArgumentException("No constructors found with given parameters:"+ argsTypes);
	}
	
}

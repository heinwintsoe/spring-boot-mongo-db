package me.hws.core.service.proxy;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

import me.hws.core.entity.Category;
import me.hws.core.repository.CategoryRepository;
import me.hws.core.service.CategoryService;
import me.hws.core.service.proxy.annotation.ServiceProxy;

import org.bson.types.ObjectId;

/**
 * 
 * 
 * <h2>Proxy Object Creation</h2>
 * Creating Proxy of CategoryService interface:
 * <pre>
 *     CategoryService categoryService = (CategoryService) Proxy
 *             .newProxyInstance(
 *                 CategoryService.class.getClassLoader(), 
 *                 new Class<?>[] { CategoryService.class },
 *                 new ServiceInvocationHandler(
 *                     CategoryRepository.class, 
 *                     (CategoryRepository) repositoryConfig.categoryRepository));
 * </pre>
 * The methods of CategoryService interface must have annotated with ServiceProxy annotation
 * 
 * @author sgarhws
 *
 */
public class ServiceInvocationHandler implements InvocationHandler {

	private Map<Class, Object> handlers = new HashMap<Class, Object>();

	public ServiceInvocationHandler(Class handlerClass, Object handlerObj) {
		handlers.put(handlerClass, handlerObj);
	}
	
	public ServiceInvocationHandler(Map<Class, Object> handlers) {
		this.handlers = handlers;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		// Read ServiceProxy annotation from the method
		Annotation annotation = method.getAnnotation(ServiceProxy.class);
		if (null != annotation) { // Found annotation
			ServiceProxy shAnnotation = (ServiceProxy) annotation;
			
			// Get handlerClass attribute
			Class handlerClass = shAnnotation.handlerClass();
			// Get handlerMethod attribute
			String methodName = shAnnotation.handlerMethod();
			// Get methodParameterTypes attribute
			Class[] methodParameters = shAnnotation.methodParamTypes();
			
			Object handlerObj = handlers.get(handlerClass);
			if (null != handlerObj) {
				Method handlerMethod = handlerClass.getMethod(methodName, methodParameters);
				return handlerMethod.invoke(handlerObj, args);
			} else {
				String errorMsg = String.format("Service handler, %s, has not been registered", handlerClass.getName());
				throw new ServiceProxyException(errorMsg);
			}
			
		} else {
			// TODO: Logging - No ServiceProxy annotation found
		}

		return null;
	}

}

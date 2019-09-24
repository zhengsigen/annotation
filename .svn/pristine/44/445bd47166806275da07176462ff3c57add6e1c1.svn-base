package cn.zhengsigen.annotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class AnnotationDemo {

	public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException, InstantiationException, NoSuchMethodException, SecurityException {

		Class cls = Class.forName("cn.zhengsigen.annotation.AnnotationTestFile2");

		Object newInstance = cls.newInstance();

		Method[] declaredMethods = cls.getDeclaredMethods();
	
		
	/*	Constructor[] constructors = cls.getConstructors();
		
		for(Constructor c:constructors) {
			
			System.out.println(c);
		}*/

		Constructor[] declaredConstructors = cls.getDeclaredConstructors();

		if (declaredConstructors.length <1) {
			 
			System.err.print("该类只有默认构造器，无法执行注解");

			return;
		}

		/*for(Constructor c:declaredConstructors) {
			
			System.out.println(c);
		}*/
		for (Method method : declaredMethods) {

			if (method.isAnnotationPresent(IgnoreX.class)) {

				System.err.println(method.getName() + "方法通过注解IgnoreX跳过");

				continue;
			}

			if (method.isAnnotationPresent(TestX.class)) {

				if (!Modifier.isPublic(method.getModifiers())) {

					System.err.println(
							
							method.getName() + "方法" + Modifier.toString(method.getModifiers()) + "权限不够（必须为public）");

					continue;
				}
				if (Modifier.isStatic(method.getModifiers())) {

					System.err.println(
							
							method.getName() + "方法" + Modifier.toString(method.getModifiers()) + "是static修饰，无法执行");

					continue;
				}
				
				Class<?>[] parameterTypes = method.getParameterTypes();
				
				if(parameterTypes.length>0) {
					
					System.err.println(method.getName()+"方法有参数，无法执行");
					
					continue;
				}
				

				TestX annotation = method.getAnnotation(TestX.class);

				Class<?> expected = method.getAnnotation(TestX.class).expected();

				long startTime = System.currentTimeMillis();

				Object invoke = method.invoke(newInstance);
				
				long endTime = System.currentTimeMillis();

				try { 
					if (invoke.toString().equals("true")) {

						System.err.println(method.getName() + "捕捉到NullPointerException异常");

					}

				} catch (Exception e) {

					if ((endTime - startTime) > annotation.timeout()) {

						System.err.println(method.getName() + "方法超时");

					} else {

						try {
							int count = method.getAnnotation(TestX.class).count();

							count = count > 10 ? 10 : count;

							for (int i = 0; i < count - 1; i++) {

								method.invoke(newInstance);

							}
						} catch (Exception e1) {

						}
					}
				}
			}
		}
	}
}

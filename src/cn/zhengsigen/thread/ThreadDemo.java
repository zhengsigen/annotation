package cn.zhengsigen.thread;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadDemo {
	
	Method method1 =null;

	public static void main(String[] args) throws InterruptedException, ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		Class cls = Class.forName("cn.zhengsigen.thread.ThreadTestFile");
		
		Object newInstance = cls.newInstance();
		
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		
		Method[] declaredMethods = cls.getDeclaredMethods();
		
		ThreadDemo threadDemo = new ThreadDemo();
	
		for(Method method:declaredMethods) {
			
			long timeout = method.getAnnotation(TestX.class).timeout();
			
		
			executorService.execute(new Runnable() {
				
				@Override
				public void run() {
					try {
									
						method.invoke(newInstance);	

						
					} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
					
				}
			});
			boolean bool = executorService.awaitTermination(timeout,TimeUnit.MILLISECONDS);
			if(!bool) {
				
				System.out.println(method.getName()+"方法执行了五秒，还未完成，已被强行关闭");

				executorService.shutdownNow();
			}
		}
		
		
	}
}

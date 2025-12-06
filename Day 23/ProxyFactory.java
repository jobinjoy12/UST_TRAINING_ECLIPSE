import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

interface Calculator {
	int add(int a, int b);
	int subtract(int a, int b);
}

class CalculatorImpl implements Calculator {
	@Override
	public int add(int a, int b) {
		System.out.println("  CalculatorImpl: Adding " + a + " and " + b);
		return a + b;
	}

	@Override
	public int subtract(int a, int b) {
		System.out.println("  CalculatorImpl: Subtracting " + b + " from " + a);
		return a - b;
	}
}

class LoggingInvocationHandler implements InvocationHandler {
	private final Object target;

	public LoggingInvocationHandler(Object target) {
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// Your code here: Log method call before delegation
		// Example: System.out.println("Proxy: Calling method " + method.getName() + " with args " + Arrays.toString(args));
		Object result = method.invoke(target, args);
		// Log result if desired
		return result;
	}
}

class ProxyFactory {
	public static <T> T createLoggingProxy(T target, Class<T> interfaceType) {
		// Your code here: Create and return a dynamic proxy
		return null;
	}
}
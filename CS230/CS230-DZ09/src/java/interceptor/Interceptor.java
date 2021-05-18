package interceptor;

import java.lang.reflect.Method;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class Interceptor {

    @AroundInvoke
    public Object logMethodCall(InvocationContext invocationContext) throws Exception {
        
        Method m = invocationContext.getMethod();
        
        System.out.println(m.getName() + " <- method *********************");
        
        Object o = invocationContext.proceed();
        
        return o;
    }
}

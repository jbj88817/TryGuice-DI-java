package us.bojie.tryguice.server.impl;

import com.google.common.base.Joiner;
import com.google.inject.Provider;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.lang.reflect.Method;

import javax.inject.Inject;

public class LoggingInterceptor implements MethodInterceptor {
    @Inject
    @SessionId
    private Provider<Long> sessionIdProvider;

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {

        Method method = methodInvocation.getMethod();
        System.out.println(String.format("In session %d: Calling %s#%s(%s)",
                sessionIdProvider.get(),
                method.getDeclaringClass().getName(),
                method.getName(),
                Joiner.on(",").join(methodInvocation.getArguments())));
        return methodInvocation.proceed();
    }
}

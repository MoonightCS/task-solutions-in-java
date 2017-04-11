package useful.proxy;

import java.lang.reflect.Proxy;

public class Solution {
    public static void main(String[] args) {
        SomeInterfaceWithMethods obj = getProxy();
        obj.stringMethodWithoutArgs();
        obj.voidMethodWithIntArg(1);

    }

    public static SomeInterfaceWithMethods getProxy() {

        SomeInterfaceWithMethods impl = new SomeInterfaceWithMethodsImpl();
        return (SomeInterfaceWithMethods) (Proxy.newProxyInstance(impl.getClass().getClassLoader(),
                impl.getClass().getInterfaces(),
                new CustomInvocationHandler(impl)));

    }
}
package useful.genericproxy;

import java.lang.reflect.Proxy;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        test(solution.getProxy(Item.class));
        test(solution.getProxy(Item.class, Small.class));
        test(solution.getProxy(Item.class, Big.class, Small.class));
        test(solution.getProxy(Big.class, Small.class));
        test(solution.getProxy(Big.class));
    }

    public <T extends Item> T getProxy(Class<T> clazz, Class<?>... interfaces) {
        Class<?>[] allInterfaces = new Class[interfaces.length + 1];
        allInterfaces[0] = clazz;
        System.arraycopy(interfaces, 0, allInterfaces, 1, interfaces.length);
        T obj = (T) Proxy.newProxyInstance(clazz.getClassLoader(), allInterfaces, new ItemInvocationHandler());
        return obj;
    }


    private static void test(Object proxy) {
        boolean isItem = proxy instanceof Item;
        boolean isBig = proxy instanceof Big;
        boolean isSmall = proxy instanceof Small;

        System.out.format("%b %b %b\n", isItem, isBig, isSmall);
    }
}
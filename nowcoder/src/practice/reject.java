package practice;

import java.lang.reflect.Method;

public class reject {
    public int fun(String s){
        return s.length();
    }
    public int fun2(String s){
        return s.length();
    }
    
    
    public static void main(String args[]){
        
//        reject r = new reject();
//        int a =r.fun("a");
//        System.out.println(a);
        
        //反射
        try {
            //动态加载
            Class reject_class = Class.forName("practice.reject");
            Object o =reject_class.newInstance();
            Method m =reject_class.getMethod("fun", String.class);
            int result = (int) m.invoke(o, "abs");
            System.out.println(result);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}

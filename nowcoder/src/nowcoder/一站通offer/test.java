package nowcoder.一站通offer;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class test {
    public static void main(String args[]){
       String src= "now coder";
       int n = 9;
       byte[] str = src.getBytes();
       
       fun(str, 0, n-1, true);
       int m=0;
       for(int i=0;i<n;i++){
           if(str[i]==' '){
               fun(str,m,i-1,false);
               m=i+1;               
           }
           else if(i == (n-1))
           {
               fun(str, m, i, false);
           }
       }
       
       System.out.println(new String(str));
    }
   public static void fun(byte[] str,int start,int end,Boolean sign){
       while(start<=end){
           byte temp = str[start];
           if(sign){
               str[start] = uptodown(str[end]);
               str[end] = uptodown(temp);
           }
           else
           {
               str[start] = str[end];
               str[end] = temp;
           }
           start++;
           end--;
       }
   }
   
   public static byte uptodown(byte c){
       int num = 'A'-'a';
       if (c<='z' && c>='a')
           return (byte)(c+num);
       else if(c<='Z' && c>='A')
           return (byte)(c-num);
       else
           return c;
   }
}
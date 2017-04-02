package practice;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class test {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        for(int i=0;i<n;i++){
            String string = scanner.nextLine();
            String[] str_arry = string.split(" ");
        }
        Set<Long> set = new TreeSet<Long>();
        int i=0;
        while(i<n && scanner.hasNextLong()){
            set.add(scanner.nextLong());
            i++;
        }
        Long[] array = set.toArray(new Long[n]);
        if(array[array.length-1] - array[0] > n)
            System.out.println("mistake");
        else if(array[array.length-1] - array[0] < n ){
                if(array[0] == 1)
                    System.out.println(array[array.length-1]+1);
                else
                    System.out.println(array[0]-1 +" "+ (array[array.length-1]+1));
        }else{
                long c= array[0];
                for(int j =0;j<array.length;j++,c++){
                    if(c != array[j]){
                        System.out.println(c);
                        break;
                    }
                }
       }
    }
    
    public static void main3(String args[]){
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] strings = line.split(" ");
        strings[0] = strings[0].replace('A', 'B');
        strings[0] = strings[0].replace('T', 'A');
        strings[0] = strings[0].replace('B', 'T');
        strings[0] = strings[0].replace('G', 'B');
        strings[0] = strings[0].replace('C', 'G');
        strings[0] = strings[0].replace('B', 'C');
        int result = 0;
        for(int i=0;i<strings[0].length();i++){
            if(strings[0].charAt(i) != strings[1].charAt(i))
                result++;
        }
        System.out.println(result);
    }
    
    public static void main2(String args[]){
        Scanner scanner = new Scanner(System.in);
        int n = Integer.valueOf(scanner.nextLine());
        String[] array = new String[n];
        int i=0;
        while(i<n&&scanner.hasNext()){
            array[i++] = scanner.nextLine();
        }
        int result = 0;
        for( i=0;i<n;i++){
            if(array[i].equals("")) continue;
            String compare = array[i] + array[i];
            
            for(int j = i+1;j<n;j++){
                if(compare.contains(array[j]) && array[i].length() == array[j].length())
                    array[j] = "";
            }   
            result++;
        }
        System.out.println(result);
    }
}

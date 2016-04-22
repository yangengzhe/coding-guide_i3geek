package nowcoder.一站通offer;


public class test2 {
    public static void main(String args[]){
     
        int[][] land = {{1,1,1,1},{0,0,0,0},{1,0,1,1}};
        int n = 4;
        int m = 3;
        
        
        int[] land_num = new int[n];
        for(int i=0;i<n;i++){
            for(int l=0;l<m;l++){
                land_num[i] += land[l][i]; 
            }
        }
        int min = Integer.MAX_VALUE;
        int temp = 0;
        for(int i=0;i<n;i++){
            int left = fun(land_num,0,i,true,m);
            int right = fun(land_num, i+1, n-1,false,m);
            if(left+right <min){
                temp = i;
                min = left+right;
            }
        }
        temp++;
        
        if(fun(land_num, 0, n-1, true, m)<min)
            System.out.println(n+","+ (n+1) );
        else if(fun(land_num, 0, n-1, false, m)<=min)
            
        
            System.out.println("0,1");
        else
            System.out.println(temp +","+ (temp+1) );
        
       
    }
    
    public static int fun(int[] a,int start ,int end,boolean sign,int m){
        if(sign){
        int sum =0;
        for(int i=start;i<=end;i++){
            sum+=a[i];
        }
        return sum;
        }
        else{
            int sum=0;
            for(int i=start;i<=end;i++){
                sum = sum+ m-a[i];
            }
            return sum;
        }
    }
}

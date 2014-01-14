import java.util.HashMap;
import java.util.Scanner;

public class Collatz{
    
    public static HashMap<Integer,Integer> cache = new HashMap<Integer,Integer>();
    
    public static int  maxCollatzSequence(int i,int j){
        int max = Integer.MIN_VALUE;
        for(int k = i;k <= j;k++ ){
            int len = collatzSequence(k);
            if(len > max)
               max = len;    
        
        }
        return max;
    }


    public static int collatzSequence(int n){
        int len = 1;
        while(n != 1){
            if(cache.containsKey(n)){
                len = cache.get(n);
                break;
            }   
            len++;
            if(n % 2 == 1) n = 3 * n + 1;
            else n = n/2;
        }
        cache.put(n,len);     
        return len;
    }
    public static void main (String[] args){
        Scanner S = new Scanner(System.in);
        System.out.println(maxCollatzSequence(900,1000)); 
        
    
    }


}

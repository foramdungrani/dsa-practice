import java.util.HashMap;
import java.util.Map;

public class Fibonacci {
    public static void main(String[] args) {
        int n = 10;
        System.out.println(fib(n));
        System.out.println(fib2(n));
        Map<Integer, Integer> map = new HashMap<>();
        System.out.println(fib3(n, map));
    }

    //recursion
    static int fib(int n){
        if(n <= 1) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }

    //iterative
    static int fib2(int n){
        if(n <= 1) {
            return n;
        }
        int prev = 0, curr = 1;
        for(int i = 2; i <= n; i++) {
            int next = prev + curr;
            prev = curr;
            curr = next;
        }
        return curr;
    }

    //optimized recursion
    static int fib3(int n, Map<Integer, Integer> map){
        if(n <= 1) {
            return n;
        }
        if(map.containsKey(n)) {
            return map.get(n);
        }
        int result = fib3(n - 1, map) + fib3(n - 2, map);
        map.put(n, result);
        return result;
    }
}

/**
 * Created by jeff on 1/3/17.
 */
public class Fib {
    static int zeroCount = 0;
    static int oneCount = 0;

    public static int stupidAdd(int curr, int inc){
        if(inc < 1){
            return curr;
        }
        else{
            curr += 1;
            inc -= 1;
            return stupidAdd(curr, inc);

        }

    }

    public static int fib(int num){
        if(num == 0){
            zeroCount++;
            return 0;
        }
        else if(num == 1){
            oneCount++;
            return 1;
        }
        else{
            return fib(num - 1) + fib(num - 2);
        }
    }

    public static long fibIter(long num){

        if(num == 0){
            return 0;
        }
        else if(num == 1){
            return 1;
        }

        long prev = 0;
        long curr = 1;
        long value = 0;
        for(int i = 1; i < num; i++){
            value = curr + prev;
            prev = curr;
            curr = value;
        }
        return value;
    }

}

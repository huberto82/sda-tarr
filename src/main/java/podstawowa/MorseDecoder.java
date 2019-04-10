package podstawowa;
import java.math.BigInteger;
import java.util.*;

public class MorseDecoder {
    public static String Factorial(int n) {
        BigInteger bn = new BigInteger(Integer.toString(n));
        while (n-- > 0){
            BigInteger d = new BigInteger(Integer.toString(n));
            bn = bn.multiply(d);
        }
        return bn.toString();
    }

    public static List<Long> findAll(final int sumDigits, final int numDigits) {
        List<Long> list = new ArrayList<>();
        Deque<Integer> digits = new ArrayDeque<>();
        findOne(sumDigits, numDigits, digits, list);
        System.out.println("LIST");
        return Arrays.asList((long)list.size(), list.get(0), list.get(list.size()-1));
    }

    public static void findOne(final int sumDigits, final int numDigits, Deque<Integer> digits, List<Long> list){
        if (digits.size() == numDigits){
            if (sumDigits(digits) == sumDigits) {
                list.add(toLong(digits));
            }
            return;
        }
        int last = digits.peekFirst() != null ? digits.peekFirst(): 1;
        for (int i = last; i < 10; i++){
            if ((sumDigits(digits) + i) <= sumDigits && numDigits >= (digits.size() + 1)){
                Deque<Integer> dg = new ArrayDeque<>(digits);
                dg.addFirst(i);
                findOne(sumDigits, numDigits, dg, list);
            }
        }
    }

    public static long toLong(Deque<Integer> digits){
        long result = 0;
        long nom = 1;
        for (int digit: digits) {
            result += nom * digit;
            nom *= 10;
        }
        return result;
    }

    public static int sumDigits(Deque<Integer> digits){
        int sum = 0;
        for (int digit: digits) {
            sum += digit;
        }
        return sum;
    }

    public static void main(String[] args) {
        List<Long> l = findAll(27, 3);
        System.out.println(l.get(0)+" "+ l.get(1)+ " "+  l.get(2));
    }


}

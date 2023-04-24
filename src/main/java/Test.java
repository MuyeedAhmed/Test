import org.checkerframework.checker.index.qual.GTENegativeOne;
import org.checkerframework.checker.index.qual.NonNegative;
import org.checkerframework.checker.lock.qual.GuardSatisfied;
import org.checkerframework.checker.nullness.qual.EnsuresKeyFor;
import org.checkerframework.checker.nullness.qual.KeyFor;
import org.checkerframework.checker.nullness.qual.MonotonicNonNull;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.checkerframework.checker.nullness.qual.PolyNull;
import org.checkerframework.checker.signedness.qual.UnknownSignedness;
import org.checkerframework.common.value.qual.*;

import java.util.Random;


public class Test {
    public void printLength(String str) {
        System.out.println(str.length());
    }

    public void printLength2(String str) {
        if (str != null) {
            System.out.println(str.length());
        } else {
            System.out.println("null");
        }
    }

    public int recurse(int x){
//        if(x>20){
//            return 0;
//        }
        return recurse(x+1);
    }


    public void recurse2(int n) {

        if (n < 5) {
            recurse2((n * 5));
        } else {
            System.out.println("Terminating recursion.");
        }
    }

    public static void countDown(int number){
        if (number <= 0) {
            System.out.println(number);
        } else {
            System.out.println(number);
            countDown(number - 1);
        }
    }

    public int incorrectBaseCase(int n) {
        if (n == 0) {
            // Incorrect base case - this function should return 1, not 0
            return 0;
        } else {
            return n * incorrectBaseCase(n - 1);
        }
    }

    public int recursiveArrayOutOfBounds(int n) {
        int[] numbers = new int[n];
        numbers[n-1] = 3;
//        return n * recursiveArrayOutOfBounds(n - 1);
        return recursiveArrayOutOfBounds(n - 1);

    }

    public int stackOverflow(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * stackOverflow(n - 1);
        }
    }


    public static int getValueAtIndex(int[] array, int index) {
        index = index + 1;
        int value = array[index];
        value = getValueAtIndex(array, value);
        return value;
    }


    public static int recurseINF2(int[] array, int index) {
        if(index < 0){
            index = index + 1;
        }
        if(index >= 0){
            index = index - 1;
        }
        int value = getValueAtIndex(array, array[index]);
        return value;
    }

    public static String generateRandomString(int length, Random random, char s) {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(chars.length());
            if (s == chars.charAt(index)){
                continue;
            }
            sb.append(chars.charAt(index));
            sb.append(generateRandomString(random.nextInt(chars.length()), random, chars.charAt(index)));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Test example = new Test();
        String s1 = null;
        String s2 = "hue";
//        example.printLength(s2);
//        example.printLength2(s1);

        example.recurse(0);
        example.countDown(90);

        example.recurse2(0);
        example.incorrectBaseCase(8);
        example.stackOverflow(9);
        example.recursiveArrayOutOfBounds(9);


        int[] numbers = { 1, 2, 3, 4, 5 };
        int[] numbers2 = { 1, 2, 3, 4, 5 , 6, 23,22,2,32,2,2};

        int valueAtIndex = getValueAtIndex(numbers, 2);
        int valueAtIndex2 = getValueAtIndex(numbers2, 8);
        recurseINF2(numbers2, 8);
    }
}
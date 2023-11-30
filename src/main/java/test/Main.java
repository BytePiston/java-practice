package test;

import lombok.Builder;

import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {

        Patient[] arr = new Patient[3];

        arr[0] = new Patient("Neel", "P", "7");
        arr[1] = new Patient("Pooja", "S", "3");
        arr[2] = new Patient("Jay", "Pr", "7");
        System.out.println(arr[0].equals(arr[2]));
        System.out.println(Arrays.toString(arr));
    }
}

package linkedin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CutTheSticks {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numSticks = scan.nextInt();
        int [] array = new int[numSticks];
        for (int i = 0; i < numSticks; i++) {
            array[i] = scan.nextInt();
        }
        scan.close();

        int[] res = cutSticks(array);
        System.out.println(Arrays.toString(res));
    }

    private static int[] cutSticks(int[] array){
        Arrays.sort(array);

        List<Integer> res = new ArrayList<>();
        res.add(array.length);
        for (int i = 1; i < array.length; i++) {
            if (array[i] != array[i-1]) {
                res.add(array.length - i);
            }
        }
        int[] ret = new int[res.size()];
        int j=0;
        for(int i:res) ret[j++] = i;
        return ret;
    }
}

package linkedin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortStringsAlphabet {

    public static void main(String[] args) {
        String[] alphabet = {"b", "bc", "aa", "c"};
        List<String> ip = new ArrayList<>(Arrays.asList("aab", "baa", "bcb", "bbc"));

        ip.sort((s1, s2) -> {
            int i1 = -1, i2=-1;
            while(i1 == i2) {

                for (int i = 0; i < alphabet.length; i++) {
                    if (s1.indexOf(alphabet[i]) == 0) {
                        i1 = i;
                    }
                }

                for (int i = 0; i < alphabet.length; i++) {
                    if (s2.indexOf(alphabet[i]) == 0) {
                        i2 = i;
                    }
                }
                s1 = s1.substring(alphabet[i1].length());
                s2 = s2.substring(alphabet[i2].length());
            }
            return i1 - i2;
        });

        System.out.println(ip.toString());
    }

}

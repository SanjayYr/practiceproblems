package linkedin;

import java.util.ArrayList;
import java.util.List;

public class AltParityPermutation {
    public static void main(String[] args) {
        List<List<Integer>> res = altParity(4);
        for (List<Integer> l: res) System.out.println(l.toString());
    }

    private static List<List<Integer>> altParity(int n){
        List<Integer> even = new ArrayList<>();
        List<Integer> odd = new ArrayList<>();

        for(int i=1; i<=n; i++){
            if(i%2==0) even.add(i);
            else odd.add(i);
        }
        List<List<Integer>> res = new ArrayList<>();
        List<List<Integer>> evenP = permute(even);
        List<List<Integer>> oddP = permute(odd);

        for (List<Integer> o: permute(odd)){
            int[] temp1 = new int[n]; int k=0;
            for (int j=0; j<n; j+=2) temp1[j] = o.get(k++);
            int[] temp2 = new int[n]; k=0;
            for (int j=1; j<n; j+=2) temp2[j] = o.get(k++);

            for (List<Integer> e: permute(even)){
                k=0;
                for (int j=1; j<n; j+=2) temp1[j] = e.get(k++);
                List<Integer> t1 = new ArrayList<>();
                for(int p:temp1) t1.add(p);
                res.add(t1);

                k=0;
                for (int j=0; j<n; j+=2) temp2[j] = e.get(k++);
                List<Integer> t2 = new ArrayList<>();
                for(int p:temp2) t2.add(p);
                res.add(t2);

            }

        }
        res.sort((l1, l2) -> {
            int s=l1.size(); int i=0;
            while (i < s){
                if(l1.get(i) == l2.get(i)) i++;
                else if(l1.get(i) > l2.get(i)) return 1;
                else return -1;
            }
            return 0;
        });
        return res;
    }

    private static List<List<Integer>> permute(List<Integer> l){
        List<List<Integer>> list = new ArrayList<>();
        int[] nums = new int[l.size()];
        int j=0;
        for (int i:l)nums[j++] = i;
        backtrack(list, new ArrayList<>(), nums);
        return list;
    }

    private static void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums){
        if(tempList.size() == nums.length){
            list.add(new ArrayList<>(tempList));
        } else{
            for(int i = 0; i < nums.length; i++){
                if(tempList.contains(nums[i])) continue; // element already exists, skip
                tempList.add(nums[i]);
                backtrack(list, tempList, nums);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}

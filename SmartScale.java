package visa;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SmartScale {
    private static class Pair<F, S> {
        private F first; //first member of pair
        private S second; //second member of pair

        public Pair(F first, S second) {
            this.first = first;
            this.second = second;
        }

        public void setFirst(F first) {
            this.first = first;
        }

        public void setSecond(S second) {
            this.second = second;
        }

        public F getFirst() {
            return first;
        }

        public S getSecond() {
            return second;
        }
    }

    public static void main(String[] args){
        int[] ids = new int[]{1,1,1,2,2,3};
        System.out.println(deleteProducts(ids, 2));
    }
    private static int deleteProducts(int[] ids, int m){
        if(m >= ids.length) return 0;
        int total = m;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i: ids){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        // Pair: {Count, Number}
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>(
                (a,b) -> a.getFirst() - b.getFirst()
        );
        for(Map.Entry<Integer, Integer> e: map.entrySet()){
            pq.offer(new Pair<>(e.getValue(), e.getKey()));
        }
        while (!pq.isEmpty()){
            Pair<Integer, Integer> p = pq.peek();
            if(total >= p.getFirst()) {
                total -= p.getFirst();
                pq.poll();
            }
            else break;
        }
        return pq.size();
    }
}

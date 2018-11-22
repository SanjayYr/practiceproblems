package visa;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class WebsitePagination {
    public static void main(String[] args){
        String[][] items = new String[3][3];
        items[0] = new String[]{"item1", "10", "15"};
        items[1] = new String[]{"item2", "3", "4"};
        items[2] = new String[]{"item3", "17", "18"};
        String[] res = fetchItemsToDisplay(items, 1, 1, 2, 1);
        for(String s:res)
            System.out.println(s);

    }
    private static String[] fetchItemsToDisplay(String[][] items, int sortParameter, int sortOrder, int x, int y){
        List<String> res = new ArrayList<>();
        PriorityQueue<String[]> pq = getPriorityQueue(sortParameter, sortOrder);

        for(String[] sArr: items){
            pq.offer(sArr);
        }

        int count = x*y;
        while(!pq.isEmpty() && count-- != 0){
            pq.poll();
        }

        count = x;
        while(!pq.isEmpty() && count-- != 0){
            String[] s = pq.poll();
            res.add(s[0]);
        }
        return res.toArray(new String[0]);
    }

    private static PriorityQueue<String[]> getPriorityQueue(int sortParameter, int sortOrder){
        PriorityQueue<String[]> pq = null;
        if(sortOrder == 0) {
            if(sortParameter == 0) {
                pq = new PriorityQueue<>(
                        (sArr1, sArr2) -> sArr1[sortParameter].compareTo(sArr2[sortParameter])
                );
            }
            else{
                pq = new PriorityQueue<>(
                        (sArr1, sArr2) -> (int)(Double.parseDouble(sArr1[sortParameter]) -
                                Double.parseDouble(sArr2[sortParameter]))
                );
            }
        }
        else {
            if(sortParameter == 0) {
                pq = new PriorityQueue<>(
                        (sArr1, sArr2) -> sArr2[sortParameter].compareTo(sArr1[sortParameter])
                );
            }
            else{
                pq = new PriorityQueue<>(
                        (sArr1, sArr2) -> (int)(Double.parseDouble(sArr2[sortParameter]) -
                                Double.parseDouble(sArr1[sortParameter]))
                );
            }
        }
        return pq;
    }
}

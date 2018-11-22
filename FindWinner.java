package visa;

public class FindWinner {
    public static void main(String[] args){
        int[] maria = new int[]{3,5,6};
        int[] andrea = new int[]{4,5,7};
        System.out.println(winner(maria, andrea, false));
    }

    private static String winner(int[] maria, int[] andrea, boolean isEven){
        int i=0, score=0;
        if(!isEven) i++;
        while(i < maria.length){
            score += maria[i] - andrea[i];
            i = i+2;
        }
        return score == 0 ? "Tie": (score > 0 ? "Maria": "Andrea");
    }
}

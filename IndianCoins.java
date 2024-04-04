import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class IndianCoins {
    public static void main(String[] args) {

        Integer[]  coins = {10,20,50,100,200,500,2000};
        int V = 1591;
        Arrays.sort(coins, Comparator.reverseOrder());
        int cnt = 0;
        ArrayList<Integer> lst = new ArrayList<>();
        for(int i=0;i<coins.length;i++)
        {
           if(coins[i] <= V)
           {
               while(coins[i] <= V)
               {
                    cnt ++;
                    lst.add(coins[i]);
                    V -= coins[i];
               }
           }
        }
        System.out.println("Min no of notes/coins used = "+cnt);
        System.out.print("List of notes/coins = ");
        for(int i=0;i<lst.size();i++)
            System.out.print(lst.get(i)+", ");
    }
}

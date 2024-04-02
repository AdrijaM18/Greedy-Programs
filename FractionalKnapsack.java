import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapsack {
    public static void main(String[] args) {
        int[] val = {60, 100 , 120};
        int[] weight = {10,20,30};
        int  W = 50;

        double[][] ratio = new double[val.length][2];
        for(int i=0;i<val.length;i++)
        {
            ratio[i][0]=i;
            ratio[i][1]=val[i]/(double)weight[i]; //ratio of value to weight
        }

        //Sort to get the max value before the smaller values
        Arrays.sort(ratio, Comparator.comparingDouble(o->o[1]));

        int capacity = W,finalVal = 0;
        //But sorting happens in ascending order we need the max value first so get the values in descending order
        for(int i=ratio.length-1;i>=0;i--)
        {
            int idx = (int)ratio[i][0];

            //full inclusion of the item
            if(capacity >= weight[idx])
            {
                finalVal += val[idx];
                capacity -= weight[idx];
            }
            //fractional inclusion of the item
            else{
                finalVal += (ratio[i][1] * capacity);
                capacity = 0;
                break;
            }
        }
        System.out.println("Final value : "+finalVal);
    }
}

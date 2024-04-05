/* Given : array of jobs with their deadline and profit (if the job is finished before the deadline).
*          Every job takes a single unit of time which means minimum possible deadline for any job is 1
*          Maximize the total profit if only one job can be scheduled at a time  */


import java.util.ArrayList;
import java.util.Collections;

public class JobSequencingProblem {
    static public class Job{
        int deadline;
        int profit,id;

        //Constructor
        public Job(int i,int d, int p){
            id = i;
            deadline = d;
            profit = p;
        }
    }
    public static void main(String[] args) {
        int[][] jobsInfo = {{4,20}, {1, 10},{1,40},{1,30}};

        ArrayList<Job> jobs = new ArrayList<>();
        for(int i=0;i<jobsInfo.length;i++)
        {
            jobs.add(new Job(i,jobsInfo[i][0],jobsInfo[i][1]));
        }

        Collections.sort(jobs, (obj1,obj2) -> (obj2.profit - obj1.profit));

        ArrayList<Integer> seq = new ArrayList<>();
        int time=0;
        for(int i=0;i<jobs.size();i++)
        {

            Job curr = jobs.get(i);
            if(curr.deadline > time){
                seq.add(curr.id);
                time++;
            }
        }
        // Maximum jobs that can be performed
        System.out.println(" Maximum jobs that can be performed = "+seq.size());
        System.out.print("Jobs are = ");
        for(int i=0;i<seq.size();i++)
        {
            System.out.print(seq.get(i)+" ");
        }
        System.out.println();
    }
}
/* output
 Maximum jobs that can be performed = 2
 Jobs are = 2 0
 */

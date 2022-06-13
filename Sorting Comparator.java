// { Driver Code Starts
import java.io.*;
import java.util.*;
import java.lang.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);

            int start[] = new int[n];
            int end[] = new int[n];

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++)
                start[i] = Integer.parseInt(inputLine[i]);

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) 
                end[i] = Integer.parseInt(inputLine[i]);
                
            int ans = new Solution().maxMeetings(start, end, n);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends

class Meeting {
    int start,end,index;
    Meeting(int start,int end,int index){
        this.start=start;
        this.end=end;
        this.index=index;
    }
}

class MeetingComparator implements Comparator<Meeting>{
    @Override
    public int compare(Meeting m1, Meeting m2){
        if(m1.end<m2.end) return -1;
        else if(m1.end>m2.end) return 1;
        else if(m1.index<m2.index) return -1;
        else return 1;
    }
}

class Solution 
{
    //Function to find the maximum number of meetings that can
    //be performed in a meeting room.
    public static int maxMeetings(int start[], int end[], int n)
    {
        // add your code here
        ArrayList<Meeting> m = new ArrayList<Meeting>();
        for(int i=0;i<n;i++){
            m.add(new Meeting(start[i],end[i],i+1));
        }
        Collections.sort(m, new MeetingComparator());
        int c=1,last=m.get(0).end;
        for(int i=1;i<n;i++){
            if(m.get(i).start>last){
                c++;
                last=m.get(i).end;
            }
        }
        return c;
    }
}

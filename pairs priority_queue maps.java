class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> m = new HashMap<Integer, Integer>();
        PriorityQueue <Pair <Integer,Integer> > pq = new PriorityQueue <Pair <Integer,Integer> > ((a,b) -> a.getKey() - b.getKey());
        for(int i:nums) {
            if(m.containsKey(i))
            {
                int freq = m.get(i);
                freq++;
                m.put(i, freq);
            }
            else
            {
                m.put(i, 1);
            }
        }
        for(Map.Entry<Integer, Integer> i:m.entrySet()){
            pq.add(new Pair <> (i.getValue(),i.getKey()));
            if(pq.size()>k) pq.poll();
        }
        int[] ans = new int[k];
        int i=0;
        while(pq.size()>0) {
            ans[i]=pq.peek().getValue();
            pq.poll();
            i++;
        }
        return ans;
    }
}

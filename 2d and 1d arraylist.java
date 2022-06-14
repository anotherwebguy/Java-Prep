class Solution {
    public static void solve(int ind,int[] nums, List<Integer> curr, List<List<Integer>> res){
        res.add(new ArrayList<>(curr));
        for(int i=ind;i<nums.length;i++){
            if(i>ind && nums[i]==nums[i-1]) continue;
            curr.add(nums[i]);
            solve(i+1,nums,curr,res);
            curr.remove(curr.size()-1);
        }
    }
    
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<Integer> curr = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        solve(0,nums,curr,ans);
        return ans;
    }
}

class Solution {
    public boolean canCross(int[] stones) {
      if (stones.length == 1) {
            return true;
        }

   
        Map<Integer, Set<Integer>> dp = new HashMap<>();

        for (int stone : stones) {
            dp.put(stone, new HashSet<>());
        }

        dp.get(0).add(0);

        for (int i = 0; i < stones.length; i++) {
            int currentStone = stones[i];

            Set<Integer> prevJumps = dp.get(currentStone);

            for (int prevJump : prevJumps) {
               
                if (prevJump - 1 > 0) {
                    int nextJump = prevJump - 1;
                    int nextStonePos = currentStone + nextJump;
                
                    if (dp.containsKey(nextStonePos)) {
                        dp.get(nextStonePos).add(nextJump);
                    }
                }
                if (prevJump > 0) {
                    int nextJump = prevJump;
                    int nextStonePos = currentStone + nextJump;
                    if (dp.containsKey(nextStonePos)) {
                        dp.get(nextStonePos).add(nextJump);
                    }
                }
                int nextJump = prevJump + 1;
                int nextStonePos = currentStone + nextJump;
                if (dp.containsKey(nextStonePos)) {
                    dp.get(nextStonePos).add(nextJump);
                }
            }
        }
        return !dp.get(stones[stones.length - 1]).isEmpty();
    }
}
  
    

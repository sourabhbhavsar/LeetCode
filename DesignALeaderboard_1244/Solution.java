class Leaderboard {

    private Map<Integer, Integer> scores;
    private Map<Integer, Integer> scoreCount;
    
    public Leaderboard() {
        scores = new HashMap<>();
        scoreCount = new TreeMap<>(Collections.reverseOrder());
    }
    
    public void addScore(int playerId, int score) {
        if (!scores.containsKey(playerId)) {
            scores.put(playerId, score);
            scoreCount.put(score, scoreCount.getOrDefault(score, 0) + 1);
        }
        else {
            int earlierScore = scores.get(playerId);
            int earlierScoreCount = scoreCount.get(earlierScore);
            if (earlierScoreCount == 1) {
                scoreCount.remove(earlierScore);
            }
            else {
                scoreCount.put(earlierScore, earlierScoreCount - 1);
            }
            
            int newScore = earlierScore + score;
            scores.put(playerId, newScore);
            scoreCount.put(newScore, scoreCount.getOrDefault(newScore, 0) + 1);
        }
    }
    
    public int top(int K) {
        int sum = 0;
        for (int score : scoreCount.keySet()) {
            int count = scoreCount.get(score);
            if (count >= K) {
                sum = sum + (K * score);
                return sum;
            }
            else {
                sum = sum + (count * score);
                K = K - count;
            }
        }
        
        return sum;
    }
    
    public void reset(int playerId) {
        int score = scores.get(playerId);
        int numScore = scoreCount.get(score);
        if (numScore == 1) {
            scoreCount.remove(score);
        }
        else {
            scoreCount.put(score, numScore - 1);
        }
        
        scores.remove(playerId);
    }
}

/**
 * Your Leaderboard object will be instantiated and called as such:
 * Leaderboard obj = new Leaderboard();
 * obj.addScore(playerId,score);
 * int param_2 = obj.top(K);
 * obj.reset(playerId);
 */

package konak_alg2_sem_autoskola;

/**
 * Object type Result, represents result of the test
 * @author Martin Koňák
 */
public class Result implements ComparingInterface, Comparable<Result>{
    private String name;
    private int score;
    private String time;
    
    /**
     * Constructor
     * @param name - name of author
     * @param score - score in test
     * @param time - time spent in test
     */
    public Result(String name, int score, String time) {
        this.name = name;
        this.score = score;
        this.time = time;
    }  

    @Override
    public String toString() {
        return String.format("Name: %-12sScore: %-18sTime: %-8s", name, String.format("%d", score), time);
    }  
    
    /**
     * Comparing condition
     * @param o - interface
     * @return boolean true - smaller, false - bigger
     */
    @Override
    public boolean isBigger(ComparingInterface o) {
        return this.score < ((Result)o).score;
    }

    public String getScoreString() {
        return Integer.toString(score);
    }   

    public int getScore() {
        return score;
    }

    public String getName() {
        return name;
    }
    
    /**Comparing method
     * 
     * @param r - object Result
     * @return 
     */
    @Override
    public int compareTo(Result r) {
        return r.score - this.score;
    }
    
}

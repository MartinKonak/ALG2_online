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
    
    /**Comparing method
     * 
     * @param r - object Result
     * @return 
     */
    @Override
    public int compareTo(Result r) { //-1, 0, 1 - menší, stejné, větší
        double d = 0;
        
        if (d > 0) {
            return 1;
        }else if(d < 0){
            return -1;
        }else{
            return 0;
        }
    }
    
}

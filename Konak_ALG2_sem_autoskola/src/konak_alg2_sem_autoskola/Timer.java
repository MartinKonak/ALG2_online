package konak_alg2_sem_autoskola;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * Object type Timer, calculates time of the test
 * @author Martin Koňák
 */
public class Timer{    
    private LocalTime startTime;
    private LocalTime finishTime;
    public final static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");

    public Timer() {
    }    
    
    
    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getFinishTime() {
        return finishTime;
    }
    

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public void setFinishTime(LocalTime finishTime) {
        this.finishTime = finishTime;
    }    
    
    /**
     * Converts startTime into String
     * @return  time in String format
     */
    public String getStartTimeString() {
        return startTime.format(dtf);
    }
    /**
     * Converts finish Time into String
     * @return time in String format
     */
    public String getFinishTimeString() {
        return finishTime.format(dtf);
    }
    
    /**
     * Calculates time between start and finish
     * @return LocalTime
     */
    public LocalTime testTime(){
        return LocalTime.ofNanoOfDay(finishTime.toNanoOfDay() - startTime.toNanoOfDay());
    } 

    
    @Override
    public String toString() {
        return testTime().format(dtf);
    }
}

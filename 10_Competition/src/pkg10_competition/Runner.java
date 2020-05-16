package pkg10_competition;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Martin Koňák
 */
public class Runner implements Comparable<Runner>{
    private String firstName;
    private String lastName;
    private int number;
    private LocalTime startTime;
    private LocalTime finishTime;
    public final static DateTimeFormatter dtfstart = DateTimeFormatter.ofPattern("HH:mm:ss");
    public final static DateTimeFormatter dtffinish = DateTimeFormatter.ofPattern("HH:mm:ss:SSS");

    public Runner(String firstName, String lastName, int number) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.number = number;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getNumber() {
        return number;
    }

    public LocalTime getStartTime() {
        return startTime;
    }    
    
    public String getStartTimeString(){
        return startTime.format(dtfstart);
    }

    public LocalTime getFinishTime() {
        return finishTime;
    }
    
    public String getFinishTimeString(){
        return finishTime.format(dtffinish);
    }

    public void setStartTime(String startTime) {
        this.startTime = LocalTime.parse(startTime, dtfstart);
    }

    public void setFinishTime(String finishTime) {
        this.finishTime = LocalTime.parse(finishTime, dtffinish);
    }

    public LocalTime runningTime(){
        return LocalTime.ofNanoOfDay(finishTime.toNanoOfDay() - startTime.toNanoOfDay());
    }
    
    @Override
    public String toString() {
        return String.format("%-4d%-10s%-10s%-12s%-15s%-15s", number, firstName, lastName,
                getStartTimeString(), getFinishTimeString(), runningTime().format(dtffinish));
    }
    
    @Override
    public int compareTo(Runner o) {
        return this.runningTime().compareTo(o.runningTime());
    }
    
    public static void main(String[] args){
        Runner r = new Runner("Alice", "Malá", 23);
        r.setStartTime("09:00:00");
        r.setFinishTime("10:20:10:019");
        System.out.println(r);
    }    
    
}

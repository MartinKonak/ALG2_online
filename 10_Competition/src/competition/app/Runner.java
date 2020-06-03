package competition.app;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Martin Koňák
 */
public class Runner implements Comparable<Runner> {
    private int number;
    private String firstname;
    private String lastname;
    private LocalTime startTime;
    private LocalTime finishTime;
    public static DateTimeFormatter dtfstart = DateTimeFormatter.ofPattern("HH:mm:ss");
    public static DateTimeFormatter dtffinish = DateTimeFormatter.ofPattern("HH:mm:ss:SSS");

    public Runner(int number, String firstname, String lastname) {
        this.number = number;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public void setStartTime(String startTime) {
        this.startTime = LocalTime.parse(startTime, dtfstart);
    }

    public void setFinishTime(String finishTime) {
        this.finishTime = LocalTime.parse(finishTime, dtffinish);
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getFinishTime() {
        return finishTime;
    }
    
    public String getStartTimeString(){
        return startTime.format(dtfstart);
    }
    
    public String getFinishTimeString(){
        return finishTime.format(dtffinish);
    }

    public int getNumber() {
        return number;
    }

    public LocalTime runningTime(){
        return LocalTime.ofNanoOfDay(finishTime.toNanoOfDay() - startTime.toNanoOfDay());
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }
    
    @Override
    public String toString() {
        return String.format("%-4d%-10s%-10s%-15s%-15s%-15s", number, firstname, lastname, getStartTimeString(), 
                getFinishTimeString(),  runningTime().format(dtffinish));
    }
    
    @Override
    public int compareTo(Runner o) {
        return this.runningTime().compareTo(o.runningTime());
    }
    
    
    /*public static void main(String[] args) {
        Runner r = new Runner(101, "Alice", "Mala");
        r.setStartTime("09:00:00");
        r.setFinishTime("09:30:01:000");
        System.out.println(r);
    }*/
}

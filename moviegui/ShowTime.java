package moviegui;
import java.util.ArrayList;

public class ShowTime {

    int time;

    ArrayList<MovieSeats> seats;
    
    public ShowTime(int time, ArrayList<MovieSeats> seats) {
        this.time = time;
        this.seats = seats;


    }
    public ArrayList<MovieSeats> getSeats() {
        return seats;
    }
    public int getTime() {
        return time;
    }
    public void setSeats(ArrayList<MovieSeats> seats) {
        this.seats = seats;
    }
    public void setTime(int time) {
        this.time = time;
    }
    
}

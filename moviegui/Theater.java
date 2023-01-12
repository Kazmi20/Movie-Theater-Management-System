package moviegui;
import java.util.ArrayList;

public class Theater{

    String theaterName;
    String location;
    ArrayList<Movie> availableMovies;

    public Theater(String theaterName, String location, ArrayList<Movie> availableMovies){
        this.location = location;
        this.theaterName= theaterName;
        this.availableMovies=availableMovies;
    }

    public String getTheaterName() {
        return theaterName;
    }
    public String getLocation() {
        return location;
    }
    public void setTheaterName(String theaterName) {
        this.theaterName = theaterName;
    }
    public void setLocation(String location) {
        this.location = location;
    }

}
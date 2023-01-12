package moviegui;
import java.util.ArrayList;
public class Ticket {

    String ticketID;
    Movie moiveTicket;
   
    ArrayList<MovieSeats> seat;
    boolean ticketType;     // To indicate if it a Normal user or a registered user.
    static double price=25.5;
    


    public Ticket(String ticketID, Movie moiveTicket, ArrayList<MovieSeats> seat,boolean ticketType) {
        this.ticketID = ticketID;
        this.moiveTicket = moiveTicket;
        
        this.seat = seat;
        this.ticketType= ticketType;


    }
    
    // getters.
    public String getTicketID() {
        return ticketID;
    }
    public Movie getMoiveTicket() {
        return moiveTicket;
    }
    
    public ArrayList<MovieSeats> getSeat() {
        return seat;
    }
    public boolean getTicketType(){
        return ticketType;
    } 

    // setters.
    public void setMoiveTicket(Movie moiveTicket) {
        this.moiveTicket = moiveTicket;
    }
    public void setTicketID(String ticketID) {
        this.ticketID = ticketID;
    }
    
    public ArrayList<MovieSeats> setSeat() {
        return seat;
    }
    public boolean setTicketType(){
        return ticketType;
    }

}

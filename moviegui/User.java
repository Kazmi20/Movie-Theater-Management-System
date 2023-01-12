package moviegui;

import java.util.ArrayList;
import java.sql.Date;

public class User {
    int userID;
    ArrayList<Ticket> ownedTickets;
    MoneyPayment payment;
    String email;
    boolean status= false;
    Date joinDate=null;
    public User() {
        

    }
    public void addTicket(Ticket ticket) {
        ownedTickets.add(ticket);

    }
    public int getUserID() {
        return userID;
    }
    public ArrayList<Ticket> getOwnedTickets() {
        return ownedTickets;
    }
    public void removeTicket(Ticket ticket) {

    }
    public void setPayment(MoneyPayment payment) {
        this.payment = payment;
    }
    public double doPayment(){
        return payment.calcPayment();

    }
    public String getEmail(){
        return email;
    }
    public boolean getStatus(){
        return status;
        
    }
    public Date getDate(){
        return joinDate;
    }
    

}

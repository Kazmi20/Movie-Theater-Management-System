package moviegui;
public class TicketPayment implements MoneyPayment {

    
    public TicketPayment() {
        

    }
    
    
    public double calcPayment(){
        return Ticket.price;


    }


    
}

package moviegui;
public class CancelPayment implements MoneyPayment {
    @Override
    public double calcPayment(){
        return 0.1 * Ticket.price;

    }


    
}

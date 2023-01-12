package moviegui;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.UUID;
import java.time.LocalDate;

import javax.management.ConstructorParameters;

public class TestConnection {

  private static Connection myConnection;

  public static void makeConnection(String username, String password) throws SQLException {
    try {
      
      myConnection = DriverManager.getConnection("jdbc:mysql://localhost/movie_database", username, password);
      System.out.println("Connection Successfull");

    

    } catch (SQLException e) {
      System.out.println("Connection fail");
      e.printStackTrace();
    }
    
  }

  public boolean validateUser(String email, String password) throws SQLException {
    makeConnection("root", "kazmi");
    Statement line1 = myConnection.createStatement();
    String Query1 = " Select Username, Password from user_table where Email =  '"+ email +"'AND Password = '" + password + "'";
    ResultSet rs = line1.executeQuery(Query1);
    boolean result=false;
    if(rs != null) {
    while (rs.next()) {
        result=true;
    }
  }
    myConnection.close();
    return result;

  }

  public void registerUser(String username, String password, String location, String email, int cardNo, int credit) throws SQLException {
    //myConnection.setAutoCommit(false);
    makeConnection("root", "kazmi");
    LocalDate todayDate=LocalDate.now();
    Date date = Date.valueOf(todayDate);
    PreparedStatement Query2 = myConnection.prepareStatement(" Insert Into user_table(Username, Password, Location, Email, Card, Credit,JoinedDate) values(?,?,?,?,?,?,?)");
    Query2.setString(1,username);
    Query2.setString(2,password);
    Query2.setString(3,location);
    Query2.setString(4,email);
    Query2.setInt(5,cardNo);
    Query2.setInt(6,0);
    Query2.setDate(7,date);
    Query2.execute();
    
    
    myConnection.close();
    

  }
  public void addCredit(int credit, String email) throws SQLException{
    try{  
      makeConnection("root", "kazmi");
      String query = "update user_table set Credit = ? where Email = ?";
      PreparedStatement preparedStmt = myConnection.prepareStatement(query);
      preparedStmt.setInt   (1, credit);
      preparedStmt.setString(2, email);

      // execute the java preparedstatement
      preparedStmt.executeUpdate();
      
      myConnection.close();
    }
    catch (Exception e)
    {
      System.err.println("Got an exception! ");
      System.err.println(e.getMessage());
    }



    
    

    

  }
  public void bookSeat(int seatNo, Date date, String email,String showtime,String movie, String ticket) throws SQLException {
    //myConnection.setAutoCommit(false);
    makeConnection("root", "kazmi");
    PreparedStatement Query2 = myConnection.prepareStatement(" Insert Into seats(SeatNo, Date,Email,Showtime,Movie,Ticket) values(?,?,?,?,?,?)");
    
    Query2.setInt(1,seatNo);
    Query2.setDate(2,date);
    Query2.setString(3,email);
    Query2.setString(4,showtime);
    Query2.setString(5,movie);
    Query2.setString(6,ticket);

   Query2.execute();
    
    
    myConnection.close();
    

  }

  public void cancelTicket(String ticket,String email) throws SQLException{
    try{  
      makeConnection("root", "kazmi");
      String query = "delete from seats where Ticket = ? and Email = ?";
      PreparedStatement preparedStmt = myConnection.prepareStatement(query);
      preparedStmt.setString(1, ticket);
      preparedStmt.setString(2, email);

      // execute the preparedstatement
      preparedStmt.execute();
      
      myConnection.close();
    }
    catch (Exception e)
    {
      System.err.println("Got an exception! ");
      System.err.println(e.getMessage());
    }

  }

  public ArrayList<Integer> getBookedSeats(String showtime, String movie, Date date) throws SQLException {
    makeConnection("root", "kazmi");
    Statement line1 = myConnection.createStatement();
    String Query1 = " Select SeatNo from seats where Showtime =  '"+ showtime +"'AND Movie = '" + movie + "'AND Date = '" + date + "'";
    ResultSet rs = line1.executeQuery(Query1);
    ArrayList<Integer> result = new ArrayList<Integer>();
    if(rs != null) {
    while (rs.next()) {
        result.add(rs.getInt("SeatNo"));
    }
  }
    myConnection.close();
    return result;

  }

  public String getMovieSummary(String name) throws SQLException{

    makeConnection("root", "kazmi");
    Statement line1 = myConnection.createStatement();
    String Query1 = " Select Summary from movie where Name = '" + name + "'";
    ResultSet rs = line1.executeQuery(Query1);
    String result="";
    if(rs != null) {
    while (rs.next()) {
        result=rs.getString("Summary");

    }
    }
    myConnection.close();
    return result;


    


  }



  public Date getMovieYear(String name) throws SQLException{

    makeConnection("root", "kazmi");
    Statement line1 = myConnection.createStatement();
    String Query1 = " Select Year from movie where Name = '" + name + "'";
    ResultSet rs = line1.executeQuery(Query1);
    Date result=null;
    if(rs != null) {
    while (rs.next()) {
        result=rs.getDate("Year");

    }
    }
    myConnection.close();
    return result;


  }
  
  
   public void setJoinedYear(Date date,String Email) throws SQLException{
      
    makeConnection("root", "kazmi");
    Statement line1 = myConnection.createStatement();
    String Query1 = "  update user_table set JoinedDate = ? where Email = ?";
    PreparedStatement preparedStmt = myConnection.prepareStatement(Query1);
      preparedStmt.setDate   (1, date);
      preparedStmt.setString(2,Email );

      // execute the java preparedstatement
      preparedStmt.executeUpdate();
      
      myConnection.close(); 
  }
   
   
    public Date getJoinedYear(String Email) throws SQLException{
    
    makeConnection("root", "kazmi");
    Statement line1 = myConnection.createStatement();
    String Query1 = "Select JoinedDate from user_table where Email = '" + Email + "'";
    ResultSet rs = line1.executeQuery(Query1);
    Date result=null;
    if(rs != null) {
    while (rs.next()) {
        result=rs.getDate("JoinedDate");

    }
    }
    myConnection.close();
    return result;
  
    }
   
   
   

  public String getMovieLang(String name) throws SQLException{

    makeConnection("root", "kazmi");
    Statement line1 = myConnection.createStatement();
    String Query1 = " Select lang from movie where Name = '" + name + "'";
    ResultSet rs = line1.executeQuery(Query1);
    String result="";
    if(rs != null) {
    while (rs.next()) {
        result=rs.getString("lang");

    }
    }
    myConnection.close();
    return result;


    


  }


  public String getUrlImage(String name) throws SQLException{

    makeConnection("root", "kazmi");
    Statement line1 = myConnection.createStatement();
    String Query1 = " Select UrlImage from movie where Name = '" + name + "'";
    ResultSet rs = line1.executeQuery(Query1);
    String result="";
    if(rs != null) {
    while (rs.next()) {
        result=rs.getString("UrlImage");

    }
    }
    myConnection.close();
    return result;

    


  }


  public String getMovieRating(String name) throws SQLException{

    makeConnection("root", "kazmi");
    Statement line1 = myConnection.createStatement();
    String Query1 = " Select Rating from movie where Name = '" + name + "'";
    ResultSet rs = line1.executeQuery(Query1);
    String result="";
    if(rs != null) {
    while (rs.next()) {
        result=rs.getString("Rating");


    }
    }
    myConnection.close();
    return result;


    


  }

  





  







  public static void main(String[] args) throws SQLException {

    TestConnection t = new TestConnection();

    //makeConnection("root", "kazmi");

    //t.registerUser("Sasuke", "urdad", "konoha", "sexyboi@shinobi.com", 1234, 0);

    //boolean check= t.validateUser("sexyboi@shinobi.com", "urdad");

//    System.out.println(check);
    String ticket= UUID.randomUUID().toString();
    //makeConnection("root", "kazmi");
    t.bookSeat(4, Date.valueOf("2022-12-04"),"hi@gogo.com", "5pm", "Black Adam", ticket);
    
    
    //t.cancelTicket("5aaeeb31-3449-4389-bbf6-530745f246e3");


    ArrayList<Integer> result = t.getBookedSeats("5pm", "Black Adam",Date.valueOf("2022-12-04") );

    for(Integer x: result) {
      System.out.println(x);
    }

    


    






    

  }

}

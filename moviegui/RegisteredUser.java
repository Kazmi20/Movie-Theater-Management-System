package moviegui;

import java.sql.SQLException;

import java.sql.Date;

public class RegisteredUser extends User {

   String email;
    String password;
    boolean regStatus=true;
    

    public RegisteredUser(String email, String password ){
        super();
        this.email = email;
        this.password = password;

    }

    public boolean verifyUser() throws SQLException{    // change return type to boolean later.

        TestConnection sql = new TestConnection();
        TestConnection.makeConnection("root", "kazmi");
        
        boolean check=sql.validateUser(email, password);
        return check;


    }
    public String getPassword() {
        return password;
    }
    
   
   @Override
    public String getEmail() {
        return email;
    }
    
    
    public void setPassword(String password){
        this.password = password;
    }
    public void setEmial(String email) {
        this.email = email;
    }
    
   @Override
    public boolean getStatus(){
        return regStatus;
    }
    
    @Override
    public Date getDate(){
        TestConnection sqlCon =new TestConnection();
        Date year=null;
        try{
            
            year = sqlCon.getJoinedYear(email);
            

        
        }
        catch (SQLException e) {
      System.out.println("Connection fail");
      
    }
        return year;
    }
    
    


    
}

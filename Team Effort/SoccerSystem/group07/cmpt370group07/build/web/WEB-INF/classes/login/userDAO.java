/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import Connection.ConnectionManager;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Date;

/**
 * This class checks the credentials entered into the login box. It compares the
 * entered data with what is in the users table. If it matches, the userBean is
 * updated with information for the current session.
 * @author Steph
 */
public class userDAO {

    static Connection currentCon = null;
    static ResultSet rs = null;

    /**
     * This function check the login credentials and sets the user information.
     * @param bean
     * @return 
     */
    public static userBean login(userBean bean) {

        //preparing some objects for connection 
        Statement stmt = null;

        String username = bean.getUsername();
        String password = bean.getPassword();

        String searchQuery =
                "select * from users where username='"
                + username
                + "' AND password='"
                + password
                + "'";

        // "System.out.println" prints in the console; Normally used to trace the process
        System.out.println("Your user name is " + username);
        System.out.println("Your password is " + password);
        System.out.println("Query: " + searchQuery);

        try {
            //connect to DB 
            currentCon = ConnectionManager.getConnection();
            stmt = currentCon.createStatement();
            rs = stmt.executeQuery(searchQuery);
            boolean more = rs.next();

            // if user does not exist set the isValid variable to false
            if (!more) {
                System.out.println("Sorry, you are not a registered user! Please sign up first");
                bean.setValid(false);
            } //if user exists set the isValid variable to true
            else if (more) {
                Integer user_id = rs.getInt("user_id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                String address = rs.getString("address");
                Integer team_id = rs.getInt("team_id");
                Date birthdate = rs.getDate("birthdate");
                Integer phone_number = rs.getInt("phone_number");
                short fees_paid = rs.getShort("fees_paid");
                Integer jersey_number = rs.getInt("jersey_number");
                Integer accessLevel = rs.getInt("access");

                System.out.println("Welcome " + firstName);
                bean.setUser_id(user_id);
                bean.setFirstName(firstName);
                bean.setLastName(lastName);
                bean.setAccessLevel(accessLevel);
                bean.setAddress(address);
                bean.setBirthdate(birthdate);
                bean.setFees_paid(fees_paid);
                bean.setJersey_number(jersey_number);
                bean.setPhone_number(phone_number);
                bean.setTeam_id(team_id);

                bean.setValid(true);
            }
        } catch (Exception ex) {
            System.out.println("Log In failed: An Exception has occurred! " + ex);
        } //some exception handling
        finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (Exception e) {
                }
                rs = null;
            }

            if (stmt != null) {
                try {
                    stmt.close();
                } catch (Exception e) {
                }
                stmt = null;
            }

            if (currentCon != null) {
                try {
                    currentCon.close();
                } catch (Exception e) {
                }

                currentCon = null;
            }
        }

        return bean;

    }
}

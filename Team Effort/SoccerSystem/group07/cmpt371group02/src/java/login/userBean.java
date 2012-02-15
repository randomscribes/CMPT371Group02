package login;

import java.util.Date;

/**
 * This class contains all the information pertaining to a user. The information
 * can be modified using setters or obtained by getters.
 * @author Steph
 */
public class userBean {

    private String username;
    private String firstName;
    private String lastName;
    private String address;
    private String password;
    private Integer accessLevel;
    public boolean valid;
    private Integer team_id;
    private Date birthdate;
    private Integer phone_number;
    private short fees_paid;
    private Integer jersey_number;
    private Integer user_id;

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setJersey_number(Integer jersey_number) {
        this.jersey_number = jersey_number;
    }

    public Integer getJersey_number() {
        return jersey_number;
    }

    public void setFees_paid(short fees_paid) {
        this.fees_paid = fees_paid;
    }

    public short getFees_paid() {
        return fees_paid;
    }

    public void setPhone_number(Integer phone_number) {
        this.phone_number = phone_number;
    }

    public Integer getPhone_number() {
        return phone_number;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setTeam_id(Integer team_id) {
        this.team_id = team_id;
    }

    public Integer getTeam_id() {
        return team_id;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setAccessLevel(Integer accessLevel) {
        this.accessLevel = accessLevel;
    }

    public Integer getAccessLevel() {
        return accessLevel;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String newFirstName) {
        firstName = newFirstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String newLastName) {
        lastName = newLastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String newPassword) {
        password = newPassword;
    }

    public String getUsername() {
        return username;
    }

    public void setUserName(String newUsername) {
        username = newUsername;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean newValid) {
        valid = newValid;
    }
}

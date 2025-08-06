package src.main.java.tracker.user;

public class User {

    private int id;
    private String username;
    private String password;
    private int userDataId;
    private boolean authenticated;

   

    

    public User(int id, String username, String password, int userDataId) {
        setId(id);
        setUsername(username);
        setPassword(password);
        setUserDataId(userDataId);
        setAuthenticated(false);
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getId() {
        return id;
    }

    public int getUserProfileId() {
        return userDataId;
    }



    public boolean isAuthenticated() {
        return authenticated;
    }


    public void setAuthenticated(boolean authenticated) {
        this.authenticated = authenticated;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserDataId(int userDataId) {
        this.userDataId = userDataId;
    }
    
}

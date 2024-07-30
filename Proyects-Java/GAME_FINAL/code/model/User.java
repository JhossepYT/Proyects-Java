package model;

public class User {
    private String username;
    private String password;
    private int id;
    private int wins;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public User(String username, String password, int wins) {
        this.username = username;
        this.password = password;
        this.wins = wins;
    }

    public User(int id, String name, int wins) {
        this.id = id;
        this.username = name;
        this.wins = wins;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.wins = 0;
    }

    public User(String username) {
        this.username = username;
        this.password = "";
        this.wins = 0;
    }

    public User() {
        this.username = "";
        this.password = "";
        this.wins = 0;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", wins=" + wins +
                '}';
    }
}
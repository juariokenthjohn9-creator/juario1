/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

/**
 *
 * @author USER31
 */
    
   

public class session {
    private static session instance;
    private int uid;
    private String fname;
    private String lname;
    private String email;

    // Private constructor for Singleton pattern
    private session() {}

    public static session getInstance() {
        if (instance == null) {
            instance = new session();
        }
        return instance;
    }

    // Getters and Setters
    public int getUid() { return uid; }
    public void setUid(int uid) { this.uid = uid; }

    public String getFname() { return fname; }
    public void setFname(String fname) { this.fname = fname; }

    public String getLname() { return lname; }
    public void setLname(String lname) { this.lname = lname; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}


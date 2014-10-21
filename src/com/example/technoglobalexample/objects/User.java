package com.example.technoglobalexample.objects;

public class User {
	
	private int id;
    private String name;
    private String lastname;
    private String username;
    private String password;
    private String cellphone;
    private String email;


    public User(int id, String name, String lastname, String username, String password, String cellphone, String email) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.username = username;
        this.password = password;
        this.cellphone = cellphone;
        this.email = email;
    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastname;
    }

    public String getUserName() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getCell() {
        return cellphone;
    }

    public String getEmail() {
        return email;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastname) {
        this.lastname = lastname;
    }
    
    public void setUserName(String username) {
        this.username = username;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public void setCell(String cellphone) {
        this.cellphone = cellphone;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    

}

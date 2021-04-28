package com.example.myphoneapp;

public class user {
    public String name,prn,email;
    public user(){

    }
    public  user(String name,String prn,String email){
        this.name=name;
        this.prn=prn;
        this.email=email;

    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrn() {
        return prn;
    }

    public void setPrn(String prn) {
        this.prn = prn;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}

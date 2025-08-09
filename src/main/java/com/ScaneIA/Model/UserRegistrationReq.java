package com.ScaneIA.Model;

public class UserRegistrationReq {
    //attributes
    private String email;
    private String password;
    private String company;
    private String cnpj;

    //constructor
    public UserRegistrationReq(){}
    public UserRegistrationReq(String email, String password, String company, String cnpj) {
        this.email = email;
        this.password = password;
        this.company = company;
        this.cnpj = cnpj;
    }

    //getters
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }
    public String getCompany() {
        return company;
    }
    public String getCnpj() {
        return cnpj;
    }
}

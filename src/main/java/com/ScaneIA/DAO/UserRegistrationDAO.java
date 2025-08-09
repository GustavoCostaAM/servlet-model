package com.ScaneIA.DAO;

import com.ScaneIA.Model.UserRegistrationReq;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserRegistrationDAO extends SuperDAO{

    //method to create a user, SQL exception will be treated on Servlet
    public void registerUser(UserRegistrationReq user) throws SQLException, ClassNotFoundException{

        //prepare to create new statement
        Connection connection = super.getConnection();
        String sql = "INSERT INTO usuario(email, password, company, cnpj) VALUES (?,?,?,?)";

        //prepare the order
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, user.getEmail());
        preparedStatement.setString(2, user.getPassword());
        preparedStatement.setString(3, user.getCompany());
        preparedStatement.setString(4, user.getCnpj());

        //execute the oder
        preparedStatement.executeUpdate();
    }
}

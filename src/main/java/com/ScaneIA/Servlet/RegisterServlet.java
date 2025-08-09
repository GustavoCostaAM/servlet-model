package com.ScaneIA.Servlet;

import com.ScaneIA.DAO.UserRegistrationDAO;
import com.ScaneIA.Model.UserRegistrationReq;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.SQLException;


public class RegisterServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        UserRegistrationReq user;

        //Get the request credentials
        try {
            //read the body
            StringBuilder listRequestBody = new StringBuilder();
            BufferedReader requestReader = request.getReader();
            String line;

            while ((line = requestReader.readLine()) != null){
                listRequestBody.append(line);
            }

            //transform the JSON to object
            String requestJSON = listRequestBody.toString();
            ObjectMapper mapper = new ObjectMapper();
            user = mapper.readValue(requestJSON, UserRegistrationReq.class);

        }catch (IOException exception){
            response.sendError(400, "could not find the credentials, please take a look on our documentation: https://github.com/GustavoCostaAM/servlet-model");

            System.out.println(exception.getMessage());

            return;
        }

        //Add the user on database
        try{
            UserRegistrationDAO dao = new UserRegistrationDAO();
            dao.registerUser(user);
        }catch (SQLException | ClassNotFoundException exception){
            response.sendError(500, "failed to connect on database");
            System.out.println(exception.getMessage());
            return;
        }

        //Returning status
        response.setStatus(200);
    }
}

package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.RegisterServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO: show the registration form
        request.getRequestDispatcher("/WEB-INF/users/register.jsp")
                .forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // TODO: ensure the submitted information is valid
        // TODO: create a new user based off of the submitted information
        // TODO: if a user was successfully created, send them to their profile
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        if (username != null && email != null && password != null){
            User newUser = new User(
                    0L, // this value is only for the temp user built here, a valid ID will be assigned by MySQL
                    username,
                    email,
                    password
            );
            newUser.setId(DaoFactory.getUsersDao().insert(newUser));
            request.getSession().setAttribute("user", request.getParameter("username"));
            response.sendRedirect("/profile");

        } else {
            request.getSession().setAttribute("error", "Invalid username, email, or password entry");
            response.sendRedirect("/register");
        }

    }
}

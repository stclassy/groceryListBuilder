package com.groceryListBuilder.controller;


import com.groceryListBuilder.persistence.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        urlPatterns = {"/searchUser"}
)
public class UserSearch extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDao dao = new UserDao();
        if(request.getParameter("submit").equals("search")) {
            request.setAttribute("users", dao.getByPropertyLike("lastName", request.getParameter("searchTerm")));
        } else {
            request.setAttribute("users", dao.getAll());
        }
    }
}

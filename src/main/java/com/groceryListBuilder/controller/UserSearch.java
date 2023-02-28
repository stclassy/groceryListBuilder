package com.groceryListBuilder.controller;


import com.groceryListBuilder.entity.User;
import com.groceryListBuilder.persistence.GenericDao;

import javax.servlet.RequestDispatcher;
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
        GenericDao dao = new GenericDao(User.class);
        if(request.getParameter("submit").equals("search")) {
            request.setAttribute("users", dao.findByPropertyEqual("lastName", request.getParameter("searchTerm")));
        } else {
            request.setAttribute("users", dao.getAll());
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/results.jsp");
        dispatcher.forward(request, response);
    }
}

package com.groceryListBuilder.controller;

import com.groceryListBuilder.entity.User;
import com.groceryListBuilder.persistence.GenericDao;
import com.groceryListBuilder.util.DaoFactory;
import org.apache.logging.log4j.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

@WebServlet (
        urlPatterns = {"/signUpUser"}
)
public class UserSignUp extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = new User();

        user.setFirstName(request.getParameter("firstName"));
        user.setLastName(request.getParameter("lastName"));
        user.setUserName(request.getParameter("userName"));
        user.setCreateDate(LocalDateTime.now());

        logger.debug("Adding new user:" + user.toString());

        GenericDao dao = DaoFactory.createDao(User.class);
        dao.insert(user);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/home.jsp");
        dispatcher.forward(request,response);
    }
}

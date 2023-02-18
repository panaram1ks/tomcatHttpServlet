package com.parom.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/dispatcher")
public class DispatcherServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("flights");
//        req.setAttribute("1", "123");
//        requestDispatcher.forward(req, resp);

//        requestDispatcher.include(req, resp);
//        resp.getWriter().write("Hello writer again");

        resp.sendRedirect("/flights");


        System.out.println();
//        getServletContext().getRequestDispatcher("");
    }
}

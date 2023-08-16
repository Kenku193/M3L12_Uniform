package com.example.m3l12_uniform.servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CatalogServlet", value = "/catalogServlet")
public class CatalogServlet extends HttpServlet {

    @Override
    public void init() {
        System.out.println("Log");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



        HttpSession session = request.getSession();
        Integer counter = (Integer) session.getAttribute("counter");

        String requestedSessionId = request.getRequestedSessionId();

        if (counter == null) {
            session.setAttribute("counter", 1);
            counter = 1;
        }
        else {
            session.setAttribute("counter", ++counter);
        }

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>CATALOGUE</h1>");
        out.println("<h3>Your counter is: " + counter + "</h3>");
        out.println("<h3>Session id: " + requestedSessionId + "</h3>");
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

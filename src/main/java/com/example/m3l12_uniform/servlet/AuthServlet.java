package com.example.m3l12_uniform.servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

@WebServlet(name = "AuthServlet", value = "/authServlet")
public class AuthServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out = response.getWriter();

      //  String lgn = request.getParameter("login");
      //  String pwd = request.getParameter("password");

        Map<String, String[]> parameterMap = request.getParameterMap();

        // login : [abc]
        // passwword : [qwerty]
        // brands : [appple, xiaomi, samsung]


        response.setContentType("text/html");

        out.println("<html><body>");
        out.println("<h1>AUTENTIFICATION</h1>");
        out.println("<br>");
        Set<String> strings = parameterMap.keySet();
        for (String string : strings) {
            out.println(string);
        }

        out.println("<br>");

        for (String[] value : parameterMap.values()){
            for (String s : value) {
                out.println(s);
            }
        }
       // out.println("Login: " + lgn + ", Password: " + pwd);
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

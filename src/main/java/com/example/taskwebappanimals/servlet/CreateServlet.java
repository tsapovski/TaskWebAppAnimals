package com.example.taskwebappanimals.servlet;

import com.example.taskwebappanimals.dao.AnimalsDao;
import com.example.taskwebappanimals.entity.Pet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/create")
public class CreateServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        getServletContext().getRequestDispatcher("/create.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            String typePet = request.getParameter("typePet");
            String name = request.getParameter("name");
            int age = Integer.parseInt(request.getParameter("age"));
            String color = request.getParameter("color");
            boolean ownerStatus = Boolean.parseBoolean(request.getParameter("ownerStatus"));
            Pet pet = new Pet(typePet, name, age, color, ownerStatus);
            AnimalsDao dao = new AnimalsDao();
            dao.insert(pet);
            response.sendRedirect(request.getContextPath()+"/index");

        }
        catch(Exception ex) {

            getServletContext().getRequestDispatcher("/create.jsp").forward(request, response);
        }
    }
}


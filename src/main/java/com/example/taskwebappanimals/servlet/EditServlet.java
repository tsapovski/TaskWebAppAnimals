package com.example.taskwebappanimals.servlet;

import com.example.taskwebappanimals.dao.AbstractDao;
import com.example.taskwebappanimals.dao.AnimalsDao;
import com.example.taskwebappanimals.entity.Pet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/edit")
public class EditServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            int id = Integer.parseInt(request.getParameter("id"));
            AnimalsDao dao = new AnimalsDao();
            Object pet = dao.selectOne(id);
            if(pet!=null) {
                request.setAttribute("pet", pet);
                getServletContext().getRequestDispatcher("/edit.jsp").forward(request, response);
            }
            else {
                getServletContext().getRequestDispatcher("/notfound.jsp").forward(request, response);
            }
        }
        catch(Exception ex) {
            getServletContext().getRequestDispatcher("/notfound.jsp").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            int id = Integer.parseInt(request.getParameter("id"));
            String typePet = request.getParameter("typePet");
            String name = request.getParameter("name");
            int age = Integer.parseInt(request.getParameter("age"));
            String color = request.getParameter("color");
            boolean ownerStatus = Boolean.parseBoolean(request.getParameter("ownerStatus"));
            Pet pet = new Pet(id, typePet, name, age, color, ownerStatus);
            AnimalsDao dao = new AnimalsDao();
            dao.update(pet);
            response.sendRedirect(request.getContextPath() + "/index");
        }
        catch(Exception ex) {

            getServletContext().getRequestDispatcher("/notfound.jsp").forward(request, response);
        }
    }
}

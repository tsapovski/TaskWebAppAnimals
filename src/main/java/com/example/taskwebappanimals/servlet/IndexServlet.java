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
import java.util.List;
@WebServlet("/index")
public class IndexServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        AbstractDao<Pet> dao = new AnimalsDao();
       List<Pet> pets = dao.select();
        request.setAttribute("pets", pets);

        getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
    }
}

package com.ejemplo.recetas.Controladores;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.ejemplo.recetas.DAO.RecetaDAO;
import com.ejemplo.recetas.entidades.Receta;

@WebServlet("/mostrar")
public class RecetasServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        RecetaDAO dao = new RecetaDAO();
        List<Receta> recetas = dao.obtenerRecetas();

        req.setAttribute("recetas", recetas);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/mostrar.jsp");
        dispatcher.forward(req, resp);
    }
}
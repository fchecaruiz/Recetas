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
import com.ejemplo.recetas.entidades.Dificultad;
import com.ejemplo.recetas.entidades.Receta;

@WebServlet("/insertar")
public class InsertarRecetaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        RecetaDAO dao = new RecetaDAO();
        List<Dificultad> dificultades = dao.obtenerDificultades();
        req.setAttribute("dificultades", dificultades);

        String ok = req.getParameter("ok");
        if ("1".equals(ok)) {
            req.setAttribute("msg", "Receta insertada correctamente.");
        } else if ("0".equals(ok)) {
            req.setAttribute("msg", "Error al insertar la receta.");
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("/insertar.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        String nombre = req.getParameter("nombre");
        String dificultadIdStr = req.getParameter("dificultad");

        Receta r = new Receta();
        r.setNombre(nombre);
        r.setFkDificultad(Integer.parseInt(dificultadIdStr));

        RecetaDAO dao = new RecetaDAO();
        boolean ok = dao.insertarReceta(r);

        resp.sendRedirect(req.getContextPath() + "/insertar?ok=" + (ok ? "1" : "0"));
    }
}
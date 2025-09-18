package Controlador;

import Modelo.Palabra;
import Modelo.PalabraDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AhorcadoServlet", urlPatterns = {"/AhorcadoServlet"})
public class AhorcadoServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();

        PalabraDAO palabraDAO = new PalabraDAO();
        List<Palabra> palabras = palabraDAO.listarPalabras();

        if (palabras != null && !palabras.isEmpty()) {
            Random random = new Random();
            Palabra palabraAleatoria = palabras.get(random.nextInt(palabras.size()));

            String json = "{"
                        + "\"palabra\": \"" + palabraAleatoria.getPalabra() + "\","
                        + "\"pista1\": \"" + palabraAleatoria.getPista1() + "\","
                        + "\"pista2\": \"" + palabraAleatoria.getPista2() + "\","
                        + "\"pista3\": \"" + palabraAleatoria.getPista3() + "\""
                        + "}";

            out.print(json);
        } else {
            out.print("{\"error\": \"No hay palabras en la base de datos\"}");
        }
        out.flush();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
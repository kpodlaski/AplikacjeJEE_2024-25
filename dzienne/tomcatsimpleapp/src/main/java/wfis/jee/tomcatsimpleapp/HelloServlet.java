package wfis.jee.tomcatsimpleapp;

import java.io.*;

import dao.DAO;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        try {
            Class.forName("org.postgresql.Driver").newInstance();
            out.print("Driver is Ready");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        EntityManagerFactory emf =  Persistence.createEntityManagerFactory("appdb");
        DAO dao;
        out.println(emf);
        out.println("</body></html>");
    }


    public void destroy() {
    }
}
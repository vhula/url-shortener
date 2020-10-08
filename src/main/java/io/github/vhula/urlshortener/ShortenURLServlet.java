package io.github.vhula.urlshortener;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/shorten")
public class ShortenURLServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("shortened-url", req.getParameter("url-to-shorten"));
        req.getRequestDispatcher("shorten.jsp").forward(req, resp);
    }
}

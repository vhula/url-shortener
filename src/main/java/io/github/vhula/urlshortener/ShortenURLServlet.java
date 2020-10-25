package io.github.vhula.urlshortener;

import io.github.vhula.urlshortener.urls.ShortenURLService;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/shorten")
public class ShortenURLServlet extends HttpServlet {

    @EJB
    private ShortenURLService shortenURLService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uuid = shortenURLService.shorten(req.getParameter("url-to-shorten"));
        req.setAttribute("shortened-url", req.getServletContext().getContextPath()
                + "/s?uuid=" + uuid);
        req.getRequestDispatcher("shorten.jsp").forward(req, resp);
    }
}

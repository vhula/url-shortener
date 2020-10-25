package io.github.vhula.urlshortener;

import io.github.vhula.urlshortener.urls.ShortenURLService;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/s")
public class ResolveURLServlet extends HttpServlet {

    @EJB
    private ShortenURLService shortenURLService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().log(req.getServletContext().getContextPath());
        getServletContext().log(req.getServletContext().getServerInfo());
        getServletContext().log(req.getServletContext().getVirtualServerName());
        String uuid = req.getParameter("uuid");
        if (uuid != null) {
            getServletContext().log("Path Context: " + req.getContextPath());
            String shortenedUrl = shortenURLService.resolve(uuid);
            if (shortenedUrl != null) {
                resp.sendRedirect(shortenedUrl);
            } else {
                resp.setStatus(404);
                resp.getWriter().write("uuid not found");
            }
        } else {
            resp.setStatus(400);
            resp.getWriter().write("uuid is required");
        }
    }
}

package servlet;

import manager.PollManagerImpl;
import model.Poll;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/poll")
public class PollServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PollManagerImpl pollManager = new PollManagerImpl();

        List<Poll> all = pollManager.findAll();
        req.setAttribute("all", all);
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}

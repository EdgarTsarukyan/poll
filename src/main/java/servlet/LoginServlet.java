package servlet;

import manager.PollManagerImpl;
import manager.UserManagerImpl;
import model.Poll;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PollManagerImpl pollManager = new PollManagerImpl();
        UserManagerImpl userManager = new UserManagerImpl();

        String email = req.getParameter("email");
        String password = req.getParameter("password");

        User user = userManager.getByEmailAndPassword(email, password);
        if (user != null) {
            if (user.getEmail().equals("admin") && user.getPassword().equals("admin")) {
                List<User> all = userManager.getAllUsers();
                req.setAttribute("all", all);
                req.getRequestDispatcher("/adminPage.jsp").forward(req,resp);
                return;
            }else {
                req.getSession().setAttribute("user", user);
                List<Poll> all = pollManager.findAll();
                req.setAttribute("all", all);
                req.getRequestDispatcher("/poll.jsp").forward(req, resp);
                return;
            }

        }
        req.getSession().setAttribute("msg", "email or password is wrong");
        resp.sendRedirect("/login.jsp");

    }
}

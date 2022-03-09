package servlet;

import manager.*;
import model.Question;
import model.Result;
import model.User;
import model.UserResult;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Time;
import java.time.LocalTime;
import java.util.List;

@WebServlet(urlPatterns = "/question")
public class QuestionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserResultManagerImpl userResultManager = new UserResultManagerImpl();
        QuestionManager questionManager = new QuestionManagerImpl();
        ResultManager resultManager = new ResultManagerImpl();

        User user = (User) req.getSession().getAttribute("user");
        String email = user.getEmail();
        List<UserResult> userResults = userResultManager.getByEmail(email);
        Time beforeTime = null;
        UserResult userResult = new UserResult();
       for (UserResult userResult1 : userResults){
           Time createTime = userResult1.getCreateTime();
           beforeTime = createTime;
           userResult = userResult1;
       }
        if (beforeTime != null){
            Time nowTime = Time.valueOf(LocalTime.now());
            long createdTime = beforeTime.getTime();
            long time1 = nowTime.getTime();
            if ((time1 - createdTime) / 1000 <= 90) {
                int resultId = userResult.getResultId();
                Result result = (Result) resultManager.findById(resultId);
                req.setAttribute("result", result);
                req.getRequestDispatcher("/result.jsp").forward(req, resp);
            }else {
                int id = Integer.parseInt(req.getParameter("id"));
                List<Question> all = questionManager.findByPollId(id);
                req.setAttribute("all", all);
                req.getRequestDispatcher("/answer").forward(req, resp);
            }
        }else {
            int id = Integer.parseInt(req.getParameter("id"));
            List<Question> all = questionManager.findByPollId(id);
            req.setAttribute("all", all);
            req.getRequestDispatcher("/answer").forward(req, resp);
        }


    }
}

package servlet;

import manager.AnswerManagerImpl;
import manager.ResultManagerImpl;
import manager.UserResultManagerImpl;
import model.Answer;
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
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@WebServlet(urlPatterns = "/result")
public class ResultServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ResultManagerImpl resultManager = new ResultManagerImpl();
        AnswerManagerImpl answerManager = new AnswerManagerImpl();
        UserResultManagerImpl userResultManager = new UserResultManagerImpl();
        UserResult userResult = new UserResult();
        int score = 0;
        String[] answersId = req.getParameterValues("answerId");
        List<Integer> id = new ArrayList<>();

        for (String answerId : answersId) {
            int i = Integer.parseInt(answerId);
            id.add(i);
        }

        for (int id1 : id) {
            Answer byId = answerManager.findById(id1);
            int weight = byId.getWeight();
            score += weight;
        }
        List<Result> all = resultManager.findAll();
        for (Result result : all) {
            if (score >= result.getMinScore() && score <= result.getMaxScore()) {
                req.setAttribute("result", result);

            }
        }
        Time time = Time.valueOf(LocalTime.now());
        User user = (User) req.getSession().getAttribute("user");
        String email = user.getEmail();
        Result result = (Result) req.getAttribute("result");
        int resultId = result.getId();

        userResult.setCreateTime(time);
        userResult.setUserEmail(email);
        userResult.setResultId(resultId);
        userResultManager.create(userResult);


        req.getRequestDispatcher("/result.jsp").forward(req, resp);


    }
}

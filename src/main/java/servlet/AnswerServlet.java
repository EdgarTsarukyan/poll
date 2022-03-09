package servlet;

import manager.AnswerManagerImpl;
import manager.QuestionManagerImpl;
import model.Answer;
import model.Question;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/answer")
public class AnswerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AnswerManagerImpl answerManager = new AnswerManagerImpl();
//        int id = Integer.parseInt(req.getParameter("id"));
//        List<Answer> allAnswers = answerManager.findByQuestionId(id);
//        req.setAttribute("allAnswers", allAnswers);
//        Object all = req.getAttribute("all");
//        req.setAttribute("all", all);

        List<Question> allQuestions = (List<Question>) req.getAttribute("all");
       List list = new ArrayList();
        for (Question question : allQuestions) {

            int id = question.getId();
            List<Answer> answersByQuestionId = answerManager.findByQuestionId(id);
            for (Answer answer : answersByQuestionId){
                list.add(answer);
            }

        }
        req.setAttribute("list", list);
        req.setAttribute("allQuestions", allQuestions);

        req.getRequestDispatcher("/question.jsp").forward(req, resp);
    }
}

package manager;

import model.Question;

import java.util.List;

public interface QuestionManager<Q, I extends Number> extends Manager <Question, Integer> {

    List<Question> findByPollId(int id);

}

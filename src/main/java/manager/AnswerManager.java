package manager;

import model.Answer;
import model.Question;

import java.util.List;

public interface AnswerManager<A, I extends Number> extends Manager <Answer, Integer> {

    List<Answer> findByQuestionId(int id);

}

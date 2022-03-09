package manager;

import model.Question;
import model.Result;

import java.util.List;

public interface ResultManager<Q, I extends Number> extends Manager <Result, Integer> {

    List<Result> findByPollId(int id);

    List<Result> findByScore(int score);

}

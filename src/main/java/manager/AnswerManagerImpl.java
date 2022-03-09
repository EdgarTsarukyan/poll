package manager;

import conf.DBConnectionProvider;
import model.Answer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AnswerManagerImpl implements AnswerManager<Answer, Integer> {

    public final Connection connection = DBConnectionProvider.getInstance().getConnection();

    @Override
    public List findAll() {

        List<Answer> answers = new ArrayList<>();
        try {
            String query = "SELECT * FROM answers";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Answer answer = new Answer();
                answer.setId(resultSet.getInt("id"));
                answer.setText(resultSet.getString("text"));
                answer.setWeight(resultSet.getInt("weight"));
                answer.setQuestionId(resultSet.getInt("question_id"));
                answers.add(answer);
            }
        } catch (SQLException e) {
            System.out.println("something wrong during work method find all answers");
        }
        return answers;

    }

    @Override
    public Answer findById(Integer id) {
        Answer answer = new Answer();
        try {
            String query = "SELECT * FROM Answers WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                answer.setId(resultSet.getInt("id"));
                answer.setText(resultSet.getString("text"));
                answer.setWeight(resultSet.getInt("weight"));
                answer.setQuestionId(resultSet.getInt("question_id"));
                return answer;
            }

        } catch (SQLException e) {
            System.out.println("something wrong during work in method findById");
        }

        return null;
    }

    @Override
    public List<Answer> findByQuestionId(int questionId) {
        List<Answer> answers = new ArrayList<>();

        try {
            String query = "SELECT * FROM answers WHERE question_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, questionId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Answer answer = new Answer();
                answer.setId(resultSet.getInt("id"));
                answer.setText(resultSet.getString("text"));
                answer.setWeight(resultSet.getInt("weight"));
                answer.setQuestionId(resultSet.getInt("question_id"));
                answers.add(answer);

            }

        } catch (SQLException e) {
            System.out.println("something wrong during work in method findById");
        }
        return answers;
    }

}

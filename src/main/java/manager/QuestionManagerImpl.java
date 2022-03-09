package manager;

import conf.DBConnectionProvider;
import model.Question;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QuestionManagerImpl implements QuestionManager<Question, Integer> {

    public final Connection connection = DBConnectionProvider.getInstance().getConnection();

    @Override
    public List findAll() {

        List<Question> questions = new ArrayList<>();
        try {
            String query = "SELECT * FROM questions";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Question question = new Question();
                question.setId(resultSet.getInt("id"));
                question.setText(resultSet.getString("text"));
                question.setPollId(resultSet.getInt("poll_id"));
                questions.add(question);
            }
        } catch (SQLException e) {
            System.out.println("something wrong during work method find all");
        }
        return questions;

    }

    @Override
    public Question findById(Integer id) {
        Question question = new Question();
        try {
            String query = "SELECT * FROM questions WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                question.setId(resultSet.getInt("id"));
                question.setText(resultSet.getString("text"));
                question.setPollId(resultSet.getInt("poll_id"));
                return question;
            }

        } catch (SQLException e) {
            System.out.println("something wrong during work in method findById");
        }

        return null;
    }

    @Override
    public List<Question> findByPollId(int pollId) {
        List<Question> questions = new ArrayList<>();

        try {
            String query = "SELECT * FROM questions WHERE poll_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, pollId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Question question = new Question();
                question.setId(resultSet.getInt("id"));
                question.setText(resultSet.getString("text"));
                question.setPollId(resultSet.getInt("poll_id"));
                questions.add(question);

            }

        } catch (SQLException e) {
            System.out.println("something wrong during work in method findById");
        }
        return questions;
    }

}

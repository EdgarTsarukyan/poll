package manager;

import conf.DBConnectionProvider;
import model.Question;
import model.Result;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ResultManagerImpl implements ResultManager<Result, Integer> {

    public final Connection connection = DBConnectionProvider.getInstance().getConnection();

    @Override
    public List findAll() {

        List<Result> results = new ArrayList<>();
        try {
            String query = "SELECT * FROM results";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Result result = new Result();
                result.setId(resultSet.getInt("id"));
                result.setExplanation(resultSet.getString("explanation"));
                result.setMaxScore(resultSet.getInt("max_score"));
                result.setMinScore(resultSet.getInt("min_score"));
                result.setPollId(resultSet.getInt("poll_id"));
                results.add(result);
            }
        } catch (SQLException e) {
            System.out.println("something wrong during work method find all results");
        }
        return results;

    }

    @Override
    public Result findById(Integer id) {
        Result result = new Result();
        try {
            String query = "SELECT * FROM results WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                result.setId(resultSet.getInt("id"));
                result.setExplanation(resultSet.getString("explanation"));
                result.setMaxScore(resultSet.getInt("max_score"));
                result.setMinScore(resultSet.getInt("min_score"));
                result.setPollId(resultSet.getInt("poll_id"));
                return result;
            }

        } catch (SQLException e) {
            System.out.println("something wrong during work in method findById");
        }

        return null;
    }

    @Override
    public List<Result> findByPollId(int pollId) {
        List<Result> results = new ArrayList<>();

        try {
            String query = "SELECT * FROM results WHERE poll_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, pollId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Result result = new Result();
                result.setId(resultSet.getInt("id"));
                result.setExplanation(resultSet.getString("explanation"));
                result.setMaxScore(resultSet.getInt("max_score"));
                result.setMinScore(resultSet.getInt("min_score"));
                result.setPollId(resultSet.getInt("poll_id"));
                results.add(result);

            }

        } catch (SQLException e) {
            System.out.println("something wrong during work in method findById");
        }
        return results;
    }

    @Override
    public List<Result> findByScore(int score) {
        List<Result> results = new ArrayList<>();

        try {
            String query = "SELECT * FROM results WHERE max_score = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, score);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Result result = new Result();
                result.setId(resultSet.getInt("id"));
                result.setExplanation(resultSet.getString("explanation"));
                result.setMaxScore(resultSet.getInt("max_score"));
                result.setMinScore(resultSet.getInt("min_score"));
                result.setPollId(resultSet.getInt("poll_id"));
                results.add(result);

            }

        } catch (SQLException e) {
            System.out.println("something wrong during work in method findByScore");
        }
        return results;
    }

}

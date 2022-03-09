package manager;

import conf.DBConnectionProvider;
import model.UserResult;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserResultManagerImpl implements UserResultManager<UserResult, Integer> {

    public final Connection connection = DBConnectionProvider.getInstance().getConnection();

    @Override
    public List findAll() {

        List<UserResult> userResults = new ArrayList<>();
        try {
            String query = "SELECT * FROM userResults";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                UserResult userResult = new UserResult();
                userResult.setId(resultSet.getInt("id"));
                userResult.setUserEmail(resultSet.getString("user_email"));
                userResult.setCreateTime((Time) resultSet.getObject("create_time"));
                userResult.setResultId(resultSet.getInt("result_id"));

                userResults.add(userResult);
            }
        } catch (SQLException e) {
            System.out.println("something wrong during work method find all userResults");
        }
        return userResults;

    }

    @Override
    public List<UserResult> getByEmail(String email) {
        List<UserResult> userResults = new ArrayList<>();


        try {
            String query = "SELECT * FROM user_results WHERE user_email = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,email);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                UserResult userResult = new UserResult();
                userResult.setId(resultSet.getInt("id"));
                userResult.setUserEmail(resultSet.getString("user_email"));
                userResult.setCreateTime((Time) resultSet.getObject("create_time"));
                userResult.setResultId(resultSet.getInt("result_id"));
                userResults.add(userResult);

            } return userResults;

        } catch (SQLException e) {
            System.out.println("something wrong during work in method getByEmail for userResult");
        }

        return null;
    }

    @Override
    public void create(UserResult userResult) {
        try {
            String query = "INSERT INTO user_results(user_email, create_time, result_id) VALUES (?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, userResult.getUserEmail());
            preparedStatement.setObject(2, userResult.getCreateTime());
            preparedStatement.setInt(3, userResult.getResultId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("something wrong during work in method create UserResult");
        }
    }

}

package manager;


import conf.DBConnectionProvider;
import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserManagerImpl implements UserManager {

    private final Connection connection = DBConnectionProvider.getInstance().getConnection();

    @Override
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        try {
            String query = "SELECT * FROM user";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                users.add(user);
            }
        } catch (SQLException e) {
            System.out.println("something wrong during work");
        }
        return users;
    }

    @Override
    public User getUserById(int id) {
        User user = new User();
        try {
            String query = "SELECT * FROM users WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                user.setId(resultSet.getInt("id"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                return user;
            }

        } catch (SQLException e) {
            System.out.println("something wrong during work in method getById");
        }

        return null;
    }

    @Override
    public void createUser(User user) {
        try {
            String query = "INSERT INTO user(email, password) VALUES (?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, user.getEmail());
            preparedStatement.setString(2, user.getPassword());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("something wrong during work in method create");
        }
    }

    @Override
    public void updateUser(User user) {
        try {
            String query = "UPDATE users Set email = ?, password = ? WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, user.getEmail());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setInt(3, user.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("something wrong during work in method create");
        }
    }

    @Override
    public void deleteUser(int id) {
        try {
            String query = "DELETE FROM user WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("something wrong during work in method delete");
        }
    }

    @Override
    public User getByEmailAndPassword(String email, String password) {

        User user = new User();
        try {
            String query = "SELECT * FROM users WHERE email = ? and password = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                user.setId(resultSet.getInt("id"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
//                user.setPollId(resultSet.getInt("pollId"));
//                user.setQuestionId(resultSet.getInt("questionId"));
//                user.setAnswerId(resultSet.getInt("answerId"));
//                user.setResultId(resultSet.getInt("resultId"));

                return user;
            }

        } catch (SQLException e) {
            System.out.println("something wrong during work in method getByEmailAndPassword");
        }

        return null;
    }
}

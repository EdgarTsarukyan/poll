package manager;

import conf.DBConnectionProvider;
import model.Poll;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PollManagerImpl implements Manager<Poll, Integer> {

    public final Connection connection = DBConnectionProvider.getInstance().getConnection();

    @Override
    public List findAll() {

        List<Poll> polls = new ArrayList<>();
        try {
            String query = "SELECT * FROM polls";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Poll poll = new Poll();
                poll.setId(resultSet.getInt("id"));
                poll.setName(resultSet.getString("name"));
                poll.setDescription(resultSet.getString("description"));
                polls.add(poll);
            }
        } catch (SQLException e) {
            System.out.println("something wrong during work method find all");
        }
        return polls;

    }

    @Override
    public Poll findById(Integer id) {
        Poll poll = new Poll();
        try {
            String query = "SELECT * FROM polls WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                poll.setId(resultSet.getInt("id"));
                poll.setName(resultSet.getString("name"));
                poll.setDescription(resultSet.getString("description"));
                return poll;
            }

        } catch (SQLException e) {
            System.out.println("something wrong during work in method findById");
        }

        return null;
    }

}

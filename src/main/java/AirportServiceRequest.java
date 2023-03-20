import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class AirportServiceRequest implements ServiceRequest {
    @Override
    public void summarizeTotalPassengerToService() {

        try (Connection connection = DriverManager.getConnection(JDBCConstants.URL, JDBCConstants.USER,
                JDBCConstants.PASSWORD)) {
            try (Statement statement = connection.createStatement()) {
                try (ResultSet resultSet = statement.executeQuery(JDBCQueries.NUMBER_OF_SEATS)) {
                    {
                        {
                            int seats = 0;
                            while (resultSet.next()) {
                                seats += resultSet.getInt("seats");

                            }
                            System.out.println("Quantity of all passengers airport can service " + seats);
                        }
                    }
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void createTable() {
        try (Connection connection = DriverManager.getConnection(JDBCConstants.URL, JDBCConstants.USER,
                JDBCConstants.PASSWORD)) {
            try (Statement statement = connection.createStatement();) {
                statement.execute(JDBCQueries.CREATE_TABLE);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void insertPassengers() {
        try (Connection connection = DriverManager.getConnection(JDBCConstants.URL, JDBCConstants.USER,
                JDBCConstants.PASSWORD)) {
            try (Statement statement = connection.createStatement();) {
                statement.execute(JDBCQueries.INSERT_PASSENGER);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void readAllPassengers() {
        try (Connection connection = DriverManager.getConnection(JDBCConstants.URL, JDBCConstants.USER,
                JDBCConstants.PASSWORD)) {
            try (Statement statement = connection.createStatement();) {
                try (ResultSet resultSet = statement.executeQuery(JDBCQueries.READ_ALL_PASSENGERS);) {
                    ArrayList<Passenger> passengers = new ArrayList<>();
                    while (resultSet.next()) {
                        Passenger passenger = new Passenger();
                        passenger.setId(resultSet.getInt("id"));
                        passenger.setFirstName(resultSet.getString("first_name"));
                        passenger.setLastName(resultSet.getString("last_name"));
                        passenger.setAge(resultSet.getInt("age"));
                        passengers.add(passenger);
                    }
                    passengers.forEach(System.out::println);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void updatePassengerAge() {
        try (Connection connection = DriverManager.getConnection(JDBCConstants.URL, JDBCConstants.USER,
                JDBCConstants.PASSWORD)) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(JDBCQueries.UPDATE_PASSENGER_AGE);) {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Please enter passenger id");
                int id = scanner.nextInt();
                System.out.println("Please enter passenger`s new age");
                int age = scanner.nextInt();
                preparedStatement.setInt(1, age);
                preparedStatement.setInt(2, id);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deletePassenger() {
        try (Connection connection = DriverManager.getConnection(JDBCConstants.URL, JDBCConstants.USER,
                JDBCConstants.PASSWORD)) {
            try (Statement statement = connection.createStatement();) {
                statement.execute(JDBCQueries.DELETE_PASSENGER);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

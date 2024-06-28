package org.example;

import java.sql.*;

public class MySqlExemple {

    // JDBC URL, username, and password of MySQL server
        // par convention une variable d'instance constante est en majuscule
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/cinema";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "";

    public static void main(String[] args) {
        Connection connection = null;
        try {
            // Register MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection to MySQL database
            connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);

            if (connection != null) {
                System.out.println("Connected to the database coin coin!");

                //statement pas très sécurisé mieux de créer une requete préparée ou preparedStatement
                Statement statement = connection.createStatement();

                // execution requette SQL
                String sqlQuery = "Select * FROM actor";
                ResultSet resultSet = statement.executeQuery(sqlQuery);

                //process the result set
                while (resultSet.next()){
                    //retrieve data from the result set
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("lastname");
                    String fname = resultSet.getString("firstname");
//                    String photo = resultSet.getString("photo");
                    //print data
                   System.out.println("ID: " + id + ", Name: " + fname + " " + name + " " );
//                 System.out.println("ID: " + id + ", Name: " + fname + " " + name + " " + photo);

                    resultSet.close();
                }

            } else {
                System.out.println("failed to make connection");
            }
        } catch (ClassNotFoundException | SQLException e){
            System.out.println("MySQL JDBC driver not found");
        }
    }
}

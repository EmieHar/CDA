package org.example;

import java.sql.*;

public class MySqlExemple2 {


        // JDBC URL, username, and password of MySQL server
        // par convention une variable d'instance constante est en majuscule
        private static final String JDBC_URL = "jdbc:mysql://localhost:3306/cinema";
        private static final String JDBC_USER = "root";
        private static final String JDBC_PASSWORD = "";

        public static void main(String[] args) {
            Connection connection = null;
            PreparedStatement preparedStatement = null;

            try {
                // Register MySQL JDBC driver
                Class.forName("com.mysql.cj.jdbc.Driver");

                // Establish connection to MySQL database
                connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);

                if (connection != null) {
                    System.out.println("Connected to the database coin coin!");


                    // execution requette SQL
                    String sqlInsert = "INSERT INTO actor (firstname, lastname) VALUES(?,?)";
                    preparedStatement = connection.prepareStatement(sqlInsert);
                    //donne type attendu --> protection contre injection sql
                    preparedStatement.setString(1,"The Kid");
                    preparedStatement.setString(2,"Billy");
                    preparedStatement.executeUpdate();


                    preparedStatement.close();

                } else {
                    System.out.println("failed to make connection");
                }
            } catch (ClassNotFoundException e){
                System.out.println("MySQL JDBC driver not found");
            } catch (SQLException e){
                System.out.println( "connection failed");
            } finally {
                try{
                    if(connection != null){
                        connection.close();
                        System.out.println("connection closed");
                    }
                } catch (SQLException e){
                    System.out.println( "erreur");
                }

            }
        }
    }



package br.com.academia.util.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

    public static Connection getConnectionMysql() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        String url = "jdbc:mysql://localhost:3306/academia";
        String login = "root";
        String senha = "123";

        //Credenciais para uso no Viannajr:
        //String login = "aluno";
        //String senha = "aluno";


        return DriverManager.getConnection(url,login,senha);
    }

}

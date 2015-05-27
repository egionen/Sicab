package dao;

import Conexao.ConnectionFactory;
import controle.Logins;
import java.sql.*;
import java.sql.PreparedStatement;

public class LoginsDAO {

    PreparedStatement pst;
    ResultSet rs;
    private Connection connection;
    String usuario;
    String senha;

    public LoginsDAO() {

            this.connection = new ConnectionFactory().getConnection();
    }

    public void adicionarUsuarios(Logins logins) throws SQLException {
        String sql = "INSERT INTO Logins (usuario,senha) VALUES (?,?) ";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, logins.getUsuario());
            stmt.setString(2, logins.getSenha());
            stmt.execute();
            stmt.close();

        } catch (SQLException u) {
            throw new RuntimeException(u);
        } finally {
            connection.close();

        }

    }

}

package dao;

import Conexao.ConnectionFactory;
import controle.Usuarios;
import java.sql.*;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UsuarioDAO {

    PreparedStatement pst;
    ResultSet rs;
    private Connection connection;
    short matricula;
    String nome;
    String cpf;
    String plano;
    String telefone1;
    String telefone2;
    String endereco;

    public UsuarioDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void adicionarClientes(Usuarios usuario) throws SQLException {
        String sql = "INSERT INTO Usuarios(nome,cpf,plano,telefone1,telefone2,endereço) VALUES(?,?,?,?,?,?)";
        try {

            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getCpf());
            stmt.setString(3, usuario.getPlano());
            stmt.setString(4, usuario.getTelefone1());
            stmt.setString(5, usuario.getTelefone2());
            stmt.setString(6, usuario.getEndereço());
            stmt.execute();
            stmt.close();

        } catch (SQLException u) {
            throw new RuntimeException(u);
        } finally {
            connection.close();

        }
    }

}

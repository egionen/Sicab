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
    
  

    /* public boolean excluirClientes(Usuarios usuario) {
        String sql = "DELETE from Usuarios where telefone1=?";
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement(sql);

            stmt.setString(4, usuario.getTelefone1());

            stmt.execute();
            return true;
        } catch (SQLException u) {
            throw new RuntimeException(u);

        } finally {
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void alterarClientes(Usuarios usuario) throws SQLException {
        String sql = "UPDATE Usuarios SET nome=? where matricula=?";
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, usuario.getNome());
            stmt.setInt(matricula, usuario.getMatricula());

            stmt.execute();
        } catch (SQLException u) {
            throw new RuntimeException(u);

        } finally {
            connection.close();
        }
    }
    

      /*public static void pesquisaClientes(String text) throws ClassNotFoundException {
        String busca = null;
        String sql = "SELECT * from usuarios where telefone1 like "+busca+" order by nome";
        
         
           try {
            
            Class.forName("com.mysql.jdbc.Driver");

            Connection conn = DriverManager.getConnection("jdbc:mysql://db4free.net:3306/sica?zeroDateTimeBehavior=convertToNull", "sica", "1122448816");
 
           }catch (SQLException u) {
            throw new RuntimeException(u);
           }   */
               public void pesquisarClientes(Usuarios usuario){  
              String sql = "SELECT * from Usuarios where telefone1 = ?";  
            try {  
                  try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                      stmt.setString(4, usuario.getTelefone1());
                      ResultSet rs = stmt.executeQuery();
                      if(rs.next()){
                          usuario.setTelefone1(rs.getString("Telefone"));
                      } }  
            } catch (SQLException e) {  
                throw new RuntimeException("Erro no sql: " + e.getMessage());  
            }  
        }  
    
    }


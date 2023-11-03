  //Criando classe aluno

public class Aluno {
    private String nome;
    private int idade;
    private String endereco;
  
}

--------------------------------------------------------------------------------------
   //Cadastro de Aluno
  
import java.sql.*;

public class AlunoDAO {
    private Connection conexao;

    public AlunoDAO() {
        this.conexao = ConnectionFactory.getConnection();
    }

    public void salvarAluno(Aluno aluno) {
        String sql = "INSERT INTO alunos (nome, idade, endereco) VALUES (?, ?, ?)";
        try (PreparedStatement statement = conexao.prepareStatement(sql)) {
            statement.setString(1, aluno.getNome());
            statement.setInt(2, aluno.getIdade());
            statement.setString(3, aluno.getEndereco());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

  
--------------------------------------------------------------------------------------
  //Classe ConnectionFactory para Conexão com o Banco de Dados

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AlunoDAO {
    private Connection conexao;

    public AlunoDAO() {
        this.conexao = ConnectionFactory.getConnection();
    }

    public void salvarAluno(Aluno aluno) {
        String sql = "INSERT INTO alunos (nome, idade, endereco) VALUES (?, ?, ?)";
        try (PreparedStatement statement = conexao.prepareStatement(sql)) {
            statement.setString(1, aluno.getNome());
            statement.setInt(2, aluno.getIdade());
            statement.setString(3, aluno.getEndereco());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

--------------------------------------------------------------------------------------
  //Objeto-Relacional (ORM) usando JDBC

import java.sql.ResultSet;
import java.sql.SQLException;

public class AlunoMapper {
    public Aluno mapFromResultSet(ResultSet rs) throws SQLException {
        Aluno aluno = new Aluno();
        aluno.setNome(rs.getString("nome"));
        aluno.setIdade(rs.getInt("idade"));
        aluno.setEndereco(rs.getString("endereco"));
        return aluno;
    }

    public PreparedStatement mapToPreparedStatement(Aluno aluno, PreparedStatement statement) throws SQLException {
        statement.setString(1, aluno.getNome());
        statement.setInt(2, aluno.getIdade());
        statement.setString(3, aluno.getEndereco());
        return statement;
    }
}

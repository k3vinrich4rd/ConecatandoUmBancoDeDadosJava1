package conexao;

import java.sql.Connection;
//Representa a conex�o com o banco de dados e proporciona informa��es sobre as tabelas do banco
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
// Respons�vel pelo gerenciamento de Drivers e estabelece conex�es ao banco de dados

public class ConnectionFactory {
    //Informa��es referentes a conex�o ao banco de dados:
    String url = "jdbc:postgresql://localhost:5432/money";
    String user = "postgres";
    String senha = "123456";
    public static Connection connect;


    /*
    1.�Parte:
    //Cria��o do m�todo para iniciar e estabelecer conex�es com o banco de dados
     */
    public Connection getConnect() {
        try {
            Class.forName("org.postgresql.Driver");
            connect = DriverManager.getConnection(url, user, senha);
            if (connect != null) {
                System.out.println("Conectado");
            } else {
                System.out.println("N�o conectado");
            }
        } catch (Exception e) {
            System.out.println("Erro de conex�o " + e);
            e.printStackTrace();
        }
        return connect;
    }

    /*
    2.� Parte:
    Cria��o do m�todo, para acrescentar valores na tabela do banco de dados escolhido
     */
    public int adicionar(String sql) {
        try {
            Statement stmt = connect.createStatement();
            int resposta = stmt.executeUpdate(sql);
            connect.close();
            return resposta;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /*
    3.� Parte:
    Cria��o do m�todo, para fazer uma busca na sua tabela e retornas os valores j� adicionados
     */
    public ResultSet buscaEstado(String sqlBuscaEstado){
        try {
            Statement stmt = connect.createStatement();
            ResultSet retorno = stmt.executeQuery(sqlBuscaEstado);
            return retorno;

        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }


}

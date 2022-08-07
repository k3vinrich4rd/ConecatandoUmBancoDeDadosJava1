package conexao;

import java.sql.Connection;
//Representa a conexão com o banco de dados e proporciona informações sobre as tabelas do banco
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
// Responsável pelo gerenciamento de Drivers e estabelece conexões ao banco de dados

public class ConnectionFactory {
    //Informações referentes a conexão ao banco de dados:
    String url = "jdbc:postgresql://localhost:5432/money";
    String user = "postgres";
    String senha = "123456";
    public static Connection connect;


    /*
    1.ºParte:
    //Criação do método para iniciar e estabelecer conexões com o banco de dados
     */
    public Connection getConnect() {
        try {
            Class.forName("org.postgresql.Driver");
            connect = DriverManager.getConnection(url, user, senha);
            if (connect != null) {
                System.out.println("Conectado");
            } else {
                System.out.println("Não conectado");
            }
        } catch (Exception e) {
            System.out.println("Erro de conexão " + e);
            e.printStackTrace();
        }
        return connect;
    }

    /*
    2.º Parte:
    Criação do método, para acrescentar valores na tabela do banco de dados escolhido
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
    3.º Parte:
    Criação do método, para fazer uma busca na sua tabela e retornas os valores já adicionados
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

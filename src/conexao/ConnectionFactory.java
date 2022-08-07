package conexao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
    //Informações referentes a conexão ao banco de dados:

    String url = "jdbc:postgresql://localhost:5432/money";
    String user = "postgres";
    String senha = "123456";
    public static Connection connect;

    //Representa a conexão com o banco de dados e proporciona informações sobre as tabelas do banco
    public Connection getConnect(){
        try {
            Class.forName("org.postgresql.Driver");
            connect = DriverManager.getConnection(url,user,senha);
            if (connect != null){
                System.out.println("Conectado");
            }else {
                System.out.println("Não conectado");
            }
        }catch (Exception e) {
            System.out.println("Erro de conexão " + e);
            e.printStackTrace();
        }
        return connect;
    }

}

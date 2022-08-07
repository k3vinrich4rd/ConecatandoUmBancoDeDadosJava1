package conexao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
    //Informa��es referentes a conex�o ao banco de dados:

    String url = "jdbc:postgresql://localhost:5432/money";
    String user = "postgres";
    String senha = "123456";
    public static Connection connect;

    //Representa a conex�o com o banco de dados e proporciona informa��es sobre as tabelas do banco
    public Connection getConnect(){
        try {
            Class.forName("org.postgresql.Driver");
            connect = DriverManager.getConnection(url,user,senha);
            if (connect != null){
                System.out.println("Conectado");
            }else {
                System.out.println("N�o conectado");
            }
        }catch (Exception e) {
            System.out.println("Erro de conex�o " + e);
            e.printStackTrace();
        }
        return connect;
    }

}

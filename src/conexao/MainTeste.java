package conexao;

import java.sql.ResultSet;

public class MainTeste {
    public static void main(String[] args) {
        /*
        Primeira parte:
        Verificação se a conexão com o banco está estável
         se estiver, ao rodar a Main, deve se retornar "Conectado" */
        ConnectionFactory con = new ConnectionFactory();
        con.getConnect();

        //Terceira parte -----------------------------------
        String sqlbuscarEstado = "Select * from estados";
        ResultSet retorno = con.buscaEstado(sqlbuscarEstado);
        //Terceira parte -----------------------------------

        /*
        Segunda parte:
        Adicionar valores a alguma tabela especifica presente no banco
         */
        String sql = "INSERT INTO estados(id_estado, nome_estado, sigla_estado) " +
                "values(default, 'Pernambuco', 'PE')";
        int adicionarEstadoConnnect = con.adicionar(sql);
        if(adicionarEstadoConnnect > 0){
            System.out.println("Adição de valores realizada");
        }else {
            System.out.println("Adição não realizada\n ");
        }


        /*
        Terceira parte:
        Exibir valores existentes na coluna da tabela e adicionados
         */
        try {
            while (retorno.next()){
                int id_estado = retorno.getInt("id_estado");
                String nomeEstado = retorno.getString("nome_estado");
                String siglaEstado = retorno.getString("sigla_estado");
                System.out.println(id_estado + " - " + nomeEstado + " - " + siglaEstado);
            }
        }catch (Exception e){
            e.printStackTrace();
        }


    }
}

package conexão;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConnectFactory {
    String url = "jdbc:postgresql://localhost:5432/teste";
    String user = "postgres";
    String senha = "123456";
    String driver = "org.postgresql.Driver";

    public static Connection connection;


    public Connection getConnect(){
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url,user,senha);
            if (connection != null){
                System.out.println("Você está conectado ao banco de dados");
            }else {
                System.out.println("Erro: falha na conexão");
            }
        }catch (Exception e){
            System.out.println("Erro de conexão " + e);
            e.printStackTrace();

        }
        return connection;
    }

    public int adicionarInformacoes (String sql){
        try {
            Statement stmt = connection.createStatement();
            int reposta = stmt.executeUpdate(sql);
            connection.close();
            return reposta;

        }catch (Exception e){
            e.printStackTrace();

        }
        return 0;
    }

    public ResultSet buscarInformacoes(String sqlBuscarInformacoes){
        try {
            Statement stmt = connection.createStatement();
            ResultSet retorno = stmt.executeQuery(sqlBuscarInformacoes);
            return retorno;

        }catch (Exception e ){
            e.printStackTrace();
            return null;
        }
    }
}

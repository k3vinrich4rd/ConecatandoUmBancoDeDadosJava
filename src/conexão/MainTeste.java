package conexão;

import java.sql.ResultSet;

public class MainTeste {
    public static void main(String[] args) {


        ConnectFactory conexao = new ConnectFactory();
        conexao.getConnect();


        String sqlbuscarInformacoes = "Select * from pessoas";
        ResultSet retorno = conexao.buscarInformacoes(sqlbuscarInformacoes);

        String sql = "INSERT INTO pessoas(id_pessoa, nome_pessoa, idade_pessoa, email_pessoa)" +
                "values(default, 'Jhonatan Tavares', '30 anos', 'jhonatantavares@gmail.com')";
        int adicionarInformacoes = conexao.adicionarInformacoes(sql);
        if (adicionarInformacoes > 0) {
            System.out.println("Ação bem sucedida, informação adicionada");
        } else {
            System.out.println("Erro, informação não inserida");
        }


        try {
            while (retorno.next()) {
                int id_pessoa = retorno.getInt("id_pessoa");
                String nomePessoa = retorno.getString("nome_pessoa");
                String pessoaIdade = retorno.getString("idade_pessoa");
                String pessoaEmail = retorno.getString("email_pessoa");
                System.out.println(id_pessoa + " - " + nomePessoa + " - " + pessoaIdade + " - " + pessoaEmail);
            }
        } catch (Exception e) {
            e.printStackTrace();

        }


    }
}

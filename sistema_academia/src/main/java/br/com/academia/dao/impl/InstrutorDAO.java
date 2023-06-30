package br.com.academia.dao.impl;

import br.com.academia.dao.IGenericDAO;
import br.com.academia.model.pessoas.Instrutor;
import br.com.academia.model.sistema.Academia;
import br.com.academia.util.connection.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class InstrutorDAO implements IGenericDAO<Instrutor, Integer> {
    @Override
    public void inserir(Instrutor obj) throws SQLException, ClassNotFoundException {
        Connection c = ConnectionManager.getConnectionMysql();

        try{
            String sql = "INSERT INTO academia.instrutor\n" +
                    "(id_academia, nome, login, senha, salario)\n" +
                    "VALUES(?, ?, ?, ?, ?);\n";

            PreparedStatement pst = c.prepareStatement(sql);

            pst.setInt(1, obj.getAcademia().getId());
            pst.setString(2, obj.getNome());
            pst.setString(3, obj.getLogin());
            pst.setString(4, obj.getSenha());
            pst.setDouble(5, obj.getSalario());

            pst.execute();
        } finally {
            c.close();
        }
    }

    @Override
    public void alterar(Instrutor obj) throws SQLException, ClassNotFoundException {
        Connection c = ConnectionManager.getConnectionMysql();

        try{
            String sql = "UPDATE academia.instrutor\n" +
                    "SET nome=?, login=?, senha=?, salario=?\n" +
                    "WHERE id=?;\n";

            PreparedStatement pst = c.prepareStatement(sql);

            pst.setString(1, obj.getNome());
            pst.setString(2, obj.getLogin());
            pst.setString(3, obj.getSenha());
            pst.setDouble(4,obj.getSalario());
            pst.setInt(5, obj.getId());

            pst.execute();
        } finally {
            c.close();
        }
    }

    public void alterarSenha(Integer key, String novaSenha) throws SQLException, ClassNotFoundException {
        Connection c = ConnectionManager.getConnectionMysql();

        try{
            String sql = "UPDATE academia.instrutor\n" +
                    "SET senha=?\n" +
                    "WHERE id=?;\n";

            PreparedStatement pst = c.prepareStatement(sql);

            pst.setString(1,novaSenha);
            pst.setInt(2,key);

            pst.execute();
        } finally {
            c.close();
        }
    }

    @Override
    public void apagar(Instrutor obj) throws SQLException, ClassNotFoundException {
        Connection c = ConnectionManager.getConnectionMysql();

        try{
            String sql = "DELETE FROM academia.instrutor\n" +
                    "WHERE id=?;\n";

            PreparedStatement pst = c.prepareStatement(sql);

            pst.setInt(1, obj.getId());

            pst.execute();
        } finally {
            c.close();
        }
    }

    @Override
    public Instrutor buscar(Integer key) throws SQLException, ClassNotFoundException {

        Connection c = ConnectionManager.getConnectionMysql();

        try {
            String sql = "select i.*, ac.*\n" +
                    "from instrutor i\n" +
                    "inner join academia ac on ac.id = i.id_academia \n" +
                    "where i.id=?;";

            PreparedStatement pst = c.prepareStatement(sql);

            pst.setInt(1, key);

            ResultSet resultado = pst.executeQuery();

            Instrutor i = null;

            if(resultado.next()){
                i = getInstrutorPreenchido(resultado);
            }

            return i;
        } finally {
            c.close();
        }
    }

    private static Instrutor getInstrutorPreenchido(ResultSet resultado) throws SQLException, ClassNotFoundException {
        Academia acad = new Academia(resultado.getInt(7),
                resultado.getString(8),
                resultado.getString(9));

        Instrutor i = new Instrutor(resultado.getInt(1),
                acad,
                resultado.getString(3),
                resultado.getString(4),
                resultado.getString(5),
                resultado.getDouble(6));

        i.setAlunos(new AlunoDAO().buscarTodosAlunosPorInstrutor(resultado.getInt(1)));

        return i;
    }

    @Override
    public ArrayList<Instrutor> buscarTodos() throws SQLException, ClassNotFoundException {
        Connection c = ConnectionManager.getConnectionMysql();

        try {
            String sql = "select i.*, ac.*\n" +
                    "from instrutor i \n" +
                    "inner join academia ac on ac.id = i.id_academia;";


            PreparedStatement pst = c.prepareStatement(sql);

            ResultSet resultado = pst.executeQuery();

            ArrayList<Instrutor> lista = new ArrayList<Instrutor>();

            while(resultado.next()){
                lista.add(getInstrutorPreenchido(resultado));
            }
            return lista;

        } finally {
            c.close();
        }
    }

    public ArrayList<Instrutor> buscarTodosInstrutoresPorAcademia(Integer key) throws SQLException, ClassNotFoundException {
        Connection c = ConnectionManager.getConnectionMysql();

        try {
            String sql = "select i.*, ac.*\n" +
                    "from instrutor i \n" +
                    "inner join academia ac on ac.id = i.id_academia\n" +
                    "where ac.id=?;";


            PreparedStatement pst = c.prepareStatement(sql);

            pst.setInt(1, key);

            ResultSet resultado = pst.executeQuery();

            ArrayList<Instrutor> lista = new ArrayList<Instrutor>();

            while(resultado.next()){
                lista.add(getInstrutorPreenchido(resultado));
            }
            return lista;

        } finally {
            c.close();
        }
    }

    @Override
    public int quantidade() throws SQLException, ClassNotFoundException {
        Connection c = ConnectionManager.getConnectionMysql();

        try {
            String sql = "SELECT count(*) FROM academia.instrutor;";

            PreparedStatement pst = c.prepareStatement(sql);

            ResultSet resultado = pst.executeQuery();

            resultado.next();

            return resultado.getInt(1);
        } finally {
            c.close();
        }
    }

    public Instrutor buscarPorLoginSenha(String login, String senha) throws SQLException, ClassNotFoundException {

        Connection c = ConnectionManager.getConnectionMysql();

        try {
            String sql = "select i.*, ac.*\n" +
                    "from instrutor i\n" +
                    "inner join academia ac on ac.id = i.id_academia \n" +
                    "where i.login=? and i.senha=?;";

            PreparedStatement pst = c.prepareStatement(sql);

            pst.setString(1, login);
            pst.setString(2, senha);

            ResultSet resultado = pst.executeQuery();

            Instrutor i = null;

            if(resultado.next()){
                i = getInstrutorPreenchido(resultado);
            }

            return i;
        } finally {
            c.close();
        }
    }

    public ArrayList<Instrutor> buscarPesquisaPersonalizada(String nome, String login) throws SQLException, ClassNotFoundException {
        Connection c = ConnectionManager.getConnectionMysql();

        try {
            String sql = "select i.*, ac.*\n" +
                    "from instrutor i \n" +
                    "inner join academia ac on ac.id = i.id_academia\n"+
                    "where i.nome like ? and i.login like ?";


            PreparedStatement pst = c.prepareStatement(sql);

            pst.setString(1, "%"+nome+"%");
            pst.setString(2, "%"+login+"%");

            ResultSet resultado = pst.executeQuery();

            ArrayList<Instrutor> lista = new ArrayList<Instrutor>();

            while(resultado.next()){
                lista.add(getInstrutorPreenchido(resultado));
            }
            return lista;

        } finally {
            c.close();
        }
    }
}

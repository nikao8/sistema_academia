package br.com.academia.dao.impl;

import br.com.academia.dao.IGenericDAO;
import br.com.academia.model.fichas.Ficha;
import br.com.academia.model.pessoas.Aluno;
import br.com.academia.model.pessoas.Instrutor;
import br.com.academia.model.sistema.Academia;
import br.com.academia.util.connection.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AlunoDAO implements IGenericDAO<Aluno, Integer> {

    @Override
    public void inserir(Aluno obj) throws SQLException, ClassNotFoundException {
        Connection c = ConnectionManager.getConnectionMysql();

        try{
            String sql = "INSERT INTO academia.aluno\n" +
                    "(id_academia ,nome, login, senha, id_instrutor)\n" +
                    "VALUES(?, ?, ?, ?, ?);\n";

            PreparedStatement pst = c.prepareStatement(sql);

            pst.setInt(1, obj.getAcademia().getId());
            pst.setString(2, obj.getNome());
            pst.setString(3, obj.getLogin());
            pst.setString(4, obj.getSenha());
            pst.setInt(5, obj.getInstrutor().getId());

            pst.execute();
        } finally {
            c.close();
        }
    }

    @Override
    public void alterar(Aluno obj) throws SQLException, ClassNotFoundException {
        Connection c = ConnectionManager.getConnectionMysql();

        try{
            String sql = "UPDATE academia.aluno\n" +
                    "SET nome=?, login=?, senha=?\n" +
                    "WHERE id=?;\n";

            PreparedStatement pst = c.prepareStatement(sql);

            pst.setString(1, obj.getNome());
            pst.setString(2, obj.getLogin());
            pst.setString(3, obj.getSenha());
            pst.setInt(4, obj.getId());

            pst.execute();
        } finally {
            c.close();
        }
    }

    public void alterarSenha(Integer key, String novaSenha) throws SQLException, ClassNotFoundException {
        Connection c = ConnectionManager.getConnectionMysql();

        try{
            String sql = "UPDATE academia.aluno\n" +
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
    public void apagar(Aluno obj) throws SQLException, ClassNotFoundException {
        Connection c = ConnectionManager.getConnectionMysql();

        try{
            String sql = "DELETE FROM academia.aluno\n" +
                    "WHERE id=?;\n";

            PreparedStatement pst = c.prepareStatement(sql);

            pst.setInt(1, obj.getId());

            new MatriculaDAO().apagarPorAluno(obj.getId());

            ArrayList<Ficha> fs = new FichaDAO().buscarFichasAluno(obj.getId());
            for(Ficha f : fs){
                new FichaDAO().apagar(f);
            }

            pst.execute();
        } finally {
            c.close();
        }
    }

    @Override
    public Aluno buscar(Integer key) throws SQLException, ClassNotFoundException {

        Connection c = ConnectionManager.getConnectionMysql();

        try {
            String sql = "select a.*, ac.*, i.*\n" +
                    "from aluno a\n" +
                    "inner join academia ac on ac.id = a.id_academia\n" +
                    "inner join instrutor i on i.id = a.id_instrutor \n" +
                    "where a.id = ?;";

            PreparedStatement pst = c.prepareStatement(sql);

            pst.setInt(1, key);

            ResultSet resultado = pst.executeQuery();

            Aluno al = null;

            if(resultado.next()){
                al = getAlunoPreenchido(resultado);
            }

            return al;
        } finally {
            c.close();
        }
    }

    @Override
    public ArrayList<Aluno> buscarTodos() throws SQLException, ClassNotFoundException {
        Connection c = ConnectionManager.getConnectionMysql();

        try {
            String sql = "select a.*, ac.*, i.*\n" +
                    "from aluno a\n" +
                    "inner join academia ac on ac.id = a.id_academia\n" +
                    "inner join instrutor i on i.id = a.id_instrutor;";


            PreparedStatement pst = c.prepareStatement(sql);

            ResultSet resultado = pst.executeQuery();

            ArrayList<Aluno> lista = new ArrayList<Aluno>();

            while(resultado.next()){
                lista.add(getAlunoPreenchido(resultado));
            }
            return lista;

        } finally {
            c.close();
        }
    }

    public ArrayList<Aluno> buscarTodosAlunosPorAcademia(Integer key) throws SQLException, ClassNotFoundException {
        Connection c = ConnectionManager.getConnectionMysql();

        try {
            String sql = "select a.*, ac.*, i.*\n" +
                    "from aluno a\n" +
                    "inner join academia ac on ac.id = a.id_academia\n" +
                    "inner join instrutor i on i.id = a.id_instrutor\n" +
                    "where ac.id=?;";


            PreparedStatement pst = c.prepareStatement(sql);

            pst.setInt(1, key);

            ResultSet resultado = pst.executeQuery();

            ArrayList<Aluno> lista = new ArrayList<Aluno>();

            while(resultado.next()){
                lista.add(getAlunoPreenchido(resultado));
            }
            return lista;

        } finally {
            c.close();
        }
    }

    public ArrayList<Aluno> buscarTodosAlunosPorInstrutor(Integer key) throws SQLException, ClassNotFoundException {
        Connection c = ConnectionManager.getConnectionMysql();

        try {
            String sql = "select a.*, ac.*, i.*\n" +
                    "from aluno a\n" +
                    "inner join academia ac on ac.id = a.id_academia\n" +
                    "inner join instrutor i on i.id = a.id_instrutor\n" +
                    "where a.id_instrutor=?;";


            PreparedStatement pst = c.prepareStatement(sql);

            pst.setInt(1, key);

            ResultSet resultado = pst.executeQuery();

            ArrayList<Aluno> lista = new ArrayList<Aluno>();

            while(resultado.next()){
                lista.add(getAlunoPreenchido(resultado));
            }
            return lista;

        } finally {
            c.close();
        }
    }

    public ArrayList<Aluno> buscarPesquisaPersonalizada(String nome, String login) throws SQLException, ClassNotFoundException {
        Connection c = ConnectionManager.getConnectionMysql();

        try {
            String sql = "select a.*, ac.*, i.*\n" +
                    "from aluno a\n" +
                    "inner join academia ac on ac.id = a.id_academia\n" +
                    "inner join instrutor i on i.id = a.id_instrutor\n" +
                    "where a.nome like ? and a.login like ?";


            PreparedStatement pst = c.prepareStatement(sql);

            pst.setString(1, "%"+nome+"%");
            pst.setString(2, "%"+login+"%");

            ResultSet resultado = pst.executeQuery();

            ArrayList<Aluno> lista = new ArrayList<Aluno>();

            while(resultado.next()){
                lista.add(getAlunoPreenchido(resultado));
            }
            return lista;

        } finally {
            c.close();
        }
    }


    private static Aluno getAlunoPreenchido(ResultSet resultado) throws SQLException, ClassNotFoundException {
        Academia acad =  new Academia(resultado.getInt(7),resultado.getString(8), resultado.getString(9));

        Aluno al = new Aluno(resultado.getInt(1),
                acad,
                resultado.getString(3),
                resultado.getString(4),
                resultado.getString(5),
                new Instrutor(resultado.getInt(10),
                        acad,
                        resultado.getString(12),
                        resultado.getString(13),
                        resultado.getString(14),
                        resultado.getDouble(15)
                )
        );

        //al.setMatricula(new MatriculaDAO().buscarMatriculaAluno(resultado.getInt(1)));
        //al.setFichas(new FichaDAO().buscarFichasAluno(resultado.getInt(1)));

        return al;
    }

    @Override
    public int quantidade() throws SQLException, ClassNotFoundException {
        Connection c = ConnectionManager.getConnectionMysql();

        try {
            String sql = "SELECT count(*) FROM academia.aluno;";

            PreparedStatement pst = c.prepareStatement(sql);

            ResultSet resultado = pst.executeQuery();

            resultado.next();

            return resultado.getInt(1);
        } finally {
            c.close();
        }
    }


    public Aluno buscarPorLoginSenha(String login, String senha) throws SQLException, ClassNotFoundException {

        Connection c = ConnectionManager.getConnectionMysql();

        try {
            String sql = "select a.*, ac.*, i.*\n" +
                    "from aluno a\n" +
                    "inner join academia ac on ac.id = a.id_academia\n" +
                    "inner join instrutor i on i.id = a.id_instrutor \n" +
                    "where a.login=? and a.senha=?;";

            PreparedStatement pst = c.prepareStatement(sql);

            pst.setString(1, login);
            pst.setString(2, senha);

            ResultSet resultado = pst.executeQuery();

            Aluno al = null;

            if(resultado.next()){
                al = getAlunoPreenchido(resultado);
            }

            return al;
        } finally {
            c.close();
        }
    }
}

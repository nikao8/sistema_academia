package br.com.academia.dao.impl;

import br.com.academia.dao.IGenericDAO;
import br.com.academia.model.e.ETipoFicha;
import br.com.academia.model.fichas.Exercicio;
import br.com.academia.model.fichas.Ficha;
import br.com.academia.util.connection.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FichaDAO implements IGenericDAO<Ficha, Integer> {
    @Override
    public void inserir(Ficha obj) throws SQLException, ClassNotFoundException {
        Connection c = ConnectionManager.getConnectionMysql();

        try {
            String sql = "INSERT INTO academia.ficha\n" +
                    "(id_aluno, id_instrutor, tipo_ficha, data_criacao)\n" +
                    "VALUES(?, ?, ?, ?);\n";

            PreparedStatement pst = c.prepareStatement(sql);

            pst.setInt(1, obj.getAluno().getId());
            pst.setInt(2, obj.getInstrutor().getId());
            pst.setString(3, obj.getTipoFicha().toString());
            pst.setDate(4, new java.sql.Date(obj.getDataCriacao().getTime()));

            pst.execute();
        } finally {
            c.close();
        }
    }

    @Override
    public void alterar(Ficha obj) throws SQLException, ClassNotFoundException {
        Connection c = ConnectionManager.getConnectionMysql();

        try {
            String sql = "UPDATE academia.ficha\n" +
                    "SET tipo_ficha=?, id_aluno=?\n" +
                    "WHERE id=?;\n";

            PreparedStatement pst = c.prepareStatement(sql);

            pst.setString(1, obj.getTipoFicha().toString());
            pst.setInt(2, obj.getAluno().getId());
            //pst.setDate(2, new java.sql.Date(obj.getDataCriacao().getTime()));
            pst.setInt(3, obj.getId());

            pst.execute();
        } finally {
            c.close();
        }
    }

    @Override
    public void apagar(Ficha obj) throws SQLException, ClassNotFoundException {
        Connection c = ConnectionManager.getConnectionMysql();

        try {
            String sql = "DELETE FROM academia.ficha WHERE id=?";

            PreparedStatement pst = c.prepareStatement(sql);

            pst.setInt(1, obj.getId());

            ArrayList<Exercicio> exs = new ExercicioDAO().buscarTodosExerciciosFicha(obj.getId());
            for (Exercicio ex : exs) {
                new ExercicioDAO().apagar(ex);
            }

            pst.execute();
        } finally {
            c.close();
        }
    }

    @Override
    public Ficha buscar(Integer key) throws SQLException, ClassNotFoundException {
        Connection c = ConnectionManager.getConnectionMysql();

        try {
            String sql = "select * from academia.ficha where id=?;";

            PreparedStatement pst = c.prepareStatement(sql);

            pst.setInt(1, key);

            ResultSet resultado = pst.executeQuery();

            Ficha f = null;

            if(resultado.next()){
                f = getFichaPreenchida(resultado);
            }

            return f;
        } finally {
            c.close();
        }
    }

    private Ficha getFichaPreenchida(ResultSet resultado) throws SQLException, ClassNotFoundException {
        Ficha f = new Ficha(resultado.getInt(1),
                new AlunoDAO().buscar(resultado.getInt(2)),
                new InstrutorDAO().buscar(resultado.getInt(3)),
                ETipoFicha.valueOf(resultado.getString(4)),
                null,
                //new ExercicioDAO().buscarTodosExerciciosFicha(resultado.getInt(1)),
                //resultado.getDate(13)
                new java.util.Date(resultado.getDate(5).getTime())
        );
        return f;
    }

    @Override
    public ArrayList<Ficha> buscarTodos() throws SQLException, ClassNotFoundException {
        Connection c = ConnectionManager.getConnectionMysql();

        try {
            String sql = "select * from academia.ficha";

            PreparedStatement pst = c.prepareStatement(sql);

            ResultSet resultado = pst.executeQuery();

            ArrayList<Ficha> lista = new ArrayList<Ficha>();

            while(resultado.next()){
                lista.add(getFichaPreenchida(resultado));
            }
            return lista;

        } finally {
            c.close();
        }
    }

    public ArrayList<Ficha> buscarTodasFichasInstrutor(Integer key) throws SQLException, ClassNotFoundException {
        Connection c = ConnectionManager.getConnectionMysql();

        try {
            String sql = "select * from academia.ficha where id_instrutor=?";

            PreparedStatement pst = c.prepareStatement(sql);

            pst.setInt(1,key);

            ResultSet resultado = pst.executeQuery();

            ArrayList<Ficha> lista = new ArrayList<Ficha>();

            while(resultado.next()){
                lista.add(getFichaPreenchida(resultado));
            }
            return lista;

        } finally {
            c.close();
        }
    }



    public ArrayList<Ficha> buscarFichasAluno(Integer key) throws SQLException, ClassNotFoundException {
        Connection c = ConnectionManager.getConnectionMysql();

        try {
            String sql = "select * from academia.ficha where id_aluno=? order by tipo_ficha asc";

            PreparedStatement pst = c.prepareStatement(sql);

            pst.setInt(1, key);

            ResultSet resultado = pst.executeQuery();

            ArrayList<Ficha> lista = new ArrayList<Ficha>();

            while(resultado.next()){
                lista.add(getFichaPreenchida(resultado));
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
            String sql = "SELECT count(*) FROM academia.ficha;";

            PreparedStatement pst = c.prepareStatement(sql);

            ResultSet resultado = pst.executeQuery();

            resultado.next();

            return resultado.getInt(1);
        } finally {
            c.close();
        }
    }

    public int quantidadeExerciciosFicha(Integer key) throws SQLException, ClassNotFoundException {
        Connection c = ConnectionManager.getConnectionMysql();

        try {
            String sql = "select count(e.id)\n" +
                    "from ficha f\n" +
                    "left join exercicio e on e.id_ficha = f.id\n" +
                    "where f.id=?; ";

            PreparedStatement pst = c.prepareStatement(sql);

            pst.setInt(1,key);

            ResultSet resultado = pst.executeQuery();

            resultado.next();

            return resultado.getInt(1);
        } finally {
            c.close();
        }
    }
}

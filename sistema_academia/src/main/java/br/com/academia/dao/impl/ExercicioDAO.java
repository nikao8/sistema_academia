package br.com.academia.dao.impl;

import br.com.academia.dao.IGenericDAO;
import br.com.academia.model.e.ETipoExercicio;
import br.com.academia.model.e.ETipoFicha;
import br.com.academia.model.fichas.Exercicio;
import br.com.academia.model.fichas.Ficha;
import br.com.academia.util.connection.ConnectionManager;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class ExercicioDAO implements IGenericDAO<Exercicio, Integer> {
    @Override
    public void inserir(Exercicio obj) throws SQLException, ClassNotFoundException {
        Connection c = ConnectionManager.getConnectionMysql();

        try {
            String sql = "INSERT INTO academia.exercicio\n" +
                    "(nome, series, repeticoes, peso, tipo_exercicio, observacao, id_ficha)\n" +
                    "VALUES(?, ?, ?, ?, ?, ?, ?);\n";

            PreparedStatement pst = c.prepareStatement(sql);

            pst.setString(1, obj.getNome());
            pst.setInt(2, obj.getSeries());
            pst.setInt(3, obj.getRepeticoes());
            pst.setDouble(4, obj.getPeso());
            pst.setString(5, obj.getTipoExercicio().toString());
            pst.setString(6, obj.getObservacao());
            pst.setInt(7,obj.getFicha().getId());

            pst.execute();
        } finally {
            c.close();
        }
    }

    @Override
    public void alterar(Exercicio obj) throws SQLException, ClassNotFoundException {
        Connection c = ConnectionManager.getConnectionMysql();

        try{
            String sql = "UPDATE academia.exercicio\n" +
                    "SET nome=?, series=?, repeticoes=?, peso=?, tipo_exercicio=?, observacao=?, id_ficha=?\n" +
                    "WHERE id=?;\n";

            PreparedStatement pst = c.prepareStatement(sql);

            pst.setString(1, obj.getNome());
            pst.setInt(2, obj.getSeries());
            pst.setInt(3, obj.getRepeticoes());
            pst.setDouble(4, obj.getPeso());
            pst.setString(5, obj.getTipoExercicio().toString());
            pst.setString(6, obj.getObservacao());
            pst.setInt(7,obj.getFicha().getId());
            pst.setInt(8,obj.getId());

            pst.execute();
        } finally {
            c.close();
        }
    }

    @Override
    public void apagar(Exercicio obj) throws SQLException, ClassNotFoundException {
        Connection c = ConnectionManager.getConnectionMysql();

        try{
            String sql = "DELETE FROM academia.exercicio WHERE id=?";

            PreparedStatement pst = c.prepareStatement(sql);

            pst.setInt(1, obj.getId());

            pst.execute();
        } finally {
            c.close();
        }
    }

    @Override
    public Exercicio buscar(Integer key) throws SQLException, ClassNotFoundException {
        Connection c = ConnectionManager.getConnectionMysql();

        try {
            String sql = "select * from academia.exercicio where id=?";

            PreparedStatement pst = c.prepareStatement(sql);

            pst.setInt(1, key);

            ResultSet resultado = pst.executeQuery();

            Exercicio e = null;

            if(resultado.next()){
                e = getExercicioPreenchido(resultado);
            }

            return e;
        } finally {
            c.close();
        }
    }

    private Exercicio getExercicioPreenchido(ResultSet resultado) throws SQLException, ClassNotFoundException {
        /*
        Ficha ficha = new Ficha(resultado.getInt(9),
                new AlunoDAO().buscar(resultado.getInt(10)),
                new InstrutorDAO().buscar(resultado.getInt(11)),
                ETipoFicha.valueOf(resultado.getString(12)),
                buscarTodosExerciciosFicha(resultado.getInt(9)),
                //resultado.getDate(13)
                new java.util.Date(resultado.getDate(13).getTime())
                );*/

        Exercicio e = new Exercicio(resultado.getInt(1),
                resultado.getString(2),
                resultado.getInt(3),
                resultado.getInt(4),
                resultado.getInt(5),
                ETipoExercicio.valueOf(resultado.getString(6)),
                resultado.getString(7),
                new FichaDAO().buscar(resultado.getInt(8))
                );
        return e;
    }

    @Override
    public ArrayList<Exercicio> buscarTodos() throws SQLException, ClassNotFoundException {
        Connection c = ConnectionManager.getConnectionMysql();

        try {
            String sql = "select * from academia.exercicio";

            PreparedStatement pst = c.prepareStatement(sql);

            ResultSet resultado = pst.executeQuery();

            ArrayList<Exercicio> lista = new ArrayList<Exercicio>();

            while(resultado.next()){
                lista.add(getExercicioPreenchido(resultado));
            }
            return lista;

        } finally {
            c.close();
        }
    }

    public ArrayList<Exercicio> buscarTodosExerciciosInstrutor(Integer key) throws SQLException, ClassNotFoundException {
        Connection c = ConnectionManager.getConnectionMysql();

        try {
            String sql = "select e.* from academia.exercicio e \n" +
                    "inner join ficha f on f.id = e.id_ficha \n" +
                    "where f.id_instrutor=?;";

            PreparedStatement pst = c.prepareStatement(sql);

            pst.setInt(1, key);

            ResultSet resultado = pst.executeQuery();

            ArrayList<Exercicio> lista = new ArrayList<Exercicio>();

            while(resultado.next()){
                lista.add(getExercicioPreenchido(resultado));
            }
            return lista;

        } finally {
            c.close();
        }
    }

    public ArrayList<Exercicio> buscarExerciciosPesquisa(Integer key,String nomeAluno, String nomeExercicio) throws SQLException, ClassNotFoundException {
        Connection c = ConnectionManager.getConnectionMysql();

        try {
            String sql = "select e.* from academia.exercicio e\n" +
                    "inner join ficha f on f.id = e.id_ficha\n" +
                    "inner join aluno a on a.id = f.id_aluno \n" +
                    "where f.id_instrutor=? and a.nome like ? and e.nome like ?;";

            PreparedStatement pst = c.prepareStatement(sql);

            pst.setInt(1, key);
            pst.setString(2,"%"+nomeAluno+"%");
            pst.setString(3, "%"+nomeExercicio+"%");


            ResultSet resultado = pst.executeQuery();

            ArrayList<Exercicio> lista = new ArrayList<Exercicio>();

            while(resultado.next()){
                lista.add(getExercicioPreenchido(resultado));
            }
            return lista;

        } finally {
            c.close();
        }
    }

    public ArrayList<Exercicio> buscarTodosExerciciosFicha(Integer key) throws SQLException, ClassNotFoundException {
        Connection c = ConnectionManager.getConnectionMysql();

        try {
            String sql = "select * from academia.exercicio where id_ficha=?;";


            PreparedStatement pst = c.prepareStatement(sql);

            pst.setInt(1, key);

            ResultSet resultado = pst.executeQuery();

            ArrayList<Exercicio> lista = new ArrayList<Exercicio>();

            while(resultado.next()){
                lista.add(getExercicioPreenchido(resultado));
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
            String sql = "SELECT count(*) FROM academia.exercicio;";

            PreparedStatement pst = c.prepareStatement(sql);

            ResultSet resultado = pst.executeQuery();

            resultado.next();

            return resultado.getInt(1);
        } finally {
            c.close();
        }
    }
}

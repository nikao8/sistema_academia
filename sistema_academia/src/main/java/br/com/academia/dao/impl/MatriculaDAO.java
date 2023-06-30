package br.com.academia.dao.impl;

import br.com.academia.dao.IGenericDAO;
import br.com.academia.model.financeiro.Pagamento;
import br.com.academia.model.sistema.Matricula;
import br.com.academia.util.connection.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MatriculaDAO implements IGenericDAO<Matricula, Integer> {
    @Override
    public void inserir(Matricula obj) throws SQLException, ClassNotFoundException {
        Connection c = ConnectionManager.getConnectionMysql();

        try {
            String sql = "INSERT INTO academia.matricula\n" +
                    "(id_aluno, mensalidade, data_matricula, data_vencimento_mensalidade)\n" +
                    "VALUES(?, ?, ?, ?);\n";

            PreparedStatement pst = c.prepareStatement(sql);

            pst.setInt(1, obj.getAluno().getId());
            pst.setDouble(2, obj.getMensalidade());
            pst.setDate(3, new java.sql.Date(obj.getDataMatricula().getTime()));
            pst.setDate(4, new java.sql.Date(obj.getDataVencimento().getTime()));

            pst.execute();
        } finally {
            c.close();
        }
    }

    @Override
    public void alterar(Matricula obj) throws SQLException, ClassNotFoundException {
        Connection c = ConnectionManager.getConnectionMysql();

        try {
            String sql = "UPDATE academia.matricula\n" +
                    "SET mensalidade=?, data_matricula=?, data_vencimento_mensalidade=?\n" +
                    "WHERE id=?;\n";

            PreparedStatement pst = c.prepareStatement(sql);

            pst.setDouble(1, obj.getMensalidade());
            pst.setDate(2, new java.sql.Date(obj.getDataMatricula().getTime()));
            pst.setDate(3, new java.sql.Date(obj.getDataVencimento().getTime()));
            pst.setInt(4, obj.getId());

            pst.execute();
        } finally {
            c.close();
        }
    }

    @Override
    public void apagar(Matricula obj) throws SQLException, ClassNotFoundException {
        Connection c = ConnectionManager.getConnectionMysql();

        try {
            String sql = "DELETE FROM academia.matricula\n" +
                    "WHERE id=?;\n";

            PreparedStatement pst = c.prepareStatement(sql);

            pst.setInt(1, obj.getId());

            pst.execute();
        } finally {
            c.close();
        }
    }

    public void apagarPorAluno(Integer key) throws SQLException, ClassNotFoundException {
        Connection c = ConnectionManager.getConnectionMysql();

        try {
            String sql = "DELETE FROM academia.matricula\n" +
                    "WHERE id_aluno=?;\n";

            PreparedStatement pst = c.prepareStatement(sql);

            pst.setInt(1, key);
            //////
            ArrayList<Pagamento> pgs = new PagamentoDAO().buscarTodosPagamentosMatricula(key);
            for(Pagamento p : pgs){
                new PagamentoDAO().apagar(p);
            }

            pst.execute();
        } finally {
            c.close();
        }
    }

    @Override
    public Matricula buscar(Integer key) throws SQLException, ClassNotFoundException {
        Connection c = ConnectionManager.getConnectionMysql();

        try {
            String sql = "select * from academia.matricula where id=?;";

            PreparedStatement pst = c.prepareStatement(sql);

            pst.setInt(1, key);

            ResultSet resultado = pst.executeQuery();

            Matricula m = null;

            if(resultado.next()){
                m = getMatriculaPreenchida(resultado);
            }

            return m;
        } finally {
            c.close();
        }
    }

    private Matricula getMatriculaPreenchida(ResultSet resultado) throws SQLException, ClassNotFoundException {
        Matricula m = new Matricula(resultado.getInt(1),
                new AlunoDAO().buscar(resultado.getInt(2)),
                resultado.getDouble(3),
                new java.util.Date(resultado.getDate(4).getTime()),
                new java.util.Date(resultado.getDate(5).getTime())
        );

        //m.setPagamentos(new PagamentoDAO().buscarTodosPagamentosMatricula(resultado.getInt(1)));

        return m;
    }

    public Matricula buscarMatriculaAluno(Integer key) throws SQLException, ClassNotFoundException {
        Connection c = ConnectionManager.getConnectionMysql();

        try {
            String sql = "select * from academia.matricula where id_aluno=?;";

            PreparedStatement pst = c.prepareStatement(sql);

            pst.setInt(1, key);

            ResultSet resultado = pst.executeQuery();

            Matricula m = null;

            if(resultado.next()){
                m = getMatriculaPreenchida(resultado);
            }

            return m;
        } finally {
            c.close();
        }
    }

    @Override
    public ArrayList<Matricula> buscarTodos() throws SQLException, ClassNotFoundException {
        Connection c = ConnectionManager.getConnectionMysql();

        try {
            String sql = "select * from academia.matricula";

            PreparedStatement pst = c.prepareStatement(sql);

            ResultSet resultado = pst.executeQuery();

            ArrayList<Matricula> lista = new ArrayList<Matricula>();

            while(resultado.next()){
                lista.add(getMatriculaPreenchida(resultado));
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
            String sql = "SELECT count(*) FROM academia.matricula;";

            PreparedStatement pst = c.prepareStatement(sql);

            ResultSet resultado = pst.executeQuery();

            resultado.next();

            return resultado.getInt(1);
        } finally {
            c.close();
        }
    }

    public double somaMensalidades() throws SQLException, ClassNotFoundException {
        Connection c = ConnectionManager.getConnectionMysql();

        try {
            String sql = "SELECT sum(mensalidade) FROM academia.matricula;";

            PreparedStatement pst = c.prepareStatement(sql);

            ResultSet resultado = pst.executeQuery();

            resultado.next();

            return resultado.getDouble(1);
        } finally {
            c.close();
        }
    }

}

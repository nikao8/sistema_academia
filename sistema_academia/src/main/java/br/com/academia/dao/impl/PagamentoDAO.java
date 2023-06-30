package br.com.academia.dao.impl;

import br.com.academia.dao.IGenericDAO;
import br.com.academia.model.e.ETipoPagamento;
import br.com.academia.model.financeiro.Pagamento;
import br.com.academia.util.connection.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class PagamentoDAO implements IGenericDAO<Pagamento, Integer> {
    @Override
    public void inserir(Pagamento obj) throws SQLException, ClassNotFoundException {
        Connection c = ConnectionManager.getConnectionMysql();

        try {
            String sql = "INSERT INTO academia.pagamento\n" +
                    "(id_matricula, data_pagamento, tipo_pagamento)\n" +
                    "VALUES(?, ?, ?);\n";

            PreparedStatement pst = c.prepareStatement(sql);

            pst.setInt(1, obj.getMatricula().getId());
            pst.setString(2, obj.getDataPagamento().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")));
            pst.setString(3, obj.getTipoPagamento().toString());

            pst.execute();
        } finally {
            c.close();
        }
    }

    @Override
    public void alterar(Pagamento obj) throws SQLException, ClassNotFoundException {
        Connection c = ConnectionManager.getConnectionMysql();

        try {
            String sql = "UPDATE academia.pagamento\n" +
                    "SET data_pagamento=?, tipo_pagamento=?\n" +
                    "WHERE id=?;\n";

            PreparedStatement pst = c.prepareStatement(sql);


            pst.setString(1, obj.getDataPagamento().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")));
            pst.setString(2, obj.getTipoPagamento().toString());
            pst.setInt(3, obj.getId());

            pst.execute();
        } finally {
            c.close();
        }
    }

    @Override
    public void apagar(Pagamento obj) throws SQLException, ClassNotFoundException {
        Connection c = ConnectionManager.getConnectionMysql();

        try {
            String sql = "DELETE FROM academia.pagamento WHERE id=?";

            PreparedStatement pst = c.prepareStatement(sql);

            pst.setInt(1, obj.getId());

            pst.execute();
        } finally {
            c.close();
        }
    }

    @Override
    public Pagamento buscar(Integer key) throws SQLException, ClassNotFoundException {
        Connection c = ConnectionManager.getConnectionMysql();

        try {
            String sql = "select * from academia.pagamento where id=?;";

            PreparedStatement pst = c.prepareStatement(sql);

            pst.setInt(1, key);

            ResultSet resultado = pst.executeQuery();

            Pagamento p = null;

            if(resultado.next()){
                p = getPagamentoPreenchido(resultado);
            }

            return p;
        } finally {
            c.close();
        }
    }


    public String retornaMesUltimoPagamento(Integer key) throws SQLException, ClassNotFoundException {
        Connection c = ConnectionManager.getConnectionMysql();

        try {
            String sql = "select data_pagamento from academia.pagamento where id_matricula=? order by data_pagamento desc limit 1;";

            PreparedStatement pst = c.prepareStatement(sql);

            pst.setInt(1, key);

            ResultSet resultado = pst.executeQuery();


            String month = "";
            if(resultado.next()){
                month = resultado.getTimestamp(1).toLocalDateTime().getMonth().toString();
            }

            return month;
        } finally {
            c.close();
        }
    }

    private Pagamento getPagamentoPreenchido(ResultSet resultado) throws SQLException, ClassNotFoundException {
        Pagamento p = new Pagamento(resultado.getInt(1),
                new MatriculaDAO().buscar(resultado.getInt(2)),
                //LocalDateTime.parse(resultado.getString(3), DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")),
                resultado.getTimestamp(3).toLocalDateTime(),
                ETipoPagamento.valueOf(resultado.getString(4))
                );
        return p;
    }

    @Override
    public ArrayList<Pagamento> buscarTodos() throws SQLException, ClassNotFoundException {
        Connection c = ConnectionManager.getConnectionMysql();

        try {
            String sql = "select * from academia.pagamento";

            PreparedStatement pst = c.prepareStatement(sql);

            ResultSet resultado = pst.executeQuery();

            ArrayList<Pagamento> lista = new ArrayList<Pagamento>();

            while(resultado.next()){
                lista.add(getPagamentoPreenchido(resultado));
            }
            return lista;

        } finally {
            c.close();
        }
    }

    public ArrayList<Pagamento> buscarTodosPagamentosMatricula(Integer key) throws SQLException, ClassNotFoundException {
        Connection c = ConnectionManager.getConnectionMysql();

        try {
            String sql = "select * from academia.pagamento where id_matricula=?";

            PreparedStatement pst = c.prepareStatement(sql);

            pst.setInt(1, key);

            ResultSet resultado = pst.executeQuery();

            ArrayList<Pagamento> lista = new ArrayList<Pagamento>();

            while(resultado.next()){
                lista.add(getPagamentoPreenchido(resultado));
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
            String sql = "SELECT count(*) FROM academia.pagamento;";

            PreparedStatement pst = c.prepareStatement(sql);

            ResultSet resultado = pst.executeQuery();

            resultado.next();

            return resultado.getInt(1);
        } finally {
            c.close();
        }
    }
}

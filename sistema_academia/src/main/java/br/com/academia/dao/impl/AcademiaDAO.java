package br.com.academia.dao.impl;

import br.com.academia.dao.IGenericDAO;
import br.com.academia.model.financeiro.Pagamento;
import br.com.academia.model.pessoas.Admin;
import br.com.academia.model.pessoas.Aluno;
import br.com.academia.model.pessoas.Instrutor;
import br.com.academia.model.sistema.Academia;
import br.com.academia.model.sistema.Matricula;
import br.com.academia.util.connection.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AcademiaDAO implements IGenericDAO<Academia, Integer> {
    @Override
    public void inserir(Academia obj) throws SQLException, ClassNotFoundException {
        Connection c = ConnectionManager.getConnectionMysql();

        try {
            String sql = "INSERT INTO academia.academia\n" +
                    "(nome, cnpj)\n" +
                    "VALUES(?, ?);\n";

            PreparedStatement pst = c.prepareStatement(sql);

            pst.setString(1, obj.getNome());
            pst.setString(2, obj.getCnpj());

            pst.execute();
        } finally {
            c.close();
        }
    }

    @Override
    public void alterar(Academia obj) throws SQLException, ClassNotFoundException {
        Connection c = ConnectionManager.getConnectionMysql();

        try {
            String sql = "UPDATE academia.academia\n" +
                    "SET nome=?, cnpj=?\n" +
                    "WHERE id=?;\n";

            PreparedStatement pst = c.prepareStatement(sql);

            pst.setString(1, obj.getNome());
            pst.setString(2, obj.getCnpj());
            pst.setInt(3, obj.getId());

            pst.execute();
        } finally {
            c.close();
        }
    }

    @Override
    public void apagar(Academia obj) throws SQLException, ClassNotFoundException {
        Connection c = ConnectionManager.getConnectionMysql();

        try {
            String sql = "DELETE FROM academia.academia\n" +
                    "WHERE id=?;\n";

            PreparedStatement pst = c.prepareStatement(sql);

            pst.setInt(1, obj.getId());

            // APAGA TODOS ALUNOS, INSTRUTORES E ADMINISTRADORES QUANDO UMA ACADEMIA É EXCLUIDA DO SISTEMA
            for(Aluno a : obj.getAlunos()){
                new AlunoDAO().apagar(a);
            }

            for(Admin ad : obj.getAdministradores()){
                new AdminDAO().apagar(ad);
            }

            for(Instrutor i : obj.getInstrutores()){
                new InstrutorDAO().apagar(i);
            }

            pst.execute();
        } finally {
            c.close();
        }
    }

    @Override
    public Academia buscar(Integer key) throws SQLException, ClassNotFoundException {
        Connection c = ConnectionManager.getConnectionMysql();

        try {
            String sql = "select * from academia.academia where id=?;";

            PreparedStatement pst = c.prepareStatement(sql);

            pst.setInt(1, key);

            ResultSet resultado = pst.executeQuery();

            Academia a = null;

            if(resultado.next()){
                a = getAcademiaPreenchido(resultado);
            }

            return a;
        } finally {
            c.close();
        }
    }

    private Academia getAcademiaPreenchido(ResultSet resultado) throws SQLException, ClassNotFoundException {
        Academia a = new Academia(
                resultado.getInt(1),
                resultado.getString(2),
                resultado.getString(3),
                new InstrutorDAO().buscarTodosInstrutoresPorAcademia(resultado.getInt(1)),
                new AlunoDAO().buscarTodosAlunosPorAcademia(resultado.getInt(1)),
                new AdminDAO().buscarTodosAdminsPorAcademia(resultado.getInt(1))
        );
        return a;
    }

    @Override
    public ArrayList<Academia> buscarTodos() throws SQLException, ClassNotFoundException {
        Connection c = ConnectionManager.getConnectionMysql();

        try {
            String sql = "select * from academia.academia";

            PreparedStatement pst = c.prepareStatement(sql);

            ResultSet resultado = pst.executeQuery();

            ArrayList<Academia> lista = new ArrayList<Academia>();

            while(resultado.next()){
                lista.add(getAcademiaPreenchido(resultado));
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
            String sql = "SELECT count(*) FROM academia.academia;";

            PreparedStatement pst = c.prepareStatement(sql);

            ResultSet resultado = pst.executeQuery();

            resultado.next();

            return resultado.getInt(1);
        } finally {
            c.close();
        }
    }
}

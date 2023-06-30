package br.com.academia.dao.impl;

import br.com.academia.dao.IGenericDAO;
import br.com.academia.model.pessoas.Admin;
import br.com.academia.model.sistema.Academia;
import br.com.academia.util.connection.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AdminDAO implements IGenericDAO<Admin, Integer> {

    @Override
    public void inserir(Admin obj) throws SQLException, ClassNotFoundException {
        Connection c = ConnectionManager.getConnectionMysql();

        try {
            String sql = "INSERT INTO academia.admin\n" +
                    "(id_academia, nome, login, senha)\n" +
                    "VALUES(?, ?, ?, ?);\n";

            PreparedStatement pst = c.prepareStatement(sql);

            pst.setInt(1, obj.getAcademia().getId());
            pst.setString(2, obj.getNome());
            pst.setString(3, obj.getLogin());
            pst.setString(4, obj.getSenha());

            pst.execute();
        } finally {
            c.close();
        }
    }

    @Override
    public void alterar(Admin obj) throws SQLException, ClassNotFoundException {
        Connection c = ConnectionManager.getConnectionMysql();

        try{
            String sql = "UPDATE academia.admin\n" +
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
            String sql = "UPDATE academia.admin\n" +
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
    public void apagar(Admin obj) throws SQLException, ClassNotFoundException {
        Connection c = ConnectionManager.getConnectionMysql();

        try{
            String sql = "DELETE FROM academia.admin\n" +
                    "WHERE id=?;\n";

            PreparedStatement pst = c.prepareStatement(sql);

            pst.setInt(1, obj.getId());

            pst.execute();
        } finally {
            c.close();
        }
    }

    @Override
    public Admin buscar(Integer key) throws SQLException, ClassNotFoundException {
        Connection c = ConnectionManager.getConnectionMysql();

        try {
            String sql = "select ac.*, a.*\n" +
                    "from admin a\n" +
                    "inner join academia ac on ac.id = a.id_academia \n" +
                    "where a.id=?";

            PreparedStatement pst = c.prepareStatement(sql);

            pst.setInt(1, key);

            ResultSet resultado = pst.executeQuery();

            Admin ad = null;
            if(resultado.next()){
                ad = getAdminPreenchido(resultado);
            }

            return ad;
        } finally {
            c.close();
        }
    }

    private Admin getAdminPreenchido(ResultSet resultado) throws SQLException {
        Academia acad = new Academia(resultado.getInt(1),
                resultado.getString(2),
                resultado.getString(3));

        Admin ad = new Admin(acad,
                resultado.getInt(4),
                resultado.getString(6),
                resultado.getString(7),
                resultado.getString(8));
        return ad;
    }

    @Override
    public ArrayList<Admin> buscarTodos() throws SQLException, ClassNotFoundException {
        Connection c = ConnectionManager.getConnectionMysql();

        try {
            String sql = "select ac.*, a.*\n" +
                    "from admin a\n" +
                    "inner join academia ac on ac.id = a.id_academia;";


            PreparedStatement pst = c.prepareStatement(sql);

            ResultSet resultado = pst.executeQuery();

            ArrayList<Admin> lista = new ArrayList<Admin>();

            while(resultado.next()){
                lista.add(getAdminPreenchido(resultado));
            }
            return lista;

        } finally {
            c.close();
        }
    }

    public ArrayList<Admin> buscarTodosAdminsPorAcademia(Integer key) throws SQLException, ClassNotFoundException {
        Connection c = ConnectionManager.getConnectionMysql();

        try {
            String sql = "select ac.*, a.*\n" +
                    "from admin a\n" +
                    "inner join academia ac on ac.id = a.id_academia\n" +
                    "where ac.id=?;";


            PreparedStatement pst = c.prepareStatement(sql);

            pst.setInt(1, key);

            ResultSet resultado = pst.executeQuery();

            ArrayList<Admin> lista = new ArrayList<Admin>();

            while(resultado.next()){
                lista.add(getAdminPreenchido(resultado));
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
            String sql = "SELECT count(*) FROM academia.admin;";

            PreparedStatement pst = c.prepareStatement(sql);

            ResultSet resultado = pst.executeQuery();

            resultado.next();

            return resultado.getInt(1);
        } finally {
            c.close();
        }
    }

    public Admin buscarPorLoginSenha(String login, String senha) throws SQLException, ClassNotFoundException {
        Connection c = ConnectionManager.getConnectionMysql();

        try {
            String sql = "select ac.*, a.*\n" +
                    "from admin a\n" +
                    "inner join academia ac on ac.id = a.id_academia \n" +
                    "where a.login=? and a.senha=?";

            PreparedStatement pst = c.prepareStatement(sql);

            pst.setString(1, login);
            pst.setString(2, senha);

            ResultSet resultado = pst.executeQuery();

            Admin ad = null;
            if(resultado.next()){
                ad = getAdminPreenchido(resultado);
            }

            return ad;
        } finally {
            c.close();
        }
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.glebson2015.agenda;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author marcio.soares <marcio@mail.com>
 */
public class Metodos {

    public ArrayList listarPessoas() {
        Statement stmt = null;
        Connection conn = null;
        ArrayList<Pessoa> pessoas = new ArrayList<>();
        Conexao conexao = new Conexao();
        String sql = "SELECT ID_PESSOA, NM_PESSOA, DT_NASCIMENTO, VL_TELEFONE, VL_EMAIL FROM TB_PESSOA";
        try {
            conn = conexao.obterConexao();
            stmt = conn.createStatement();
            ResultSet resultados = stmt.executeQuery(sql);
            DateFormat formatadorData = new SimpleDateFormat("dd/MM/yyyy");

            while (resultados.next()) {
                Pessoa pessoa = new Pessoa();
                pessoa.setId(resultados.getLong("ID_PESSOA"));
                pessoa.setNome(resultados.getString("NM_PESSOA"));
                pessoa.setDt_nascimento(resultados.getDate("DT_NASCIMENTO"));
                pessoa.setEmail(resultados.getString("VL_EMAIL"));
                pessoa.setTelefone(resultados.getString("VL_TELEFONE"));
                pessoa.setDt_cadastro(resultados.getTimestamp("DT_CADASTRO"));
                pessoas.add(pessoa);
            }
            conn.close();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Agenda.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Agenda.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Agenda.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return pessoas;
    }

    
    public void cadastrarPessoas(Pessoa pessoa) {
        PreparedStatement stmt = null;
        Connection conn = null;
        Conexao conexao = new Conexao();
        String sql = "INSERT INTO TB_PESSOA (NM_PESSOA, DT_NASCIMENTO, VL_TELEFONE, VL_EMAIL, DT_CADASTRO)"
                + "VALUES(?,?,?,?,?)";
        try {
            conn = conexao.obterConexao();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, pessoa.getNome());
            stmt.setDate(2, pessoa.getDt_nascimento());
            stmt.setString(3, pessoa.getTelefone());
            stmt.setString(4, pessoa.getEmail());
            stmt.setTimestamp(5, pessoa.getDt_cadastro());
            stmt.executeQuery();
            conn.close();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Agenda.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Agenda.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Agenda.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }
    //Método que altera os dados do contato de acordo com o ID
    public void alteraPessoas(Pessoa pessoa) {

        Conexao conexao = new Conexao();
        String sql = "UPDATE contato SET (NM_PESSOA, DT_NASCIMENTO, VL_TELEFONE, VL_EMAIL, DT_CADASTRO)"
                + "VALUES(?,?,?,?,?) WHERE ID_CONTATO = ?";

        PreparedStatement stmt = null;
        Connection conn = null;

        try {

            conn = conexao.obterConexao();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, pessoa.getNome());
            stmt.setDate(2, pessoa.getDt_nascimento());
            stmt.setString(3, pessoa.getTelefone());
            stmt.setString(4, pessoa.getEmail());
            stmt.setTimestamp(5, pessoa.getDt_cadastro());
            stmt.executeQuery();
            conn.close();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Agenda.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Agenda.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Agenda.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        }

    }
    //Método que remove o contato de acordo com seu ID
    public void removePessoas(int id) {

        String sql = "DELETE FROM contato WHERE ID = ?";
        Conexao conexao = new Conexao();
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            
            conn = conexao.obterConexao();
            stmt = conn.prepareStatement(sql);
            stmt.setLong(1, id);
            stmt.executeQuery();
            conn.close();

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Agenda.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Agenda.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Agenda.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        }

    }

}

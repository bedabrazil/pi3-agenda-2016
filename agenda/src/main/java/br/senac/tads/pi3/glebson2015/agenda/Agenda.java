/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.glebson2015.agenda;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author glebson.lsilva1
 */
public class Agenda {

    private Connection obterConexao() throws SQLException, ClassNotFoundException {

        Connection conn = null;
        //Passo: Registrar drive JDBC
        Class.forName("org.apche.derby.jdbc.ClientDataSource");

        //Passo 2: Abrir a conexão
        conn = DriverManager.getConnection(
                "jdbc:derby://localhost:1527/agendabd;SecurityMechanism=3",
                "app", //Usuário
                "app" //Senha
        );
        return conn;

    }

}

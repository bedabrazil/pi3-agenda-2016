/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.glebson2015.agenda;

import java.util.ArrayList;

/**
 *
 * @author glebson.lsilva1
 */
public class Agenda {

    public static void main(String[] args) {
        ArrayList<Pessoa> pessoas = new Metodos().listarPessoas();
        for(Pessoa pessoa:pessoas){
            System.out.println("ID            => "+pessoa.getId());
            System.out.println("Nome          => "+pessoa.getNome());
            System.out.println("Email         => "+pessoa.getEmail());
            System.out.println("Telefone      => "+pessoa.getTelefone());
            System.out.println("DT NASCIMENTO => "+pessoa.getDt_nascimento());
            System.out.println("DT_CADASTRO   => "+pessoa.getDt_cadastro());
        }
    }

}

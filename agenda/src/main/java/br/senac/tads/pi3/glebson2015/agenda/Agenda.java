/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.glebson2015.agenda;

/**
 *
 * @author glebson.lsilva1
 */
public class Agenda {
    
    Pessoa pessoa = new Pessoa();

        //Variável de opção
        int opcao;

        //Scanner - Entrada de dados do usuário
        Scanner sc = new Scanner(System.in);

        System.out.println("******************************");
        System.out.println("*     AGENDA DE CONTATOS     *");
        System.out.println("******************************");

        //Do while - Controla o menu da agenda por meio de condicionais if
        do {

            System.out.println("Escolha uma das opçõesdo menu abaixo: \n1 - Cadastrar Contato"
                    + "\n2 - Alterar Contato\n3 - Mostrar Contato\n4 - Excluir Contatos\n5 - Sair da Agenda");
            opcao = sc.nextInt();

            if (opcao == 1) {
                
                
            }
            if (opcao == 2) {

            }
            if (opcao == 3) {

            }
            if (opcao == 4) {

            }
            if (opcao == 5) {

                System.out.println("Sistema de agenda de contato finalizado!!");
            }

        } while (opcao != 5);

    }

}
    
    


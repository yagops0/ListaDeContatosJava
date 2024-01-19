package com.yagos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.classes.Contato;
import com.controladores.ControladorContato;

/*Faça um programa Java para implementar uma lista de contatos, com os atributos
apelido, nome e telefone. O programa principal deverá exibir um menu com as opções:
1 – incluir contato; 2 – alterar telefone; 3 – excluir contato; 4 – consultar um contato; 5
– listar todos os contatos; e 6 – sair. Na opção de incluir contato, o programa deve pedir
os dados do contato e, se não existir nenhum contato com o apelido digitado, inserir o
contato na lista; caso contrário, o programa deve exibir uma mensagem de que já existe
um contato com o mesmo apelido. Na opção de alterar telefone, o programa deve pedir
o apelido do contato e procurá-lo na lista e, encontrando o contato, o programa deve
solicitar o novo telefone e alterar na lista; caso contrário, o programa deve exibir uma
mensagem de que o contato não existe. Na opção de excluir o contato, o programa deve
pedir o apelido do contato e procurá-lo na lista e, encontrando o contato, o programa
deve excluí-lo da lista; caso não encontre, o programa deve exibir uma mensagem de
que o contato não existe. Na opção de consultar um contato, o programa deve pedir o
apelido do contato e procurá-lo na lista e, encontrando o contato, o programa deve
exibir todos os dados do contato; caso não encontre, o programa deve exibir uma
mensagem de que o contato não existe. Na opção de listar todos os contatos, o
programa irá varrer a lista e exibir todos os dados de todos os contatos. Na opção de
sair, o programa deve ser encerrado. */


public class ListaDeContatos1 
{
    private static void espera()
    {
        try
        {
            Thread.sleep(1000);
        }
        catch(InterruptedException e)
        {
            System.out.println(e);
        }
    }

    private static void frufru()
    {
        System.out.println("========================================================================");
    }

    public static void main( String[] args )
    {
        //List<Contato> contatos = new ArrayList<>();
        //String nome, apelido, telefon;
        ControladorContato cc = new ControladorContato();
        Scanner ent = new Scanner(System.in);
        int escolha;
        String nome, telefone, apelido;

        try 
        {
            while(true)
            {
                System.out.println("==========================LISTA DE CONTATOS==========================");
                espera();
                System.out.println("- MENU");
                System.out.println("- 1: Incluir Contato");
                System.out.println("- 2: Alterar Telefone");
                System.out.println("- 3: Excluir Contato");
                System.out.println("- 4: Consultar Contato");
                System.out.println("- 5: Listar Contatos");
                System.out.println("- 6: Sair");
                System.out.println("========================================================================");
                espera();
                System.out.print("Digite o que deseja fazer: ");
                escolha = ent.nextInt();
                ent.nextLine();
                espera();
                char continuar, simNao;
                switch(escolha)
                {
                    case 1:
                    {
                        frufru();
                        System.out.println("ADICIONAR CONTATO");
                        frufru();

                        System.out.println();

                        do
                        {
                            System.out.print("Nome: ");
                            nome = ent.nextLine();

                            System.out.print("Apelido: ");
                            apelido = ent.nextLine();

                            System.out.print("Telefone: ");
                            telefone = ent.nextLine();
                            frufru();

                            Contato c = new Contato(apelido, nome, telefone);

                            if(cc.incluirContato(c))
                            {
                                System.out.println("Contato adicionado com sucesso!");
                                
                            }
                            else
                            {
                                
                                System.out.println("Sinto muito não foi possível adiconar o contato. Já existe um contato com esse apelido.");
                            }

                            System.out.println("Deseja adicionar mais contatos (S/N)?");
                            continuar = ent.nextLine().charAt(0);

                        }while(continuar == 's');

                        break;
                    }
                    case 2:
                    {
                        frufru();
                        System.out.println("ALTERAR CONTATO");
                        frufru();

                        do 
                        {
                            System.out.print("Digite o apelido do contato para alterá-lo: ");
                            apelido = ent.nextLine();
                            espera();

                            for(Contato c : cc.getListaContatos())
                            {
                                if(cc.existeContato(apelido))
                                {
                                    if(apelido.equals(c.getApelido()))
                                    {
                                        if(cc.alterarTelefone(c))
                                        {
                                            frufru();
                                            System.out.println("CONTATO");
                                            System.out.println("Apelido: " + c.getApelido());
                                            System.out.println("Nome: " + c.getNome());
                                            System.out.println("Telefone: " + c.getTelefone());
                                            frufru();
                                            System.out.println("ALTERAR");
                                            frufru();

                                            System.out.print("Apelido: ");
                                            c.setApelido(ent.nextLine());

                                            System.out.print("Nome: ");
                                            c.setNome(ent.nextLine());

                                            System.out.print("Telefone:");
                                            c.setTelefone(ent.nextLine());

                                            espera();
                                            frufru();
                                            System.out.println("Contato alterado com sucesso!");
                                            frufru();

                                        }
                                        else
                                        {
                                            System.out.println("Não foi possível alterar o contato.");
                                        }
                                    }
                                }
                                else
                                {
                                    frufru();
                                    System.out.println("Não foi possível encontrar um contato com o apelido digitado, por favor digite um apelido válido.");
                                    frufru();
                                    break;
                                }
                            }

                            
                            System.out.println("Deseja alterar mais algum contato(S/N)?");
                            continuar = ent.nextLine().charAt(0);
                            frufru();

                        } while (continuar == 's');
                        break;
                    }
                    case 3:
                    {
                        frufru();
                        System.out.println("EXCLUIR CONTATO");
                        frufru();

                        do 
                        {
                            System.out.print("Digite o apelido do contato que deseja excluir: ");
                            apelido = ent.nextLine();
                            espera();

                            for(Contato c : cc.getListaContatos())
                            {
                                if(cc.existeContato(apelido))
                                {
                                    if(apelido.equals(c.getApelido()))
                                    {
                                        frufru();
                                        System.out.println("CONTATO");
                                        System.out.println("Apelido: " + c.getApelido());
                                        System.out.println("Nome: " + c.getNome());
                                        System.out.println("Telefone: " + c.getTelefone());

                                        frufru();
                                        System.out.println("Deseja excluir esse contato(S/N)?");
                                        simNao = ent.nextLine().charAt(0);
                                        frufru();

                                        if(simNao == 's')
                                        {
                                            if(cc.excluirContato(c))
                                            {
                                                System.out.println("Contato excluído com sucesso!");
                                                break;
                                            }
                                            else
                                            {
                                                System.out.println("Ocorreu um erro ao excluir o contato.");
                                                break;
                                            }
                                        }
                                        else
                                        {
                                            System.out.println("O contato não foi excluído.");
                                        }
                                    
                                    }
                                }
                                else
                                {
                                    System.out.println("Não foi possível achar um contato com esse apelido.");
                                    break;
                                }
                            }
                           
                            espera();
                            System.out.println("Deseja excluir mais algum contato(S/N)?");
                            continuar = ent.nextLine().charAt(0);
                        } while (continuar == 's');
                        break;
                    }
                    case 4:
                    {
                        frufru();
                        System.out.println("CONSULTAR");
                        frufru();
                        do 
                        {
                            System.out.print("Digite o apelido do contato que deseja consultar: ");
                            apelido = ent.nextLine();

                            for(Contato c : cc.getListaContatos())
                            {
                                if(cc.existeContato(apelido))
                                {
                                    if(apelido.equals(c.getApelido()))
                                    {
                                        System.out.println("Apelido: " + c.getApelido());
                                        System.out.println("Nome: " + c.getNome());
                                        System.out.println("Telefone: " + c.getTelefone());
                                    }
                                }
                                else
                                {
                                    System.out.println("Não foi possível encontrar um a contato com esse apelido.");
                                }
                                   
                            }
                            System.out.println("Deseja consultar mais algum contato(S/N)?");
                            continuar = ent.nextLine().charAt(0);

                        } while (continuar == 's');
                        break;
                    }
                    case 5:
                    {

                        break;
                    }
                }

                
                if(escolha == 6)
                {
                    break;
                }

                if(escolha < 1 || escolha > 6)
                {
                    System.out.println("Por favor digite uma opção válida.");
                    continue;
                }



            }

            for(Contato c : cc.getListaContatos())
            {
                System.out.println("Apelido: " + c.getApelido());
                System.out.println("Nome: " + c.getNome());
                System.out.println("Telefone: " + c.getTelefone());
            }
        } 
        catch (Exception e) 
        {
            System.out.println("ERRO: " + e);
        }

    }
}

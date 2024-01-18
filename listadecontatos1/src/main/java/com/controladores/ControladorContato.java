package com.controladores;

import java.util.ArrayList;
import java.util.List;
import com.classes.Contato;

/* Na opção de incluir contato, o programa deve pedir
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

public class ControladorContato 
{
    List<Contato> listaContatos = new ArrayList<>();

    public boolean existeContato(String apelido)
    {
        for (Contato c : this.listaContatos) 
        {
            if(c.getApelido().equals(apelido))
            {
                return true;
            }
        }
        return false;

    }

    public int retornarIndice(String apelido)
    {
        for(Contato c : this.listaContatos)
        {
            if(c.getApelido().equals(apelido))
            {
                return this.listaContatos.indexOf(c);
            }
        }
        return -1;
    }

    public boolean incluirContato(Contato c)
    {
        if(c == null)
        {
            return false;
        }

        if(existeContato(c.getApelido()))
        {
            return false;
        }
        else
        {
            this.listaContatos.add(c);
            return true;
        }

    }
}

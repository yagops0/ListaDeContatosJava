package com.controladores;

import java.util.ArrayList;
import java.util.List;
import com.classes.Contato;



public class ControladorContato 
{
    List<Contato> listaContatos = new ArrayList<>();

    public List<Contato> getListaContatos() {
        return listaContatos;
    }

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

    public boolean alterarTelefone(Contato c)
    {
        if(c == null)
        {
            return false;
        }

        if(existeContato(c.getApelido()))
        {
            listaContatos.set(retornarIndice(c.getApelido()), c);
            return true;
        }
        else
        {
            return false;
        }
    }

    public boolean excluirContato(Contato c)
    {

        if(existeContato(c.getApelido()))
        {
            this.listaContatos.remove(retornarIndice(c.getApelido()));
            return true;
        }
        else
        {
            return false;
        }
    }

    /*public Contato retornarContato(String apelido)
    {
        for(Contato c : listaContatos)
        {
            if(apelido.equals(c.getApelido()))
            {
                return c;
            }
        }
        return null;
    }*/

    
}

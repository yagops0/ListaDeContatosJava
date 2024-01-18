package com.classes;

public class Contato 
{
    private String nome;
    private String apelido;
    private String telefone;

    


    public Contato(String nome, String apelido, String telefone) {
        this.nome = nome;
        this.apelido = apelido;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    

    
}

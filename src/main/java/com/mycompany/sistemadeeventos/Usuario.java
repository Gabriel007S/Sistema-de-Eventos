package com.mycompany.sistemadeeventos;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String nome;
    private String email;
    private String telefone;
    private List<Evento> eventosConfirmados;

    public Usuario(String nome, String email) {
        this.nome = nome;
        this.email = email;
        this.telefone = "";
        this.eventosConfirmados = new ArrayList<>();
    }
    public String  getNome(){ return nome; }
    public String getEmail() {return email;}
    public String getTelefone(){return telefone; }
    public List<Evento> getEventosConfirmados() {return eventosConfirmados;}
    
    public void confirmarEvento(Evento evento){
        if (!eventosConfirmados.contains(evento)){
            eventosConfirmados.add(evento);
        }
    }
    public void cancelarEvento(Evento evento){
        eventosConfirmados.remove(evento);
    }
    @Override
    public String toString(){
        return"Usuário: " + nome +" | Email: " + email + "| Telefone: " + telefone;
    }
}

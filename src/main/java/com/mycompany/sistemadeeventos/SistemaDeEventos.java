package com.mycompany.sistemadeeventos;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import com.mycompany.sistemadeeventos.Usuario;
import com.mycompany.sistemadeeventos.Evento;


public class SistemaDeEventos {
    private List<Usuario> usuarios = new ArrayList<>();
    private List<Evento> eventos = new ArrayList<>();

    public void cadastrarUsuario(Usuario u) {
        usuarios.add(u);
    }

    public void cadastrarEvento(Evento e) {
        eventos.add(e);
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public List<Evento> getEventos() {
        return eventos;
    }

    public void confirmarParticipacao(Usuario usuario, Evento evento) {
        usuario.confirmarEvento(evento);
    }

    public void cancelarParticipacao(Usuario usuario, Evento evento) {
        usuario.cancelarEvento(evento);
    }
}


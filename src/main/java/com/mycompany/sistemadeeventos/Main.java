package com.mycompany.sistemadeeventos;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;



public class Main {
    public static void main(String[] args){
    SistemaDeEventos sistema = new SistemaDeEventos();
    Scanner scanner = new Scanner(System.in);
    
    Usuario u1 = new Usuario("gabriel", "gabriel@email.com");
    Usuario u2 = new Usuario("Rose", "rose@email.com");
    sistema.cadastrarUsuario(u1);
    sistema.cadastrarUsuario(u2);
    
    if (sistema.getEventos().isEmpty()){
        sistema.cadastrarEvento(new Evento("Aniversario", "Rua das Flores", "Festa de aniversario", Evento.CategoriaEvento.FESTA, LocalDateTime.of(2025, 6, 10, 18, 30)));
        sistema.cadastrarEvento(new Evento("Show Rock", "Praça Central", "Show de rock ao ar livre", Evento.CategoriaEvento.SHOW, LocalDateTime.of(2025, 7, 5, 20, 0)));
    }
    
    System.out.println("Bem vindo ao Sistema de Eventos!");
    
    boolean rodando = true;
    while (rodando){
        System.out.println("\nMenu:");
        System.out.println("1 - Lista eventos");
        System.out.println("2  - Confirmar presença");
        System.out.println("3 - Cancelar presença");
        System.out.println("4 - Meus eventos confirmados");
        System.out.println("5 - Sair");
        System.out.println("Escolha uma opção: ");
        int opcao = scanner.nextInt();
        scanner.nextLine();
        
        switch (opcao){
            case 1:
                List<Evento> eventos = sistema.getEventos();
                System.out.println("Eventos cadastrados:");
                for (int i = 0; i  <eventos.size(); i++){
                    Evento e = eventos.get(i);
                    String status = e.estaOcorrendoAgora() ? "(OCORRENDO AGORA)" : "";
                    System.out.println(i + " - " + e + status);
                }
                break;
           
            case 2:
                    System.out.print("Digite seu nome: ");
                    String nome = scanner.nextLine();
                    Usuario usuario = sistema.getUsuarios().stream()
                            .filter(u -> u.getNome().equalsIgnoreCase(nome))
                            .findFirst()
                            .orElse(null);
                    if (usuario == null) {
                        System.out.println("Usuário não encontrado!");
                        break;
                    }

                    System.out.print("Digite o número do evento para confirmar presença: ");
                    int idxConfirma = scanner.nextInt();
                    scanner.nextLine();
                    if (idxConfirma >= 0 && idxConfirma < sistema.getEventos().size()) {
                        sistema.confirmarParticipacao(usuario, sistema.getEventos().get(idxConfirma));
                        System.out.println("Presença confirmada!");
                    } else {
                        System.out.println("Evento inválido.");
                    }
                    break;
             
            case 3:
                System.out.println("Digite seu nome: ");
                String nomeCancelar = scanner.nextLine();
                Usuario usuarioCancela = sistema.getUsuarios().stream()
                        .filter(u -> u.getNome().equalsIgnoreCase(nomeCancelar))
                        .findFirst()
                        .orElse(null);
                if (usuarioCancela == null){
                    System.out.println("Usuario não encontrado!");
                    break;
        }
                System.out.println("Digite o número de evento para cancelar presença: ");
                int idxCancela = scanner.nextInt();
                if (idxCancela >= 0 && idxCancela < sistema.getEventos().size()){
                    sistema.cancelarParticipacao(usuarioCancela, sistema.getEventos().get(idxCancela));
                    System.out.println("presença cancelada!");
                }else{
                    System.out.println("Evento inválido.");
                }
                break;
            case 4:
                System.out.print("Digite seu nome: ");
                String nomeLista = scanner.nextLine();
                Usuario usuarioLista = sistema.getUsuarios().stream()
                        .filter(u -> u.getNome().equalsIgnoreCase(nomeLista))
                        .findFirst()
                        .orElse(null);
                if(usuarioLista == null){
                    System.out.println("Usuário não encontrado!");
                    break;
                }
                System.out.println("Seus eventos confirmados:");
                for (Evento e : usuarioLista.getEventosConfirmados()){
                    System.out.println(e);
                }
                break;
            
            case 5:
                rodando = false;
                System.out.println("Saindo...");
                break;
            
                default:
                    System.out.println("Opção inválida.");
                
        
            }
    
         }
         scanner.close();
   
    }
    
}

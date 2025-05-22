package com.mycompany.sistemadeeventos;
import java.time.LocalDateTime;
    
 public class Evento implements Comparable <Evento> {
     public enum CategoriaEvento{
     FESTA,
     SHOW,
     EVENTO_ESPORTIVO
     }
     public boolean estaOcorrendoAgora() {
    LocalDateTime agora = LocalDateTime.now();
    return horario != null && horario.isBefore(agora.plusHours(2)) && horario.isAfter(agora.minusHours(2));
}

    private String nome;
    private String endereco;
    private String descricao;
    private CategoriaEvento categoria;
    private LocalDateTime horario; 
    
    public Evento(String nome, String endereco, String descricao, CategoriaEvento categoria, LocalDateTime horario){
        this.nome = nome;
        this.endereco = endereco;
        this.categoria = categoria;
        this.horario = horario;
    }
    
    public String getNome(){ return nome;}
    public String getEndereco(){return endereco; }
    public CategoriaEvento getCategoria() { return categoria; }
    public LocalDateTime getHorario(){ return horario; }
    
    @Override
    public String toString(){
        return nome + "|" + categoria +"|"+ endereco + "|" + horario +"|"+ descricao;
    }
    
    @Override
    public int compareTo(Evento outro){
        return this.horario.compareTo(outro.horario);
    }
    
    public boolean estaOcorrendoAgora(){
    LocalDateTime agora = LocalDateTime.now();
    
    LocalDateTime fim = horario.plusHours(2);
    return (agora.isEqual(horario) || agora.isAfter(horario)) && agora.isBefore(fim);
    }
}

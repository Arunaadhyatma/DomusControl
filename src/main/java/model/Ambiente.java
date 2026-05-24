package model;

import java.util.ArrayList;
import java.util.List;

public class Ambiente {
    
    public Ambiente() {
}
    
    private int id;
    private String nome;
    private List<Dispositivo> dispositivos;
    public Ambiente(int id, String nome) {
        this.id = id;
        this.nome = nome;
        dispositivos = new ArrayList<>();
    }
    
    public int getId() {return id;}
    public void setId(int id) {this.id = id;}
    
    public String getNome() {return nome;}
    public void setNome(String nome) {this.nome = nome;}
    
    public List<Dispositivo> getDispositivos() {return dispositivos;}
    public void adicionarDispositivo(Dispositivo dispositivo) {dispositivos.add(dispositivo);}
    public void removerDispositivo(Dispositivo dispositivo) {dispositivos.remove(dispositivo);}
    
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author gabri
 */
public class Dispositivo {
    private int id;
    private String nome;
    private TipoDispositivo tipo;
    private Ambiente ambiente;
    private String estado;
    
    public Dispositivo(String nome, TipoDispositivo tipo, Ambiente ambiente, String estado) {
        this.nome = nome;
        this.tipo = tipo;
        this.ambiente = ambiente;
        this.estado = estado;
    }
    
    public Dispositivo(int id, String nome, TipoDispositivo tipo, Ambiente ambiente, String estado) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.ambiente = ambiente;
        this.estado = estado;
    }

    public int getId() {return id;}
    public String getNome() {return nome;}
    public TipoDispositivo getTipo() {return tipo;}
    public Ambiente getAmbiente() {return ambiente;}
    public String getEstado() {return estado;}
    
    public void setId(int id) {this.id = id;}
    public void setNome(String nome) {this.nome = nome;}
    public void setTipo(TipoDispositivo tipo) {this.tipo = tipo;}
    public void setAmbiente(Ambiente ambiente) {this.ambiente = ambiente;}
    public void setEstado(String estado) {this.estado = estado;}
    
    public boolean isLigado() {
        return "LIGADO".equalsIgnoreCase(estado) || "LIGADA".equalsIgnoreCase(estado) || "ABERTO".equalsIgnoreCase(estado);
    }
    
    public void ligar() {
        this.estado = "LIGADO";
    }
    
    public void desligar() {
        this.estado = "DESLIGADO";
    }
}

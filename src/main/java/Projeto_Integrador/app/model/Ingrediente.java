/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Projeto_Integrador.app.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author henri
 */
@Entity
@Table(name = "ingredientes")
public class Ingrediente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ingredienteId")
    private int id;
    @Column
    private String nome;
    @Column
    private Float valor;
    @Column
    private Float quantidade;
    @Column
    private String tipo;
    
    @OneToMany(mappedBy = "ingrediente")
    private List<IngredienteReceita> receitas;

    public Ingrediente() {
    }

    public Ingrediente(int id, String nome, Float valor, Float quantidade, String tipo) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
        this.quantidade = quantidade;
        this.tipo = tipo;
    }

    public Ingrediente(String nome, Float valor, Float quantidade, String tipo) {
        this.nome = nome;
        this.valor = valor;
        this.quantidade = quantidade;
        this.tipo = tipo;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    public Float getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Float quantidade) {
        this.quantidade = quantidade;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public List<IngredienteReceita> getReceitas() {
        return receitas;
    }

    public void setReceitas(List<IngredienteReceita> receitas) {
        this.receitas = receitas;
    }

}

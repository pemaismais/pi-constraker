/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Projeto_Integrador.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author henri
 */
@Entity
@Table (name = "Produtos") 
public class Produto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ingredienteId")
    private int id;
    private String nome;
    private Float valor;
    private Float quantidade;
    private String tipo;
    
    @OneToMany(mappedBy = "produto", cascade = CascadeType.ALL)
    private List<ProdutoReceita> receitas;

    public Produto() {
    }

    public Produto(String nome, Float valor, Float quantidade, String tipo) {
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

    public List<ProdutoReceita> getReceitas() {
        return receitas;
    }

    public void setReceitas(List<ProdutoReceita> receitas) {
        this.receitas = receitas;
    }
    
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Projeto_Integrador.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author henri
 */
@Entity
@Table(name="Produto_Receitas")
public class ProdutoReceita implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;
    
    @ManyToOne
    @JoinColumn(name = "receita_id")
    private Receita receitaPrdt;
    
    private float quantidade;

    public ProdutoReceita() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Receita getReceita() {
        return receitaPrdt;
    }

    public void setReceita(Receita receitaPrdt) {
        this.receitaPrdt = receitaPrdt;
    }

    public float getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(float quantidade) {
        this.quantidade = quantidade;
    }
    
    
    
    
}

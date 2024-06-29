/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Projeto_Integrador.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
    private Float lucro;
    
    @OneToMany(mappedBy = "produto", cascade = CascadeType.ALL)
    private List<ProdutoReceita> receitas;

    public Produto() {
    }

    public Produto(String nome, Float valor, Float quantidade, String tipo, Float lucro) {
        this.nome = nome;
        this.valor = valor;
        this.quantidade = quantidade;
        this.tipo = tipo;
        this.lucro = lucro;
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

    public Float getLucro() {
        return lucro;
    }

    public void setLucro(Float lucro) {
        this.lucro = lucro;
    }
    

    public void setReceitas(List<ProdutoReceita> receitas) {
        this.receitas = receitas;
    }
    public Map<String, String> getReceitasEQuantidades() {
        Map<String, String> receitasEQuantidades = new HashMap<>();
        for (ProdutoReceita produtoReceita : this.receitas) {
            String IdENome = produtoReceita.getReceita().getId() + " " + produtoReceita.getReceita().getNome();
            String quantidade = String.valueOf(produtoReceita.getQuantidade());
            receitasEQuantidades.put(IdENome, quantidade);
        }
        return receitasEQuantidades;
    }
    
}

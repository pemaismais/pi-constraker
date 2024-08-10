/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Projeto_Integrador.app.model.DTO;

import Projeto_Integrador.app.model.ProdutoReceita;

import java.util.List;

/**
 *
 * @author henri
 */
public class ProdutoDTO {
    private int id;
    private String nome;
    private String valor;
    private String quantidade;
    private String tipo;
    private float  lucro;
    private List<ProdutoReceita> receitas;

    public ProdutoDTO() {
    }

    public ProdutoDTO( String nome, String valor, String quantidade, String tipo, float lucro) {
        this.nome = nome;
        this.valor = valor;
        this.quantidade = quantidade;
        this.tipo = tipo;
        this.lucro = lucro;
    }

    public ProdutoDTO(int id, String nome, String valor, String quantidade, String tipo, float lucro) {
        this.id = id;
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

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(String quantidade) {
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

    public float getLucro() {
        return lucro;
    }

    public void setLucro(float lucro) {
        this.lucro = lucro;
    }
  
    
    
    

}

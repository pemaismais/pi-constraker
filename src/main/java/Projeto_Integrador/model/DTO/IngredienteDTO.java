/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Projeto_Integrador.model.DTO;

import Projeto_Integrador.model.IngredienteReceita;
import java.util.List;

/**
 *
 * @author henri
 */
public class IngredienteDTO {

    private int id;
    private String nome;
    private Float valor;
    private Float quantidade;
    private String valorStr;
    private String quantidadeStr;
    private String tipo;
    private List<IngredienteReceita> receitas;

    public IngredienteDTO() {
    }
    public IngredienteDTO(int id, String nome, String valorStr, String quantidadeStr, String tipo) {
        this.id = id;
        this.nome = nome;
        this.valorStr = valorStr;
        this.quantidadeStr = quantidadeStr;
        this.tipo = tipo;
    }
    public IngredienteDTO(String nome, String valorStr, String quantidadeStr, String tipo) {
        this.nome = nome;
        this.valorStr = valorStr;
        this.quantidadeStr = quantidadeStr;
        this.tipo = tipo;
    }
    
    public IngredienteDTO(int id, String nome, Float valor, Float quantidade, String tipo) {
        this.id = id;
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

    public String getValorStr() {
        return valorStr;
    }

    public void setValorStr(String valorStr) {
        this.valorStr = valorStr;
    }

    public String getQuantidadeStr() {
        return quantidadeStr;
    }

    public void setQuantidadeStr(String quantidadeStr) {
        this.quantidadeStr = quantidadeStr;
    }
    
    
    
    
}

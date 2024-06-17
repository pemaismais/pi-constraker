/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Projeto_Integrador.model.DTO;

import Projeto_Integrador.model.IngredienteReceita;
import java.util.List;
import java.util.Set;

/**
 *
 * @author henri
 */
public class ReceitaDTO {

    private int id;
    private String nome;
    private String valorStr;
    private String quantidadeStr;
    private float valor;
    private float quantidade;
    private String tipo;
    private Set<Integer> IngredientesIds;
    private List<IngredienteReceita> ingredientesEQtd;

    public List<IngredienteReceita> getIngredientesEQtd() {
        return ingredientesEQtd;
    }

    public void setIngredientesEQtd(List<IngredienteReceita> ingredientesEQtd) {
        this.ingredientesEQtd = ingredientesEQtd;
    }

    public ReceitaDTO() {
    }

    public ReceitaDTO(int id, String nome, float valor, float quantidade, String tipo) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
        this.quantidade = quantidade;
        this.tipo = tipo;
    }

    public ReceitaDTO(int id, String nome, String valor, String quantidade, String tipo) {
        this.id = id;
        this.nome = nome;
        this.valorStr = valor;
        this.quantidadeStr = quantidade;
        this.tipo = tipo;
    }

    public ReceitaDTO(String nome, String valor, String quantidade, String tipo) {
        this.nome = nome;
        this.valorStr = valor;
        this.quantidadeStr = quantidade;
        this.tipo = tipo;
    }

    public ReceitaDTO(int id, String nome, String valor, String quantidade, String tipo, Set<Integer> IngredientesIds) {
        this.id = id;
        this.nome = nome;
        this.valorStr = valor;
        this.quantidadeStr = quantidade;
        this.tipo = tipo;
        this.IngredientesIds = IngredientesIds;
    }

    public ReceitaDTO(String nome, String valor, String quantidade, String tipo, Set<Integer> IngredientesIds) {
        this.nome = nome;
        this.valorStr = valor;
        this.quantidadeStr = quantidade;
        this.tipo = tipo;
        this.IngredientesIds = IngredientesIds;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public float getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(float quantidade) {
        this.quantidade = quantidade;
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

    public String getValorStr() {
        return valorStr;
    }

    public void setValorStr(String valorStr) {
        this.valorStr = valorStr;
    }

    public String getQuantidadeStr() {
        return this.quantidadeStr;
    }

    public void setQuantidadeStr(String quantidadeStr) {
        this.quantidadeStr = quantidadeStr;
    }

    public String getTipo() {
        return this.tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Set<Integer> getIngredientesIds() {
        return IngredientesIds;
    }

    public void setReceitaIds(Set<Integer> IngredientesIds) {
        this.IngredientesIds = IngredientesIds;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Projeto_Integrador.model;

import Projeto_Integrador.utils.Utils;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.*;
import javax.persistence.Table;

/**
 *
 * @author henri
 */
@Entity
@Table(name = "receitas")
public class Receita implements Serializable {

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

    @OneToMany(mappedBy = "receita", cascade = CascadeType.ALL)
    private List<IngredienteReceita> ingredientes;
    
    @OneToMany(mappedBy = "receitaPrdt", cascade = CascadeType.ALL)
    private List<ProdutoReceita> produtos;
    
    public Receita() {
    }

    
    public List<IngredienteReceita> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<IngredienteReceita> ingredientes) {
        this.ingredientes = ingredientes;
    }

    public Receita(int id, String nome, Float valor) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;

    }

    public Receita(int id, String nome, Float valor, Float quantidade, String tipo, List<IngredienteReceita> ingredientes) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
        this.ingredientes = ingredientes;
    }

    public Receita(String nome, Float valor, Float quantidade, String tipo) {
        this.nome = nome;
        this.valor = valor;
        this.quantidade = quantidade;
        this.tipo = tipo;
    }

    public Receita(int id, String nome, Float valor, Float quantidade, String tipo) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
        this.quantidade = quantidade;
        this.tipo = tipo;
    }

    public Float getQuantidade() {
        return quantidade;
    }

    public List<ProdutoReceita> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<ProdutoReceita> produtos) {
        this.produtos = produtos;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void getId(int id) {
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

    public List<String> getIngredientesEQuantidades() {
        List<String> ingredientesQuantidades = new ArrayList<>();
        for (IngredienteReceita ingredienteReceita : ingredientes) {
            String nomeIngrediente = ingredienteReceita.getIngrediente().getNome();
            Float quantidade = ingredienteReceita.getQuantidade();
            String ingredienteQuantidade = nomeIngrediente + ": " + quantidade;
            ingredientesQuantidades.add(ingredienteQuantidade);
        }
        return ingredientesQuantidades;
    }
    public Map<String, String> getIngredientesEQuantidades2() {
        Map<String, String> ingredientesEQuantidades = new HashMap<>();
        for (IngredienteReceita ingredienteReceita : ingredientes) {
            String IdENome = ingredienteReceita.getIngrediente().getId() + " " + ingredienteReceita.getIngrediente().getNome();
            String quantidade = String.valueOf(ingredienteReceita.getQuantidade());
            ingredientesEQuantidades.put(IdENome, quantidade);
        }
        return ingredientesEQuantidades;
    }

    public void removerTodosIngredientes() throws SQLException {
        EntityManager em = null;
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
            em = emf.createEntityManager();
            em.getTransaction().begin();

            // Verifica se a lista de ingredientes não é nula
            if (ingredientes != null) {
                // Itera sobre a lista de ingredientes e remove cada um deles
                for (IngredienteReceita ingredienteReceita : ingredientes) {
                    // Remove a entrada de ingrediente da receita
                    ingredienteReceita.getIngrediente().getReceitas().remove(ingredienteReceita);
                              // Remove a associação IngredienteReceita do banco de dados
                em.remove(ingredienteReceita);
                }
                // Limpa a lista de ingredientes da receita
                ingredientes.clear();
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            // Em caso de exceção, faz rollback da transação
            if (em != null && em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new SQLException("Erro na comunicação com o banco de dados: " + e.getMessage(), e);
        }
    }

}

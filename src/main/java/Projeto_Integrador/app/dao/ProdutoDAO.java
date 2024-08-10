/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Projeto_Integrador.app.dao;

import Projeto_Integrador.app.model.Produto;
import Projeto_Integrador.app.model.ProdutoReceita;

import javax.persistence.*;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author henri
 */
public class ProdutoDAO {

    private EntityManager em;

    public ProdutoDAO() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        this.em = emf.createEntityManager();
    }

    public void beginTransaction() {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
    }

    public void commitTransaction() {
        EntityTransaction transaction = em.getTransaction();
        transaction.commit();
    }

    public Produto insert(Produto produto) {
        em.persist(produto);
        return produto;
    }

    public Produto update(Produto produto) {
        em.merge(produto);
        em.persist(produto);
        return produto;
    }

    public Produto selectById(int id) throws SQLException {
        try {
            Produto produto = em.find(Produto.class, id);
            return produto;
        } catch (Exception e) {
            e.printStackTrace();
            throw new SQLException("Erro: " + e.getMessage(), e);
        }
    }

    public void delete(Produto produto) {
        em.remove(produto);
    }

    public void close() {
        em.close();
    }

    public List<Produto> selectAll() throws SQLException {
        try {
            String jpql = "SELECT e FROM Produto AS e";
            Query query = em.createQuery(jpql);
            List<Produto> produtos = query.getResultList();
            return produtos;
        } catch (Exception e) {
            e.printStackTrace();
            throw new SQLException("Erro na comunicaçao com o banco de dados: " + e.getMessage(), e);
        }
    }

    public boolean cadastrarProduto(Produto produto) throws SQLException {
        try {
            beginTransaction();
            insert(produto);
            commitTransaction();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            throw new SQLException("Erro na comunicaçao com o banco de dados: " + e.getMessage(), e);
        }
    }
        public boolean removerProduto(int idProduto) throws SQLException {
        try {
            beginTransaction();
            Produto produto = selectById(idProduto);
            delete(produto);
            commitTransaction();
            return true;
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new SQLException("Erro na comunicaçao com o banco de dados: " + e.getMessage(), e);
        }
    }
    public void removerTodasReceitas(int id) throws SQLException {
        try {
            Produto produto = selectById(id);
            List<ProdutoReceita> receitas = produto.getReceitas();
            beginTransaction();
           
            // Verifica se a lista de ingredientes não é nula
            if (receitas != null) {
                // Itera sobre a lista de ingredientes e remove cada um deles
                for (ProdutoReceita produtoReceita : receitas) {
                    // Remove a entrada de ingrediente da receita
                    produtoReceita.getReceita().getProdutos().remove(produtoReceita);
                              // Remove a associação IngredienteReceita do banco de dados
                em.remove(produtoReceita);
                }
                // Limpa a lista de ingredientes da receita
                receitas.clear();
            }
            commitTransaction();
        } catch (Exception e) {
            // Em caso de exceção, faz rollback da transação
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new SQLException("Erro na comunicaçao com o banco de dados: " + e.getMessage(), e);
        }
    }
        public boolean alterarProduto(Produto novoProduto) throws SQLException {
        try {
            beginTransaction();
            if (selectById(novoProduto.getId()) != null) {
                em.merge(novoProduto);
                commitTransaction();
                return true;
            } else {
                return false; // Retorna false se a receita não existir no banco de dados
            }
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new SQLException("Erro na comunicaçao com o banco de dados: " + e.getMessage(), e);
        }
    }
}

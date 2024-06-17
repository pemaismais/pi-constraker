/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Projeto_Integrador.dao;

import Projeto_Integrador.model.IngredienteReceita;
import Projeto_Integrador.model.Receita;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author henri
 */
public class ReceitaDAO {

    private EntityManager em;

    public ReceitaDAO() {
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

    public Receita insert(Receita receita) {
        em.persist(receita);
        return receita;
    }

    public Receita update(Receita receita) {
        em.merge(receita);
        em.persist(receita);
        return receita;
    }

    public Receita selectById(int id) throws SQLException {
        try {
            Receita receita = em.find(Receita.class, id);
            return receita;
        } catch (Exception e) {
            e.printStackTrace();
            throw new SQLException("Erro:" + e.getMessage(), e);
        }
    }

    public void delete(Receita receita) {
        em.remove(receita);
    }

    public void close() {
        em.close();
    }

    public List<Receita> selectAll() throws SQLException {
        try {
            String jpql = "SELECT e FROM Receita AS e";
            Query query = em.createQuery(jpql);
            List<Receita> receitas = query.getResultList();
            return receitas;
        } catch (Exception e) {
            e.printStackTrace();
            throw new SQLException("Erro na comunicaçao com o banco de dados: " + e.getMessage(), e);
        }
    }

    public boolean cadastrarReceita(Receita receita) throws SQLException {
        try {
            beginTransaction();
            insert(receita);
            commitTransaction();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            throw new SQLException("Erro na comunicaçao com o banco de dados: " + e.getMessage(), e);
        }
    }

    public boolean removerReceita(int idReceita) throws SQLException {
        try {
            beginTransaction();
            Receita receita = selectById(idReceita);
            delete(receita);
            commitTransaction();
            return true;
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new SQLException("Erro na comunicaçao com o banco de dados: " + e.getMessage(), e);
        }
    }

    public boolean alterarReceita(Receita novaReceita) throws SQLException {
        try {
            beginTransaction();
            if (selectById(novaReceita.getId()) != null) {
                em.merge(novaReceita);
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

    public void removerTodosIngredientes(int id) throws SQLException {
        try {
            Receita receita = selectById(id);
            List<IngredienteReceita> ingredientes = receita.getIngredientes();
            beginTransaction();

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
            commitTransaction();
        } catch (Exception e) {
            // Em caso de exceção, faz rollback da transação
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new SQLException("Erro na comunicaçao com o banco de dados: " + e.getMessage(), e);
        }
    }

}

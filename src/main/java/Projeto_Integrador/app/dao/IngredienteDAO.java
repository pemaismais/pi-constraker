/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Projeto_Integrador.app.dao;

import Projeto_Integrador.app.model.Ingrediente;

import javax.persistence.*;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author henri
 */
public class IngredienteDAO {

    private EntityManager em;

    public IngredienteDAO() {
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

    public Ingrediente insert(Ingrediente ingrediente) {
        em.persist(ingrediente);
        return ingrediente;
    }

    public Ingrediente update(Ingrediente ingrediente) {
        em.merge(ingrediente);
        em.persist(ingrediente);
        return ingrediente;
    }

    public Ingrediente selectById(int id) throws SQLException {
        try {
            Ingrediente ingrediente = em.find(Ingrediente.class, id);
            return ingrediente;
        } catch (Exception e) {
            e.printStackTrace();
            throw new SQLException("Erro: " + e.getMessage(), e);
        }
    }

    public void delete(Ingrediente ingrediente) {
        em.remove(ingrediente);
    }

    public List<Ingrediente> selectAll() throws SQLException {
        try {
            String jpql = "SELECT e FROM Ingrediente AS e";
            Query query = em.createQuery(jpql);
            List<Ingrediente> ingredientes = query.getResultList();
            return ingredientes;
        } catch (Exception e) {
            e.printStackTrace();
            throw new SQLException("Erro na comunicaçao com o banco de dados: " + e.getMessage(), e);
        }
    }

    public boolean cadastrarIngrediente(Ingrediente ingrediente) throws SQLException {
        try {
            em.clear();
            beginTransaction();
            insert(ingrediente);
            commitTransaction();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            throw new SQLException("Erro na comunicaçao com o banco de dados: " + e.getMessage(), e);
        }
    }

    public void removerIngrediente(int id) throws SQLException {
        try {
            beginTransaction();
            Ingrediente ingrediente = selectById(id);
            delete(ingrediente);
            commitTransaction();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            Throwable lastCause = getLastCause(e);
            throw new SQLException("Erro na comunicaçao com o banco de dados: " + lastCause.getMessage(), lastCause);
        }
    }

    public boolean alterarIngrediente(Ingrediente novoIngrediente) throws SQLException {
        try {
            beginTransaction();
            if (selectById(novoIngrediente.getId()) != null) {
                em.merge(novoIngrediente);
                commitTransaction();
                return true;
            } else {
                if (em.getTransaction().isActive()) {
                    em.getTransaction().rollback();
                }
                return false;
            }
        } catch (IllegalArgumentException e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
            throw new SQLException("Erro na comunicaçao com o banco de dados: " + e.getMessage(), e);
        }
    }

    private Throwable getLastCause(Throwable throwable) {
        Throwable cause = throwable;
        while (cause.getCause() != null) {
            cause = cause.getCause();
        }
        return cause;
    }
}

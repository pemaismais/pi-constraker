/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Projeto_Integrador.model.DTO;

import Projeto_Integrador.model.Produto;
import Projeto_Integrador.model.Receita;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author henri
 */
public class ProdutoReceitaDTO {

    private int id;
    private Produto produto;
    private Receita receitaPrdt;
    private float quantidade;
}

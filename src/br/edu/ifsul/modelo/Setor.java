/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author DanielPrigol
 */

@Entity
@Table(name = "setor")
public class Setor implements Serializable{
    @Id
    @SequenceGenerator(name = "seq_setor", sequenceName = "seq_setor_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_setor", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @NotBlank(message = "O nome deve ser informado")
    @Length(max = 50, message = "O nome não deve ultrapassar {max} caracteres")    
    @Column(name = "nome", length = 50, nullable = false)
    private String nome;
    
    @NotBlank(message = "O tipo deve ser informado")
    @Length(max = 50, message = "O tipo não deve ultrapassar {max} caracteres")    
    @Column(name = "tipo", length = 50, nullable = false)
    private String tipo;
    
    @Column(name = "qtd_funcionario", nullable = false, columnDefinition = "numeric(12,2)")
    private Double qtdFuncionario;
    
    //@OneToMany(mappedBy = "qtd_funcionario", cascade = CascadeType.ALL,
    //        orphanRemoval = true, fetch = FetchType.LAZY)
    //private List<Usuario> qtdFuncionario = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "atuacoes",
            joinColumns = 
            @JoinColumn(name = "setor", referencedColumnName = "id", 
                    nullable = false),
            inverseJoinColumns = 
            @JoinColumn(name = "usuario", referencedColumnName = "id", 
                    nullable = false))
    private List<Funcionario> atuam = new ArrayList<>();
    
    
    public Setor() {
        
    }
    
    
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

   

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Setor other = (Setor) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

   

    
    

    public Double getQtdFuncionario() {
        return qtdFuncionario;
    }

    public void setQtdFuncionario(Double qtdFuncionario) {
        this.qtdFuncionario = qtdFuncionario;
    }

    public List<Funcionario> getAtuam() {
        return atuam;
    }

    public void setAtuam(List<Funcionario> atuam) {
        this.atuam = atuam;
    }

    @Override
    public String toString() {
        return "Setor{" + "id=" + id + ", nome=" + nome + ", tipo=" + tipo + ", qtdFuncionario=" + qtdFuncionario + ", atuam=" + atuam + '}';
    }

    

    
    

    

    

   
    
    
}

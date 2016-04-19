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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

/**
 *
 * @author DanielPrigol
 */
@Entity
@Table(name = "filial")
public class Filial implements Serializable{
    @Id
    @SequenceGenerator(name = "seq_filial", sequenceName = "seq_filial_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_filial", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @NotBlank(message = "O nome deve ser informado")
    @Length(max = 14, message = "O nome não deve ter mais que {max} caracteres")
    @Column(name = "nome", length = 14, nullable = false)
    private String nome;
    
    @NotBlank(message = "O nome fantasia deve ser informado")
    @Length(max = 14, message = "O nome fantasia não deve ter mais que {max} caracteres")
    @Column(name = "nome_fantasia", length = 14, nullable = false)
    private String nomeFantasia;
    
    
    @NotBlank(message = "O cnpj deve ser informado")
    @Length(max = 14, message = "O cnpj não deve ter mais que {max} caracteres")
    @Column(name = "cnpj", length = 14, nullable = false)
    private String cnpj;
    
    @NotBlank(message = "O endereço deve ser informado")
    @Length(max = 14, message = "O endereço não deve ter mais que {max} caracteres")
    @Column(name = "endereco", length = 14, nullable = false)
    private String endereco;
    
    
    

    public Filial() {
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

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.id);
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
        final Filial other = (Filial) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Filial{" + "id=" + id + ", nome=" + nome + ", nomeFantasia=" + nomeFantasia + ", cnpj=" + cnpj + ", endereco=" + endereco + '}';
    }

    

    

    

    

    
    
    
    
}

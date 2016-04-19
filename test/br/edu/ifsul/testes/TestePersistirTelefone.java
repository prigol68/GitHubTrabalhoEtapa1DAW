package br.edu.ifsul.testes;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.Cidade;
import br.edu.ifsul.modelo.Telefone;
import br.edu.ifsul.modelo.Usuario;
import java.util.Calendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author daniel prigol
 */
public class TestePersistirTelefone {

    EntityManager em;

    public TestePersistirTelefone() {
    }

    @Before
    public void setUp() {                       
        em = em = EntityManagerUtil.getEntityManager();
    }

    @After
    public void tearDown() {
        em.close();
        
        
    }

    @Test
    public void teste() {
        boolean exception = false;
        try {
            Usuario usu = em.find(Usuario.class, 1);
            Telefone t = new Telefone();
            t.setNumero("(54) 9999 9999");
            t.setOperadora("21");
            t.setDescricao("Celular");
            usu.adicionarTelefone(t);
            
            em.getTransaction().begin();
            em.persist(usu);
            em.getTransaction().commit();
        } catch (Exception e) {
            exception = true;
            e.printStackTrace();
        }
        // verificando se o resultado é igual ao esperado
        Assert.assertEquals(false, exception);
    }

}
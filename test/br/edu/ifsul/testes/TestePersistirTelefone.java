package br.edu.ifsul.testes;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import br.edu.ifsul.testes.*;
import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.Cidade;
import br.edu.ifsul.modelo.Estado;
import br.edu.ifsul.modelo.Telefone;
import br.edu.ifsul.modelo.Usuario;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.persistence.EntityManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


/**
 *
 * @author DanielPrigol
 */
public class TestePersistirTelefone {
    
    EntityManager em;
    
    public TestePersistirTelefone() {
        
    }
    
    @Before
    public void setUp() {
       em = EntityManagerUtil.getEntityManager();
        
    }
    
    @After
    public void tearDown() {
        em.close();
    }
    
    @Test
    public void test() {
        Boolean exception = false;
        try{
            Usuario usu = em.find(Usuario.class, 1);
            Telefone t = new Telefone();
            t.setNumero("(54) 1111 2222");
            t.setDescricao("Celular");
            usu.adicionarTelefone(t);
            
            em.getTransaction().begin();
            em.persist(usu);
            em.getTransaction().commit();
        }catch(Exception e){
            exception = true;
            e.printStackTrace();
        }
        Assert.assertEquals(false, exception);
    }
    
}

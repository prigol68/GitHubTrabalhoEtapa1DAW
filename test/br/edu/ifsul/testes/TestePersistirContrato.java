/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.Contrato;
import br.edu.ifsul.modelo.Funcionario;
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
public class TestePersistirContrato {
    
    EntityManager em;
    
    public TestePersistirContrato() {
        
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
            Contrato c = new Contrato();
            c.setSalario(5000.00);
            c.setDataAdm(new GregorianCalendar(2012, Calendar.JANUARY, 21));
            c.setDataDemissao(new GregorianCalendar());
            c.setStatus(true);
            
            em.getTransaction().begin();
            em.persist(c);
            em.getTransaction().commit();
        }catch(Exception e){
            exception = true;
            e.printStackTrace();
        }
        Assert.assertEquals(false, exception);
    }
    
}

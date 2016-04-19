/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.Estado;
import br.edu.ifsul.modelo.Filial;
import br.edu.ifsul.modelo.Pais;
import br.edu.ifsul.modelo.Usuario;
import javax.persistence.EntityManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


/**
 *
 * @author DanielPrigol
 */
public class TestePersistirFilial {
    
    EntityManager em;
    
    public TestePersistirFilial() {
        
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
            Filial f = new Filial();
            f.setNome("prigol&cia");
            f.setNomeFantasia("Marketing Digital");
            f.setEndereco("Rua: Lalala");
            f.setCnpj("53.353.464/0001-48");

            em.getTransaction().begin();
            em.persist(f);
            em.getTransaction().commit();
        }catch(Exception e){
            exception = true;
            e.printStackTrace();
        }
        Assert.assertEquals(false, exception);
    }
    
}


package br.edu.ifsul.testes;

import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.Pais;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

/**
 *
 * @author DanielPrigol
 */
public class TesteEntityManagerUtil {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManager em = EntityManagerUtil.getEntityManager();
        Pais m = new Pais();
        m.setNome("Alemanha");
        Validator validador = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<Pais>> erros = validador.validate(m);
        if (erros.size() > 0){
            for (ConstraintViolation<Pais> erro : erros){
                System.out.println("Erro: "+erro.getMessage());
            }    
        } else {
            em.getTransaction().begin();
            em.persist(m);
            em.getTransaction().commit();         
        }
        

    }

}

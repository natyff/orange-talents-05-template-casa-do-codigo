package br.com.zupacademy.natalia.casadocodigo.validacao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;


public class ExistIdValidator implements ConstraintValidator<ExistId, Object> {

    private String attibute;
    private Class<?> classe;
    @PersistenceContext
    private EntityManager em;

    @Override
    public void initialize(ExistId param) {
        attibute = param.fieldValue();
        classe = param.domainClass();
    }

    @Override
    public boolean isValid(Object s, ConstraintValidatorContext constraintValidatorContext) {
        Query query = em.createQuery("select 1 from " + classe.getName()+ " where "+attibute+" =:value");
        query.setParameter("value", s);
        List<?> list = query.getResultList();
        if(list.size() < 1){
            return false;
        }
        return true;

    }
}

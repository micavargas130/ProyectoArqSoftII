package ar.edu.ucc.arqSoft.baseService.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import ar.edu.ucc.arqSoft.baseService.model.Tarea;
import ar.edu.ucc.arqSoft.common.dao.GenericDaoImp;

@Repository
public class TareaDaoImp extends GenericDaoImp<Tarea, Long> implements TareaDao{
	
	@Override
	public List<Tarea> findByName(String name) {
		CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Tarea> criteria = builder.createQuery(Tarea.class);
        Root<Tarea> entity = criteria.from(Tarea.class);

        criteria.select(entity).where(builder.equal(entity.get("name"), name));
        return em.createQuery(criteria).getResultList();
	}

}

package ar.edu.ucc.arqSoft.baseService.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import ar.edu.ucc.arqSoft.baseService.model.Proyecto;
import ar.edu.ucc.arqSoft.common.dao.GenericDaoImp;
@Repository
public class ProyectoDaoImp extends GenericDaoImp<Proyecto, Long> implements ProyectoDao{

	@Override
	public List<Proyecto> findByName(String name) {
		CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Proyecto> criteria = builder.createQuery(Proyecto.class);
        Root<Proyecto> entity = criteria.from(Proyecto.class);

        criteria.select(entity).where(builder.equal(entity.get("name"), name));
        return em.createQuery(criteria).getResultList();
	}
}

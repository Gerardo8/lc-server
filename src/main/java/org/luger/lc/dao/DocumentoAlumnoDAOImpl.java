package org.luger.lc.dao;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.luger.lc.model.DocumentoAlumno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@SuppressWarnings("unchecked")
@Repository("documentoAlumnoDAO")
public class DocumentoAlumnoDAOImpl implements DocumentoAlumnoDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public DocumentoAlumno findById(Integer id) {
        return (DocumentoAlumno) sessionFactory.getCurrentSession().get(DocumentoAlumno.class, id);
    }

    @Override
    public DocumentoAlumno findByAlumnoId(Integer id) {
        return (DocumentoAlumno) sessionFactory.getCurrentSession().createCriteria(DocumentoAlumno.class)
                    .add(Restrictions.eq("alumno.id", id)).uniqueResult();
    }

    @Override
    public void persist(DocumentoAlumno documentoAlumno) {
        sessionFactory.getCurrentSession().persist(documentoAlumno);
    }

    @Override
    public void update(DocumentoAlumno documentoAlumno) {
        sessionFactory.getCurrentSession().update(documentoAlumno);
    }

    @Override
    public void delete(DocumentoAlumno documentoAlumno) {
        sessionFactory.getCurrentSession().delete(documentoAlumno);
    }

    @Override
    public List<DocumentoAlumno> findAll() {
        return sessionFactory.getCurrentSession().createCriteria(DocumentoAlumno.class).list();
    }

    @Override
    public void deleteAll() {
        findAll().forEach(this::delete);
    }
}

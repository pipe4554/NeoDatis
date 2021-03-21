package dao;

import java.util.ArrayList;
import java.util.List;

import org.neodatis.odb.ODB;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

import models.Profesor;

public class ProfesorDao implements DAO<Profesor> {

    public List<Profesor> getAll(ODB odb) {
        List <Profesor> profesores = new ArrayList<Profesor>();

        IQuery query = new CriteriaQuery(Profesor.class);
        org.neodatis.odb.Objects<Profesor> objectProfesores = odb.getObjects(query);

        while(objectProfesores.hasNext()) {
            profesores.add(objectProfesores.next());
        }

        return profesores;
    }

    public void save(Profesor t, ODB odb) {
        odb.store(t);
    }
}

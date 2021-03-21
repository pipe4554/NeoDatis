package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.neodatis.odb.ODB;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

import models.Asignatura;

public class AsignaturaDao implements DAO<Asignatura> {

    public List<Asignatura> getAll(ODB odb) { //metodo para añadir las asignaturas en la DB
    	
        ArrayList<Asignatura> asignaturas = new ArrayList();
        IQuery query = new CriteriaQuery(Asignatura.class);
        org.neodatis.odb.Objects<Asignatura> objectsAsignaturas = odb.getObjects(query);

        while (objectsAsignaturas.hasNext()) {
            asignaturas.add(objectsAsignaturas.next());
        }
        
        return asignaturas;
    }

    public void save(Asignatura t, ODB odb) {
        odb.store(t);
    }
}

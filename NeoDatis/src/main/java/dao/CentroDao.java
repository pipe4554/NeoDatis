package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.neodatis.odb.ODB;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

import models.Centro;

public class CentroDao implements DAO<Centro> {

    public List<Centro> getAll(ODB odb) {
        List <Centro> centros = new ArrayList<Centro>();

        IQuery query = new CriteriaQuery(Centro.class);
        org.neodatis.odb.Objects<Centro> objectCentros = odb.getObjects(query);

        while(objectCentros.hasNext()) {
            centros.add(objectCentros.next());
        }

        return centros;
    }

    public void save(Centro t, ODB odb) {
        odb.store(t);
    }
}

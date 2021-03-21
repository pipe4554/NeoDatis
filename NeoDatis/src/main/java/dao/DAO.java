package dao;

import java.util.List;

import org.neodatis.odb.ODB;

public interface DAO<T> {
	//obtener y guardar todos los objetos
    public List <T> getAll(ODB odb); 

    public void save(T t, ODB odb); 
    
}

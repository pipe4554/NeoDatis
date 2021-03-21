package app;

import java.util.*;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;

import dao.*;
import models.*;

public class Main {

    private static Scanner sc = new Scanner(System.in);
    private static ODB odb = ODBFactory.open("test.neodatis"); //se inicia la base de datos
    //se crea los objetos que conforman la base de datos 
    private static CentroDao centroDao = new CentroDao();
    private static ProfesorDao profesorDao = new ProfesorDao();
    private static AsignaturaDao asignaturaDao = new AsignaturaDao();

    public static void main(String[] args) {

        int opcion = 10;

        while (opcion != 0) {
            System.out.println("1. Poblar base de datos\n2. Listar todos los centros\n3. Listar todos los profesores"
                    + "\n4. Listar profesores de un centro\n5. Listar todos los profesores"
                    + "de un centro cuya fecha de nacimiento sea anterior a 1993\n6. Listar todos los profesores de sexo masculino"
                    + "que impartan la asignatura de Acceso a Datos\n7. Comprobar que un profesor ya existe\n\n0. Salir");

            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    poblarBD();
                    break;

                case 2:
                    listarCentros();
                    break;

                case 3:
                    listarProfesores();
                    break;

                case 4:
                    listarProfesoresCentro();
                    break;

                case 5:
                    listarProfesoresNac();
                    break;

                case 6:
                    listarProfesoresMA();
                    break;

                case 7:
                    comprobarProfesor();
                    break;

                default:
                    break;
            }
        }
        System.out.println("FIN DEL PROGRAMA");
    }

    static void listarCentros() {
    	//listar todos los centros
        for (Centro c : centroDao.getAll(odb)) {
            System.out.println(c.toString());
        }
    }

    static void listarProfesores() {
    	//listar todos los profesores
        for (Profesor p : profesorDao.getAll(odb)) {
            System.out.println(p.toString());
        }
    }

    static void listarProfesoresCentro() {
    	//profesores de un centro
        System.out.println("Introduzca el codigo de centro del cual quieres saber que profesores trabajan ahi");
        int cod = sc.nextInt();

        for (Centro c : centroDao.getAll(odb)) { //recorre todos los centros de la DB
            if (c.getCod_centro() == cod) { // compara los codigos de los centros con el introducido por el usuario
                for (Profesor p : c.getProfesores()) { 
                    System.out.println(p.toString()); //imprime los profesores que del centro
                }
            }
        }
    }

    static void listarProfesoresNac() {
    	//listar los profesores cuya fecha de nacimiento sea inferior a 1993
        for (Profesor p : profesorDao.getAll(odb)) { //recorre todos los profesores de la DB
            int year = Integer.parseInt(p.getFechaNacimiento().substring(6, 10)); //consigue la posicion del año en el String de FechaNacimiento
            if (year < 1993) {
                System.out.println(p); 
            }
        }
    }

    static void listarProfesoresMA() {
    	//Listar los profesores con sexo masculino que impartan la asignatura de “Acceso a datos”.
        for (Profesor p : profesorDao.getAll(odb)) { //recorre los profesores 
            for (Asignatura a : p.getAsignaturas()) { //recorre las asignaturas 
                if (p.getSexo().equals("M") && a.getNombre().equals("Acceso a datos")) { // doble condicion: la variable sexo == M && nombreAsignatura == Acceso a datos 
                    System.out.println(p.toString());
                }
            }
        }
    }

    static void comprobarProfesor() {
    	
        System.out.println("Introduzca el codigo de profesor para comprobar su existencia");
        int codigo = sc.nextInt();

        for (Profesor p : profesorDao.getAll(odb)) {
            if (p.getCod_profesor() == codigo) { //compara el codigo introducido con los de la base de datos
                System.out.println(p.toString());
            }
        }
    }

    static void poblarBD() {

        // Creacion de 2 centros
        Centro c1 = new Centro(1, "Juan Pablo Bonet", "C/La Compuerta", "Zaragoza", "Zaragoza");
        Centro c2 = new Centro(2, "Espartidero", "C/Espartidero", "Zaragoza", "Zaragoza");

        // Crecion de 6 profesores
        Profesor p1 = new Profesor(1, "Carlos", "Tardez", "M", "21/10/2001");
        Profesor p2 = new Profesor(2, "Angela", "Berdiel", "F", "29/07/2001");
        Profesor p3 = new Profesor(3, "Oscar", "Martinez", "M", "02/02/1994");
        Profesor p4 = new Profesor(4, "Samuel", "Sierra", "M", "17/04/1992");
        Profesor p5 = new Profesor(5, "Marcos", "Tardez", "M", "21/02/1997");
        Profesor p6 = new Profesor(6, "Pedro", "Sancho", "M", "19/11/1990");

        // Creacion de 8 asignaturas
        Asignatura a1 = new Asignatura(1, "PSP");
        Asignatura a2 = new Asignatura(2, "Acceso a datos");
        Asignatura a3 = new Asignatura(3, "Programacion multimedia");
        Asignatura a4 = new Asignatura(4, "Desarrollo de interfaces");
        Asignatura a5 = new Asignatura(5, "Bases de datos");
        Asignatura a6 = new Asignatura(6, "Programacion");
        Asignatura a7 = new Asignatura(7, "Lenguaje de Marcas");
        Asignatura a8 = new Asignatura(8, "Ingles");

        // Asignamos 3 profesores a cada centro de los cuales 1 sera el director
        List<Profesor> profesoresC1 = new ArrayList<Profesor>();
        profesoresC1.add(p1);
        profesoresC1.add(p2);
        profesoresC1.add(p3);
        c1.setDirector(p1);
        c1.setProfesores(profesoresC1);

        List<Profesor> profesoresC2 = new ArrayList<Profesor>();
        profesoresC2.add(p4);
        profesoresC2.add(p5);
        profesoresC2.add(p6);
        c2.setDirector(p4);
        c2.setProfesores(profesoresC2);

        // Asignamos 2 asignaturas a cada profesores
        List<Asignatura> asignaturasP1 = new ArrayList<Asignatura>();
        asignaturasP1.add(a1);
        asignaturasP1.add(a2);
        p1.setAsignaturas(asignaturasP1);

        List<Asignatura> asignaturasP2 = new ArrayList<Asignatura>();
        asignaturasP2.add(a3);
        asignaturasP2.add(a4);
        p2.setAsignaturas(asignaturasP2);

        List<Asignatura> asignaturasP3 = new ArrayList<Asignatura>();
        asignaturasP3.add(a5);
        asignaturasP3.add(a6);
        p3.setAsignaturas(asignaturasP3);

        List<Asignatura> asignaturasP4 = new ArrayList<Asignatura>();
        asignaturasP4.add(a7);
        asignaturasP4.add(a8);
        p4.setAsignaturas(asignaturasP4);

        List<Asignatura> asignaturasP5 = new ArrayList<Asignatura>();
        asignaturasP5.add(a3);
        asignaturasP5.add(a6);
        p5.setAsignaturas(asignaturasP5);

        List<Asignatura> asignaturasP6 = new ArrayList<Asignatura>();
        asignaturasP6.add(a1);
        asignaturasP6.add(a7);
        p6.setAsignaturas(asignaturasP6);

        // Una vez todas las instancias completadas las guardamos en nuestra bbdd
        centroDao.save(c1, odb);
        centroDao.save(c2, odb);

        profesorDao.save(p1, odb);
        profesorDao.save(p2, odb);
        profesorDao.save(p3, odb);
        profesorDao.save(p4, odb);
        profesorDao.save(p5, odb);
        profesorDao.save(p6, odb);

        asignaturaDao.save(a1, odb);
        asignaturaDao.save(a2, odb);
        asignaturaDao.save(a3, odb);
        asignaturaDao.save(a4, odb);
        asignaturaDao.save(a5, odb);
        asignaturaDao.save(a6, odb);
        asignaturaDao.save(a7, odb);
        asignaturaDao.save(a8, odb);

        System.out.println("Base de datos poblada con exito!\n");
    }
}

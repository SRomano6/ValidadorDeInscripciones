package Domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Alumno {
    private String nombre;
    private Integer legajo;
    private Set<Materia> aprobadas;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getLegajo() {
        return legajo;
    }

    public void setLegajo(Integer legajo) {
        this.legajo = legajo;
    }

    public Alumno(){
        this.aprobadas = new HashSet<>();
    }
    public void agregarMateriasAprobadas(Materia ... materias){
        Collections.addAll(this.aprobadas, materias);
    }

    public boolean tieneAprobadaCorrelativas(Materia materia) {
        return this.aprobadas.containsAll(materia.getCorrelativas());
    }

    public Inscripcion generarAlterantiva(Materia ... materias){
        Inscripcion alternativa = new Inscripcion();
        alternativa.agregarAsignaturas(materias);
        alternativa.asignarAlumno(this);
        return alternativa;
    }
}

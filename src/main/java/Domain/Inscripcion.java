package Domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Inscripcion {
    private Set<Materia> asignaturas;
    private Alumno alumno;

    public Inscripcion() {
        this.asignaturas = new HashSet<>();
    }
    public void agregarAsignaturas(Materia ... materias){
        Collections.addAll(this.asignaturas, materias);
    }
    public void asignarAlumno(Alumno alumno){
        this.alumno = alumno;
    }
    public boolean aprobada(){
       return asignaturas.stream().allMatch(this.alumno::tieneAprobadaCorrelativas);
    }
}
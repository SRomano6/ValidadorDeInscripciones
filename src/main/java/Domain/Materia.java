package Domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Materia {
    private Set<Materia> correlativas;

    public Materia(){
        this.correlativas = new HashSet<>();
    }
    public void agregarCorrelativas(Materia ... materias){
        Collections.addAll(this.correlativas, materias);
    }

    public Set<Materia> getCorrelativas() {
        return correlativas;
    }
}

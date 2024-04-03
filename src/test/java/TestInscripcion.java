import Domain.Alumno;
import Domain.Inscripcion;
import Domain.Materia;
import org.junit.Assert;
import org.junit.Test;

public class TestInscripcion {
    @Test
    public void inscripcionAceptada(){
        Alumno juan = new Alumno();
        juan.setNombre("juan");
        juan.setLegajo(999);

        Materia fisica1 = new Materia();
        Materia analisis1 = new Materia();

        Materia analisis2 = new Materia();
        analisis2.agregarCorrelativas(analisis1);

        juan.agregarMateriasAprobadas(analisis1);
        Inscripcion alterantiva = juan.generarAlterantiva(analisis2);
        Assert.assertTrue(alterantiva.aprobada());  //tiene todas las correlativas necesarias
    }
    @Test
    public void inscripcionRechazada(){
        Alumno juan = new Alumno();
        juan.setNombre("juan");
        juan.setLegajo(999);

        Materia fisica1 = new Materia();
        Materia analisis1 = new Materia();

        Materia analisis2 = new Materia();
        analisis2.agregarCorrelativas(analisis1);
        Materia fisica2 = new Materia();
        fisica2.agregarCorrelativas(fisica1, analisis1);

        juan.agregarMateriasAprobadas(analisis1);
        Inscripcion alterantiva = juan.generarAlterantiva(analisis2, fisica2);
        Assert.assertFalse(alterantiva.aprobada()); //falta fisica2 aprobada
    }
}


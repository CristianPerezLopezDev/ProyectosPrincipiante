
import java.time.LocalDate;


public class ResultadoSentencia {
    String dato1;
    String dato2;
    String dato3;
    
    public ResultadoSentencia(String cantidad,String nombre,String fecha){
        dato1=nombre;
        dato2=fecha;
        dato3=cantidad;
    }
    public ResultadoSentencia(String cantidad){
        this(cantidad,"sin nombre","sin fecha");
    }
    public ResultadoSentencia(String cantidad,String nombre){
        this(cantidad,nombre,"sin fecha");
    }
    public String getNombre() {
        return dato1;
    }

    public String getFecha() {
        return dato2;
    }

    public String getCantidad() {
        return dato3;
    }

    public void setNombre(String nombre) {
        this.dato1 = nombre;
    }

    public void setFecha(String fecha) {
        this.dato2 = fecha;
    }

    public void setCantidad(String cantidad) {
        this.dato3 = cantidad;
    }
    
}

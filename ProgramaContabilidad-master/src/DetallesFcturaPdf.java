
public class DetallesFcturaPdf {
    String detalles;
    String total;
    String cif;
    String correo;
    String nombreEmpresa;
    String nombre;

    public DetallesFcturaPdf(String detalles, String total, String cif, String correo, String nombreEmpresa,String nombre) {
        this.detalles = detalles;
        this.total = total;
        this.cif = cif;
        this.correo = correo;
        this.nombreEmpresa = nombreEmpresa;
        this.nombre = nombre;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getDetalles() {
        return detalles;
    }

    public String getTotal() {
        return total;
    }

    public String getCif() {
        return cif;
    }

    public String getCorreo() {
        return correo;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public String getNombre() {
        return nombre;
    }
    
}

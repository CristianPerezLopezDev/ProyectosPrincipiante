
import com.mysql.cj.xdevapi.Statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.*;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ConectorBD {
    String cC;
    String usuario;
    String clave;
    ConectorProfundo cP=new ConectorProfundo();
    List<String> listaPlatosDetallados= Arrays.asList("menu","plato","pasta","lasaña","carneSalsa","albondigas"
                                            ,"croquetas","postres","gazpacho","tortilla","LomoOrza","salmorejo","ensaladilla","numeroentas");
    

    public ConectorBD(){
        cC="jdbc:mysql://127.0.0.1:3306/fdmContabilidad";
        usuario="root";
        clave="";
        
        
    }
   
    public List<String> getListaPlatos(){
        return this.listaPlatosDetallados;
    }
    public void CrearTablasDePlatos(List<String> lista){
        //este metodo esta comentado en la clase registradora en e evento windows opened hay que mejorar para poder añadir 
        // dinamicamente platos que se quieran detallar
        for(String nombre:lista){
            cP.lanzarSentencia("CREATE TABLE if not exists `"+nombre+"` ( `id`  bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT , `fecha`  date , PRIMARY KEY (`id`) ) ENGINE=MyISAM DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci AUTO_INCREMENT=1");
        }
       
    }
    public void registrarGasto(double c, LocalDate f,String nombre,String tipo){
        
        String sentencia="Insert into "+tipo+" values ('"+c+"','"+f+"','"+nombre+"');";
        cP.lanzarSentencia(sentencia);
           
    }
    public void borrarGasto(Integer c,String nombre,LocalDate fecha,String tipo){
       
        String sentencia="Delete from "+tipo+" where cantidad='"+c+"' and fecha='"+fecha+"' and nombreProveedor='"+nombre.toUpperCase()+"';";
        cP.lanzarSentencia(sentencia);
           
    }
    public void registrarCaja(String s){
        Integer valor=Integer.valueOf(s);
        String sentencia="Insert into caja values ("+valor+",'"+LocalDate.now()+"');";
        cP.lanzarSentencia(sentencia);
    }
    public List<ResultadoSentencia> getGastosPorProveedor(String n, String tipo,LocalDate desde,LocalDate hasta){
        List<ResultadoSentencia> datos=new ArrayList<>();
        String sentencia="Select cantidad,nombreProveedor,fecha from "+tipo+" where nombreProveedor='"+n+"' and fecha>='"+desde+"' and fecha <='"+hasta+"';";
        datos=cP.lanzarSentenciaSelect(sentencia);
         return datos;
       
    }

    public List<ResultadoSentencia> getGastos(LocalDate desde,LocalDate hasta,String tipo) {
        List<ResultadoSentencia> datos=new ArrayList<>();
        String sentencia="Select cantidad,nombreProveedor,fecha from "+tipo+" where fecha>='"+desde+"' and fecha<='"+hasta+"';";
        datos=cP.lanzarSentenciaSelect(sentencia);
        return datos;
        
    }
    public List<ResultadoSentencia> getNombreProveedor(){
        List<ResultadoSentencia> datos=new ArrayList<>();
        String sentencia="Select nombre,nombre,nombre from proveedor;";
        datos=cP.lanzarSentenciaSelect(sentencia);
        return datos;  
        
    }
    public void comprobarAlbaranes(double cantidad,String nombre){
        int soloBorrarUno=0;   
        List<ResultadoSentencia> albaranes=this.getGastos(LocalDate.parse("01/01/2000",DateTimeFormatter.ofPattern( "dd/MM/yyyy")),LocalDate.now(),"albaran");
                for(ResultadoSentencia f:albaranes){
                double cantidadAlbaran=Double.parseDouble(f.getCantidad());
                String nombreAlbaran=f.getNombre()+"";
                if(cantidad==cantidadAlbaran&&nombre.equalsIgnoreCase(nombreAlbaran)&&soloBorrarUno<1){
                    soloBorrarUno++;
                    cP.lanzarSentencia("delete from albaran where nombreProveedor='"+nombre+"' and cantidad="+cantidad+"");
                }
            }
            
    }
    public void añadirProveedor(String n){
        String sentencia="Insert into proveedor values ('"+n+"',000000) ";
        cP.lanzarSentencia(sentencia);
        
        
    }
     public void borrarProveedor(String nombre){
       
        String sentencia="Delete from proveedor where nombre='"+nombre+"';";
        cP.lanzarSentencia(sentencia);
           
    }

     
     public int[] getDetallesVenta(LocalDate desde,LocalDate hasta){
        
         
        int[] detalles=new int[listaPlatosDetallados.size()];
        Connection conector=null;
        
        for(int i=0;i<listaPlatosDetallados.size();i++){
            try {
                String sentencia="Select count(*) from "+listaPlatosDetallados.get(i)+" where fecha>='"+desde+"' and fecha<='"+hasta+"';";
                conector=DriverManager.getConnection(cC,usuario,clave);
                java.sql.Statement sc=conector.createStatement();
                ResultSet resultado1=sc.executeQuery(sentencia);
                while(resultado1.next()){
                    detalles[i]=resultado1.getInt(1); 
                }
            } catch (SQLException ex) {
                Logger.getLogger(ConectorBD.class.getName()).log(Level.SEVERE, null, ex);
            }finally{
                try {
                    conector.close();

                } catch (Exception e) {
                }
            }
        
        }
        return detalles;
    }
        
}

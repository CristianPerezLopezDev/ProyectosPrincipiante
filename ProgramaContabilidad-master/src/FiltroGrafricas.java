
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class FiltroGrafricas {
    ConectorBD cbd;
    List<String> meses;
    Map<String,Double> proveedores;//MAP PARA METODO gastoTotalPorProveedor
    Map<String,Double> cajas;//MAP PARA METODO getCajasProAño
    Map<String,Double> facturas;
    
    public FiltroGrafricas(){
        cbd=new ConectorBD();
        meses= Arrays.asList("","ENERO","FEBRERO","MARZO","ABRIL","MAYO","JUNIO","JULIO","AGOSTO","SEPTIEMBRE","OCTUBRE","NOVIEMBRE","DICIEMBRE");
        proveedores=new HashMap<>();
        cajas=new HashMap<>();
        facturas=new HashMap<>();
    }
    
    public List<String> getMeses(){
        return meses;
    }
    
    public Map<String,Double>  gastosTotalPorProveedor(LocalDate desde,LocalDate hasta){
        List<ResultadoSentencia> resultado=cbd.getGastos(desde,hasta,"facturas");   //solicito lista de proveedores
        
        for(ResultadoSentencia r:resultado){
            if(!proveedores.containsKey(r.getNombre())){//si NO contiene el nombre lo añade
                Double cantidad=Double.parseDouble(r.getCantidad());
                proveedores.put(r.getNombre(),cantidad);
            }else{                                      //si lo contiene extrae la cantidad la suma y lo añade de nuevo
                Double cantidad=proveedores.remove(r.getNombre());
                Double cantidadSumada=cantidad+Double.parseDouble(r.getCantidad());
                proveedores.put(r.getNombre(), cantidadSumada);
            }
        }
        
        return proveedores;
    }
    
    public Map<String,Double>  getCajasPorAño(int año){
        
        List<ResultadoSentencia> ventas=cbd.getGastos(LocalDate.of(año,01,01),LocalDate.of(año,12,31),"caja");
        
        for(ResultadoSentencia r:ventas){
           LocalDate fecha=LocalDate.parse(r.getFecha());
        
           int mes=fecha.getMonthValue();
  
           if(!cajas.containsKey(meses.get(mes))){
                cajas.put(meses.get(mes),Double.parseDouble(r.getCantidad()));
           }else{
                Double cantidad=cajas.remove(meses.get(mes));
                Double cantidadSumada=cantidad+Double.parseDouble(r.getCantidad());
                cajas.put(meses.get(mes), cantidadSumada);
                
           }
        }
        return cajas;

    }
    public Map<String,Double>  getFacturasPorAño(int año){
        
        List<ResultadoSentencia> ventas=cbd.getGastos(LocalDate.of(año,01,01),LocalDate.of(año,12,31),"facturas");
        
        for(ResultadoSentencia r:ventas){
           LocalDate fecha=LocalDate.parse(r.getFecha());
        
           int mes=fecha.getMonthValue();
  
           if(!facturas.containsKey(meses.get(mes))){
                facturas.put(meses.get(mes),Double.parseDouble(r.getCantidad()));
           }else{
                Double cantidad=facturas.remove(meses.get(mes));
                Double cantidadSumada=cantidad+Double.parseDouble(r.getCantidad());
                facturas.put(meses.get(mes), cantidadSumada);
                
           }
        }
        return facturas;

    }
}

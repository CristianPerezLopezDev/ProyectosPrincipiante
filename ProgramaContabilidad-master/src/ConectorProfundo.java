
import com.mysql.cj.protocol.Resultset;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class ConectorProfundo {
        String cC;
    String usuario;
    String clave;
    
    public ConectorProfundo(){
        cC="jdbc:mysql://127.0.0.1:3306/fdmContabilidad";
        usuario="root";
        clave="";
    }
    public int lanzarSentencia(String s){
        Connection conector=null;
        int todoOk=0;
        try {
                conector=DriverManager.getConnection(cC,usuario,clave);
                java.sql.Statement sc=conector.createStatement();
                todoOk=sc.executeUpdate(s);System.out.println(todoOk);
            } catch (SQLException ex) {
                System.out.println("eroorrrr con la sentencia"+ex.getMessage());
        }finally{
            try {
                     conector.close();
                } catch (Exception e) {
            }
        }
        return todoOk;
    }
    public List<ResultadoSentencia> lanzarSentenciaSelect(String s){
        List<ResultadoSentencia> documentos=new ArrayList<>();
        Connection conector=null;
        try {
            conector=DriverManager.getConnection(cC,usuario,clave);
            java.sql.Statement sc=conector.createStatement();
            ResultSet resultado=sc.executeQuery(s);
            while(resultado.next()){
                ResultadoSentencia resultadoSentencia=new ResultadoSentencia(resultado.getString(1),resultado.getString(2),resultado.getString(3));
                 documentos.add(resultadoSentencia);
            }
       
        } catch (SQLException ex) {
            Logger.getLogger(ConectorBD.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                conector.close();
            
            } catch (Exception e) {
            }
        }
        return documentos;
    }
}

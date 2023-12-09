
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;

import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import sun.net.dns.ResolverConfiguration;
import sun.security.krb5.internal.crypto.Crc32CksumType;
import com.sun.org.apache.bcel.internal.generic.LCMP;


public class FacturaPdf {
    
    
    public FacturaPdf(){
        
       
            
    }
    public void generarFacturaPdf(DetallesFcturaPdf detalles) throws IOException, BadElementException{
        Image imagen=Image.getInstance("Captura.PNG");
        FileOutputStream archivo=null;
        ConectorProfundo cP=new ConectorProfundo();
        List<ResultadoSentencia> resultado=cP.lanzarSentenciaSelect("Select count(*)a,count(*)b,count(*)c from contadorFactura");
        cP.lanzarSentencia("INSERT INTO contadorFactura values ('"+LocalDate.now()+"')");
        try {
            archivo= archivo = new FileOutputStream("C:\\Users\\petot\\Desktop\\Facturas Flor del mercado\\"+detalles.getNombre()+" "+detalles.getCorreo()+" "+LocalDate.now()+" "+".pdf");
            Document documento= new Document();
            PdfWriter.getInstance(documento, archivo);
            documento.open();
       
            imagen.getAlignment();
            imagen.scaleAbsolute(500,100);
            documento.add(imagen);
            
            Paragraph numeroFactura=new Paragraph("Factura Nº: "+resultado.get(0).getCantidad()+"            A dia: "+LocalDate.now()+""+"               Cif cliente: "+detalles.getCif()+"\n\n");
            Paragraph total=new Paragraph("\n\nTotal compra                  "+detalles.getTotal()+"€");
            Paragraph compra=new Paragraph("Detalles de la compra: \n\n"+detalles.getDetalles());
            compra.setIndentationRight(2f);
            total.setIndentationRight(2f);
            documento.add(numeroFactura);
            documento.add(compra);
            documento.add(total);
            documento.close();
            
            
            
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CajaRegistradora.class.getName()).log(Level.SEVERE, null, ex+"error pdf ff");
        } catch (DocumentException ex) {
            Logger.getLogger(CajaRegistradora.class.getName()).log(Level.SEVERE, null, ex+"error pdf ff");
        } finally {
            try {
                archivo.close();
            } catch (IOException ex) {
                Logger.getLogger(CajaRegistradora.class.getName()).log(Level.SEVERE, null, ex+"error pdf ff");
            }
        }
    }
}

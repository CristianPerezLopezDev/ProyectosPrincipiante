

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.*;
import com.itextpdf.text.Paragraph;
import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.border.Border;




        
 

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author petot
 */
public class CajaRegistradora extends javax.swing.JDialog {
   
    List<JButton> botones;
    List<String> precioProductosSeleccionados;
    List<String> nombreProductosSeleccionados;
    List<String> productos;
    List<Double> precioProductos;
    
    String textoSalida="";
    ConectorProfundo cP;
    ConectorBD cbd;
    int contadorBontones=0;
    
    public CajaRegistradora(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
    
        initComponents();
      
        productos=new ArrayList<>();
        precioProductos=new ArrayList<>();
        precioProductosSeleccionados=new ArrayList<>();
        nombreProductosSeleccionados=new ArrayList<>();
        cP=new ConectorProfundo(); 
        botones=new ArrayList<>();
        cbd=new ConectorBD();
        this.setSize((int)this.getAncho(),(int)this.getAlto());
    }
    public double getAncho(){
        Toolkit t = Toolkit.getDefaultToolkit();
        Dimension detectorDeDimensiones = Toolkit.getDefaultToolkit().getScreenSize();
        return detectorDeDimensiones.getWidth();

    }
      public double getAlto(){
        Toolkit t = Toolkit.getDefaultToolkit();
        Dimension detectorDeDimensiones = Toolkit.getDefaultToolkit().getScreenSize();
        return detectorDeDimensiones.getHeight();

    }
    /*Muy interesante... Metodo para cagar los botones a gusto del usuario, se añaden dinamicamente a 
        la app, hay que sobreescribir los metodos de las intefaces que se requieran para 
        los eventos
    */
    
    public void cargarBotones(){
        //solicito una lista con los platos que hay a la venta (esta lista se recarga dianmicamente con el boton añadir plato)
          List<ResultadoSentencia> resultado=cP.lanzarSentenciaSelect("Select precio,nombre,numero   from platosventa");
          //añado el precio y el nombre a su losta corresponciente y coinciden por su indice
          for(int i=0;i<resultado.size();i++){
              productos.add(resultado.get(i).getNombre());
              precioProductos.add(Double.parseDouble(resultado.get(i).getCantidad()));
          } 
          //por cada objeto de la lista creo un boton con las correspondientes propiedades
          for(int i=0;i<productos.size();i++){
              JButton b=new JButton();
              b.setBackground(new Color(0,0,51));
              b.setForeground(new Color(255,255,255));
              b.setBorderPainted(true);
              b.setFont(new Font("Tahoma",Font.BOLD, 14));
              b.setName(precioProductos.get(i)+"");
              b.setText(productos.get(i));     
              //sobrescribimos los metodos que queramos utilizar de la interfaz actionListener
              b.addActionListener(new ActionListener(){
                    public void actionPerformed (){
                      //Acciones
                    }

                        @Override
                        public void actionPerformed(ActionEvent e) {
                            //añado el nombre del producto el la propiedad text() del boton
                            // y el precio en la propiedad del nombre (me parece un poco chapuza)
                            //pero asi consigo añadir el precio y el nombre a las listas de productos seleccionados
                            textoSalida+="-"+b.getText()+"   "+b.getName()+"€ \n";
                            txtAreaMostrar.setText(textoSalida);
                            precioProductosSeleccionados.add(b.getName());
                            nombreProductosSeleccionados.add(b.getText());
                            txtTotal.setText(totalCompra()+"");
                            
                    }
                   
              });
              b.addMouseListener(new MouseListener() {
                  @Override
                  public void mouseClicked(MouseEvent e) {
                      
                  }

                  @Override
                  public void mousePressed(MouseEvent e) {
                  }

                  @Override
                  public void mouseReleased(MouseEvent e) {
                  }

                  @Override
                  public void mouseEntered(MouseEvent e) {
                      b.setBackground(Color.BLUE);
                  }

                  @Override
                  public void mouseExited(MouseEvent e) {
                      b.setBackground(new Color(0,0,51));
                  }
              });
              //añado el boton
              botones.add(b);
              panelPlatos.add(b);
             
             
          }
    }
    public  double totalCompra(){
        return precioProductosSeleccionados.stream()
                .mapToDouble(e -> Double.parseDouble(e))
                .sum();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        btnCambio = new javax.swing.JButton();
        txtCambio = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtVuelta = new javax.swing.JTextField();
        btnConfirmar = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        btnFacturaPdf = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAreaMostrar = new javax.swing.JTextArea();
        txtTotal = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        pnlScrollPlatos = new javax.swing.JScrollPane();
        panelPlatos = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        txtPrecio = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        btnRefrescar = new javax.swing.JButton();
        cmbClientesRegistrados = new javax.swing.JComboBox<>();
        btnAñadirPlato = new javax.swing.JButton();
        btnAñadirCliente = new javax.swing.JButton();
        btnBorrarPlato = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("CAJA REGISTRADORA");
        setBackground(new java.awt.Color(0, 51, 204));
        setIconImage(null);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(153, 153, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setForeground(new java.awt.Color(0, 0, 51));

        btnCambio.setBackground(new java.awt.Color(0, 0, 51));
        btnCambio.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnCambio.setForeground(new java.awt.Color(255, 255, 255));
        btnCambio.setText("CAMBIO DE");
        btnCambio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCambioActionPerformed(evt);
            }
        });

        txtCambio.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        txtCambio.setText("20");
        txtCambio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCambioActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText(" =");

        txtVuelta.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        txtVuelta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtVueltaActionPerformed(evt);
            }
        });

        btnConfirmar.setBackground(new java.awt.Color(0, 0, 51));
        btnConfirmar.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnConfirmar.setForeground(new java.awt.Color(255, 255, 255));
        btnConfirmar.setText("CONFIRMAR");
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarActionPerformed(evt);
            }
        });

        btnBorrar.setBackground(new java.awt.Color(0, 0, 51));
        btnBorrar.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnBorrar.setForeground(new java.awt.Color(255, 255, 255));
        btnBorrar.setText("BORRAR");
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });

        btnFacturaPdf.setBackground(new java.awt.Color(0, 0, 51));
        btnFacturaPdf.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnFacturaPdf.setForeground(new java.awt.Color(255, 255, 255));
        btnFacturaPdf.setText("FACTURA");
        btnFacturaPdf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFacturaPdfActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnCambio, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 146, Short.MAX_VALUE)
                .addComponent(txtCambio, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtVuelta, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnFacturaPdf, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(btnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtCambio, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1))
                    .addComponent(btnCambio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtVuelta)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnFacturaPdf, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnConfirmar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
                            .addComponent(btnBorrar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(153, 153, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 51)));

        txtAreaMostrar.setColumns(20);
        txtAreaMostrar.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        txtAreaMostrar.setRows(5);
        jScrollPane1.setViewportView(txtAreaMostrar);

        txtTotal.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("TOTAL:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setText("€");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 459, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        panelPlatos.setBackground(new java.awt.Color(204, 204, 255));
        panelPlatos.setLayout(new java.awt.GridLayout(0, 5));
        pnlScrollPlatos.setViewportView(panelPlatos);

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setToolTipText("");

        jButton1.setBackground(new java.awt.Color(0, 0, 51));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Atras");
        jButton1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        txtPrecio.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtPrecio.setText("Precio");
        txtPrecio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtPrecioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtPrecioMouseExited(evt);
            }
        });
        txtPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecioActionPerformed(evt);
            }
        });

        txtNombre.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtNombre.setText("Nombre");
        txtNombre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtNombreMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtNombreMouseExited(evt);
            }
        });
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });

        btnRefrescar.setBackground(new java.awt.Color(0, 0, 51));
        btnRefrescar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnRefrescar.setForeground(new java.awt.Color(255, 255, 255));
        btnRefrescar.setText("Refrescar lista");
        btnRefrescar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefrescarActionPerformed(evt);
            }
        });

        btnAñadirPlato.setBackground(new java.awt.Color(0, 0, 51));
        btnAñadirPlato.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnAñadirPlato.setForeground(new java.awt.Color(255, 255, 255));
        btnAñadirPlato.setText("AÑADIR PLATO");
        btnAñadirPlato.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                btnAñadirPlatoFocusGained(evt);
            }
        });
        btnAñadirPlato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAñadirPlatoActionPerformed(evt);
            }
        });

        btnAñadirCliente.setBackground(new java.awt.Color(0, 0, 51));
        btnAñadirCliente.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAñadirCliente.setForeground(new java.awt.Color(255, 255, 255));
        btnAñadirCliente.setText("Añadir cliente");
        btnAñadirCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAñadirClienteActionPerformed(evt);
            }
        });

        btnBorrarPlato.setBackground(new java.awt.Color(0, 0, 51));
        btnBorrarPlato.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnBorrarPlato.setForeground(new java.awt.Color(255, 255, 255));
        btnBorrarPlato.setText("BORRAR PLATO");
        btnBorrarPlato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarPlatoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnRefrescar, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                    .addComponent(btnBorrarPlato, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAñadirCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAñadirPlato, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cmbClientesRegistrados, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnAñadirCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnRefrescar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbClientesRegistrados))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnBorrarPlato, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnAñadirPlato, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(pnlScrollPlatos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlScrollPlatos))
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(86, 86, 86))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCambioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCambioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCambioActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        if(nombreProductosSeleccionados.size()>0){
            int corte=textoSalida.lastIndexOf("-");
            textoSalida=textoSalida.substring(0,corte);//cortamos desde la ultima aparicion de el char 'clave'
            txtAreaMostrar.setText(textoSalida);
            precioProductosSeleccionados.remove(precioProductosSeleccionados.size()-1);//borramos el ultimo de cada lista
            nombreProductosSeleccionados.remove(nombreProductosSeleccionados.size()-1);
           
            txtTotal.setText(this.totalCompra()+"");
          
        }
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        int opcion =JOptionPane.showConfirmDialog(rootPane, "Confirmar compra");
        
        if(opcion==JOptionPane.YES_OPTION){
           List<String> platosFijos=cbd.getListaPlatos();
          //recorremos la lista de platos seleccionados y por cada uno que coincida 
          // con la lista de platos que queremos detallados hace un insert con la fecha en su tabla correspondiente
         
           for(int i=0;i<nombreProductosSeleccionados.size();i++){
               
               for(int j=0;j<platosFijos.size();j++){
                   //si el plato nombre coincide con alguno de la lista de detallados insertamos 
                   if(nombreProductosSeleccionados.get(i).equalsIgnoreCase(platosFijos.get(j))){
                       cP.lanzarSentencia("insert into "+platosFijos.get(j)+" values (null,'"+LocalDate.now()+"')");
                   }
               } 
           }

            double total=this.totalCompra();
            nombreProductosSeleccionados.clear();
            precioProductosSeleccionados.clear();
            txtAreaMostrar.setText(textoSalida);
            textoSalida="";
          
            txtTotal.setText("");
            txtAreaMostrar.setText("");
          //cada vez que pasa por aqui inserta en la tabla ventas el total
            cP.lanzarSentencia("INSERT INTO caja VALUES ('"+total+"','"+LocalDate.now()+"','premio¡¡');");
            cP.lanzarSentencia("INSERT INTO numeroVentas VALUES ('"+LocalDate.now()+"');");
        }
        
    }//GEN-LAST:event_btnConfirmarActionPerformed


    @Override
    public Component add(Component comp) {
        return super.add(comp); //To change body of generated methods, choose Tools | Templates.
    }

    private void txtVueltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtVueltaActionPerformed
        txtVuelta.setText(Double.parseDouble(txtCambio.getText())-Double.parseDouble(txtTotal.getText())+"");
    }//GEN-LAST:event_txtVueltaActionPerformed

    private void btnCambioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCambioActionPerformed
        double vuelta=(Double.parseDouble(txtCambio.getText())-this.totalCompra())*100;//lo multiplico por 100 para rescatar ls dos prmeros decimales
        int SinDecimales=(int)vuelta;                       //lo paso a  entero para desechar el resto de decimales
        double vueltaConDosDecimales=vuelta/100;            //lo divido por 10 para representar la cantidad real con dos decimaels
        txtVuelta.setText(vueltaConDosDecimales+"");
    }//GEN-LAST:event_btnCambioActionPerformed

    private void btnFacturaPdfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFacturaPdfActionPerformed
       
        
        String sentencia="Select empresa,cif,correo from cliente where nombre = '"+cmbClientesRegistrados.getSelectedItem().toString()+"'; ";
        List<ResultadoSentencia> resultado=cP.lanzarSentenciaSelect(sentencia);
        String cif=resultado.get(0).dato1;
        String nombreEmpresa=resultado.get(0).dato3;
        String total=this.totalCompra()+"";
        String detalles=textoSalida;
        String correo=resultado.get(0).dato2;
        String nombre=cmbClientesRegistrados.getSelectedItem().toString();
        
        DetallesFcturaPdf datosCompletos= new DetallesFcturaPdf( detalles,total,cif,correo,nombreEmpresa,nombre);
        try {
            FacturaPdf factura=new FacturaPdf();
            factura.generarFacturaPdf(datosCompletos);
            JOptionPane.showMessageDialog(rootPane, "Factura generada");

        } catch (IOException ex) {
             JOptionPane.showMessageDialog(rootPane, "error al generar la factura");
        } catch (BadElementException ex) {
             JOptionPane.showMessageDialog(rootPane, "error al generar la factura");
        }
    }//GEN-LAST:event_btnFacturaPdfActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
    
          List<ResultadoSentencia> resultados=cP.lanzarSentenciaSelect("Select correo,nombre,cif from cliente");

          resultados.stream()
                  .forEach(e -> cmbClientesRegistrados.addItem(e.getNombre()));
          this.cargarBotones();
         
          cbd.CrearTablasDePlatos(cbd.getListaPlatos());//solicitamos la lsita de platos qe queremos detallar y creamos tablas para cada plato s no existe ya
         
          
    }//GEN-LAST:event_formWindowOpened

    private void btnRefrescarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefrescarActionPerformed

        ConectorProfundo cP=new ConectorProfundo();
        List<ResultadoSentencia> resultados=cP.lanzarSentenciaSelect("Select correo,nombre,cif from cliente");
        cmbClientesRegistrados.removeAllItems();
        resultados.stream()
        .forEach(e -> cmbClientesRegistrados.addItem(e.getNombre()));
    }//GEN-LAST:event_btnRefrescarActionPerformed

    private void btnAñadirClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAñadirClienteActionPerformed
        new AñadirDatosCliente(new Principal(), true).setVisible(true);

    }//GEN-LAST:event_btnAñadirClienteActionPerformed

    private void btnAñadirPlatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAñadirPlatoActionPerformed
        
        if(!txtNombre.getText().equals("")&&!txtNombre.getText().equals("Nombre")){
            Double d=Double.parseDouble(txtPrecio.getText());
            int todoOk=cP.lanzarSentencia("INSERT into platosventa values('"+d+"','"+txtNombre.getText()+"',1);");
            if(todoOk==1){
                JOptionPane.showMessageDialog(rootPane, "Boton añadido");
            }
           this.setVisible(false);
           new CajaRegistradora(new Principal(),true).setVisible(true);
        }else{
            JOptionPane.showMessageDialog(rootPane,"Rellena el nomre");
        };
           
    }//GEN-LAST:event_btnAñadirPlatoActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
       
    }//GEN-LAST:event_txtNombreActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.setVisible(false);
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtNombreMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNombreMouseEntered
        txtNombre.setText("");
    }//GEN-LAST:event_txtNombreMouseEntered

    private void txtNombreMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNombreMouseExited
     
    }//GEN-LAST:event_txtNombreMouseExited

    private void txtPrecioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPrecioMouseEntered
        txtPrecio.setText("");
    }//GEN-LAST:event_txtPrecioMouseEntered

    private void txtPrecioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPrecioMouseExited
    
    }//GEN-LAST:event_txtPrecioMouseExited

    private void btnBorrarPlatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarPlatoActionPerformed
        
        if(!txtNombre.getText().equals("")&&!txtNombre.getText().equals("Nombre")){
            cP.lanzarSentencia("Delete from platosventa where nombre='"+txtNombre.getText().toUpperCase()+"' and precio="+Double.parseDouble(txtPrecio.getText())+";");      
            this.setVisible(false);        
            new CajaRegistradora(new Principal(),true).setVisible(true);
        }else{
            JOptionPane.showMessageDialog(rootPane,"Rellena el nomre");
        };
    }//GEN-LAST:event_btnBorrarPlatoActionPerformed

    private void btnAñadirPlatoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_btnAñadirPlatoFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAñadirPlatoFocusGained

    private void txtPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecioActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CajaRegistradora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CajaRegistradora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CajaRegistradora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CajaRegistradora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CajaRegistradora dialog = new CajaRegistradora(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAñadirCliente;
    private javax.swing.JButton btnAñadirPlato;
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnBorrarPlato;
    private javax.swing.JButton btnCambio;
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JButton btnFacturaPdf;
    private javax.swing.JButton btnRefrescar;
    private javax.swing.JComboBox<String> cmbClientesRegistrados;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panelPlatos;
    private javax.swing.JScrollPane pnlScrollPlatos;
    private javax.swing.JTextArea txtAreaMostrar;
    private javax.swing.JTextField txtCambio;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtTotal;
    private javax.swing.JTextField txtVuelta;
    // End of variables declaration//GEN-END:variables

    private void btnRefrescarActionPerformed() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

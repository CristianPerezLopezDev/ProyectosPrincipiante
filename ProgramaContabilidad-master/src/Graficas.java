
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import static java.awt.image.ImageObserver.PROPERTIES;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;


public class Graficas extends javax.swing.JDialog {

    ConectorBD cbd=new ConectorBD();
    int contadorParaVentas=0;
    
    
    public Graficas(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setSize(400,(int)this.getAlto());
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
    public LocalDate getDesde(){
        String desdeStr=txtAñoDe.getText()+"/"+txtMesDe.getText()+"/"+txtDiaDe.getText();
        return LocalDate.parse(desdeStr,DateTimeFormatter.ofPattern("yyyy/MM/dd"));
    }
    public LocalDate getHasta(){
        String hastaStr=txtAñoHa.getText()+"/"+txtMesHa.getText()+"/"+txtDiaHa.getText();
        return LocalDate.parse(hastaStr,DateTimeFormatter.ofPattern("yyyy/MM/dd"));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlGrafica = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtAñoDe = new javax.swing.JTextField();
        txtMesDe = new javax.swing.JTextField();
        txtDiaDe = new javax.swing.JTextField();
        txtAñoHa = new javax.swing.JTextField();
        txtMesHa = new javax.swing.JTextField();
        txtDiaHa = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnVentas = new javax.swing.JButton();
        btnPlatos = new javax.swing.JButton();
        btnProveedores = new javax.swing.JButton();
        btnBalance = new javax.swing.JButton();
        btnSiguiente = new javax.swing.JButton();
        btnFacturas = new javax.swing.JButton();
        pnlGrafica1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        javax.swing.GroupLayout pnlGraficaLayout = new javax.swing.GroupLayout(pnlGrafica);
        pnlGrafica.setLayout(pnlGraficaLayout);
        pnlGraficaLayout.setHorizontalGroup(
            pnlGraficaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 16, Short.MAX_VALUE)
        );
        pnlGraficaLayout.setVerticalGroup(
            pnlGraficaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 265, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(102, 102, 255));
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        jLabel3.setText("Desde:");

        jLabel4.setText("Hasta:");

        txtAñoDe.setText("2001");
        txtAñoDe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAñoDeActionPerformed(evt);
            }
        });

        txtMesDe.setText("01");
        txtMesDe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMesDeActionPerformed(evt);
            }
        });

        txtDiaDe.setText("01");

        txtAñoHa.setText("2023");
        txtAñoHa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAñoHaActionPerformed(evt);
            }
        });

        txtMesHa.setText("01");
        txtMesHa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMesHaActionPerformed(evt);
            }
        });

        txtDiaHa.setText("01");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Año             Mes                   Dia");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtAñoHa, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                            .addComponent(txtAñoDe))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtMesDe, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                            .addComponent(txtMesHa))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDiaDe, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDiaHa, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtAñoDe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMesDe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDiaDe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAñoHa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMesHa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDiaHa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(102, 102, 255));

        btnVentas.setBackground(new java.awt.Color(0, 0, 51));
        btnVentas.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnVentas.setForeground(new java.awt.Color(255, 255, 255));
        btnVentas.setText("GRAFICA DE VENTAS");
        btnVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVentasActionPerformed(evt);
            }
        });

        btnPlatos.setBackground(new java.awt.Color(0, 0, 51));
        btnPlatos.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnPlatos.setForeground(new java.awt.Color(255, 255, 255));
        btnPlatos.setText("GRAFICA DE PLATOS");
        btnPlatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlatosActionPerformed(evt);
            }
        });

        btnProveedores.setBackground(new java.awt.Color(0, 0, 51));
        btnProveedores.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnProveedores.setForeground(new java.awt.Color(255, 255, 255));
        btnProveedores.setText("GRAFICA DE PROVEEDORES");
        btnProveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProveedoresActionPerformed(evt);
            }
        });

        btnBalance.setBackground(new java.awt.Color(0, 0, 51));
        btnBalance.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnBalance.setForeground(new java.awt.Color(255, 255, 255));
        btnBalance.setText("GRAFICA DE BALANCE");
        btnBalance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBalanceActionPerformed(evt);
            }
        });

        btnSiguiente.setBackground(new java.awt.Color(0, 0, 51));
        btnSiguiente.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnSiguiente.setForeground(new java.awt.Color(255, 255, 255));
        btnSiguiente.setText("->");
        btnSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteActionPerformed(evt);
            }
        });

        btnFacturas.setBackground(new java.awt.Color(0, 0, 51));
        btnFacturas.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnFacturas.setForeground(new java.awt.Color(255, 255, 255));
        btnFacturas.setText("GRAFICA DE FACTURAS");
        btnFacturas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFacturasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnBalance, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnProveedores, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPlatos, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnFacturas, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSiguiente)
                        .addGap(4, 4, 4)))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnFacturas, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnSiguiente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnPlatos, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(btnProveedores, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnBalance, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        javax.swing.GroupLayout pnlGrafica1Layout = new javax.swing.GroupLayout(pnlGrafica1);
        pnlGrafica1.setLayout(pnlGrafica1Layout);
        pnlGrafica1Layout.setHorizontalGroup(
            pnlGrafica1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnlGrafica1Layout.setVerticalGroup(
            pnlGrafica1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 258, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlGrafica, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlGrafica1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(pnlGrafica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pnlGrafica1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 21, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:z
    }//GEN-LAST:event_formWindowOpened

    private void btnVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVentasActionPerformed
        pnlGrafica.removeAll();
        FiltroGrafricas filtro=new FiltroGrafricas();
        int añoInicioGraficas=2020+contadorParaVentas;//CON ESTE CONTADOR PODEMOS AVANZAR EN LOS AÑOS 
        Map<String,Double> ventasPorAño=filtro.getCajasPorAño(añoInicioGraficas);//le pedimos al filtro el map con la venta de cada mes de ese año

        DefaultCategoryDataset datos= new DefaultCategoryDataset();
        List<String> meses=filtro.getMeses();//pedimos la lista con los meses del año que son la clave del map
     
        for(String m:meses){
            datos.setValue(ventasPorAño.get(m), "MESES", m);
        }
        
        JFreeChart grafico=ChartFactory.createBarChart3D(
                "VENTAS FLOR DEL MERCADO DE: "+añoInicioGraficas//nombre del grafico
                , "FECHA"//nombre de barras oclumnas
                , "€"//nombrede ña umeracio
                , datos//datos del grafico
                , PlotOrientation.VERTICAL//orientacion
                , true//leyendd de barras
                , true//herramientas
                ,false//url del grafico
        );
        ChartPanel panel= new ChartPanel(grafico);
        panel.setMouseWheelEnabled(true);//se habilita la rueda del raton
        panel.setPreferredSize(new Dimension(900,300));//la dimension del panel
       
        pnlGrafica.setLayout(new BorderLayout());//primero se establee un  borde 
        pnlGrafica.add(panel,BorderLayout.NORTH);//lo agregamos
        
        pack();
        repaint();
        
    }//GEN-LAST:event_btnVentasActionPerformed

    private void txtAñoDeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAñoDeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAñoDeActionPerformed

    private void txtMesDeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMesDeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMesDeActionPerformed

    private void txtAñoHaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAñoHaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAñoHaActionPerformed

    private void txtMesHaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMesHaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMesHaActionPerformed

    private void btnPlatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlatosActionPerformed
        pnlGrafica.removeAll();
        List<String> listaPlatos=cbd.getListaPlatos();
        int[] detallesVentas=cbd.getDetallesVenta(this.getDesde(),this.getHasta());
        DefaultCategoryDataset datos= new DefaultCategoryDataset();
        
     
       for(int i =0;i<listaPlatos.size();i++){
           datos.setValue(detallesVentas[i], "PLATOS",listaPlatos.get(i));
       }
        
        JFreeChart grafico=ChartFactory.createBarChart3D(
                "CANTIDAD DE PLATOS VENDIDOS DESDE: "+this.getDesde()
                        +"    HASTA: "+this.getHasta()//nombre del grafico
                , "PLATOS"//nombre de barras oclumnas
                , "Nº VENTAS"//nombrede ña umeracio
                , datos//datos del grafico
                , PlotOrientation.VERTICAL//orientacion
                , true//leyendd de barras
                , true//herramientas
                ,false//url del grafico
        );
        ChartPanel panel= new ChartPanel(grafico);
        panel.setMouseWheelEnabled(true);//se habilita la rueda del raton
        panel.setPreferredSize(new Dimension(900,300));//la dimension del panel
       
        pnlGrafica.setLayout(new BorderLayout());//primero se establee un  borde 
        pnlGrafica.add(panel,BorderLayout.NORTH);//lo agregamos
        
        pack();
        repaint();
        
    }//GEN-LAST:event_btnPlatosActionPerformed

    private void btnProveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProveedoresActionPerformed
        pnlGrafica.removeAll();
        List<ResultadoSentencia> nombreProveedores=cbd.getNombreProveedor();//NECESITAMSO LA LISTA DE PROVEEDORES PARA RECORRER EL MAP     
        
        FiltroGrafricas filtro=new FiltroGrafricas();//ESTE OBJETO SE CREA PARA FILTRAR UN POCO LOS GRAFICOS
        
        //LE PASAMOS UNA FECHA Y NOS DEVUELVE UN MAP CON TODOS LOS PROVEEDORES Y SU GASTO TOTAL EN FACTURAS
        Map<String,Double> resultadoFiltrado=filtro.gastosTotalPorProveedor(this.getDesde(), this.getHasta());
        
     
        //objeto que recoje los datos del grafico
        DefaultCategoryDataset datos= new DefaultCategoryDataset();
        
        //VAMOS PASANDO POR CADA PROVEEDOR QUE SON LA CLAVE DEL MAP Y VAMOS AÑADIEDNO SUS VALORES AL GRAFICO
        nombreProveedores.stream()
                .forEach(e -> datos.setValue(resultadoFiltrado.get(e.getNombre()),"FACTURAS",e.getNombre()));
        
        
       
        JFreeChart grafico=ChartFactory.createBarChart3D(
                "GASTOS CON PROVEEDORES DESDE: "+this.getDesde()
                        +"    HASTA: "+this.getHasta()//nombre del grafico
                , "PROVEEDORES"//nombre de barras oclumnas
                , "€"//nombrede ña umeracio
                , datos//datos del grafico
                , PlotOrientation.VERTICAL//orientacion
                , true//leyendd de barras
                , true//herramientas
                ,false//url del grafico
        );
        ChartPanel panel= new ChartPanel(grafico);
        panel.setMouseWheelEnabled(true);//se habilita la rueda del raton
        panel.setPreferredSize(new Dimension(900,300));//la dimension del panel
       
        pnlGrafica.setLayout(new BorderLayout());//primero se establee un  borde 
        pnlGrafica.add(panel,BorderLayout.NORTH);//lo agregamos
        
        pack();
        repaint();
    }//GEN-LAST:event_btnProveedoresActionPerformed

    private void btnBalanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBalanceActionPerformed
        pnlGrafica.removeAll();
        Double resultadoFormadoVentas=cbd.getGastos(this.getDesde(),this.getHasta(),"caja").stream()
        .mapToDouble(e -> Double.valueOf(e.getCantidad()))
        .sum();

        Double resultadoTodasFacturas=cbd.getGastos(this.getDesde(),this.getHasta(),"facturas").stream()
        .mapToDouble(e -> Double.valueOf(e.getCantidad()))
        .sum();
         DefaultCategoryDataset datos= new DefaultCategoryDataset();
        
        datos.setValue(resultadoTodasFacturas, "GASTOS","GASTOS: "+resultadoTodasFacturas);
        datos.setValue(resultadoFormadoVentas, "VENTAS","VENTAS: "+resultadoFormadoVentas);
        JFreeChart grafico=ChartFactory.createBarChart3D(
                "BALANCE FLOR DEL MERCADO DESDE: "+this.getDesde()
                        +"    HASTA: "+this.getHasta()//nombre del grafico
                , "BALACE"//nombre de barras oclumnas
                , "€"//nombrede ña umeracio
                , datos//datos del grafico
                , PlotOrientation.VERTICAL//orientacion
                , true//leyendd de barras
                , true//herramientas
                ,false//url del grafico
        );
        ChartPanel panel= new ChartPanel(grafico);
        panel.setMouseWheelEnabled(true);//se habilita la rueda del raton
        panel.setPreferredSize(new Dimension(900,300));//la dimension del panel
       
        pnlGrafica.setLayout(new BorderLayout());//primero se establee un  borde 
        pnlGrafica.add(panel,BorderLayout.NORTH);//lo agregamos
        
        pack();
        repaint();
        
    }//GEN-LAST:event_btnBalanceActionPerformed

    private void btnSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteActionPerformed
        this.contadorParaVentas++;
        
    }//GEN-LAST:event_btnSiguienteActionPerformed

    private void btnFacturasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFacturasActionPerformed
        pnlGrafica1.removeAll();
        FiltroGrafricas filtro=new FiltroGrafricas();
        int añoInicioGraficas=2020+contadorParaVentas;//CON ESTE CONTADOR PODEMOS AVANZAR EN LOS AÑOS 
        Map<String,Double> ventasPorAño=filtro.getFacturasPorAño(añoInicioGraficas);//le pedimos al filtro el map con las facturas de cada mes de ese año

        DefaultCategoryDataset datos= new DefaultCategoryDataset();
        List<String> meses=filtro.getMeses();//pedimos la lista con los meses del año que son la clave del map
     
        for(String m:meses){
            datos.setValue(ventasPorAño.get(m), "MESES", m);
        }
        
        JFreeChart grafico=ChartFactory.createBarChart3D(
                "FACTURAS FLOR DEL MERCADO DE: "+añoInicioGraficas//nombre del grafico
                , "FECHA"//nombre de barras oclumnas
                , "€"//nombrede ña umeracio
                , datos//datos del grafico
                , PlotOrientation.VERTICAL//orientacion
                , true//leyendd de barras
                , true//herramientas
                ,false//url del grafico
        );
        ChartPanel panel= new ChartPanel(grafico);
        panel.setMouseWheelEnabled(true);//se habilita la rueda del raton
        panel.setPreferredSize(new Dimension(900,300));//la dimension del panel
       
        pnlGrafica1.setLayout(new BorderLayout());//primero se establee un  borde 
        pnlGrafica1.add(panel,BorderLayout.NORTH);//lo agregamos
       
        pack();
        repaint();
    }//GEN-LAST:event_btnFacturasActionPerformed

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
            java.util.logging.Logger.getLogger(Graficas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Graficas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Graficas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Graficas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Graficas dialog = new Graficas(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnBalance;
    private javax.swing.JButton btnFacturas;
    private javax.swing.JButton btnPlatos;
    private javax.swing.JButton btnProveedores;
    private javax.swing.JButton btnSiguiente;
    private javax.swing.JButton btnVentas;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel pnlGrafica;
    private javax.swing.JPanel pnlGrafica1;
    private javax.swing.JTextField txtAñoDe;
    private javax.swing.JTextField txtAñoHa;
    private javax.swing.JTextField txtDiaDe;
    private javax.swing.JTextField txtDiaHa;
    private javax.swing.JTextField txtMesDe;
    private javax.swing.JTextField txtMesHa;
    // End of variables declaration//GEN-END:variables
}

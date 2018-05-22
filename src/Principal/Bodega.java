package Principal;

import Opciones_Admin.Modo_Valorizacion;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author daalb
 */
public class Bodega extends javax.swing.JFrame {

    DefaultTableModel modelo;
    String datos[][] = {};
    String columnas[] = {"Nombre", "Cantidad", "Código", "Precio de compra", "Precio de venta"};
    Modo_Valorizacion MV = new Modo_Valorizacion();

    public Bodega() {
        initComponents();
        this.setLocationRelativeTo(null);
        resetColor(add);
        resetColor(add);
        resetColor(devolucion);
        resetColor(devolucion);
        this.setIconImage(new ImageIcon(getClass().getResource("/Imagenes/icons8_Trolley_96px.png")).getImage());
        modelo = new DefaultTableModel(datos, columnas);
        Actualizar();
        Tabla();

    }
    Nodo_Productos ptr = null, ult = null;

    public void Actualizar() {
        Nodo_Productos p = ptr;
        String ruta = "archivo_productos.txt";
        File archivo_productos = new File(ruta);
        if (archivo_productos.exists()) {
            ptr = null;
            ult = null;
            String Nombre = "", PrecioCompra = "", PrecioVenta = " ", Cantidad = "", Random = "";
            File archivo;
            FileReader fr = null;
            BufferedReader br = null;
            try {
                archivo = new File("archivo_productos.txt");
                fr = new FileReader(archivo);
                br = new BufferedReader(fr);
                String linea;
                while ((linea = br.readLine()) != null) {
                    int punt = 0;
                    int cont = 0;
                    for (int i = 0; i < linea.length(); i++) {
                        if (linea.substring(i, i + 1).equals(";")) {
                            if (punt == 0) {
                                Nombre = linea.substring(cont, i);
                            }
                            if (punt == 1) {
                                Cantidad = linea.substring(cont, i);
                            }
                            if (punt == 2) {
                                PrecioCompra = linea.substring(cont, i);
                            }
                            if (punt == 3) {
                                PrecioVenta = linea.substring(cont, i);
                            }
                            if (punt == 4) {
                                Random = linea.substring(cont, i);
                            }

                            punt++;
                            cont = i + 1;
                        }
                    }
                    if (ptr == null) {
                        ptr = new Nodo_Productos(Nombre, Integer.parseInt(Cantidad), Float.parseFloat(PrecioCompra), Float.parseFloat(PrecioVenta), Integer.parseInt(Random), null, null);
                        ptr.setLlink(null);
                        p = ptr;
                    } else {
                        Nodo_Productos q = new Nodo_Productos(Nombre, Integer.parseInt(Cantidad), Float.parseFloat(PrecioCompra), Float.parseFloat(PrecioVenta), Integer.parseInt(Random), null, null);
                        p.setRlink(q);
                        q.setLlink(p);
                        p = q;
                    }
                    p.setRlink(null);
                    ult = p;

                }
                br.close();
                fr.close();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if (null != fr) {
                        fr.close();
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }

        } else {
            System.out.println("No hay archivo");
        }
        Tabla();
    }

    public void Actualizar_Archivo() {
        eliminarArchivo();
        String ruta = "archivo_productos.txt";
        File archivo_productos = new File(ruta);
        BufferedWriter BFW = null;
        if (archivo_productos.exists()) {
            try {
                BFW = new BufferedWriter(new FileWriter(archivo_productos, true));
            } catch (IOException ex) {
                Logger.getLogger(Bodega.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                BFW = new BufferedWriter(new FileWriter(archivo_productos, true));
            } catch (IOException ex) {
                Logger.getLogger(Bodega.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        FileWriter archivo = null;
        PrintWriter PW = null;
        int cont = 0;
        try {
            archivo = new FileWriter("archivo_productos.txt", true);
            PW = new PrintWriter(archivo);
            Nodo_Productos p = ptr;
            while (p != null) {
                PW.println(p.getNombre() + ";" + p.getCantidad() + ";" + p.getPrecioCompra() + ";" + p.getPrecioVenta() + ";" + p.getRamdom() + ";");
                p = p.getRlink();
                System.out.println(cont++);
            }
            BFW.close();
            archivo.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != archivo) {
                    archivo.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        Actualizar();
    }

    public void resetColor(JPanel panel) {
        panel.setBackground(new java.awt.Color(240, 240, 240));
    }

    public void setColor(JPanel panel) {
        panel.setBackground(new java.awt.Color(197, 197, 197));
    }
    //Fin metodos de diseño

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        Titulo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        nombre = new javax.swing.JTextField();
        pv = new javax.swing.JTextField();
        cantidad = new javax.swing.JTextField();
        pc = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_bodega = new javax.swing.JTable();
        add = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jlabel = new javax.swing.JLabel();
        devolucion = new javax.swing.JPanel();
        dev = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

        jLabel1.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(108, 110, 88));
        jLabel1.setText("X");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(233, 247, 247));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(164, 207, 190));
        jPanel2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel2MouseDragged(evt);
            }
        });
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel2MousePressed(evt);
            }
        });

        Titulo.setFont(new java.awt.Font("Arial Rounded MT Bold", 3, 36)); // NOI18N
        Titulo.setForeground(new java.awt.Color(108, 110, 88));
        Titulo.setText("Bodega");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8_Trolley_96px.png"))); // NOI18N
        jLabel2.setText("jLabel2");

        jLabel3.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(108, 110, 88));
        jLabel3.setText("X");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(144, 144, 144)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(Titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Titulo)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(66, 66, 66)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 730, 130));

        jLabel5.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(108, 110, 88));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Precio de venta");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 210, 110, 30));

        jLabel6.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(108, 110, 88));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Nombre del producto");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 150, 30));

        jLabel7.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(108, 110, 88));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Cantidad");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 160, 110, 30));

        jLabel8.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(108, 110, 88));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Precio de compra");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, 110, 30));

        nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreActionPerformed(evt);
            }
        });
        jPanel1.add(nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 160, 190, 30));

        pv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pvActionPerformed(evt);
            }
        });
        jPanel1.add(pv, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 210, 140, 30));

        cantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cantidadActionPerformed(evt);
            }
        });
        jPanel1.add(cantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 160, 60, 30));

        pc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pcActionPerformed(evt);
            }
        });
        jPanel1.add(pc, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 210, 150, 30));

        tabla_bodega.setBackground(new java.awt.Color(233, 247, 247));
        tabla_bodega.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 14)); // NOI18N
        tabla_bodega.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Cantidad", "Código", "Precio de Compra", "Precio de Venta"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla_bodega.setSelectionBackground(new java.awt.Color(167, 207, 205));
        tabla_bodega.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tabla_bodega);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 360, 720, 260));

        add.setBackground(new java.awt.Color(233, 247, 247));
        add.setForeground(new java.awt.Color(164, 207, 190));
        add.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                addMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                addMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                addMousePressed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(108, 110, 88));
        jLabel4.setText("Agregar");

        jlabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8_Add_30px.png"))); // NOI18N

        javax.swing.GroupLayout addLayout = new javax.swing.GroupLayout(add);
        add.setLayout(addLayout);
        addLayout.setHorizontalGroup(
            addLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addContainerGap(16, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jlabel)
                .addGap(26, 26, 26))
        );
        addLayout.setVerticalGroup(
            addLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlabel, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4))
        );

        jPanel1.add(add, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 260, 80, 70));

        devolucion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                devolucionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                devolucionMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                devolucionMousePressed(evt);
            }
        });

        dev.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8_Sell_30px_1.png"))); // NOI18N

        jLabel11.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(108, 110, 88));
        jLabel11.setText("Devolucion");

        javax.swing.GroupLayout devolucionLayout = new javax.swing.GroupLayout(devolucion);
        devolucion.setLayout(devolucionLayout);
        devolucionLayout.setHorizontalGroup(
            devolucionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(devolucionLayout.createSequentialGroup()
                .addGroup(devolucionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(devolucionLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel11))
                    .addGroup(devolucionLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(dev)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        devolucionLayout.setVerticalGroup(
            devolucionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(devolucionLayout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(dev, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11))
        );

        jPanel1.add(devolucion, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 260, 80, 70));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 720, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel3MouseClicked
    int xx, xy;
    private void jPanel2MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xx, y - xy);
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel2MouseDragged

    private void jPanel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MousePressed
        xx = evt.getX();
        xy = evt.getY();
// TODO add your handling code here:
    }//GEN-LAST:event_jPanel2MousePressed

    private void nombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreActionPerformed

    private void pvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pvActionPerformed

    private void cantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cantidadActionPerformed

    private void pcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pcActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pcActionPerformed

    private void addMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addMouseExited
        resetColor(add);
        // TODO add your handling code here:
    }//GEN-LAST:event_addMouseExited

    private void addMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addMouseEntered
        setColor(add);
        // TODO add your handling code here:
    }//GEN-LAST:event_addMouseEntered

    private void devolucionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_devolucionMouseExited
        resetColor(devolucion);
// TODO add your handling code here:
    }//GEN-LAST:event_devolucionMouseExited

    private void devolucionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_devolucionMouseEntered
        setColor(devolucion);
// TODO add your handling code here:
    }//GEN-LAST:event_devolucionMouseEntered

    private void addMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addMousePressed
        String ruta = "archivo_productos.txt";
        int N = 1;
        File archivo_productos = new File(ruta);
        if (archivo_productos.exists()) {
            Actualizar();
            N = 2;
        }
        Registrar(N);
        Actualizar();

        // TODO add your handling code here:
    }//GEN-LAST:event_addMousePressed

    private void devolucionMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_devolucionMousePressed
        // TODO add your handling code here:
        String nombre;
        System.out.println();
        System.out.println();
        Nodo_Productos p = ptr;
        Nodo_Productos u = ult;
        if (tabla_bodega.getSelectedRow() != -1) {
            while (!p.getNombre().equals(tabla_bodega.getValueAt(tabla_bodega.getSelectedRow(), 0))) {
                p = p.getRlink();
            }
            String can = JOptionPane.showInputDialog("Cuantos desea eliminar");

            try {
                int N = Integer.parseInt(can);
                if ((p.getCantidad() - N) < 0) {
                    System.out.println("No se puede quitar esa cantidad");
                } else {
                    p.setCantidad(p.getCantidad() - N);
                    if ((p.getCantidad()) == 0) {
                        if (p == ptr) {
                            ptr = p.getRlink();
                        } else {
                            Nodo_Productos aux = p;
                            Nodo_Productos der = p.getRlink();
                            Nodo_Productos izq = p.getLlink();
                            if (p == u) {
                                izq.setRlink(null);
                                ult = izq;
                            } else {
                                der.setLlink(izq);
                                izq.setRlink(der);
                            }
                        }
                    }
                    Actualizar_Archivo();
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "FEO");
            }

        }


    }//GEN-LAST:event_devolucionMousePressed
    public void eliminarArchivo() {
        File fichero = new File("Archivo_productos.txt");
        if (fichero.delete()) {
            System.out.println("El fichero ha sido borrado satisfactoriamente");
        } else {
            System.out.println("El fichero no pudó ser borrado");
        }
    }

    public void Crear_Producto(int N) {
        Modo_Valorizacion mv = new Modo_Valorizacion();
        if (mv.modo == true) {
            System.out.println("Pila");
        } else {
            System.out.println("Cola");
        }
        String ruta = "archivo_productos.txt";
        File archivo_productos = new File(ruta);
        BufferedWriter BFW = null;
        if (archivo_productos.exists()) {
            try {
                BFW = new BufferedWriter(new FileWriter(archivo_productos, true));
            } catch (IOException ex) {
                Logger.getLogger(Bodega.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                BFW = new BufferedWriter(new FileWriter(archivo_productos, true));
            } catch (IOException ex) {
                Logger.getLogger(Bodega.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        FileWriter archivo = null;
        PrintWriter PW = null;
        try {
            archivo = new FileWriter("archivo_productos.txt", true);
            PW = new PrintWriter(archivo);
            int R = (int) (Math.random() * 1000) + 1;
            Nodo_Productos p = ptr;
            while (p != null && N == 2) {
                if (p.getRamdom() == R) {
                    R = (int) (Math.random() * 1000) + 1;
                    p = ptr;
                } else {
                    p = p.getRlink();
                }
            }
            PW.println(nombre.getText().toUpperCase() + ";" + cantidad.getText() + ";" + pc.getText() + ";" + pv.getText() + ";" + R + ";");
            nombre.setText("");
            cantidad.setText("");
            pv.setText("");
            pc.setText("");
            PW.close();
            archivo.close();
            BFW.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != archivo) {
                    archivo.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

    }

    public void Tabla() {
        modelo = new DefaultTableModel(datos, columnas);
        MV.modo = false;
        if (MV.modo == true) {
            Nodo_Productos t = ult;
            if (ult == null) {
                JOptionPane.showMessageDialog(null, "Lista vacía");
            } else {
                while (t != null) {
                    modelo.addRow(new Object[]{t.getNombre(), t.getCantidad(), t.getRamdom(), t.getPrecioCompra(), t.getPrecioVenta()});
                    t = t.getLlink();
                }
            }
        } else {
            Nodo_Productos t = ptr;
            if (ptr == null) {
                JOptionPane.showMessageDialog(null, "Lista vacía");
            } else {
                while (t != null) {
                    modelo.addRow(new Object[]{t.getNombre(), t.getCantidad(), t.getRamdom(), t.getPrecioCompra(), t.getPrecioVenta()});
                    t = t.getRlink();
                }
            }
        }

        tabla_bodega.setModel(modelo);
        System.out.println(modelo.getRowCount());

    }

    public void Registrar(int N) {
        if (Pattern.compile("[A-Za-z ]*").matcher(nombre.getText()).matches() && !nombre.getText().equals("") && !Pattern.compile("[ \\t\\n\\x0b\\r\\f]*").matcher(nombre.getText()).matches()) {
            try {
                int cant = Integer.parseInt(cantidad.getText());
                if (cant > 0) {
                    try {
                        float prec = Float.parseFloat(pc.getText());
                        if (prec >= 0) {
                            try {
                                float prev = Float.parseFloat(pv.getText());
                                if (prev >= 0) {
                                    Nodo_Productos p = ptr;
                                    boolean sw = true;
                                    while (p != null && sw == true) {
                                        if (p.getNombre().equals(nombre.getText().toUpperCase())) {
                                            sw = false;
                                        } else {
                                            p = p.getRlink();
                                        }
                                    }
                                    if (sw == false) {
                                        p.setCantidad(p.getCantidad() + cant);
                                        p.setPrecioCompra(prec);
                                        p.setPrecioVenta(prev);
                                        Actualizar_Archivo();
                                        nombre.setText("");
                                        cantidad.setText("");
                                        pv.setText("");
                                        pc.setText("");

                                    } else {
                                        Crear_Producto(N);
                                    }
                                }
                            } catch (Exception e) {
                                JOptionPane.showMessageDialog(null, "¡ERROR! Ingrese un precio de venta valido", "Atencion", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "¡ERROR! Ingrese un precio de compra valido", "Atencion", JOptionPane.ERROR_MESSAGE);
                    }
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "¡ERROR! Ingrese una cantidad valida", "Atencion", JOptionPane.ERROR_MESSAGE);
            }

        } else {
            JOptionPane.showMessageDialog(null, "NOMBRE NO VALIDO", "ATENCIÓN", JOptionPane.ERROR_MESSAGE);

        }

    }

    public String generarCod() {
        int cod;
        cod = (int) (Math.random() * 99999) + 10000;
        return String.valueOf(cod);
    }

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
            java.util.logging.Logger.getLogger(Bodega.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Bodega.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Bodega.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Bodega.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Bodega().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Titulo;
    private javax.swing.JPanel add;
    private javax.swing.JTextField cantidad;
    private javax.swing.JLabel dev;
    private javax.swing.JPanel devolucion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jlabel;
    private javax.swing.JTextField nombre;
    private javax.swing.JTextField pc;
    private javax.swing.JTextField pv;
    private javax.swing.JTable tabla_bodega;
    // End of variables declaration//GEN-END:variables

    private void ActualizarDatos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

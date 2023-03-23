
package vista;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

/**
 *
 * @author monge
 */
public class VistaPrincipal extends javax.swing.JFrame {
//////

    public VistaPrincipal() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
//////////////

    public JButton getBtnPlatos() {
        return btnPlatos;
    }

    public void setBtnPlatos(JButton btnPlatos) {
        this.btnPlatos = btnPlatos;
    }


    public JDesktopPane getEscritorio() {
        return escritorio;
    }

    public void setEscritorio(JDesktopPane escritorio) {
        this.escritorio = escritorio;
    }
    ////////////////////////////

    public JMenu getMnuProductos() {
        return mnuProductos;
    }

    public void setMnuProductos(JMenu mnuProductos) {
        this.mnuProductos = mnuProductos;
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jToolBar1 = new javax.swing.JToolBar();
        btnPlatos = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        escritorio = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnuProductos = new javax.swing.JMenu();
        mnuVentas = new javax.swing.JMenu();

        jMenuItem1.setText("jMenuItem1");

        jMenuItem3.setText("jMenuItem3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jToolBar1.setRollover(true);

        btnPlatos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/icons/plato.png"))); // NOI18N
        btnPlatos.setFocusable(false);
        btnPlatos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnPlatos.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btnPlatos);

        jPanel1.setBackground(new java.awt.Color(255, 255, 102));

        jLabel1.setText("Restaurante v1.1");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(768, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 416, Short.MAX_VALUE)
        );

        mnuProductos.setText("Platillos");
        jMenuBar1.add(mnuProductos);

        mnuVentas.setText("Ventas");
        jMenuBar1.add(mnuVentas);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(escritorio)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(escritorio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPlatos;
    private javax.swing.JDesktopPane escritorio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JMenu mnuProductos;
    private javax.swing.JMenu mnuVentas;
    // End of variables declaration//GEN-END:variables
}

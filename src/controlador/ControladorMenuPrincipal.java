package controlador;

import modelo.ModeloPlatos;
import vista.VistaPrincipal;
import vista.VistaPlatos;

public class ControladorMenuPrincipal {

    VistaPrincipal vistaPrincipal;

    public ControladorMenuPrincipal(VistaPrincipal vistaprincipal) {
        this.vistaPrincipal = vistaprincipal;
        vistaprincipal.setVisible(true);
    }

    public void iniciaControl() {

        vistaPrincipal.getBtnPlatos().addActionListener(l -> crudProductos());
        //vistaPrincipal.getMnuCrear().addActionListener(l-> crudPersonas());
    }


    private void crudProductos() {
        //Instancio las clases del Modelo y la Vista.
        VistaPlatos vista = new VistaPlatos();
        ModeloPlatos modelo = new ModeloPlatos();

        //Agregar Vista Personas al Desktop Pane.
        vistaPrincipal.getEscritorio().add(vista);

        ControladorPlatos control = new ControladorPlatos(modelo, vista);
        control.iniciarControl();//Empezamos las escuchas a los eventos de la vista, Listeners.
    }

    public void ControladorPrincipal(VistaPrincipal vistaPrincipal) {
        this.vistaPrincipal = vistaPrincipal;
        vistaPrincipal.setVisible(true);
    }
}

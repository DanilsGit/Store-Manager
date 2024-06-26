import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Insertar extends JFrame {

    ImageIcon img;

    JMenuBar barraDeNavegacion;
    JMenu menuOpciones;
    JMenu menuColorFondo;
    JMenuItem itemRojo;
    JMenuItem itemAzul;
    JMenuItem itemNegro;
    JMenuItem itemSalir;

    Font calibri;

    Color anaranjado;

    JLabel lbl_id, lbl_nombre, lbl_precio, lbl_fecha, lbl_cantidad, labelimagen, labelTitulo;
    JPanel containerTitulo;
    JButton btn_agregar, salir;
    JTextField tfl_id, tfl_nombre, tfl_precio, tfl_fecha, tfl_cantidad;

    Insertar() {
        iniciarGui();

        iniciarComponentes();

        ordenarComponentes();

        addComponentes();
    }

    private void iniciarGui() {
        setSize(645, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(3);
        setLayout(null);
        setResizable(false);
        setIconImage(new ImageIcon(getClass().getResource("imagenes/icon.png")).getImage());
        setTitle("Ingresar nuevos productos");
    }

    private void iniciarComponentes() {
        barraDeNavegacion = Principal.barraDeNavegacion;
        menuOpciones = Principal.menuOpciones;
        menuColorFondo = Principal.menuColorFondo;
        itemRojo = Principal.itemRojo;
        itemAzul = Principal.itemAzul;
        itemNegro = Principal.itemNegro;
        itemSalir = Principal.itemSalir;

        img = new ImageIcon(getClass().getResource("imagenes/logo.png"));
        labelimagen = new JLabel(img);

        // paneles
        containerTitulo = new JPanel();

        // PROPIOS

        calibri = new Font("Calibro", 1, 20);
        anaranjado = new Color(255, 192, 9);

        // LABELS

        labelTitulo = new JLabel("Registro de productos");
        lbl_id = new JLabel("Codigo del producto");
        lbl_nombre = new JLabel("Nombre del producto");
        lbl_precio = new JLabel("Precio");
        lbl_fecha = new JLabel("Fecha de ingreso");
        lbl_cantidad = new JLabel("Cantidad");

        // botones
        btn_agregar = new JButton("Agregar");
        salir = new JButton("Volver...");

        // TextField

        tfl_id = new JTextField();
        tfl_nombre = new JTextField();
        tfl_precio = new JTextField();
        tfl_fecha = new JTextField();
        tfl_cantidad = new JTextField();

    }

    private void ordenarComponentes() {

        getContentPane().setBackground(Bienvenida.fondo);

        //
        itemAzul.addActionListener(new ItemAction());
        itemNegro.addActionListener(new ItemAction());
        itemRojo.addActionListener(new ItemAction());
        itemSalir.addActionListener(new ItemAction());
        //

        labelimagen.setBounds(100, 30, 470, 46);

        labelTitulo.setFont(calibri);

        containerTitulo.setBounds(40, 100, 550, 40);
        containerTitulo.setBackground(anaranjado);
        containerTitulo.setLayout(new FlowLayout(FlowLayout.CENTER));
        containerTitulo.add(labelTitulo);

        lbl_id.setBounds(45, 130, 470, 40);
        lbl_id.setFont(calibri);

        tfl_id.setBounds(40, 165, 170, 40);
        tfl_id.setFont(calibri);
        tfl_id.setForeground(anaranjado);

        lbl_nombre.setBounds(45, 230, 470, 40);
        lbl_nombre.setFont(calibri);

        tfl_nombre.setBounds(40, 265, 170, 40);
        tfl_nombre.setFont(calibri);
        tfl_nombre.setForeground(anaranjado);

        lbl_precio.setBounds(45, 330, 470, 40);
        lbl_precio.setFont(calibri);

        tfl_precio.setBounds(40, 365, 170, 40);
        tfl_precio.setFont(calibri);
        tfl_precio.setForeground(anaranjado);

        btn_agregar.setBounds(40, 500, 150, 35);
        btn_agregar.setBackground(anaranjado);
        btn_agregar.setFont(calibri);
        btn_agregar.addActionListener(new Action());

        lbl_fecha.setBounds(340, 130, 470, 40);
        lbl_fecha.setFont(calibri);

        tfl_fecha.setBounds(340, 165, 170, 40);
        tfl_fecha.setFont(calibri);
        tfl_fecha.setForeground(anaranjado);

        lbl_cantidad.setBounds(340, 230, 470, 40);
        lbl_cantidad.setFont(calibri);

        tfl_cantidad.setBounds(340, 265, 170, 40);
        tfl_cantidad.setFont(calibri);
        tfl_cantidad.setForeground(anaranjado);

        salir.setBounds(450, 550, 150, 35);
        salir.setBackground(anaranjado);
        salir.setFont(calibri);
        salir.addActionListener(new Action());

    }

    private void addComponentes() {
        add(barraDeNavegacion);
        add(labelimagen);
        add(containerTitulo);
        add(lbl_id);
        add(salir);
        add(tfl_id);
        add(lbl_nombre);
        add(tfl_nombre);
        add(lbl_precio);
        add(tfl_precio);
        add(btn_agregar);
        add(lbl_fecha);
        add(tfl_fecha);
        add(lbl_cantidad);
        add(tfl_cantidad);

    }

    class Action implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            BDconnect acti = new BDconnect();

            if (e.getSource() == btn_agregar) {

                try {
                    acti.insertar(Integer.parseInt(tfl_id.getText()), tfl_nombre.getText(), tfl_cantidad.getText(),
                            Integer.parseInt(tfl_precio.getText()), tfl_fecha.getText());
                    System.out.println("agregao");

                } catch (Exception ex) {
                    System.err.println(ex.getClass().getName() + " " + ex.getMessage());
                    System.out.println("algo va mal xd");
                }

            }

            if (e.getSource() == salir) {

                try {
                    Principal p1 = new Principal();
                    p1.setVisible(true);
                    dispose();

                } catch (Exception ex) {
                    System.err.println(ex.getClass().getName() + " " + ex.getMessage());
                    System.out.println("algo va mal xd");
                }

            }

        }

    }

    class ItemAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == itemAzul) {
                Color nuevoFondo = new Color(11, 113, 194);
                Bienvenida.fondo = nuevoFondo;
                getContentPane().setBackground(Bienvenida.fondo);
            }
            if (e.getSource() == itemNegro) {
                Color nuevoFondo = new Color(32, 32, 32);
                Bienvenida.fondo = nuevoFondo;
                getContentPane().setBackground(Bienvenida.fondo);
            }
            if (e.getSource() == itemRojo) {
                Color nuevoFondo = new Color(234, 29, 29);
                Bienvenida.fondo = nuevoFondo;
                getContentPane().setBackground(Bienvenida.fondo);
            }
            if (e.getSource() == itemSalir) {
                Bienvenida ventBienvenida = new Bienvenida();
                ventBienvenida.setVisible(true);
                dispose();

            }
        }

    }

}
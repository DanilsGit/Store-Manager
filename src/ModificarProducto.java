import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ModificarProducto extends JFrame {

    ImageIcon img;

    JMenuBar barraDeNavegacion;
    JMenu menuOpciones;
    JMenu menuColorFondo;
    JMenuItem itemRojo;
    JMenuItem itemAzul;
    JMenuItem itemNegro;
    JMenuItem itemSalir;

    Color anaranjado;

    JLabel labelTitulo, labelIdModificar, labelImagen, labelInstrucciones, labelNombre, labelInventario, labelPrecio,
            labelImportacion, labelImportacionD, labelImportacionM, labelImportacionA;

    Font calibri;

    JPanel containerTitulo;

    JTextField fieldId, fieldNombre, fieldPrecio, fieldInventario, fieldD, fieldM, fieldA;

    boolean clickD = false, clickM = false, clickA = false;

    JButton btnModificar, btnAtras;


    ModificarProducto() {
        iniciarGui();

        iniciarComponentes();

        ordenarComponentes();

        addComponentes();
    }

    private void iniciarGui() {
        setSize(1000, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(3);
        setLayout(null);
        setResizable(false);
        setIconImage(new ImageIcon(getClass().getResource("imagenes/icon.png")).getImage());
        setTitle("Modificar productos del sistema");
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
        labelImagen = new JLabel(img);

        labelIdModificar = new JLabel("Ingrese la id del producto a modificar");

        containerTitulo = new JPanel();

        labelTitulo = new JLabel("Modificar productos");

        anaranjado = new Color(255, 192, 9);

        calibri = new Font("Calibro", 1, 20);

        fieldId = new JTextField();

        labelInstrucciones = new JLabel("Especifique los nuevos valores");

        labelNombre = new JLabel("Nombre ");
        labelInventario = new JLabel("Existencias ");
        labelPrecio = new JLabel("Precio ");
        labelImportacion = new JLabel("Día, mes y año de la importación ");

        labelImportacionD = new JLabel("Dia");
        labelImportacionM = new JLabel("Mes");
        labelImportacionA = new JLabel("Año");

        fieldNombre = new JTextField();
        fieldPrecio = new JTextField();
        fieldInventario = new JTextField();
        fieldD = new JTextField();
        fieldM = new JTextField();
        fieldA = new JTextField();

        btnModificar = new JButton("Modificar");

        btnAtras = new JButton("Atrás");

    }

    private void ordenarComponentes() {

        getContentPane().setBackground(Bienvenida.fondo);

        barraDeNavegacion.add(menuOpciones);

        menuOpciones.add(menuColorFondo);

        menuColorFondo.add(itemAzul);
        menuColorFondo.add(itemNegro);
        menuColorFondo.add(itemRojo);

        menuOpciones.add(itemSalir);

        itemAzul.addActionListener(new ItemAction());
        itemNegro.addActionListener(new ItemAction());
        itemRojo.addActionListener(new ItemAction());
        itemSalir.addActionListener(new ItemAction());

        labelTitulo.setFont(calibri);

        containerTitulo.setBounds(20, 52, 400, 35);
        containerTitulo.setBackground(anaranjado);
        containerTitulo.setLayout(new FlowLayout());
        containerTitulo.add(labelTitulo);

        labelImagen.setBounds(500, 50, 470, 46);

        labelIdModificar.setBounds(20, 120, 400, 25);
        labelIdModificar.setFont(calibri);
        labelIdModificar.setForeground(Color.white);

        fieldId.setBounds(20, 150, 300, 35);
        fieldId.setFont(calibri);

        labelInstrucciones.setBounds(352, 220, 295, 35);
        labelInstrucciones.setFont(calibri);
        labelInstrucciones.setForeground(Color.orange);

        labelNombre.setBounds(20, 300, 100, 30);
        labelNombre.setFont(calibri);
        labelNombre.setForeground(Color.white);

        fieldNombre.setBounds(20, 340, 140, 30);
        fieldNombre.setFont(calibri);

        labelInventario.setBounds(190, 300, 200, 30);
        labelInventario.setFont(calibri);
        labelInventario.setForeground(Color.white);

        fieldInventario.setBounds(190, 340, 100, 30);
        fieldInventario.setFont(calibri);

        labelPrecio.setBounds(360, 300, 200, 30);
        labelPrecio.setFont(calibri);
        labelPrecio.setForeground(Color.white);

        fieldPrecio.setBounds(360, 340, 150, 30);
        fieldPrecio.setFont(calibri);

        labelImportacion.setBounds(600, 300, 350, 30);
        labelImportacion.setFont(calibri);
        labelImportacion.setForeground(Color.white);

        fieldD.setBounds(600, 340, 50, 30);
        fieldD.setForeground(new Color(0, 0, 0, 40));
        fieldD.setFont(calibri);
        fieldD.setText("Dia");
        fieldD.addMouseListener(new FieldAction());

        fieldM.setBounds(700, 340, 50, 30);
        fieldM.setForeground(new Color(0, 0, 0, 40));
        fieldM.setFont(calibri);
        fieldM.setText("Mes");
        fieldM.addMouseListener(new FieldAction());

        fieldA.setBounds(800, 340, 80, 30);
        fieldA.setForeground(new Color(0, 0, 0, 40));
        fieldA.setFont(calibri);
        fieldA.setText("Año");
        fieldA.addMouseListener(new FieldAction());

        btnModificar.setBounds(350, 400, 300, 40);
        btnModificar.setBackground(anaranjado);
        btnModificar.setFont(calibri);
        btnModificar.addActionListener(new Action());

        btnAtras.setBounds(20, 500, 150, 40);
        btnAtras.setBackground(anaranjado);
        btnAtras.setFont(calibri);
        btnAtras.addActionListener(new Action());

    }

    private void addComponentes() {
        add(barraDeNavegacion);
        add(containerTitulo);
        add(labelImagen);
        add(labelIdModificar);
        add(fieldId);
        add(labelInstrucciones);
        add(labelNombre);
        add(labelInventario);
        add(labelPrecio);
        add(labelImportacion);
        //
        add(fieldNombre);
        add(fieldPrecio);
        add(fieldInventario);
        add(fieldD);
        add(fieldM);
        add(fieldA);
        //
        add(btnModificar);
        add(btnAtras);
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

    class FieldAction extends MouseAdapter {

        @Override
        public void mousePressed(MouseEvent e) {

            if (e.getSource() == fieldD && !(clickD)) {
                fieldD.setText("");
                fieldD.setForeground(Color.black);
                clickD = true;
            }
            if (e.getSource() == fieldM && !(clickM)) {
                fieldM.setText("");
                fieldM.setForeground(Color.black);
                clickM = true;
            }
            if (e.getSource() == fieldA && !(clickA)) {
                fieldA.setText("");
                fieldA.setForeground(Color.black);
                clickA = true;
            }

        }

    }

    class Action implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == btnModificar) {
                String nombre, existencias, precio, importacion, dia, mes, ano, id;
                nombre = fieldNombre.getText();
                existencias = fieldInventario.getText();
                precio = fieldPrecio.getText();
                id = fieldId.getText();

                dia = fieldD.getText();
                mes = fieldM.getText();
                ano = fieldA.getText();

                importacion = ano + "/" + mes + "/" + dia;

                if (!((nombre.trim().equals("")) || (existencias.trim().equals(""))
                        || (precio.trim().equals("")) || (id.trim().equals("")))) {

                    BDconnect miBD = new BDconnect();

                    miBD.modificarProducto(id,nombre,existencias,precio,importacion);

                    miBD.cerrar();

                } else {
                    JOptionPane.showMessageDialog(null, "Por favor, rellene todos los campos", "Campos vacíos", 1);
                }

            }

            if (e.getSource() == btnAtras) {
                Principal ventanaPrincipal = new Principal();
                ventanaPrincipal.setVisible(true);

                dispose();
            }

        }

    }

}

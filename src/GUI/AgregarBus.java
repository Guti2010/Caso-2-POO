package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.*;

import Bus.Autobus;
import Empresa.*; 
import Config.*;
public class AgregarBus extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextArea rutaTextArea;
    private JTextArea autobusTextArea;
    private Flotilla Flotilla;
    private settingJSON configuracion;

    public AgregarBus(Flotilla Flotilla,settingJSON configuracion) {
    	this.Flotilla = Flotilla;
    	this.configuracion = configuracion;
    	// Usa FondoPanel como el panel de contenido
        FondoPanel fondoPanel = new FondoPanel("C:\\Users\\windows\\Documents\\TransportePúblico\\src\\GUI\\maxresdefault.jpg");
        
        setContentPane(fondoPanel);
        setTitle("Agregar Autobus");
        setSize(620, 500);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocation(60, 60);

        
        
        JLabel label = new JLabel("Agregar Autobus");
        label.setFont(new Font("Arial", Font.BOLD, 40));
        label.setForeground(Color.BLACK);
        label.setBounds(170, 0, 350, 100);
        getContentPane().setLayout(null);
        getContentPane().add(label);

        // Etiqueta y área de texto para "Placa"
        JLabel rutaLabel = new JLabel("Placa:");
        rutaLabel.setFont(new Font("Arial", Font.PLAIN, 24));
        rutaLabel.setForeground(Color.BLACK);
        rutaLabel.setBounds(35, 80, 70, 25);
        getContentPane().setLayout(null);
        getContentPane().add(rutaLabel);
        

        rutaTextArea = new JTextArea();
        rutaTextArea.setBounds(110, 80, 150, 30); // Cambia el tamaño según tus necesidades
        getContentPane().setLayout(null);
        getContentPane().add(rutaTextArea);

        // Etiqueta y área de texto para "Autobús"
        JLabel autobusLabel = new JLabel("Chofer:");
        autobusLabel.setFont(new Font("Arial", Font.PLAIN, 24));
        autobusLabel.setForeground(Color.BLACK);
        autobusLabel.setBounds(305, 80, 130, 25);
        getContentPane().add(autobusLabel);

        autobusTextArea = new JTextArea();
        autobusTextArea.setBounds(400, 80, 180, 30); // Cambia el tamaño según tus necesidades
        getContentPane().add(autobusTextArea);

        // Botón para realizar acciones con la información ingresada
        JButton button1 = new JButton("Agregar");
        button1.setBounds(240, 150, 150, 50);
        personalizarBoton(button1, new Font("Arial", Font.PLAIN, 20), new Color(50, 120, 250));
        
        button1.addActionListener(e -> {
        	String placa = rutaTextArea.getText();
        	String chofer = autobusTextArea.getText();
        	boolean existeBus = false;
        	for (Autobus bus : Flotilla.getBuses()) {
                if (placa.equals(bus.getPlaca())) {
                    existeBus = true;
                    break;
                }
            }

            if (placa != null && !placa.isEmpty() && chofer != null && !chofer.isEmpty() && existeBus==false  ) {
                String mensaje = "Placa: " + placa + "\nChofer: " + chofer;
                JOptionPane.showMessageDialog(this, mensaje, "Información Capturada", JOptionPane.INFORMATION_MESSAGE);
                Flotilla.agregarBus(placa, chofer, configuracion.getCantPersonas());
            } else {
                if (placa.isEmpty()) {
                    String mensaje = "Por favor, ingrese la placa del autobús.";
                    JOptionPane.showMessageDialog(this, mensaje, "Advertencia", JOptionPane.WARNING_MESSAGE);
                }
                if (chofer == null || chofer.isEmpty()) {
                    String mensaje = "Por favor, ingrese el nombre del chofer.";
                    JOptionPane.showMessageDialog(this, mensaje, "Advertencia", JOptionPane.WARNING_MESSAGE);
                } 
                if (existeBus) {
                    String mensaje = "El autobús con la placa " + placa + " ya está registrado";
                    JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
                    existeBus=false;
                }
            }
            
        });
        
     // Botón para modificar el nombre del chofer
        JButton modificarButton = new JButton("Cambiar Chofer");
        modificarButton.setBounds(225, 250, 180, 50);
        personalizarBoton(modificarButton, new Font("Arial", Font.PLAIN, 20), new Color(50, 120, 50));
        modificarButton.addActionListener(e -> {
        	String placa = rutaTextArea.getText();
            String nuevoChofer = autobusTextArea.getText();
            boolean existeBus = false;
            for (Autobus bus : Flotilla.getBuses()) {
                if (placa.equals(bus.getPlaca())) {
                    existeBus = true;
                    bus.setConductor(nuevoChofer); // Modificar el nombre del chofer
                    break;
                }
            }

            if (!existeBus) {
                String mensaje = "El autobús con la placa " + placa + " no está registrado en la flotilla.";
                JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                String mensaje = "Chofer del autobús con placa " + placa + " modificado a: " + nuevoChofer;
                JOptionPane.showMessageDialog(this, mensaje, "Información Actualizada", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        // Botón para borrar un autobús
        JButton borrarButton = new JButton("Borrar Autobús");
        borrarButton.setBounds(225, 350, 180, 50);
        personalizarBoton(borrarButton, new Font("Arial", Font.PLAIN, 20), new Color(77, 50, 100));
        borrarButton.addActionListener(e -> {
            String placa = rutaTextArea.getText();
            boolean eliminado = false;
            for (Autobus bus : Flotilla.getBuses()) {
                if (placa.equals(bus.getPlaca())) {
                    Flotilla.getBuses().remove(bus);
                    eliminado = true;
                    break;
                }
            }
            

            if (eliminado) {
                String mensaje = "El autobús con la placa " + placa + " ha sido eliminado de la flotilla.";
                JOptionPane.showMessageDialog(this, mensaje, "Autobús Eliminado", JOptionPane.INFORMATION_MESSAGE);
            } else {
                String mensaje = "El autobús con la placa " + placa + " no está registrado en la flotilla.";
                JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
           
        getContentPane().add(button1);
        getContentPane().add(modificarButton);
        getContentPane().add(borrarButton);
    }
    
    private void personalizarBoton(JButton button, Font font, Color backgroundColor) {
        button.setFont(font);
        button.setForeground(Color.WHITE);
        button.setBackground(backgroundColor);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
    }
}




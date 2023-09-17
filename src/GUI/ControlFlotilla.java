package GUI;

import javax.swing.*; 
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ControlFlotilla extends JFrame {
	private JTextArea conductorTextArea;
    private JTextArea autobusTextArea;

    public ControlFlotilla() {
    	// Usa FondoPanel como el panel de contenido
        FondoPanel fondoPanel = new FondoPanel("C:\\Users\\windows\\Documents\\TransportePúblico\\src\\GUI\\maxresdefault.jpg");
        
        setContentPane(fondoPanel);
        setTitle("Control de Flotilla");
        setSize(620, 800);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocation(60, 60);

        
        JLabel label = new JLabel("Flotilla");
        label.setFont(new Font("Arial", Font.BOLD, 40));
        label.setForeground(Color.BLACK);
        label.setBounds(250, 10, 250, 100);
        getContentPane().setLayout(null);
        getContentPane().add(label);

        
        JLabel conductorLabel = new JLabel("Conductor:");
        conductorLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        conductorLabel.setForeground(Color.BLACK);
        conductorLabel.setBounds(60, 100, 90, 25);
        getContentPane().setLayout(null);
        getContentPane().add(conductorLabel);
    
        conductorTextArea = new JTextArea();
        conductorTextArea.setBounds(145, 100, 150, 30);
        getContentPane().setLayout(null);
        getContentPane().add(conductorTextArea);

        // Etiqueta y área de texto para "Autobús"
        JLabel autobusLabel = new JLabel("Autobus:");
        autobusLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        autobusLabel.setForeground(Color.BLACK);
        autobusLabel.setBounds(310,100, 90, 25);
        getContentPane().add(autobusLabel);

        autobusTextArea = new JTextArea();
        autobusTextArea.setBounds(390, 100, 180, 30);
        getContentPane().add(autobusTextArea);
        
        
     // Etiqueta y área de texto para "Autobús"
        JLabel autobusLabel1 = new JLabel("Ruta: ");
        autobusLabel1.setFont(new Font("Arial", Font.PLAIN, 16));
        autobusLabel1.setForeground(Color.BLACK);
        autobusLabel1.setBounds(210,150, 90, 25);
        getContentPane().add(autobusLabel1);

        JTextArea rutaTextArea = new JTextArea();
        rutaTextArea.setBounds(290, 150, 180, 30);
        getContentPane().add(rutaTextArea);
        
        
        
        

        // Botón para realizar acciones con la información ingresada
        JButton button1 = new JButton("Agregar Autobus");
        button1.setBounds(240, 250, 150, 50);
        personalizarBoton(button1, new Font("Arial", Font.BOLD, 12), new Color(50, 10, 220));
        button1.addActionListener(e -> {
        	String conductor = conductorTextArea.getText();
            String autobus = autobusTextArea.getText();
            String ruta = rutaTextArea.getText();
            String mensaje = "Conductor: " + conductor + "\nAutobus: "+autobus + "\nRuta: "+ruta;
            JOptionPane.showMessageDialog(this, mensaje, "Autobus agregado", JOptionPane.INFORMATION_MESSAGE);
        });
     // Botón para realizar acciones con la información ingresada
        JButton button2 = new JButton("Reparar Autobus");
        button2.setBounds(240, 350, 150, 50);
        personalizarBoton(button2, new Font("Arial", Font.BOLD,12), new Color(0, 128, 64));
        button2.addActionListener(e ->{
            String autobus = autobusTextArea.getText();
            String mensaje = "Autobus: "+autobus + "\nEstado: Dañado";
            JOptionPane.showMessageDialog(this, mensaje, "Daños del autobus", JOptionPane.INFORMATION_MESSAGE);
        });
        
     // Botón para realizar acciones con la información ingresada
        JButton button3 = new JButton("Estado de Autobus");
        button3.setBounds(240, 450, 150, 50);
        personalizarBoton(button3,new Font("Arial", Font.BOLD,12), Color.RED);
        button3.addActionListener(e -> {
        	
            String autobus = autobusTextArea.getText();
            String mensaje = "Autubus "+autobus+" reparado";
            JOptionPane.showMessageDialog(this, mensaje, "Reparación" , JOptionPane.INFORMATION_MESSAGE);
        });
        
            
            
        getContentPane().add(button1);
        getContentPane().add(button2);
        getContentPane().add(button3);
    }
    private void personalizarBoton(JButton button, Font font, Color backgroundColor) {
        button.setFont(font);
        button.setForeground(Color.WHITE);
        button.setBackground(backgroundColor);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
    }
   

  }


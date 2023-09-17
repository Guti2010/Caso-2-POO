package GUI;

import javax.swing.*;
import java.awt.*;

public class SolicitarInformacion extends JFrame {
	private JTextArea rutaTextArea;
    private JTextArea autobusTextArea;

    public SolicitarInformacion() {
    	
    	// Usa FondoPanel como el panel de contenido
        FondoPanel fondoPanel = new FondoPanel("C:\\Users\\windows\\Documents\\TransportePúblico\\src\\GUI\\maxresdefault.jpg");
        
        setContentPane(fondoPanel);
        setTitle("Solicitar Información");
        setSize(620, 800);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocation(60, 60);

        ImageIcon imagenIcono = new ImageIcon("C:\\Users\\windows\\Documents\\TransportePúblico\\src\\GUI\\6398309.jpg");
        Image imagen = imagenIcono.getImage();
        Image nuevaImagen = imagen.getScaledInstance(300, 300, Image.SCALE_SMOOTH); // Ajusta el tamaño de la imagen
        ImageIcon nuevaImagenIcono = new ImageIcon(nuevaImagen);
        
        JLabel imagenLabel = new JLabel(nuevaImagenIcono);
        imagenLabel.setBounds(150, 350, 320, 300);
        getContentPane().add(imagenLabel);


        
        
        
        JLabel label = new JLabel("Información");
        label.setFont(new Font("Arial", Font.BOLD, 40));
        label.setForeground(Color.BLACK);
        label.setBounds(200, 10, 250, 100);
        getContentPane().setLayout(null);
        getContentPane().add(label);

        // Etiqueta y área de texto para "Ruta"
        JLabel rutaLabel = new JLabel("Ruta:");
        rutaLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        rutaLabel.setForeground(Color.BLACK);
        rutaLabel.setBounds(70, 150, 70, 25);
        getContentPane().setLayout(null);
        getContentPane().add(rutaLabel);
        

        rutaTextArea = new JTextArea();
        rutaTextArea.setBounds(110, 150, 150, 30); // Cambia el tamaño según tus necesidades
        getContentPane().setLayout(null);
        getContentPane().add(rutaTextArea);

        // Etiqueta y área de texto para "Autobús"
        JLabel autobusLabel = new JLabel("Ubicación actual:");
        autobusLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        autobusLabel.setForeground(Color.BLACK);
        autobusLabel.setBounds(270, 150, 130, 25);
        getContentPane().add(autobusLabel);

        autobusTextArea = new JTextArea();
        autobusTextArea.setBounds(400, 150, 180, 30); // Cambia el tamaño según tus necesidades
        getContentPane().add(autobusTextArea);

        // Botón para realizar acciones con la información ingresada
        JButton button1 = new JButton("Consultar");
        button1.setBounds(240, 250, 150, 50);
        personalizarBoton(button1, new Font("Arial", Font.PLAIN, 20), new Color(204, 153, 0));
        button1.addActionListener(e -> {
        	String ruta = rutaTextArea.getText();
            
            String mensaje = "Ruta: " + ruta  + "\nUbicación de autobus más cercano: parada hacia " + "\nHorario de Salida" ;
            JOptionPane.showMessageDialog(this, mensaje, "Información Capturada", JOptionPane.INFORMATION_MESSAGE);
        });
        
            
            
        getContentPane().add(button1);
    }
    
    private void personalizarBoton(JButton button, Font font, Color backgroundColor) {
        button.setFont(font);
        button.setForeground(Color.WHITE);
        button.setBackground(backgroundColor);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
    }
}

    

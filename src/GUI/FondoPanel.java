package GUI;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class FondoPanel extends JPanel {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Image imagenFondo;

    public FondoPanel(String pRuta) {
        // Carga la imagen de fondo (asegúrate de tener la imagen en tu proyecto)
        ImageIcon icono = new ImageIcon(pRuta); // Reemplaza con la ruta de tu imagen
        imagenFondo = icono.getImage();
    }

   
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Dibuja la imagen de fondo
        g.drawImage(imagenFondo, 0, 0, getWidth(), getHeight(), this);
    }
}

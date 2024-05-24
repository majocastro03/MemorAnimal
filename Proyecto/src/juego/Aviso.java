package juego;

import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.border.LineBorder;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

import java.awt.Toolkit;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import javax.swing.JButton;

public class Aviso extends JFrame{
	

	public Aviso(boolean otrojug, String nombre) {
		getContentPane().setBackground(new Color(230, 230, 250));
		getContentPane().setLayout(null);
		
		JButton btnSalir = new JButton("Ok");
		btnSalir.setForeground(new Color(230, 230, 250));
		btnSalir.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
			public void mouseEntered(MouseEvent e) {
				btnSalir.setForeground(new Color(255, 250, 205));
				btnSalir.setBackground(new Color(255, 215, 0));
			}
			
			public void mouseExited(MouseEvent e) {
				btnSalir.setForeground(new Color(255, 215, 0));
				btnSalir.setBackground(new Color(255, 250, 205));
			}
		});
		
		btnSalir.setForeground(new Color(255, 215, 0));
		btnSalir.setBackground(new Color(255, 250, 205));
		btnSalir.setBorder(new LineBorder(new Color(255, 250, 205), 1, true));
		btnSalir.setFont(new Font("Cocogoose", Font.PLAIN, 18));
		btnSalir.setBounds(110, 55, 80, 35);
		btnSalir.setFocusable(false);
		getContentPane().add(btnSalir);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(10, 10, 280, 80);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel Title = new JLabel("Siguiente jugador");
		Title.setBounds(0, 6, 280, 20);
		panel.add(Title);
		Title.setForeground(new Color(147, 112, 219));
		Title.setHorizontalAlignment(SwingConstants.CENTER);
		Title.setFont(new Font("The Bold Font", Font.PLAIN, 18));

		JLabel Jug = new JLabel(nombre);
		Jug.setBounds(0, 27, 280, 14);
		panel.add(Jug);
		Jug.setForeground(new Color(75, 0, 130));
		Jug.setHorizontalAlignment(SwingConstants.CENTER);
		Jug.setFont(new Font("Bahnscript", Font.PLAIN, 14));

		setType(Type.POPUP);
		setIconImage(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/imagenes/pata1sinfondo.png")));
		setTitle("MemorAnimal");
		setBackground(new Color(147, 112, 219));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(300,100);
		setUndecorated(true);
		setLocationRelativeTo(null);
		setResizable(false);
		
		
		
		
	}
	
	
	public Aviso(String nombre) {
		getContentPane().setBackground(new Color(230, 230, 250));
		getContentPane().setLayout(null);
		
		JButton btnSalir = new JButton("Ok");
		btnSalir.setForeground(new Color(230, 230, 250));
		btnSalir.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
			public void mouseEntered(MouseEvent e) {
				btnSalir.setForeground(new Color(255, 250, 205));
				btnSalir.setBackground(new Color(255, 215, 0));
			}
			
			public void mouseExited(MouseEvent e) {
				btnSalir.setForeground(new Color(255, 215, 0));
				btnSalir.setBackground(new Color(255, 250, 205));
			}
		});
		
		btnSalir.setForeground(new Color(255, 215, 0));
		btnSalir.setBackground(new Color(255, 250, 205));
		btnSalir.setBorder(new LineBorder(new Color(255, 250, 205), 1, true));
		btnSalir.setFont(new Font("The Bold Font", Font.PLAIN, 20));
		btnSalir.setBounds(152, 121, 103, 44);
		btnSalir.setFocusable(false);
		getContentPane().add(btnSalir);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(50, 32, 304, 105);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel nombre1 = new JLabel(nombre);
		nombre1.setHorizontalAlignment(SwingConstants.CENTER);
		nombre1.setBounds(10, 49, 284, 22);
		panel.add(nombre1);
		nombre1.setForeground(new Color(75, 0, 130));
		nombre1.setFont(new Font("Cocogoose", Font.BOLD, 22));
		
		JLabel Title = new JLabel("Empieza la partida:");
		Title.setBounds(-42, 0, 393, 51);
		panel.add(Title);
		Title.setForeground(new Color(147, 112, 219));
		Title.setHorizontalAlignment(SwingConstants.CENTER);
		Title.setFont(new Font("The Bold Font", Font.PLAIN, 28));
		setType(Type.POPUP);
		setIconImage(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/imagenes/pata1sinfondo.png")));
		setTitle("MemorAnimal");
		setBackground(new Color(147, 112, 219));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(403,188);
		setUndecorated(true);
		setLocationRelativeTo(null);
		setResizable(false);
		setAlwaysOnTop(true);
		
	}
	
	
	public Aviso(int puntaje, String nombreJug) {
		getContentPane().setBackground(new Color(230, 230, 250));
		getContentPane().setLayout(null);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setForeground(new Color(230, 230, 250));
		btnSalir.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				dispose();
				System.exit(0);
			}
			public void mouseEntered(MouseEvent e) {
				btnSalir.setForeground(new Color(255, 250, 205));
				btnSalir.setBackground(new Color(255, 215, 0));
			}
			
			public void mouseExited(MouseEvent e) {
				btnSalir.setForeground(new Color(255, 215, 0));
				btnSalir.setBackground(new Color(255, 250, 205));
			}
		});
		
		btnSalir.setForeground(new Color(255, 215, 0));
		btnSalir.setBackground(new Color(255, 250, 205));
		btnSalir.setBorder(new LineBorder(new Color(255, 250, 205), 1, true));
		btnSalir.setFont(new Font("The Bold Font", Font.PLAIN, 20));
		btnSalir.setBounds(56, 121, 103, 44);
		btnSalir.setFocusable(false);
		getContentPane().add(btnSalir);

		JButton btnJugar = new JButton("Volver a Jugar");
		btnJugar.setForeground(new Color(230, 230, 250));
		btnJugar.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				dispose();
				
			}
			public void mouseEntered(MouseEvent e) {
				btnJugar.setForeground(new Color(255, 250, 205));
				btnJugar.setBackground(new Color(255, 215, 0));
			}
			
			public void mouseExited(MouseEvent e) {
				btnJugar.setForeground(new Color(255, 215, 0));
				btnJugar.setBackground(new Color(255, 250, 205));
			}
		});
		
		btnJugar.setForeground(new Color(255, 215, 0));
		btnJugar.setBackground(new Color(255, 250, 205));
		btnJugar.setBorder(new LineBorder(new Color(255, 250, 205), 1, true));
		btnJugar.setFont(new Font("The Bold Font", Font.PLAIN, 20));
		btnJugar.setBounds(170, 121, 180, 44);
		btnJugar.setFocusable(false);
		getContentPane().add(btnJugar);

		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(50, 32, 304, 105);
		getContentPane().add(panel);
		panel.setLayout(null);
		

		
		JLabel Title = new JLabel("Partida terminada");
		Title.setBounds(0, 0, 304, 51);
		panel.add(Title);
		Title.setForeground(new Color(147, 112, 219));
		Title.setHorizontalAlignment(SwingConstants.CENTER);
		Title.setFont(new Font("The Bold Font", Font.PLAIN, 26));
		
		JLabel texto = new JLabel("¡Ganaste "+nombreJug+"!");
		texto.setHorizontalAlignment(SwingConstants.CENTER);
		texto.setBounds(0, 41, 304, 22);
		panel.add(texto);
		texto.setForeground(new Color(75, 0, 130));
		texto.setFont(new Font("Cocogoose", Font.PLAIN, 20));
		
		JLabel puntajee = new JLabel("Puntaje: "+puntaje+"");
		puntajee.setHorizontalAlignment(SwingConstants.CENTER);
		puntajee.setBounds(0, 66, 304, 12);
		panel.add(puntajee);
		puntajee.setForeground(new Color(75, 0, 130));
		puntajee.setFont(new Font("Bahnscript", Font.BOLD, 12));
		
		
		
		
		setType(Type.POPUP);
		setIconImage(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/imagenes/FINAL.png")));
		setTitle("MemorAnimal");
		setBackground(new Color(147, 112, 219));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(403,188);
		setUndecorated(true);
		setLocationRelativeTo(null);
		setResizable(false);
		
	}
	
	public Aviso(int puntaje) {
		getContentPane().setBackground(new Color(230, 230, 250));
		getContentPane().setLayout(null);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setForeground(new Color(230, 230, 250));
		btnSalir.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				dispose();
				System.exit(0);
			}
			public void mouseEntered(MouseEvent e) {
				btnSalir.setForeground(new Color(255, 250, 205));
				btnSalir.setBackground(new Color(255, 215, 0));
			}
			
			public void mouseExited(MouseEvent e) {
				btnSalir.setForeground(new Color(255, 215, 0));
				btnSalir.setBackground(new Color(255, 250, 205));
			}
		});
		
		btnSalir.setForeground(new Color(255, 215, 0));
		btnSalir.setBackground(new Color(255, 250, 205));
		btnSalir.setBorder(new LineBorder(new Color(255, 250, 205), 1, true));
		btnSalir.setFont(new Font("The Bold Font", Font.PLAIN, 20));
		btnSalir.setBounds(56, 121, 103, 44);
		btnSalir.setFocusable(false);
		getContentPane().add(btnSalir);

		JButton btnJugar = new JButton("Volver a Jugar");
		btnJugar.setForeground(new Color(230, 230, 250));
		btnJugar.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				dispose();
				
			}
			public void mouseEntered(MouseEvent e) {
				btnJugar.setForeground(new Color(255, 250, 205));
				btnJugar.setBackground(new Color(255, 215, 0));
			}
			
			public void mouseExited(MouseEvent e) {
				btnJugar.setForeground(new Color(255, 215, 0));
				btnJugar.setBackground(new Color(255, 250, 205));
			}
		});
		
		btnJugar.setForeground(new Color(255, 215, 0));
		btnJugar.setBackground(new Color(255, 250, 205));
		btnJugar.setBorder(new LineBorder(new Color(255, 250, 205), 1, true));
		btnJugar.setFont(new Font("The Bold Font", Font.PLAIN, 20));
		btnJugar.setBounds(170, 121, 180, 44);
		btnJugar.setFocusable(false);
		getContentPane().add(btnJugar);

		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(50, 32, 304, 105);
		getContentPane().add(panel);
		panel.setLayout(null);
		

		
		JLabel Title = new JLabel("Partida terminada");
		Title.setBounds(0, 0, 304, 51);
		panel.add(Title);
		Title.setForeground(new Color(147, 112, 219));
		Title.setHorizontalAlignment(SwingConstants.CENTER);
		Title.setFont(new Font("The Bold Font", Font.PLAIN, 26));
		
		JLabel texto = new JLabel("¡Empate!");
		texto.setHorizontalAlignment(SwingConstants.CENTER);
		texto.setBounds(0, 41, 304, 22);
		panel.add(texto);
		texto.setForeground(new Color(75, 0, 130));
		texto.setFont(new Font("Cocogoose", Font.PLAIN, 20));
		
		JLabel puntajee = new JLabel("Puntaje: "+puntaje+"");
		puntajee.setHorizontalAlignment(SwingConstants.CENTER);
		puntajee.setBounds(0, 66, 304, 12);
		panel.add(puntajee);
		puntajee.setForeground(new Color(75, 0, 130));
		puntajee.setFont(new Font("Bahnscript", Font.BOLD, 12));
		
		
		
		
		setType(Type.POPUP);
		setIconImage(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/imagenes/FINAL.png")));
		setTitle("MemorAnimal");
		setBackground(new Color(147, 112, 219));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(403,188);
		setUndecorated(true);
		setLocationRelativeTo(null);
		setResizable(false);
		
	}
}
package juego;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Inicio extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inicio frame = new Inicio();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Inicio() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Inicio.class.getResource("/imagenes/pata1sinfondo.png")));
		setTitle("MemorAnimal");
		setBackground(new Color(147, 112, 219));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(800,600);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(147, 112, 219));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBorder(new LineBorder(new Color(148, 0, 211), 7, true));

		panel.setBounds(175, 105, 447, 356);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel title = new JLabel("MemorAnimal");
		title.setBounds(49, 52, 355, 77);
		panel.add(title);
		title.setForeground(new Color(147, 112, 219));
		title.setFont(new Font("The Bold Font", Font.PLAIN, 48));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton btnJugar = new JButton("Jugar");
		btnJugar.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				dispose();
				new Modo().setVisible(true);;	
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
		btnJugar.setFocusable(false);
		btnJugar.setFont(new Font("Cocogoose", Font.PLAIN, 25));
		btnJugar.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
		btnJugar.setBounds(120, 139, 202, 64);
		panel.add(btnJugar);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
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
		btnSalir.setFont(new Font("Cocogoose", Font.PLAIN, 25));
		btnSalir.setFocusable(false);
		btnSalir.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
		btnSalir.setBackground(new Color(255, 250, 205));
		btnSalir.setBounds(120, 213, 202, 64);
		panel.add(btnSalir);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(230, 230, 250));
		panel_1.setBounds(159, 91, 476, 387);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel fondo = new JLabel("");
		fondo.setIcon(new ImageIcon(Inicio.class.getResource("/imagenes/FONDO.png")));
		fondo.setBounds(0, 0, 800, 600);
		contentPane.add(fondo);
	}
}
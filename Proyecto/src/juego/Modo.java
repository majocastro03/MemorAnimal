package juego;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;


public class Modo extends JFrame {

	private JPanel contentPane;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Modo frame = new Modo();
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
	public Modo() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Modo.class.getResource("/imagenes/pata1sinfondo.png")));
		setSize(800,600);
		setLocationRelativeTo(null);
		setTitle("MemorAnimal");
		setBackground(new Color(147, 112, 219));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
		
		JLabel title = new JLabel("Escoge el modo de juego");
		title.setBounds(34, 60, 388, 77);
		panel.add(title);
		title.setForeground(new Color(147, 112, 219));
		title.setFont(new Font("Cocogoose", Font.BOLD, 25));
		title.setHorizontalAlignment(SwingConstants.CENTER);

		
		JButton btn1 = new JButton("Un jugador");
		btn1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				dispose();
				new Dificultad().setVisible(true);
			}
			
			public void mouseEntered(MouseEvent e) {
				btn1.setForeground(new Color(255, 250, 205));
				btn1.setBackground(new Color(255, 215, 0));
			}
			
			public void mouseExited(MouseEvent e) {
				btn1.setForeground(new Color(255, 215, 0));
				btn1.setBackground(new Color(255, 250, 205));
			}
			
			
		});
		btn1.setForeground(new Color(255, 215, 0));
		btn1.setBackground(new Color(255, 250, 205));
		btn1.setFocusable(false);
		btn1.setFont(new Font("Cocogoose", Font.PLAIN, 20));
		btn1.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
		btn1.setBounds(45, 138, 161, 50);
		panel.add(btn1);
		
		JButton btn2 = new JButton("Dos jugadores");
		btn2.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				new Dificultad2().setVisible(true);
				dispose();
			}
			
			public void mouseEntered(MouseEvent e) {
				btn2.setForeground(new Color(255, 250, 205));
				btn2.setBackground(new Color(255, 215, 0));
			}
			
			public void mouseExited(MouseEvent e) {
				btn2.setForeground(new Color(255, 215, 0));
				btn2.setBackground(new Color(255, 250, 205));
			}
			
			
		});
		btn2.setForeground(new Color(255, 215, 0));
		btn2.setFont(new Font("Cocogoose", Font.PLAIN, 20));
		btn2.setFocusable(false);
		btn2.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
		btn2.setBackground(new Color(255, 250, 205));
		btn2.setBounds(227, 138, 182, 50);
		panel.add(btn2);
		
		JButton btn1C = new JButton("Un jugador vs. la computadora");
		btn1C.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				new Dificultad3().setVisible(true);
				dispose();
			}
			
			public void mouseEntered(MouseEvent e) {
				btn1C.setForeground(new Color(255, 250, 205));
				btn1C.setBackground(new Color(255, 215, 0));
			}
			
			public void mouseExited(MouseEvent e) {
				btn1C.setForeground(new Color(255, 215, 0));
				btn1C.setBackground(new Color(255, 250, 205));
			}});
		btn1C.setForeground(new Color(255, 215, 0));
		btn1C.setFont(new Font("Cocogoose", Font.PLAIN, 19));
		btn1C.setFocusable(false);
		btn1C.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
		btn1C.setBackground(new Color(255, 250, 205));
		btn1C.setBounds(45, 209, 364, 50);
		panel.add(btn1C);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(230, 230, 250));
		panel_1.setBounds(159, 91, 476, 387);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton atras = new JButton("Atrás");
		atras.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				dispose();
				new Inicio().setVisible(true);
			}
		});
		atras.setBounds(10, 10, 85, 31);
		atras.setForeground(new Color(148, 0, 211));
		atras.setFont(new Font("Cocogoose", Font.PLAIN, 15));
		atras.setFocusable(false);
		atras.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
		atras.setBackground(new Color(255, 255, 255));
		contentPane.add(atras);
	}
}
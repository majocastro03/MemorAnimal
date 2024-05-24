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
import javax.swing.JTextField;

public class Dificultad3 extends JFrame {

	private JPanel contentPane;
	private JTextField nombre;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dificultad3 frame = new Dificultad3();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Dificultad3() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Dificultad3.class.getResource("/imagenes/pata1sinfondo.png")));
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
		
		JLabel title = new JLabel("Ingresa tu nombre");
		title.setBounds(45, 20, 364, 77);
		panel.add(title);
		title.setForeground(new Color(147, 112, 219));
		title.setFont(new Font("Cocogoose", Font.BOLD, 25));
		title.setHorizontalAlignment(SwingConstants.CENTER);

		
		JButton btn1 = new JButton("4x4");
		btn1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				dispose();
				Computador4.main(nombre.getText());
		
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
		btn1.setFont(new Font("CHICKEN Pie Height", Font.PLAIN, 25));
		btn1.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
		btn1.setBounds(45, 194, 169, 50);
		panel.add(btn1);
		
		JButton btn2 = new JButton("6x6");
		btn2.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				dispose();
				Computador6.main(nombre.getText());			}
			
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
		btn2.setFont(new Font("CHICKEN Pie Height", Font.PLAIN, 25));
		btn2.setFocusable(false);
		btn2.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
		btn2.setBackground(new Color(255, 250, 205));
		btn2.setBounds(240, 194, 169, 50);
		panel.add(btn2);
		
		JButton btn3 = new JButton("8x8");
		btn3.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				dispose();
				Computador8.main(nombre.getText());
			}
			
			public void mouseEntered(MouseEvent e) {
				btn3.setForeground(new Color(255, 250, 205));
				btn3.setBackground(new Color(255, 215, 0));
			}
			
			public void mouseExited(MouseEvent e) {
				btn3.setForeground(new Color(255, 215, 0));
				btn3.setBackground(new Color(255, 250, 205));
			}});
		btn3.setForeground(new Color(255, 215, 0));
		btn3.setFont(new Font("CHICKEN Pie Height", Font.PLAIN, 25));
		btn3.setFocusable(false);
		btn3.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
		btn3.setBackground(new Color(255, 250, 205));
		btn3.setBounds(45, 267, 364, 50);
		panel.add(btn3);
		
		JLabel title2 = new JLabel("Escoge la dificultad");
		title2.setHorizontalAlignment(SwingConstants.CENTER);
		title2.setForeground(new Color(147, 112, 219));
		title2.setFont(new Font("Cocogoose", Font.BOLD, 25));
		title2.setBounds(45, 122, 364, 77);
		panel.add(title2);
		
		nombre = new JTextField();
		

		nombre.setHorizontalAlignment(SwingConstants.CENTER);
		nombre.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				nombre.setText("");

			}
			
			
		});
		nombre.setForeground(Color.LIGHT_GRAY);
		nombre.setFont(new Font("Cocogoose", Font.PLAIN, 20));
		nombre.setText("Aquí");
		nombre.setBounds(45, 86, 364, 39);
		panel.add(nombre);
		nombre.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(230, 230, 250));
		panel_1.setBounds(159, 91, 476, 387);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton atras = new JButton("Atrás");
		atras.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				dispose();
				new Modo().setVisible(true);
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
	
	
	public String getNombreJug() {
		String nombreJug= nombre.getText();
		return nombreJug;
	}
}
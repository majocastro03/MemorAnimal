package juego;

import java.util.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.util.Iterator;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

@SuppressWarnings("serial")//no serialización ¿?
public class Memorama extends JFrame implements ActionListener {
	
	JButton arreglo[] = new JButton[64];//arreglo para los botones
	Carta cartas[] = new Carta[64];//arreglo para las cartas
	Carta temporal = new Carta(0, "/imagenes/pata1sinfondo.png", 0); //carta por defecto
	protected int par = 0;
	int contadorMovimientos = 0;
	int contadorPuntaje = 0;
	int puntaje1 = 0; int puntaje2 = 0;
	int numJugador=0;
	String nombre1;
	String nombre2;
	Usuario usuario1;
	Usuario usuario2;
	ArrayList <Usuario> listaUsuarios= new ArrayList<Usuario>();
	
	public Memorama(String nombre) {
		iniciarTablero(nombre);

	}
	public Memorama(String nombre, String nombre2) {
		iniciarTablero(nombre, nombre2);
		

	}

	public final void iniciarTablero(String nombreJug) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Memorama.class.getResource("/imagenes/pata1sinfondo.png")));
		setTitle("MemorAnimal");
		setBackground(new Color(147, 112, 219));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(609,699);
		setLocationRelativeTo(null);
		setResizable(false);
		JPanel contentPane = new JPanel();
		contentPane.setBackground(new Color(147, 112, 219));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(230, 230, 250));
		panel_1.setBounds(38, 64, 512, 501);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		nombre1=nombreJug;
		
		numJugador = 1;
		
	    JLabel nombre1= new JLabel(nombreJug);
		nombre1.setHorizontalAlignment(SwingConstants.LEFT);
		nombre1.setForeground(new Color(230, 230, 250));
		nombre1.setFont(new Font("CHICKEN Pie Height", Font.BOLD, 25));
		nombre1.setBounds(38, 25, 169, 42);
		contentPane.add(nombre1);
		
		
		
		JTextArea Salir = new JTextArea();
		Salir.setText("   Abandonar         partida");
		Salir.setLineWrap(true);
		Salir.setForeground(Color.PINK);
		Salir.setFont(new Font("Cocogoose", Font.PLAIN, 18));
		Salir.setEditable(false);
		Salir.setBackground(Color.WHITE);
		Salir.setBounds(192, 575, 143, 60);
		contentPane.add(Salir);
		
		JButton btnSalir = new JButton("");
		btnSalir.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				dispose();
				new Inicio().setVisible(true);
			}
		});
		btnSalir.setIcon(new ImageIcon(Memorama.class.getResource("/imagenes/pata1peq.png")));
		btnSalir.setBorder(new LineBorder(new Color(245, 169, 183), 1, true));
		btnSalir.setBackground(Color.PINK);
		btnSalir.setBounds(333, 575, 60, 60);
		contentPane.add(btnSalir);
		
		int contador = 0;
		//for para poner botones de manera aleatoria

		for (int i = 381; i > 11; i=i-120) {
			for (int j =0 ; j < 4; j++) {
			JButton boton = new JButton("");
			boton.setBorder(null);
			boton.setIcon(new ImageIcon(Memorama.class.getResource("/imagenes/tarjetaAtras110x110.png")));
			boton.setBounds((i), (j)*126, 110, 110);
			boton.addActionListener(this);
			boton.setName(contador + "");
			arreglo[contador] = boton;
			contador++;
			panel_1.add(boton);
			}
		}
		
		//llamar metodo para poner las cartas
		revolver();
	}
	
	public final void iniciarTablero(String nombreJug, String nombreJug2) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Memorama.class.getResource("/imagenes/pata1sinfondo.png")));
		setTitle("MemorAnimal");
		setBackground(new Color(147, 112, 219));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(609,699);
		setLocationRelativeTo(null);
		setResizable(false);
		JPanel contentPane = new JPanel();
		contentPane.setBackground(new Color(147, 112, 219));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(230, 230, 250));
		panel_1.setBounds(38, 64, 512, 501);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		nombre1=nombreJug;
		nombre2=nombreJug2;
		numJugador = ElegirJugador(nombre1, nombre2);
		if (numJugador == 1) {
			new Aviso(nombre1).setVisible(true);
		} else {
			new Aviso(nombre2).setVisible(true);
		}
		
		
	    JLabel nombre1= new JLabel(nombreJug);
		nombre1.setHorizontalAlignment(SwingConstants.LEFT);
		nombre1.setForeground(new Color(230, 230, 250));
		nombre1.setFont(new Font("CHICKEN Pie Height", Font.BOLD, 25));
		nombre1.setBounds(38, 25, 169, 42);
		contentPane.add(nombre1);
		
		JLabel nombre2 = new JLabel(nombreJug2);
		nombre2.setHorizontalAlignment(SwingConstants.RIGHT);
		nombre2.setForeground(new Color(230, 230, 250));
		nombre2.setFont(new Font("CHICKEN Pie Height", Font.BOLD, 25));
		nombre2.setBounds(380, 25, 169, 42);
		contentPane.add(nombre2);
		

		
		JTextArea Salir = new JTextArea();
		Salir.setText("   Abandonar         partida");
		Salir.setLineWrap(true);
		Salir.setForeground(Color.PINK);
		Salir.setFont(new Font("Cocogoose", Font.PLAIN, 18));
		Salir.setEditable(false);
		Salir.setBackground(Color.WHITE);
		Salir.setBounds(192, 575, 143, 60);
		contentPane.add(Salir);
		

		
		JButton btnSalir = new JButton("");
		btnSalir.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				dispose();
				new Inicio().setVisible(true);
			}
		});
		btnSalir.setIcon(new ImageIcon(Memorama.class.getResource("/imagenes/pata1peq.png")));
		btnSalir.setBorder(new LineBorder(new Color(245, 169, 183), 1, true));
		btnSalir.setBackground(Color.PINK);
		btnSalir.setBounds(333, 575, 60, 60);
		contentPane.add(btnSalir);
		
		int contador = 0;
		//for para poner botones de manera aleatoria

		for (int i = 381; i > 11; i=i-120) {
			for (int j =0 ; j < 4; j++) {
			JButton boton = new JButton("");
			boton.setBorder(null);
			boton.setIcon(new ImageIcon(Memorama.class.getResource("/imagenes/tarjetaAtras110x110.png")));
			boton.setBounds((i), (j)*126, 110, 110);
			boton.addActionListener(this);
			boton.setName(contador + "");
			arreglo[contador] = boton;
			contador++;
			panel_1.add(boton);
			}
		}
		
		//llamar metodo para poner las cartas
		revolver();
	}
	
	
	
	
	public void revolver() {
		int contadorLocal = 0;
		for (int i = 1; i < 9; i++) {
			Carta carta1 = new Carta(i, i + ".png", contadorLocal);
			Carta carta2 = new Carta(i, i + ".png", contadorLocal + 1);
			cartas[contadorLocal] = carta1;
			contadorLocal++;
			cartas[contadorLocal] = carta2;
			contadorLocal++;
		}
		int llenar = 0;
		System.out.println(llenar);
		Carta cartaTemporal[] = new Carta[16];
		for (int i = 0; i < cartaTemporal.length; i++) {
			cartaTemporal[i] = new Carta(0, "/imagenes/tarjetaAtras110x110.png", -1);
		}
		while (llenar <= 15) {
			int aleatorio = ((int) (Math.random() * 16));
			//busca si el numero aleatorio ya se encuentra en el arreglo de cartas
			if (buscarNumero(aleatorio, cartaTemporal)) {
				cartaTemporal[llenar] = cartas[aleatorio]; //llenar el arreglo de manera aleatoria
				cartaTemporal[llenar].boton = arreglo[llenar];//acceso a los botones
				llenar++;
			}
		}
		cartas = cartaTemporal;
	}


	
	//al metodo ingresa el numero aleatorio y un arreglo de cartas
	public boolean buscarNumero(int num, Carta contador[]) {
		int contador2 = 0;
		for (Carta c1 : contador) {
			if (num == c1.posicion) {
				contador2++;
			}
		}
		return (contador2 < 1);
	}
	public void MostrarCartas() {
		
		try {
			for (int i = 0; i < cartas.length; i++) {
			cartas[i].boton.setIcon(cartas[i].image);
		}
			Thread.sleep(1000);
		} catch (Exception e) {
			System.out.println(e);
		}
		for (int i = 0; i < cartas.length; i++) {
			cartas[i].boton.setIcon(cartas[i].fondo);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		for (int i = 0; i < arreglo.length; i++) {
			if (cartas[i].boton == e.getSource() && cartas[i].revelado == false) {
				cartas[i].boton.setIcon(cartas[i].image);//muestra la carta seleccionada
				if (par == 0) {
					cartas[i].revelado = true;//revela la carta 
					temporal = cartas[i]; //guarda la carta que el usuario elegió
					par = 1;
					contadorMovimientos++;
				} else {
					par = 0;
					if (cartas[i].valor == temporal.valor) {
						cartas[i].revelado = true;
						contadorPuntaje++;
						if(numJugador == 1){
							puntaje1++;
						}else{
							puntaje2++;
						}
					
						boolean bandera = true;
						for (Carta elemento : cartas) {
							if (elemento.revelado == false) {
								bandera = false;
								break;
							}
						}
						if (bandera) {
							if(nombre2==null){
								String puntajeString= String.valueOf(contadorMovimientos);
								usuario1= new Usuario(nombre1,puntajeString);
								addUsuarios(usuario1);
								String nomArchivo = "usuarios";
       								 try {
										Fichero fichero = new Fichero();
										fichero.crearXML(nomArchivo, listaUsuarios);
			
       								 } catch(Exception e3) {
          								e3.printStackTrace();
      								 }
								new Aviso(contadorMovimientos,nombre1).setVisible(true);
								
							}else{
								String puntaje1String= String.valueOf(puntaje1);
								String puntaje2String= String.valueOf(puntaje2);
								usuario1= new Usuario(nombre1,puntaje1String);
								usuario2= new Usuario(nombre2,puntaje2String);
								addUsuarios(usuario1);addUsuarios(usuario2);
								String nomArchivo = "usuarios";
       								 try {
										Fichero fichero = new Fichero();
										fichero.crearXML(nomArchivo, listaUsuarios);
			
       								 } catch(Exception e3) {
          								e3.printStackTrace();
      								 }
							if(puntaje1==puntaje2) {
								new Aviso(puntaje1).setVisible(true);
							}
							if (puntaje1>puntaje2) {
								new Aviso(puntaje1, nombre1).setVisible(true);
								
							} else {
								new Aviso(puntaje2, nombre2).setVisible(true);
								
							}}
							
						}

					}else {
						if(nombre2!=null) {
							if(numJugador==1){
								numJugador=2;
								new Aviso(true,nombre2).setVisible(true);
							}else{
								numJugador=1;
								new Aviso(true,nombre1).setVisible(true);
							}
							
						}
						try {
							//actualizar boton
							cartas[i].boton.update(cartas[i].boton.getGraphics());
							Thread.sleep(500);
							tapar(i);

						} catch (Exception e2) {
							System.out.println(e2);
						}
					}
				}
			}
		}

	}

	public void tapar(int a) {
		cartas[a].boton.setIcon(new ImageIcon(this.getClass().getResource("/imagenes/tarjetaAtras110x110.png")));//voltear carta
		cartas[Integer.valueOf(temporal.boton.getName())].revelado=false;
		cartas[Integer.valueOf(temporal.boton.getName())].boton.setIcon((new ImageIcon(this.getClass().getResource("/imagenes/tarjetaAtras110x110.png"))));
	}
	public static int ElegirJugador(String nombre1, String nombre2){
		int jugadorActual = 0;
		int numeroAleatorio = (int) (Math.random()*2);
		
		numeroAleatorio = jugadorActual;
		return numeroAleatorio;
	}

	public void addUsuarios(Usuario usuario) {
        listaUsuarios.add(usuario);
    }
	
	public static void main(String nombre, String nombre2) {
		new Memorama(nombre,nombre2).setVisible(true);
		
		}
	
	public static void main(String nombre) {
		new Memorama(nombre).setVisible(true);
		}
}

package juego;

import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;

//import java.util.Iterator;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

@SuppressWarnings("serial") // no serialización ¿?
public class Computador8 extends JFrame implements ActionListener {
	JButton arreglo[] = new JButton[64];//arreglo para los botones
	Carta cartas[] = new Carta[64];//arreglo para las cartas
	Carta temporal = new Carta(0, "/imagenes/pata1sinfondo.png", 0); //carta por defecto //esto aun no tiene ningun uso
	protected int par = 0;
	int contadorMovimientos1 = 0;
	int contadorMovimientos2 = 0;
	int puntaje1 = 0;
	int puntaje2 = 0;
	String nombre1;
	String nombre2 = "Computadora";
	Usuario usuario1;
	ArrayList <Usuario> listaUsuarios= new ArrayList<Usuario>();



	public Computador8(String nombreJug) {
		iniciarTablero(nombreJug);
	}

	public final void iniciarTablero(String nombreJug) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Memorama.class.getResource("/imagenes/pata1sinfondo.png")));
		setTitle("MemorAnimal");
		setBackground(new Color(147, 112, 219));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(646,762);
		setLocationRelativeTo(null);
		setResizable(false);
		JPanel contentPane = new JPanel();
		contentPane.setBackground(new Color(147, 112, 219));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(230, 230, 250));
		panel_1.setBounds(38, 64, 561, 561);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		nombre1=nombreJug;
		
		
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
		Salir.setBounds(217, 645, 143, 60);
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
		btnSalir.setBounds(360, 645, 60, 60);
		contentPane.add(btnSalir);
		
		int contador = 0;
		//for para poner botones de manera aleatoria

		for (int i = 500; i > 9; i=i-70) {
			for (int j =0 ; j < 8; j++) {
			JButton boton = new JButton("");
			boton.setBorder(null);
			boton.setIcon(new ImageIcon(Memorama8.class.getResource("/imagenes/tarjetaAtras60x60.png")));
			boton.setBounds((i), (j) * 70, 60, 60);
			boton.addActionListener(this);
			boton.setName(contador + "");
			arreglo[contador] = boton;
			contador++;
			panel_1.add(boton);
			}
		}
		
		//llamar metodo para poner las cartas
		revolver3();
		
		
	}

    public void revolver3() {
		int contadorLocal = 0;
		for (int i = 27; i < 59; i++) {
			//pares de cartas
			Carta carta1 = new Carta(i, i + ".png", contadorLocal);
			Carta carta2 = new Carta(i, i + ".png", contadorLocal + 1);
			cartas[contadorLocal] = carta1;
			contadorLocal++;
			cartas[contadorLocal] = carta2;
			contadorLocal++;
		}
		int llenar = 0;
		System.out.println(llenar);
		Carta cartaTemporal[] = new Carta[64]; //arreglo de cartas temporales
		for (int i = 0; i < cartaTemporal.length; i++) {
			cartaTemporal[i] = new Carta(0, "/imagenes/tarjetaAtras60x60.png", -1);
		}
		while (llenar <= 63) {
			int aleatorio = ((int) (Math.random() * 64));
			if (buscarNumero(aleatorio, cartaTemporal)) {
				cartaTemporal[llenar] = cartas[aleatorio];
				cartaTemporal[llenar].boton = arreglo[llenar];
				llenar++;
			}
		}
		cartas = cartaTemporal;
	}

	

	// al metodo ingresa el numero aleatorio y un arreglo de cartas
	public boolean buscarNumero(int num, Carta contador[]) {
		int contador2 = 0;
		for (Carta c1 : contador) {
			if (num == c1.posicion) {
				contador2++;
			}
		}
		return (contador2 < 1);
	}

	// Metodo para mostrar las cartas al inicio


	// Método para que la maquina juegue
	public void Jugar() {
		for (int i = 0; i < arreglo.length; i++) {
			i = (int) (Math.random() * 64); //el numero aleatorio es dependiendo la dificultad 
			if (cartas[i].revelado == false) {// seleccionar dos cartas
				cartas[i].boton.setIcon(cartas[i].image);// muestra la carta seleccionada
				if (par == 0) {
					cartas[i].revelado = true;// revela la carta
					temporal = cartas[i]; // guarda la carta que el usuario elegió
					par = 1;
					contadorMovimientos2++;
				} else {
					par = 0;
					if (cartas[i].valor == temporal.valor) {
						System.out.println(i);
						cartas[i].revelado = true;
						puntaje2++;
						if (puntaje1 + puntaje2 == 32) {
							ElegirGanador(puntaje1, puntaje2); //metodo para el puntaje
						}
					} else {
						JOptionPane.showMessageDialog(null, "Turno del jugador: " + nombre1);
						try {
							// actualizar boton
							cartas[i].boton.update(cartas[i].boton.getGraphics());
							Thread.sleep(500);
							tapar(i);
						} catch (Exception e2) {
							System.out.println(e2);
						}
						actionPerformed(null); //llama al metodo para que juegue el usuario
					}
				}
			}
		}
	}

	// Metodo para que el usuario juegue
	@Override
	public void actionPerformed(ActionEvent e) {
		
		for (int i = 0; i < arreglo.length; i++) {
			if (cartas[i].boton == e.getSource() && cartas[i].revelado == false) {// seleccionar dos cartas
				cartas[i].boton.setIcon(cartas[i].image);// muestra la carta seleccionada
				if (par == 0) {
					cartas[i].revelado = true;// revela la carta
					temporal = cartas[i]; // guarda la carta que el usuario elegió
					par = 1;
					contadorMovimientos1++;
				} else {
					par = 0;
					if (cartas[i].valor == temporal.valor) {
						System.out.println(i);
						cartas[i].revelado = true;
						puntaje1++;
						if (puntaje1 + puntaje2 == 8) {
							ElegirGanador(puntaje1, puntaje2);
						}
					} else {
						JOptionPane.showMessageDialog(null, "Turno del jugador: " + nombre2);
						try {
							// actualizar boton
							cartas[i].boton.update(cartas[i].boton.getGraphics());
							Thread.sleep(500);
							tapar(i);
						} catch (Exception e2) {
							System.out.println(e2);
						}
						Jugar(); //llama al metodo para que juegue la computadora 
					}
				}
			}
		}
	}

	// Metodo para elegir ganador
	public void ElegirGanador(int puntaje1, int puntaje2) {
		String puntajeString= String.valueOf(puntaje1);
		usuario1= new Usuario(nombre1,puntajeString);
		addUsuarios(usuario1);
		String nomArchivo = "usuarios";
       	try {
			Fichero fichero = new Fichero();
			fichero.crearXML(nomArchivo, listaUsuarios);
			
       	} catch(Exception e3) {
          	e3.printStackTrace();
      	}
		if (puntaje1 == puntaje2) {
			new Aviso(puntaje2).setVisible(true);
		} else {
			if (puntaje1 > puntaje2) {
				new Aviso(puntaje1, nombre1).setVisible(true);
			} else {
				new Aviso(puntaje2, nombre2).setVisible(true);
			}
		}
	}

	// Metodo para tapar las cartas
	public void tapar(int a) {
		cartas[a].boton.setIcon(new ImageIcon(this.getClass().getResource("/imagenes/tarjetaAtras60x60.png")));//voltear carta
		cartas[Integer.valueOf(temporal.boton.getName())].revelado=false;
		cartas[Integer.valueOf(temporal.boton.getName())].boton.setIcon((new ImageIcon(this.getClass().getResource("/imagenes/tarjetaAtras60x60.png"))));
	}

	// Metodo para mostrar las cartas al inicio
	public void addUsuarios(Usuario usuario) {
        listaUsuarios.add(usuario);
    }

	public static void main(String nombreJug) {
		new Computador8(nombreJug).setVisible(true);
		
	}
	
}
package net.jimenez.herencia;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import acm.graphics.GImage;
import acm.program.GraphicsProgram;

/**
 * 
 * @author Surrui
 *
 */
public class App extends GraphicsProgram {

	private static final int TOTAL_PEIXOS = 50;
	private static final int TOTAL_TAURONS = 10;
	private static final int PEIXERA_AMP = 600;
	private static final int PEIXERA_ALT = 776;
	private static final long serialVersionUID = 8690459163749096224L;
	private static final int[] DIRECCIO = { 0, 1, -1 };
	List<Peix> Peixos = new ArrayList<Peix>();
	Random rnd = new Random();

	/**
	 * Metode on creem variables que no variaran mentre fem servir el programa.
	 */
	public void init() {

		setSize(PEIXERA_AMP, PEIXERA_ALT);
		GImage fons = new GImage("Pacman-fond.png");
		add(fons);

	}

	/**
	 * Metode principal del programa, on creem tots els objectes.
	 */
	public void run() {
		for (int i = 0; i < TOTAL_PEIXOS; i++) {

			if (i < (TOTAL_PEIXOS / 2)) {
				Peixos.add(crearPeix("mascle"));

			} else {
				Peixos.add(crearPeix("femella"));
			}
		}
		
		for (int i = 0; i < TOTAL_TAURONS; i++) {
			
			if (i < (TOTAL_TAURONS / 2)) {
				Peixos.add(crearTauro("mascle"));

			} else {
				Peixos.add(crearTauro("femella"));
			}
			
		}

		Peixera peixera = new Peixera(Peixos, this);
		boolean noPeixos = peixera.inici();

		if (noPeixos) {
			GImage fi = new GImage("fi.png");
			fi.setLocation(0, (getHeight() / 2) - (fi.getHeight() / 2));
			add(fi);
		}
	}

	/**
	 * Metode que s'encarrega de crear objectes Tauro, als quals
	 * els hi dona la direcció del moviment, la GImage i un 
	 * String amb el seu sexe.
	 * 
	 * @param sexe String que dona el sexe al objecte Tauro.
	 * @return
	 */
	public Peix crearTauro(String sexe) {
		
		int movX = DIRECCIO[rnd.nextInt(3)];
		int movY = 0;

		if (movX == 0) {
			movY = DIRECCIO[rnd.nextInt(2) + 1];
		}

		GImage img;

		if (sexe.equals("mascle")) {
			img = new GImage("pacman.png");
			img.scale(0.08);
			add(img);
		} else {
			img = new GImage("ms pacman.png");
			img.scale(0.08);
			add(img);
		}

		Tauro T = new Tauro(img, sexe, movX, movY);

		return T;
	}

	/**
	 * Metode que s'encarrega de crear objectes Peix_Fantasma, als 
	 * quals els hi dona la direcció del moviment, la GImage i un 
	 * String amb el seu sexe.
	 * 
	 * @param sexe String que dona el sexe al objecte Peix_Fantasma.
	 * @return
	 */
	public Peix crearPeix(String sexe) {

		int movX = DIRECCIO[rnd.nextInt(3)];
		int movY = 0;

		if (movX == 0) {
			movY = DIRECCIO[rnd.nextInt(2) + 1];
		}

		GImage img;

		if (sexe.equals("mascle")) {
			img = new GImage("inky.png");
			img.scale(0.08);
			add(img);
		} else {
			img = new GImage("pinky.png");
			img.scale(0.08);
			add(img);
		}

		Peix_Fantasma P = new Peix_Fantasma(img, sexe, movX, movY);

		return P;
	}
}

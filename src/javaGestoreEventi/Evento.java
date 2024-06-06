package javaGestoreEventi;

import java.time.LocalDate;

public class Evento {
	private String titolo;
	private LocalDate data;
	private int postiTotali;
	private int postiPrenotati;
	
	
	public Evento(String titolo, LocalDate data, int postiTotali) {
		super();
		this.titolo = titolo;
		this.data = data;
		this.postiTotali = postiTotali;
		this.postiPrenotati = 0;
	
	}

//GETTER N' SETTER
	public String getTitolo() {
		return titolo;
	}


	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}


	public LocalDate getData() {
		return data;
	}


	public void setData(LocalDate data) {
		this.data = data;
	}

	public int getPostiTotali() {
		return postiTotali;
	}


	public int getPostiPrenotati() {
		return postiPrenotati;
	}
	
	
	public void prenota() {
		if (data.isBefore(LocalDate.now())) {
			System.out.println("ALLERT!! evento non disponibile ALLERT!!");
		}else if (postiTotali > postiPrenotati) {
			postiPrenotati += 1;
		}else {
			System.out.println("ALLERT!! posti non disponibili ALLERT!!");
		}
	}
	
	public void disdici() {
		if (data.isBefore(LocalDate.now())) {
			System.out.println("ALLERT!! evento non disponibile ALLERT!!");
		}else if (postiTotali > postiPrenotati) {
			postiPrenotati -= 1;
		}else {
			System.out.println("ALLERT!! nessuna prenotazxione disponibile da disdire ALLERT!!");
		}
	}
}

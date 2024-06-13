package javaGestoreEventi;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Evento {
	private String titolo;
	private LocalDate data;
	private int postiTotali;
	private int postiPrenotati;
	private int postiDisdetti ;
	
	
	public Evento(String titolo, LocalDate data, int postiTotali) {
		super();
		this.titolo = titolo;
		this.data = data;
		this.postiTotali = postiTotali;
		this.postiPrenotati = 0;
		this.postiDisdetti =0;
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
	
	public int getPostiDisdetti() {
		return postiDisdetti;
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
	
	
	
	@Override
	public String toString() {
		//String pattern = "dd/MM/yyyy";
		//SimpleDateFormat simpledateformat = new SimpleDateFormat (pattern);
		//String data = simpledateformat.format(new Date());
		//System.out.println(data);
		//return data;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return "Evento:" + titolo + " In data: " + data.format(formatter);
		
				
		
	}
}

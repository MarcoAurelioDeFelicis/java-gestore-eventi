package javaGestoreEventi;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Teatro extends Evento {
	private LocalTime ora;
	private double prezzo;

	//COSTRUTTORE
	public Teatro(String titolo, LocalDate data, LocalTime ora, int postiTotali, double prezzo) {
		super(titolo, data, postiTotali);
		this.ora = ora;
		this.prezzo = prezzo;
		
	}
    //GETTER SETTER
	public LocalTime getOra() {
		return ora;
	}

	public void setOra(LocalTime ora) {
		this.ora = ora;
	}

	public double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
	
	public String formattaData () {
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
        return getData().format(dateFormatter) + " ORE: " + ora.format(timeFormatter);

	}	
	
	public String formattaPrezzo () {
		return String.format(Locale.ITALY, "€" , prezzo );
	}

	@Override
    public String toString() {
		return "Evento: " + getTitolo() + " IN DATA: " + formattaData() + " PREZZO: " + formattaPrezzo();
		

	}
	
}




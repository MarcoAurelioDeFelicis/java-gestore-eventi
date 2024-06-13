package javaGestoreEventi;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Maintest {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("inserire nome evento da organizzare: \n"
				           + " - Concerto \n"
				           + " - Teatro \n");
		
		String userEvento = scan.nextLine();
		String messageEvent = "";
		
		System.out.println("inserire titolo evento ");
		String userTitolo = scan.nextLine();
		
		System.out.println("Inserire data evento formato (dd/MM/yyyy)");
		String stringData = scan.nextLine();
		LocalDate data = LocalDate.parse(stringData, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		
		System.out.println("inserire orario evento in formato (HH:mm) ");
		String stringOrario = scan.nextLine();
		LocalTime ora = LocalTime.parse(stringOrario, DateTimeFormatter.ofPattern("HH:mm"));
		
		System.out.println("inserire i posti disponibili evento ");
		int userPostiTotali = scan.nextInt();
		
		System.out.println("inserire prezzo biglietto evento ");
		double userPrezzo = scan.nextDouble();
		
		scan.nextLine();
		
		Evento evento = null;
		
		switch (userEvento.toLowerCase()) {
		
		case "concerto":
			evento = new Concerto (userTitolo, data, ora, userPostiTotali, userPrezzo);
			messageEvent = "concerto";
			break;
			
		case "teatro":
			evento = new Teatro (userTitolo, data, ora, userPostiTotali, userPrezzo);
			messageEvent = "conferenza";
			break;
			
		default:
			System.out.println("ALLERT!! evento non disponibile ALLERT!!");
			break;
		}
			
			System.out.println("IL TUO EVENTO: " + evento);
			
			//PRENOTARE
			System.out.println("inserire numero posti da prenotare");
			int userPostiPrenotati = scan.nextInt();
			scan.nextLine();
			
			if (userPostiPrenotati  > 0) {
				for (int i = 0; i < userPostiPrenotati; i++ ) {
					evento.prenota();
				}
				System.out.println("I TUOI POSTI PRENOTATI: " + evento.getPostiPrenotati());
				
			}else {
				System.out.println("ALLERT!! nessun posto prenotato ALLERT!!");	
			}
			
			//POSTI RIMASTI DOPO PRENOTAIONE
			int postiRimanenti = evento.getPostiTotali() - evento.getPostiPrenotati();
			System.out.printf("posti rimanenti per evento :" + userEvento + "\n SONO: " + postiRimanenti );
			
			//DISDIRE
			System.out.println("\n Desideri DISDIRE prenotazioni posti? SI-NO");
			String yesNo = scan.nextLine(); 
			
			if(yesNo.equalsIgnoreCase("si".toLowerCase())) {
				System.out.println("inserire numero posti da disdire ");	
				    int userPostiDisdetti = scan.nextInt();
				if ( userPostiDisdetti > 0) {
					evento.disdici();
					System.out.println("POSTI DISDETTI: " + userPostiDisdetti );
				}
				
			}else {
				System.out.println("ALLERT!! nessuna disdetta effettuata ALLERT!!");
			}
			
			//POSTI RIMASTI DOPO DISDETTA
			int postiRimanentiDisdetta = evento.getPostiTotali() + evento.getPostiDisdetti();
			System.out.printf("posti rimanenti per evento :" + userTitolo + "\n SONO: " + postiRimanentiDisdetta);
			
		    //EVENTO ORGANIZZATO
			System.out.println("\n     <<Hai organizzato l'evento:  " + messageEvent + ": " + userTitolo + "in data: " + evento.getData() + ">>");
			
		
		
		
	}
}

package reserver;

public class CalendrierAnnuel {
	private Mois[] calendrier;
	
	public CalendrierAnnuel() {
		calendrier = new Mois[12];
		calendrier[0] = new Mois("Janvier",31);
		calendrier[1] = new Mois("Février",28);
		calendrier[2] = new Mois("Mars",31);
		calendrier[3] = new Mois("Avril",30);
		calendrier[4] = new Mois("Mai",31);
		calendrier[5] = new Mois("Juin",30);
		calendrier[6] = new Mois("Juillet",31);
		calendrier[7] = new Mois("Août",31);
		calendrier[8] = new Mois("Septembre",30);
		calendrier[9] = new Mois("Octobre",31);
		calendrier[10] = new Mois("Novembre",30);
		calendrier[11] = new Mois("Décembre",31);
	}
	
	public boolean estLibre(int jour, int mois) {
		return calendrier[mois-1].estLibre(jour-1);
	}
		
	public boolean reserver(int jour, int mois) {
		try{
			calendrier[mois-1].reserver(jour-1);
		} catch (IllegalStateException e) {
			return false;
		}
		return true;
	}
	
	
	public class Mois{
		private String nom;
		private boolean[] jour;
		
		public Mois(String nom, int nbjours) {
			this.nom = nom;
			jour = new boolean[nbjours];
			for (int i=0; i<nbjours; i++) {
				jour[i] = false;
			}
		}
		
		public boolean estLibre(int i) {
			return !jour[i];
		}
		
		public void reserver(int i) {
			if (!estLibre(i)) {
				throw new IllegalStateException();
			}
			jour[i] = true;
		}
	}
}

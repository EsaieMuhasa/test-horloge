
/**
 * 
 * @author Esaie MUHASA
 * Interface d'emission des evennements du model des donnees
 */
public interface ITimeModel {
	void updateTime (int houre, int min, int sec);
	void updatePosition (int x, int y);
	
	int getCurrentX ();
	int getCurrentY ();
	
	int getCurrentWidth();
	int getCurrentHeight();
}

import Gui.Labyrinthe;
import java.util.concurrent.TimeUnit;

public class App {
	public static void main(String[] args) {
		Labyrinthe lab = new Labyrinthe();
		while(true) {
			lab.start();
			try {
				TimeUnit.MILLISECONDS.sleep(250);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

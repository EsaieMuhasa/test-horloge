import java.awt.Font;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * 
 */

/**
 * @author Esaie MUHASA
 *
 */
public class MainFrame extends JFrame {
	private static final long serialVersionUID = 2269971701250845501L;
	
	private JLabel ecran = new JLabel();
	
	public MainFrame() {
		super("Horloge bidon");
		
		this.add(ecran);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.pack();
		this.setLocationRelativeTo(null);
		this.init();
	}
	
	/**
	 * manipulation de l'ecran
	 */
	private void init() {
		ecran.setFont(new Font("Arial", Font.BOLD, 30));
		
		while (true) {			
			Calendar cal = Calendar.getInstance();
			int heur = cal.get(Calendar.HOUR_OF_DAY), 
					min = cal.get(Calendar.MINUTE),
					sec = cal.get(Calendar.SECOND);
			ecran.setText(heur+":"+min+":"+sec);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
	}

}

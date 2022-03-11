import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * 
 */

/**
 * @author Esaie MUHASA
 *
 */
public class MainFrame extends JFrame implements ITimeModel {
	private static final long serialVersionUID = 2269971701250845501L;
	
	private JLabel ecran = new JLabel();
	private JButton btn = new JButton("Button");
	
	private final TimeModel model;
	
	public MainFrame() {
		super("Horloge bidon");
		
		model = new TimeModel(this);
		
		this.add(ecran, BorderLayout.CENTER);
		this.getContentPane().add(btn, BorderLayout.SOUTH);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setSize(300, 120);
		this.setLocationRelativeTo(null);
		this.init();
		
		btn.addActionListener(event -> {
			System.out.println("Click");
		});
	}
	
	/**
	 * manipulation de l'ecran
	 */
	private void init() {
		ecran.setFont(new Font("Arial", Font.BOLD, 30));
		ecran.setHorizontalAlignment(JLabel.CENTER);
	}

	@Override
	public void updateTime(int houre, int min, int sec) {
		ecran.setText(houre+":"+min+":"+sec);
	}

	@Override
	public void updatePosition(int x, int y) {
		this.setLocation(x, y);
	}

	@Override
	public int getCurrentX() {
		return this.getLocation().x;
	}

	@Override
	public int getCurrentY() {
		return this.getLocation().y;
	}

	@Override
	public int getCurrentWidth() {
		return this.getWidth();
	}

	@Override
	public int getCurrentHeight() {
		return this.getHeight();
	}

}

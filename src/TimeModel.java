import java.awt.Toolkit;
import java.util.Calendar;

/**
 * 
 */

/**
 * @author Esaie MUHASA
 *
 */
public class TimeModel {
	
	private boolean variationX = true, variationY = true;
	
	private ITimeModel iModel;
	
	public TimeModel(ITimeModel model) {
		this.iModel = model;
		Thread t = new Thread(new Runnable() {
			private int lastTime = 0;
			private Toolkit  t = Toolkit.getDefaultToolkit();
			int pause = 50;
			@Override
			public void run() {
				int wScreen = t.getScreenSize().width,
						hScreen =t.getScreenSize().height;
				while (true) {			
					try {
						//calcul position
						if(wScreen <= (iModel.getCurrentWidth()+iModel.getCurrentX()+1) && variationX == true)
							variationX = false;
						
						if(iModel.getCurrentX()-1 == 0 && variationX == false)
							variationX = true;
						
						if(hScreen <= (iModel.getCurrentHeight()+iModel.getCurrentY()+1) && variationY == true)
							variationY = false;
						
						if(iModel.getCurrentY()-1 == 0 && variationY == false)
							variationY = true;
						
						int varX = iModel.getCurrentX(), varY = iModel.getCurrentY();
						
						if(variationX == true) //pour X
							varX += 1;
						else 
							varX -= 1;
						
						if(variationY == true) //pout Y
							varY += 1;
						else 
							varY -= 1;
						
						iModel.updatePosition(varX, varY);
						// ==
						
						if((lastTime/pause) == 20) {
							lastTime = 0;
							Calendar cal = Calendar.getInstance();
							int heur = cal.get(Calendar.HOUR_OF_DAY), 
									min = cal.get(Calendar.MINUTE),
									sec = cal.get(Calendar.SECOND);
							iModel.updateTime(heur, min, sec);
						}
						Thread.sleep(pause);
						lastTime += pause;
					} catch (InterruptedException e) {
						System.out.println(e.getMessage());
					}
				}
				
			}
		});
		
		t.start();
	}
}

package canalis.scene;

import java.util.Random;

import canalis.Assets;
import canalis.Display;
import canalis.Game;
import canalis.objects.ButtonChangeScene;
import canalis.objects.TextCentered;

public class SceneResult extends Scene {

	private final String[] result = {"You Did It !", "Well Done !", "Good Job !"};
	private final Random rng;
	private final TextCentered win;
	private final TextCentered time;
	private int random;
	
	public SceneResult(Game game, Display display) {
		super(game, display);
		rng = new Random();
		random = rng.nextInt(3);
		addSceneObject(win = new TextCentered(display, 150, Assets.font.deriveFont(100.0f), Assets.colorMain, result[random]));
		addSceneObject(time = new TextCentered(display, 300, Assets.fontSecondary.deriveFont(40.0f), Assets.colorMain, ""));
		addSceneObject(new ButtonChangeScene(display, (display.getWidth()/3*1)-(200/2), (display.getHeight()/3*2), 200, 80, 1, Assets.buttonRetry));
		addSceneObject(new ButtonChangeScene(display, (display.getWidth()/3*2)-(200/2), (display.getHeight()/3*2), 200, 80, 0, Assets.buttonMainMenu));
	}
	
	public void randomize() {
		random = rng.nextInt(3);
		win.setText(result[random]);
	}

	public void setTime(int minute, int second) {
		time.setText(String.format("Time: %02d:%02d", minute, second));
	}
	
}

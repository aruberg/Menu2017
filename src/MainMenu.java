import edu.digipen.Game;
import edu.digipen.InputManager;
import edu.digipen.gameobject.GameObject;
import edu.digipen.gameobject.ObjectManager;
import edu.digipen.level.GameLevel;
import edu.digipen.level.GameLevelManager;

import java.awt.event.KeyEvent;

/**
 * Created by User on 9/26/2017.
 */
public class MainMenu extends GameLevel
{
	@Override public void create()
	{
		GameObject startText = new GameObject("StartText", 400, 100, "StartText.png");
		startText.setPositionY(100);
		ObjectManager.addGameObject(startText);

		GameObject quitText = new GameObject("QuitText", 400, 100, "QuitText.png");
		quitText.setPositionY(-100);
		ObjectManager.addGameObject(quitText);

	}

	@Override public void initialize()
	{

	}

	@Override public void update(float v)
	{
		if(InputManager.isPressed(KeyEvent.VK_ESCAPE))
		{
			Game.quit();
		}
		if(InputManager.isPressed(KeyEvent.VK_SPACE))
		{
			GameLevelManager.goToLevel(new Level1());
		}

	}

	@Override public void uninitialize()
	{

	}
}

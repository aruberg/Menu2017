import edu.digipen.InputManager;
import edu.digipen.gameobject.GameObject;
import edu.digipen.gameobject.ObjectManager;
import edu.digipen.level.GameLevel;
import edu.digipen.level.GameLevelManager;

import java.awt.event.KeyEvent;

/**
 * Created by User on 9/26/2017.
 */
public class Level1 extends GameLevel
{

	@Override public void create()
	{
		Player player1 = new Player();

	}

	@Override public void initialize()
	{
		for(int i = 0; i < 10; ++i)
		{
			GameObject coin = new GameObject("Coin", 28, 28, "Coin.png");
			ObjectManager.addGameObject(coin);
			coin.setPositionX(200);
			coin.setPositionY(245 - i*55);
			coin.setCircleCollider(14);
		}
	}

	@Override public void update(float v)
	{
		if(InputManager.isTriggered(KeyEvent.VK_R))
		{
			GameLevelManager.restartLevel();
		}
	}

	@Override public void uninitialize()
	{
		ObjectManager.removeAllObjectsByName("Coin");
	}
}

import edu.digipen.InputManager;
import edu.digipen.gameobject.GameObject;
import edu.digipen.level.GameLevelManager;

import java.awt.event.KeyEvent;

/**
 * Created by User on 9/26/2017.
 */
public class Player extends GameObject
{
	int coinCount = 10;

	public Player()
	{
		super("Circle", 64,64,"Circle.png");
		setCircleCollider(32);
	}

	@Override public void initialize()
	{
		coinCount = 10;
		setPosition(0,0);
	}

	@Override public void update(float dt)
	{
		float y = getPositionY();
		float x = getPositionX();
		if(InputManager.isPressed(KeyEvent.VK_UP))
		{
			y += 3;
		}
		if(InputManager.isPressed(KeyEvent.VK_DOWN))
		{
			y -= 3;
		}
		if(InputManager.isPressed(KeyEvent.VK_RIGHT))
		{
			x += 3;
		}
		if(InputManager.isPressed(KeyEvent.VK_LEFT))
		{
			x -= 3;
		}

		setPositionX(x);
		setPositionY(y);

		if(coinCount <= 0)
		{
			GameLevelManager.goToLevel(new MainMenu());
		}
	}

	@Override public void collisionReaction(GameObject collidedWith)
	{
		if("Coin".equals(collidedWith.getName()))
		{
			collidedWith.kill();
			--coinCount;
		}
	}

}

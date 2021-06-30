package weapons;

import game.Animation;
import game.Assets;
import game.Handler;

public class KABAR extends MeleeWeapon {

	public KABAR(Handler handler) {
		super(handler);
		attack = new Animation(40, Assets.kabarAttack, 100);
		speed = 3.0f;
		name = "KA-BAR";
		attackSFX = Assets.knifeSlashSFX;
		lastAttackTime = System.currentTimeMillis();
	}
	
	@Override
	public void attack() {
		lastAttackTime = System.currentTimeMillis();
		attack.setAnimated(true);
		
		if (attack.getIndex() == 0 && handler.getMouseManager().isShoot()) {
			attackSFX.play();
		}
		
		if (attack.getIndex() == attack.getNumFrames() - 1) {
			attack.setAnimated(false);
		}
	}
}
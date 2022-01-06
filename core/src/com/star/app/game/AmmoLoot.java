package com.star.app.game;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.star.app.screen.utils.Assets;

public class AmmoLoot extends UsableLoot{
    private final GameController gameController;

    protected AmmoLoot(GameController gameController) {
        super(Assets.getInstance().getAtlas().findRegion("star16"));
        this.gameController = gameController;
    }

    @Override
    public void activateLoot() {
        gameController.getHero().addAmmo(20);
    }
}

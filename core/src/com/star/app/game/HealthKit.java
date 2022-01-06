package com.star.app.game;

import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.star.app.screen.utils.Assets;

public class HealthKit extends UsableLoot{
    private GameController gameController;

    protected HealthKit(GameController gameController) {
        super(Assets.getInstance().getAtlas().findRegion("star16"));
        this.gameController = gameController;
    }

    @Override
    public void activateLoot() {
        gameController.getHero().addHp(20);
    }
}

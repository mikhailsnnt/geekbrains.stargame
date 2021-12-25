package com.star.app.renderers;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.star.app.controllers.GameController;

public class WorldRenderer {
    private GameController controller;
    private SpriteBatch batch;

    public WorldRenderer(GameController controller, SpriteBatch batch) {
        this.controller = controller;
        this.batch = batch;
    }
    public void render(){
        ScreenUtils.clear(0.0f, 0.1f, 0.5f, 1);
        batch.begin();
        controller.getBackground().render(batch);
        controller.getHero().render(batch);
        controller.getBulletController().render(batch);
        controller.getAsteroidController().render(batch);
        batch.end();
    }
}

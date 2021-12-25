package com.star.app.screen;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.star.app.controllers.GameController;
import com.star.app.renderers.WorldRenderer;


public class GameScreen  extends  AbstractScreen{
    private GameController controller;
    private WorldRenderer renderer;
    private SpriteBatch batch;
    public GameScreen(SpriteBatch batch) {
        this.batch = batch;
    }

    @Override
    public void show() {
        controller = new GameController();
        renderer = new WorldRenderer(controller,batch);
    }

    public void render(float dt){
        controller.update(dt);
        renderer.render();
    }

}

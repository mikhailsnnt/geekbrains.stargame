package com.star.app.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.star.app.controllers.GameController;
import com.star.app.game.helpers.ObjectPool;

public class AsteroidController extends ObjectPool<Asteroid> {
    private final GameController gameController;


    public AsteroidController(GameController gameController) {
        this.gameController = gameController;
    }

    @Override
    protected Asteroid newObject() {
        return new Asteroid(gameController);
    }

    public void update(float dt){
        for (int i = 0; i < activeList.size(); i++) {
            activeList.get(i).update(dt);
        }
        checkPool();
    }
    public void render(SpriteBatch batch){
        for (int i = 0; i < activeList.size(); i++) {
            activeList.get(i).render(batch);
        }
    }
    public void setup(Vector2 position,Vector2 speed){
        getActiveElement().activate(position,speed);
    }
}

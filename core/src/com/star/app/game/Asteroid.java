package com.star.app.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.star.app.controllers.GameController;
import com.star.app.game.helpers.Poolable;
import com.star.app.screen.ScreenManager;

public class Asteroid implements Poolable {
    private final Texture textureAsteroid;
    private  Vector2 position;
    private  Vector2 v;
    private final GameController controller;
    private boolean isHit = false;
    public Asteroid(GameController controller){
        this.textureAsteroid = new Texture("asteroid.png");
        this.controller = controller;
    }

    public void render(Batch batch){
        batch.draw(textureAsteroid,position.x,position.y);
    }

    public void update(float dt){
        position.mulAdd(v,dt).mulAdd(controller.getHero().getVelocity(),-dt);
        if(position.x < -textureAsteroid.getWidth())
            position.x = ScreenManager.SCREEN_WIDTH+10;
        if(position.y < -textureAsteroid.getHeight())
            position.y = ScreenManager.SCREEN_HEIGHT+10;
        if(position.x > ScreenManager.SCREEN_WIDTH)
            position.x = 0;
        if(position.y > ScreenManager.SCREEN_HEIGHT)
            position.y = 0;
    }


    @Override
    public boolean isActive() {
        updateIsHit();
        return !isHit;
    }

    public void activate(Vector2 position,Vector2 speed){
        this.v = speed;
        this.position = position;
        isHit = false;
    }

    public void updateIsHit(){
        if(!isHit)
            isHit = controller.getBulletController().checkCollision(position, 256 );
    }
}

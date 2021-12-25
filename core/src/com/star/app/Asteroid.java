package com.star.app;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

public class Asteroid {
    private final Texture textureAsteroid;
    private final Vector2 position;
    private final Vector2 v;
    private final StarGame game;
    public Asteroid(StarGame game){
        this.textureAsteroid = new Texture("asteroid.png");
        this.position = new Vector2(MathUtils.random(0,ScreenManager.SCREEN_WIDTH),MathUtils.random(0,ScreenManager.SCREEN_HEIGHT));
        this.v = new Vector2(MathUtils.random(50,100),MathUtils.random(50,100));
        this.game = game;
    }

    public void render(Batch batch){
        batch.draw(textureAsteroid,position.x,position.y);
    }

    public void update(float dt){
        position.mulAdd(v,dt);
        position.mulAdd(game.getHero().getLastDisplacement(),-1);
        if(position.x < -textureAsteroid.getWidth())
            position.x = ScreenManager.SCREEN_WIDTH+10;
        if(position.y < -textureAsteroid.getHeight())
            position.y = ScreenManager.SCREEN_HEIGHT+10;
        if(position.x > ScreenManager.SCREEN_WIDTH)
            position.x = 0;
        if(position.y > ScreenManager.SCREEN_HEIGHT)
            position.y = 0;
    }
}

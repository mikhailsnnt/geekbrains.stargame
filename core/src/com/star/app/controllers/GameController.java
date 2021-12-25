package com.star.app.controllers;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.star.app.game.*;
import com.star.app.screen.ScreenManager;

public class GameController {
    private Background background;
    private Hero hero;
    private AsteroidController asteroidController;
    private BulletController bulletController;

    public GameController(){
        background = new Background(this);
        hero = new Hero(this);
        asteroidController = new AsteroidController(this);
        asteroidController.setup( new Vector2(MathUtils.random(0, ScreenManager.SCREEN_WIDTH),MathUtils.random(0,ScreenManager.SCREEN_HEIGHT)), new Vector2(MathUtils.random(50,100),MathUtils.random(50,100)));
        asteroidController.setup( new Vector2(MathUtils.random(0, ScreenManager.SCREEN_WIDTH),MathUtils.random(0,ScreenManager.SCREEN_HEIGHT)), new Vector2(MathUtils.random(50,100),MathUtils.random(50,100)));
        bulletController = new BulletController();
    }

    public Background getBackground() {
        return background;
    }

    public Hero getHero() {
        return hero;
    }

    public AsteroidController getAsteroidController() {
        return asteroidController;
    }

    public BulletController getBulletController() {
        return bulletController;
    }

    public void update(float dt){
        background.update(dt);
        hero.update(dt);
        bulletController.update(dt);
        asteroidController.update(dt);

    }

}

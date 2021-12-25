package com.star.app;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.star.app.game.Asteroid;
import com.star.app.game.Background;
import com.star.app.game.Hero;
import com.star.app.screen.GameScreen;

public class StarGame extends Game {
    private SpriteBatch batch;



    @Override
    public void create() {
        this.batch = new SpriteBatch();
        setScreen(new GameScreen(batch));
    }

    @Override
    public void render() {
        float dt = Gdx.graphics.getDeltaTime();
        getScreen().render(dt);
    }


    @Override
    public void dispose() {
        batch.dispose();
    }
}

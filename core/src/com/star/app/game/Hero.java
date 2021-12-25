package com.star.app.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.star.app.controllers.GameController;
import com.star.app.screen.ScreenManager;

public class Hero {
    private Texture texture;
    private final GameController controller;
    private final Vector2 position;
    private final Vector2 velocity;
    private float angle;
    final float V_FRONT = 120.0f;
    final float V_BACK = 60.0f;
    private float lastShotTime;

    public Vector2 getVelocity() {
        return velocity;
    }

    public Hero(GameController controller) {
        this.controller = controller;
        this.texture = new Texture("ship.png");
        this.position = new Vector2(ScreenManager.SCREEN_WIDTH / 2, ScreenManager.SCREEN_HEIGHT / 2);
        this.velocity = new Vector2(0,0);
        this.angle = 0.0f;
    }

    public void render(SpriteBatch batch) {
        batch.draw(texture, position.x - 32, position.y - 32, 32, 32,
                64, 64, 1, 1,
                angle, 0, 0, 64, 64, false, false);
    }

    public void update(float dt) {
        lastShotTime+=dt;
        if(Gdx.input.isKeyPressed(Input.Keys.E)){
            if(lastShotTime>0.2f) {
                controller.getBulletController().setup(position.x,position.y, velocity.x + MathUtils.cosDeg(angle) * 300 , velocity.y + MathUtils.sinDeg(angle) * 300  );
                lastShotTime = 0;
            }
        }
        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            angle += 180.0f * dt;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            angle -= 180.0f * dt;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            velocity.add(MathUtils.cosDeg(angle) * V_FRONT * dt,MathUtils.sinDeg(angle) * V_FRONT * dt);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            velocity.sub(MathUtils.cosDeg(angle) * V_BACK * dt,MathUtils.sinDeg(angle) * V_BACK * dt);
        }
        float stopScale = Math.max(1.0f - 0.9f*dt,0);
        velocity.scl(stopScale);
        position.mulAdd(velocity,dt);

        if (position.x < 32)
            position.x = 32;
        else if (position.x >= ScreenManager.SCREEN_WIDTH - 32)
            position.x = ScreenManager.SCREEN_WIDTH - 32;

        if(position.y < 32)
            position.y = 32;
        else if (position.y >= ScreenManager.SCREEN_HEIGHT - 32)
            position.y = ScreenManager.SCREEN_HEIGHT - 32;
    }

}

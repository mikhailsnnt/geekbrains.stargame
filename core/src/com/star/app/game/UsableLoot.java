package com.star.app.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public abstract class UsableLoot {
    private final TextureRegion texture;

    protected UsableLoot(TextureRegion texture) {
        this.texture = texture;
    }

    public abstract void activateLoot();

    public TextureRegion getTexture() {
        return texture;
    }
}

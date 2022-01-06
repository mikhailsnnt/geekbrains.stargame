package com.star.app.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.star.app.game.helpers.ObjectPool;

public class AsteroidLootController extends ObjectPool<Loot> {


    @Override
    protected Loot newObject() {
        return new Loot() ;
    }


    public void render(SpriteBatch batch){
        for (int i = 0; i < activeList.size(); i++) {
            activeList.get(i).render(batch);
        }
    }

    public void update(float dt){
        checkPool();
    }
    public void setUpLoot(float x, float y, float r, UsableLoot usableLoot){
        getActiveElement().activate(x,y,r,usableLoot);
    }
}

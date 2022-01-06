package com.star.app.game;

import com.star.app.screen.utils.Assets;

public class CoinLoot extends UsableLoot {
    private final GameController gameController;

    protected CoinLoot(GameController gameController) {
        super(Assets.getInstance().getAtlas().findRegion("star16"));
        this.gameController = gameController;
    }

    @Override
    public void activateLoot() {
        gameController.getHero().addCoin(30);
    }
}

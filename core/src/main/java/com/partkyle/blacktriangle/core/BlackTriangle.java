package com.partkyle.blacktriangle.core;

import static playn.core.PlayN.*;

import java.util.ArrayList;
import java.util.List;

import com.partkyle.blacktriangle.components.GameComponent;
import com.partkyle.blacktriangle.components.Triangle;

import playn.core.Canvas;
import playn.core.CanvasImage;
import playn.core.Game;
import playn.core.Image;
import playn.core.ImageLayer;
import playn.core.Key;
import playn.core.Keyboard.Listener;
import playn.core.Path;
import playn.core.SurfaceLayer;
import playn.core.Keyboard.Event;
import playn.core.Keyboard.TypedEvent;

public class BlackTriangle implements Game {

    private static final int SPEED = 15;

    List<GameComponent> components = new ArrayList<GameComponent>();
    List<GameComponent> projectiles = new ArrayList<GameComponent>();

    List<Key> keysDown = new ArrayList<Key>();

    @Override
    public void init() {
        // create and add background image layer
        Image bgImage = assets().getImage("images/bg.png");
        ImageLayer bgLayer = graphics().createImageLayer(bgImage);
        graphics().rootLayer().add(bgLayer);

        components.add(new Triangle(0, 0));

        keyboard().setListener(new Listener() {
            @Override
            public void onKeyUp(Event event) {
                keysDown.remove(event.key());
            }

            @Override
            public void onKeyTyped(TypedEvent event) {
            }

            @Override
            public void onKeyDown(Event event) {
                keysDown.add(event.key());
                if (event.key() == Key.SPACE) {
                    projectiles.add(((Triangle) components.get(0)).shoot());
                }
            }
        });
    }

    @Override
    public void paint(float alpha) {
        for (GameComponent component : components) {
            component.render();
        }

        for (GameComponent projectile : projectiles) {
            projectile.render();
        }
    }

    @Override
    public void update(float delta) {
        GameComponent gc = components.get(0);
        if (keysDown.contains(Key.LEFT)) {
            gc.updateX(SPEED);
        }
        if (keysDown.contains(Key.RIGHT)) {
            gc.updateX(-SPEED);
        }
        if (keysDown.contains(Key.DOWN)) {
            gc.updateY(-SPEED);
        }
        if (keysDown.contains(Key.UP)) {
            gc.updateY(SPEED);
        }

        if (projectiles.size() > 0) {
            List<GameComponent> toRemove = new ArrayList<GameComponent>();
            for (GameComponent pew : projectiles) {
                if (pew.getY() > 0) {
                    toRemove.add(pew);
                    pew.destroy();
                } else {
                    pew.updateY(SPEED);
                }
            }
            projectiles.removeAll(toRemove);
        }
    }

    @Override
    public int updateRate() {
        return 25;
    }
}

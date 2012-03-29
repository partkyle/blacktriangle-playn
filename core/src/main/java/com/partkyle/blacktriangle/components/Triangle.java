package com.partkyle.blacktriangle.components;

import static playn.core.PlayN.assets;
import static playn.core.PlayN.graphics;
import playn.core.Image;
import playn.core.ImageLayer;

public class Triangle implements GameComponent {
    Image triangle;
    ImageLayer shapeLayer;
    float x = 0;
    float y = 0;

    public Triangle(float x, float y) {
        this.x = x;
        this.y = y;

        triangle = assets().getImage("images/triangle.png");
        shapeLayer = graphics().createImageLayer(triangle);
        render();
    }

    public GameComponent shoot() {
        return new Triangle(this.x, this.y + 50);
    }

    @Override
    public float getX() {
        return x;
    }

    @Override
    public float getY() {
        return y;
    }

    @Override
    public void update(float x, float y) {
        this.x += x;
        this.y += y;
    }

    @Override
    public void updateX(float x) {
        this.x += x;
    }

    @Override
    public void updateY(float y) {
        this.y += y;
    }

    @Override
    public void render() {
        graphics().rootLayer().add(shapeLayer);
        shapeLayer.setOrigin(this.x, this.y);
    }

    @Override
    public void destroy() {
        shapeLayer.destroy();
    }

}

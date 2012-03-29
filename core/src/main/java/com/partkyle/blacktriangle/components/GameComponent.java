package com.partkyle.blacktriangle.components;

/**
 * @author partkyle
 * 
 */
public interface GameComponent {
    public void render();

    public float getY();

    public float getX();

    public void updateY(float y);

    public void updateX(float x);

    public void update(float x, float y);

    public void destroy();

}

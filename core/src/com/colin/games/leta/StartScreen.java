package com.colin.games.leta;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class StartScreen extends ScreenAdapter {
    private LETA leta;
    public StartScreen(LETA game) {
        super();
        leta = game;
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(new InputAdapter(){
            @Override
            public boolean keyDown(int keycode) {
                if(keycode == Input.Keys.ESCAPE){
                    System.exit(0);
                }else if(keycode == Input.Keys.ENTER){

                }else if(keycode == Input.Keys.W){

                }else if(keycode == Input.Keys.S){
                }
                return true;
            }
        });
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(.25f,.25f,.25f,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        SpriteBatch batch = leta.getBatch();
        BitmapFont font = leta.getFont();
        batch.begin();
        font.draw(batch,"Welcome to LETA.",Gdx.graphics.getWidth() * .5f,Gdx.graphics.getHeight() * .75f);
        font.draw(batch,"Press enter to start.",Gdx.graphics.getWidth() * .5f,Gdx.graphics.getHeight() * .5f);
        batch.end();
        leta.getCamera().update();
        System.out.println(Gdx.graphics.getWidth() + " " + Gdx.graphics.getHeight());
    }

    @Override
    public void hide() {
         Gdx.input.setInputProcessor(null);
    }

    @Override
    public void resize(int width, int height) {
    }
}

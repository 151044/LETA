package com.colin.games.leta;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import java.awt.*;

public class LETA extends Game {
	private OrthographicCamera camera;
	private BitmapFont font;
	private ShapeRenderer shape;
	private SpriteBatch batch;
	@Override
	public void create () {
		camera = new OrthographicCamera(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
		camera.position.set(Gdx.graphics.getWidth() / 2f, Gdx.graphics.getHeight() / 2f,0);
		camera.update();
		font = new BitmapFont();
		shape = new ShapeRenderer();
		batch = new SpriteBatch();
		batch.setProjectionMatrix(camera.combined);
		shape.setProjectionMatrix(camera.combined);
		setScreen(new StartScreen(this));
	}

	@Override
	public void dispose () {
		font.dispose();
		shape.dispose();
		batch.dispose();
	}
	public SpriteBatch getBatch(){
		return batch;
	}
	public OrthographicCamera getCamera(){
		return camera;
	}
	public ShapeRenderer getShapeRenderer(){
		return shape;
	}
	public BitmapFont getFont(){
		return font;
	}
}

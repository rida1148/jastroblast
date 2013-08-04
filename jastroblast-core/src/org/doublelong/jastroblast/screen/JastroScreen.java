package org.doublelong.jastroblast.screen;

import org.doublelong.jastroblast.Inputs;
import org.doublelong.jastroblast.JastroBlast;
import org.doublelong.jastroblast.entity.Space;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class JastroScreen implements Screen
{
	private OrthographicCamera cam;
	private final SpriteBatch batch;
	private final Space space;

	private final Inputs input;
	public final float ppuX;
	public final float ppuY;

	public JastroScreen(JastroBlast game)
	{
		// define the pixels
		this.ppuX = game.WINDOW_WIDTH / Space.WIDTH;
		this.ppuY = game.WINDOW_HEIGHT / Space.HEIGHT;

		this.space = new Space(game, this.ppuX, this.ppuY);

		this.batch = new SpriteBatch();
		this.cam = new OrthographicCamera(Space.WIDTH, Space.HEIGHT);
		this.cam.setToOrtho(false, Space.WIDTH, Space.HEIGHT);

		this.input = new Inputs(this.space.getShip().controller);
	}

	@Override
	public void render(float delta)
	{
		this.cam.update();
		//this.batch.setProjectionMatrix(this.cam.combined);

		this.cam.apply(Gdx.gl10);
		Gdx.gl.glClearColor(0.1f, 0.1f, 0.1f, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);

		this.space.render(this.batch, this.cam);
		this.update(delta);
	}

	public void update(float delta)
	{
		this.space.update(delta);
	}

	@Override
	public void resize(int width, int height)
	{
		// TODO Auto-generated method stub
		this.cam = new OrthographicCamera(width, height);
	}

	@Override
	public void show()
	{
		// TODO Auto-generated method stub
		Gdx.input.setInputProcessor(this.input);
	}

	@Override
	public void hide()
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void pause()
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void resume()
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose()
	{
		// TODO Auto-generated method stub
		this.space.dispose();
	}

}

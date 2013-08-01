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
	private final OrthographicCamera cam;
	private final SpriteBatch batch;
	private final Space space;

	private final Inputs input;

	public JastroScreen(JastroBlast game)
	{
		this.space = new Space(game);
		this.batch = new SpriteBatch();
		this.cam = new OrthographicCamera(Space.WIDTH, Space.HEIGHT);
		this.cam.setToOrtho(false, Space.WIDTH, Space.HEIGHT);

		this.input = new Inputs(this.space.getShip().controller);
	}

	@Override
	public void render(float delta)
	{
		this.cam.update();
		this.cam.apply(Gdx.gl10);
		//		this.batch.setProjectionMatrix(this.cam.combined);

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
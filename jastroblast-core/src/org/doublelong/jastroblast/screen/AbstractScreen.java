package org.doublelong.jastroblast.screen;

import org.doublelong.jastroblast.entity.Menu;

import com.badlogic.gdx.Screen;

public abstract class AbstractScreen implements Screen
{
	protected Menu menu;
	public Menu getMenu() { return this.menu; }

	public AbstractScreen()
	{
	}

	public abstract void transitionScreen();


	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub

	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub

	}

	@Override
	public void show() {
		// TODO Auto-generated method stub

	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

}

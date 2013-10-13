package org.doublelong.jastroblast.entity;

import java.util.ArrayList;
import java.util.List;

import org.doublelong.jastroblast.JastroBlast;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

public class MainMenu extends Menu
{
	private JastroBlast game;

	public MainMenu(JastroBlast game, Actor cursor)
	{
		super(game, cursor);
		this.game = game;
		this.table = new Table();
		this.elements = this.loadMenuItems();

		this.initializeTable();
	}

	private List<MenuButton> loadMenuItems()
	{
		List<MenuButton> list = new ArrayList<MenuButton>();
		{
			list.add(new MenuButton("Play!", "org.doublelong.jastroblast.screen.JastroScreen"));
			list.add(new MenuButton("Options", null));
			list.add(new MenuButton("Credits", "org.doublelong.jastroblast.screen.CreditsScreen"));
			list.add(new MenuButton("Quit", "org.doublelong.jastroblast.screen.QuitScreen"));
		}
		return list;
	}
}
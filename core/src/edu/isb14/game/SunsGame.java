package edu.isb14.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class SunsGame extends ApplicationAdapter {
	public static final int CONFIG_WIDTH = 1280;
	public static final int CONFIG_HEIGHT = 720;
	// ТАК ДЕЛАТЬ НЕЛЬЗЯ!!!!!!!!!!!!!!!!

	private SpriteBatch batch;
	OrthographicCamera camera1;
	private Background background;
	// Настройка отображения под разными экранами
	private Viewport viewport;
	private Camera camera;
	// Анимация человечка
	private AnimationGame walkAnimation;
	// ---

	private Hero player1;
	private Hero player2;

	@Override
	public void create () {
		batch = new SpriteBatch();
		camera = new OrthographicCamera();
//		camera1.setToOrtho(false, 800, 480);
		background = new Background("back.png");

		camera = new PerspectiveCamera();
		viewport = new FitViewport(CONFIG_WIDTH, CONFIG_HEIGHT, camera);

		walkAnimation = new AnimationGame("sprite-animation4.png", 5, 6, 0.02f, false);
		player1 = new Hero(Hero.Player.P1);
		player2 = new Hero(Hero.Player.P2);

	}

	@Override
	public void render () {
		update();
		Gdx.gl.glClearColor(0, 0, 0, 1);	// Цвет фона
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);	// Очищает экран при каждом кадре.

		batch.begin();

		background.render(batch);	// Отрисовка фона
		walkAnimation.render(batch);	// Отрисовка бегущего человечка
		player1.render(batch);		// Отрисовка игрока
		player2.render(batch);		// Отрисовка игрока

		batch.end();
	}

	public void resize(int width, int height) {
		viewport.update(width, height);
	}

	private void update(){

	}
	
	@Override
	public void dispose () {
		batch.dispose();
//		img.dispose();
	}
}

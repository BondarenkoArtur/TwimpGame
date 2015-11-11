package ga.uabart.twimp.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import ga.uabart.twimp.Objects.Pers;
import ga.uabart.twimp.TwimpGame;

public class GameScreen implements Screen {

    TwimpGame game;
    SpriteBatch batch;
    BitmapFont font;
    public String additionalText = "";

    public GameScreen(TwimpGame twimpGame) {
        this.game = twimpGame;
    }

    @Override
    public void show() {
        batch = new SpriteBatch();
        font = new BitmapFont();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.2f, 0.2f, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        int h = Gdx.graphics.getHeight() - 20;
        if (game.people != null)
            for (Pers pers : game.people.getPeople()) {
                font.draw(batch, pers.getName() + " Money:" + pers.getMoney() + " Exp:" + pers.getExp(), 40, h-=20);
            }
        font.draw(batch, additionalText, 40, 20);
        batch.end();

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}

package com.theironyard.hellogame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class HelloGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;

	float x = 0;
	float y = 0;
	//V means Velocity
	float xV = 0;
	float yV = 0;

	final float MAX_VELOCITY = 100; //100 Pixels per Second


	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
	}

	@Override
	public void render () {
		if(Gdx.input.isKeyPressed(Input.Keys.UP)){
			yV = MAX_VELOCITY;
			//y++;
		}//UP Arrow KEY
		if(Gdx.input.isKeyPressed(Input.Keys.DOWN)){
			yV = MAX_VELOCITY * -1;
			//y--;
		}//Down Arrow Key
		if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
			xV = MAX_VELOCITY;
			//x++;
		}//Right Arrow Key
		if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
			xV = MAX_VELOCITY * -1;
			//x--;
		}//Left Arrow Key

		//Acceleration with Velocity per refreshed Frame
		x += xV * Gdx.graphics.getDeltaTime();
		y += yV * Gdx.graphics.getDeltaTime();

		//Dampening Velocity
		xV *= 0.9;
		yV *= 0.9;


		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(img, x, y);
		batch.end();
	}




}//End of HelloGame Class

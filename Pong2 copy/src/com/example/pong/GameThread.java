package com.example.pong;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.SurfaceHolder;

public class GameThread extends Thread {

	private SurfaceHolder my_surfaceHolder;
	private Paint paint;
	private GameState gameState;

	public GameThread(SurfaceHolder surfaceHolder, Context context, Handler handler)
	{
		my_surfaceHolder = surfaceHolder;
		paint = new Paint();
		gameState = new GameState();	
	}

	@Override
	public void run() 
	{
		while(true)
		{
			Canvas canvas = my_surfaceHolder.lockCanvas();
			gameState.update();
			gameState.draw(canvas,paint);
			my_surfaceHolder.unlockCanvasAndPost(canvas);
		}
	}

	public GameState getGameState()
	{
		return gameState;
	}
}

package com.example.pong;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class GameView extends SurfaceView  implements SurfaceHolder.Callback{
   private GameThread game_thread;

   public GameView(Context context, AttributeSet attrs) 
   {
       super(context, attrs);

       SurfaceHolder holder = getHolder();
       holder.addCallback(this);
       setFocusable(true); 

       game_thread = new GameThread(holder, context, new Handler());
   }  

   @Override
   public boolean onKeyDown(int keyCode, KeyEvent msg) 
   {
       return game_thread.getGameState().keyStroke(keyCode);
   }

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) 
	{
		return;
	}

	@Override
	public void surfaceCreated(SurfaceHolder holder) 
	{
		game_thread.start();
		return;
	}

	@SuppressWarnings("deprecation")
	@Override
	public void surfaceDestroyed(SurfaceHolder holder) 
	{
       game_thread.stop();
       return;
	}
}
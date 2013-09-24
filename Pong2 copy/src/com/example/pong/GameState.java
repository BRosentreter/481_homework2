package com.example.pong;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Picture;
import android.graphics.Rect;
import android.view.KeyEvent;

public class GameState {
	
	int width_screen = 460;
	int height_screen = 420;

	int ball_size = 10;
	int ball_x = 100; 	int ball_y = 100;
	int ball_Xspeed = 4; 	int ball_Yspeed = 4;

	int paddle_width = 75;	
	int paddle_Height = 10;
	int paddle_speed = 30;
	int top_paddleX = (width_screen / 2) - (paddle_width / 2);
	int top_paddleY = 5;
	int bottom_paddleX = (width_screen / 2) - (paddle_width / 2);	
	int bottom_paddleY = 415;
	int right_paddleY = (height_screen / 2) - (paddle_width / 2);
	int right_paddleX = 455;
	int left_paddleY = (height_screen / 2) - (paddle_width / 2);
	int left_paddleX = 5;

	public GameState(){}

	public void update() 
	{
		
		ball_x += ball_Xspeed;
		ball_y += ball_Yspeed;

		if(ball_x > width_screen || ball_x < 0 || ball_y > height_screen || ball_y < 0)     	
		{
			ball_x = width_screen / 2; 	
			ball_y = height_screen / 2;
			ball_Xspeed = (int) (Math.pow(-1, (int) Math.random())) * ball_Xspeed;
			ball_Yspeed = (int) (Math.pow(-1, (int) Math.random())) * ball_Yspeed;
		}

		if(ball_x >= top_paddleX && ball_x <= top_paddleX+paddle_width && ball_y <= top_paddleY)  	
				ball_Yspeed *= -1.1;      	

		if(ball_x >= bottom_paddleX && ball_x <= bottom_paddleX+paddle_width 
	                				&& ball_y >= bottom_paddleY)
				ball_Yspeed *= -1.1;
		if(ball_y >= left_paddleY && ball_y <= left_paddleY+paddle_width && ball_x <= left_paddleX)  	
				ball_Xspeed *= -1.1;   	

		if(ball_y >= right_paddleY && ball_y <= right_paddleY+paddle_width 
           				&& ball_x >= right_paddleX)
				ball_Xspeed *= -1.1;
	}

	public boolean keyStroke(int key)
	{
		if(key == KeyEvent.KEYCODE_J)
		{
			top_paddleX -= paddle_speed; 
			bottom_paddleX -= paddle_speed;
		}

		if(key == KeyEvent.KEYCODE_L)
		{
			top_paddleX += paddle_speed; 
			bottom_paddleX += paddle_speed;
		}
	
		if(key == KeyEvent.KEYCODE_K)
		{
			left_paddleY += paddle_speed; 
			right_paddleY += paddle_speed;
		}
	
		if(key == KeyEvent.KEYCODE_I)
		{
			left_paddleY -= paddle_speed; 
			right_paddleY -= paddle_speed;
		}
		return true;
	}

	public void draw(Canvas canvas, Paint paint) 
	{
		canvas.drawRGB(0, 0, 128);

		paint.setARGB(200, 255, 215, 0);

		canvas.drawCircle(ball_x, ball_y, ball_size, paint);

		canvas.drawRect(new Rect(top_paddleX, top_paddleY, top_paddleX + paddle_width,
											top_paddleY + paddle_Height), paint);
		canvas.drawRect(new Rect(bottom_paddleX, bottom_paddleY, bottom_paddleX + paddle_width, 
											bottom_paddleY + paddle_Height), paint);
		canvas.drawRect(new Rect(left_paddleX, left_paddleY, left_paddleX + paddle_Height, 
											left_paddleY + paddle_width), paint);
		canvas.drawRect(new Rect(right_paddleX, right_paddleY, right_paddleX + paddle_Height, 
											right_paddleY + paddle_width), paint);
		return;
	}
}

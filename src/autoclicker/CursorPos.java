/*
 *  CursorPos.java  Object that contains the position of the cursor
 */
package autoclicker;

import java.awt.MouseInfo;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.AWTException;

public class CursorPos {

	private int width; // Pixel position on horizontal axis, 0 = Left
	private int height; // Pixel position on vertical axis, 0 = Top

	public CursorPos() {
		this.updateCursorPos();
	}

	public void updateCursorPos() {
		try {
			width = (int) MouseInfo.getPointerInfo().getLocation().getX();
			height = (int) MouseInfo.getPointerInfo().getLocation().getY();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int getCursorX() {
		return width;
	}

	public int getCursorY() {
		return height;
	}

	public void moveCursor(int w, int h) {
		try {
			Robot robot = new Robot();
			robot.mouseMove(w, h);
		} catch (AWTException ex) {
			ex.printStackTrace();
		}

	}

	public void click() {
		try {
			Robot robot = new Robot();
			robot.mousePress(InputEvent.BUTTON1_MASK);
			robot.mouseRelease(InputEvent.BUTTON1_MASK);
		} catch (AWTException ex) {
			ex.printStackTrace();
		}
	}
}
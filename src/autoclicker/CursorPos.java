/*
 *  CursorPos.java  Object that contains the position of the cursor
 */
package autoclicker;

import java.awt.MouseInfo;
import java.awt.Robot;
import java.awt.AWTException;

 public class CursorPos {

    private int width;	// Pixel position on horizontal axis, 0 = Left
	private int height;	// Pixel position on vertical axis, 0 = Top
    
     public void CursorPos()
     {
         this.getCursorPos();
     }

     public void updateCursorPos() {
         try {
			width = (int) MouseInfo.getPointerInfo().getLocation().getX();
			height = (int) MouseInfo.getPointerInfo().getLocation().getY();
			} catch (Exception e) {
				System.out.println("Getting mouse pointeer position failed");
				e.printStackTrace();
			}
     }

     public int getCursorX() {
         this.updateCursorPos();
         return width;
     }

     public int getCursorY() {
         this.updateCursorPos();
         return height;
     }
     public void moveCursor(int w, int h)
     {
         			Robot robot = null;
					try {
						robot = new Robot();
					} catch (AWTException ex) {
						ex.printStackTrace();
					}
					System.out.println("The action key was pressed");
					robot.mouseMove(w, h);
					robot.mousePress(InputEvent.BUTTON1_MASK);
				    robot.mouseRelease(InputEvent.BUTTON1_MASK);
					System.out.println("Mouse cursor moved to :" + w + " " + h);
     }
 }
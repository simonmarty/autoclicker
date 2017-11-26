package autoclicker;
import java.awt.EventQueue;
import javax.swing.JFrame;
//import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.MouseInfo;
import java.awt.Robot;
import java.awt.AWTException;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Frame1 {

	private JFrame frmAutoclicker;
	public int width; // Pixel position on horizontal axis, 0 = Left
	public int height; // Pixel position on vertical axis, 0 = Top
	public final int RECORD = 75; // key : k
	public final int ACTION = 73; // key : i

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame1 window = new Frame1();
					window.frmAutoclicker.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Frame1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAutoclicker = new JFrame();
		frmAutoclicker.setTitle("Autoclicker");
		frmAutoclicker.setBounds(100, 100, 388, 169);
		frmAutoclicker.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAutoclicker.getContentPane().setLayout(null);

		JButton btnClick = new JButton("Press I to execute the autoclick");
		btnClick.setForeground(Color.BLACK);
		btnClick.setBackground(Color.LIGHT_GRAY);
		btnClick.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnClick.setBounds(80, 80, 220, 23);
		frmAutoclicker.getContentPane().add(btnClick);

		JButton btnSaveCursorPosition = new JButton("Press K to save the Position of your cursor");
		btnSaveCursorPosition.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSaveCursorPosition.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnSaveCursorPosition.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				int code = arg0.getKeyCode(); // get the key code of the key currently pressed
				if (code == RECORD) {
					System.out.println("The record key was pressed");
					width = (int) MouseInfo.getPointerInfo().getLocation().getX();
					height = (int) MouseInfo.getPointerInfo().getLocation().getY();
					System.out.println("Mouse Position : " + width + " " + height);
				}
				if (code == ACTION) {
					Robot robot = null;
					try {
						robot = new Robot();
					} catch (AWTException ex) {
						ex.printStackTrace();
					}
					System.out.println("The action key was pressed");
					robot.mouseMove(width, height);
					robot.mousePress(InputEvent.BUTTON1_MASK);
				    robot.mouseRelease(InputEvent.BUTTON1_MASK);
					System.out.println("Mouse cursor moved to :" + width + " " + height);
				}

			}
		});
		btnSaveCursorPosition.setBounds(50, 30, 280, 23);
		frmAutoclicker.getContentPane().add(btnSaveCursorPosition);
	}
}
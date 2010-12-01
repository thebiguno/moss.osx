/*
 * Created on Sep 3, 2007 by wyatt
 */
package ca.digitalcave.moss.osx;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

import ca.digitalcave.moss.swing.MossFrame;
import ca.digitalcave.moss.swing.exception.WindowOpenException;

public class HiddenMossFrame extends MossFrame {
	public static final long serialVersionUID = 0;
	
	public HiddenMossFrame() {
		super("Hidden Frame for Frameless Menus");
		this.addWindowFocusListener(new WindowFocusListener(){
			public void windowGainedFocus(WindowEvent e) {
				updateMenus();
			}
			public void windowLostFocus(WindowEvent e) {
				updateMenus();
			}
		});
		this.setDefaultCloseOperation(MossFrame.DO_NOTHING_ON_CLOSE);
		this.setLocation(new Point(10, 10));
		this.setSize(new Dimension(0, 0));
		this.setUndecorated(true);
		this.pack();
		this.setVisible(true);
	}
	
	@Override
	public void openWindow() throws WindowOpenException {}
	
	@Override
	public void openWindow(boolean closeExisting) throws WindowOpenException {}
	
	@Override
	public void openWindow(Dimension dimension, Point position) throws WindowOpenException {}
	
	@Override
	public void openWindow(Dimension dimension, Point position, boolean closeExisting) throws WindowOpenException {}
	
	@Override
	public Object closeWindow() {
		return null;
	}
	
	@Override
	public void closeWindowWithoutPrompting() {}
	
	@Override
	public void init() {}
	
	@Override
	public void initPostPack() {}
}

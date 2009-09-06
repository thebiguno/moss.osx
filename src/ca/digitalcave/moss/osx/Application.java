/*
 * Created on May 29, 2007 by wyatt
 */
package ca.digitalcave.moss.osx;

import java.lang.reflect.Method;

import org.homeunix.thecave.moss.swing.MossFrame;
import org.homeunix.thecave.moss.swing.MossMenuBar;

import ca.digitalcave.moss.common.OperatingSystemUtil;

/**
 * Wrapper around the Apple specific classes used to interface with Buddi. This
 * allows applications to run on non Apple systems, as we don't try loading this
 * class (and by extension, the classes provided by Apple), unless we are on a
 * Mac system.
 * 
 * We also include a Mac-specific call to set the frameless menu bar. This idea
 * was based loosely off of MRJAdapter, but modified to fit my needs.
 * 
 * The correct way to use this class is to check if we are on a Mac, and if so,
 * call one or more of these methods.
 * 
 * @author wyatt
 */
public class Application {

	private final Object application;
	private final Class<?> applicationClass;
	private HiddenMossFrame hiddenFrame;

	public static Application getApplication() {
		return SingletonHolder.instance;
	}

	static class SingletonHolder {
		private static Application instance = new Application();
	}

	private Application() {
		try {
			applicationClass = ClassLoader.getSystemClassLoader().loadClass("com.apple.eawt.Application");
			application = applicationClass.newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public void addAboutMenuItem() {
		try {
			Method m = applicationClass.getMethod("addAboutMenuItem", new Class[0]);
			m.invoke(application, new Object[0]);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public void addApplicationListener(final ApplicationAdapter adapter) {
		try {
			Class<?> applicationListenerClass = ClassLoader.getSystemClassLoader().loadClass("com.apple.eawt.ApplicationListener");
			Method m = applicationClass.getMethod("addApplicationListener", new Class[] { applicationListenerClass });
			m.invoke(application, new Object[] { new ApplicationAdapterWrapper(adapter) });
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public void addPreferencesMenuItem() {
		try {
			Method m = applicationClass.getMethod("addPreferencesMenuItem",
					new Class[0]);
			m.invoke(application, new Object[0]);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public boolean getEnabledAboutMenu() {
		try {
			Method m = applicationClass.getMethod("getEnabledAboutMenu",
					new Class[0]);
			return (Boolean) m.invoke(application, new Object[0]);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public boolean getEnabledPreferencesMenu() {
		try {
			Method m = applicationClass.getMethod("getEnabledPreferencesMenu",
					new Class[0]);
			return (Boolean) m.invoke(application, new Object[0]);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public boolean isAboutMenuItemPresent() {
		try {
			Method m = applicationClass.getMethod("isAboutMenuItemPresent",
					new Class[0]);
			return (Boolean) m.invoke(application, new Object[0]);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public boolean isPreferencesMenuItemPresent() {
		try {
			Method m = applicationClass.getMethod(
					"isPreferencesMenuItemPresent", new Class[0]);
			return (Boolean) m.invoke(application, new Object[0]);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public void removeAboutMenuItem() {
		try {
			Method m = applicationClass.getMethod("removeAboutMenuItem",
					new Class[0]);
			m.invoke(application, new Object[0]);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public void removeApplicationListener(ApplicationAdapter adapter) {
		try {
			Class<?> applicationListenerClass = ClassLoader.getSystemClassLoader().loadClass("com.apple.eawt.ApplicationListener");
			Method m = applicationClass.getMethod("removeApplicationListener", new Class[] { applicationListenerClass });
			m.invoke(application, new Object[] { new ApplicationAdapterWrapper(adapter) });
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public void removePreferencesMenuItem() {
		try {
			Method m = applicationClass.getMethod("removePreferencesMenuItem", new Class[0]);
			m.invoke(application, new Object[0]);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public void setEnabledAboutMenu(boolean arg0) {
		try {
			Method m = applicationClass.getMethod("setEnabledAboutMenu", new Class[] { boolean.class });
			m.invoke(application, new Object[] { arg0 });
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public void setEnabledPreferencesMenu(boolean arg0) {
		try {
			Method m = applicationClass.getMethod("setEnabledPreferencesMenu", new Class[] { boolean.class });
			m.invoke(application, new Object[] { arg0 });
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public void setFramessMenuBar(MossMenuBar menuBar) {
		if (OperatingSystemUtil.isMac()) {
			getHiddenFrame().setJMenuBar(menuBar);
			getHiddenFrame().pack();
		}
	}

	public MossFrame getHiddenFrame() {
		if (OperatingSystemUtil.isMac()) {
			if (hiddenFrame == null)
				hiddenFrame = new HiddenMossFrame();
			return hiddenFrame;
		}
		return null;
	}
}

/*
 * Created on Aug 10, 2007 by wyatt
 */
package ca.digitalcave.moss.osx;

import com.apple.eawt.ApplicationListener;


@SuppressWarnings("deprecation")
class ApplicationAdapterWrapper implements ApplicationListener {

	private ApplicationAdapter adapter;
	
	public ApplicationAdapterWrapper(ApplicationAdapter adapter) {
		this.adapter = adapter;
	}
	
	public void handleAbout(com.apple.eawt.ApplicationEvent arg0) {
		if (adapter != null)
			adapter.handleAbout(new ApplicationEvent(arg0));
	}

	public void handleOpenApplication(com.apple.eawt.ApplicationEvent arg0) {
		if (adapter != null)
			adapter.handleOpenApplication(new ApplicationEvent(arg0));
	}

	public void handleOpenFile(com.apple.eawt.ApplicationEvent arg0) {
		if (adapter != null)
			adapter.handleOpenFile(new ApplicationEvent(arg0));
	}

	public void handlePreferences(com.apple.eawt.ApplicationEvent arg0) {
		if (adapter != null)
			adapter.handlePreferences(new ApplicationEvent(arg0));
	}

	public void handlePrintFile(com.apple.eawt.ApplicationEvent arg0) {
		if (adapter != null)
			adapter.handlePrintFile(new ApplicationEvent(arg0));
	}

	public void handleQuit(com.apple.eawt.ApplicationEvent arg0) {
		if (adapter != null)
			adapter.handleQuit(new ApplicationEvent(arg0));
	}

	public void handleReOpenApplication(com.apple.eawt.ApplicationEvent arg0) {
		if (adapter != null)
			adapter.handleReOpenApplication(new ApplicationEvent(arg0));
	}		
}

/*
 * Created on Aug 10, 2007 by wyatt
 */
package ca.digitalcave.moss.osx;

@SuppressWarnings("deprecation")
public class ApplicationEvent {
	private com.apple.eawt.ApplicationEvent event;

	public ApplicationEvent(com.apple.eawt.ApplicationEvent event) {
		this.event = event;
	}
	
	public com.apple.eawt.ApplicationEvent getEvent() {
		return event;
	}

	public void setEvent(com.apple.eawt.ApplicationEvent event) {
		this.event = event;
	}

	public String getFilename() {
		return this.event.getFilename();
	}

	public boolean isHandled() {
		return this.event.isHandled();
	}

	public void setHandled(boolean arg0) {
		this.event.setHandled(arg0);
	}
}

package interfaceadapters;

import java.util.ArrayList;
import java.util.List;

import frameworks.desktop.Subscriber;

public class Publisher {
	private List<Subscriber> subscribers = new ArrayList<>();
	
	public void addSubscriber(Subscriber sub) {
		subscribers.add(sub);
	}

	public void removeSubscriber(Subscriber sub) {
		subscribers.remove(sub);
	}
	 
	public void notifySubscribers() {
		for (Subscriber subscriber : subscribers) {
			subscriber.update();
		}
	}
}

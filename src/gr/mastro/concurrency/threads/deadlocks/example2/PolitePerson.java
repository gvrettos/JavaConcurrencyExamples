package gr.mastro.concurrency.threads.deadlocks.example2;

public class PolitePerson {
	private final String name;

	public PolitePerson(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	public synchronized void sayHello(PolitePerson person) {
		System.out.format("%s: %s has said hello to me!%n", this.name, person.getName());
		person.sayHelloBack(this);
	}
	
	private synchronized void sayHelloBack(PolitePerson person) {
		System.out.format("%s: %s has said hello back to me!%n", this.name, person.getName());
	}
}

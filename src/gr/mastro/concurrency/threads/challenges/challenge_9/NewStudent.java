package gr.mastro.concurrency.threads.challenges.challenge_9;

import java.util.concurrent.locks.ReentrantLock;

class NewStudent {

	private NewTutor tutor;
	private ReentrantLock studentLock;

	NewStudent(NewTutor tutor, ReentrantLock studentLock) {
		this.tutor = tutor;
		this.studentLock = studentLock;
	}

	public void startStudy() {
		// study
		System.out.println("Student is studying");
	}

	public void handInAssignment() {
		synchronized (tutor) {
			tutor.getProgressReport();
			if (studentLock.tryLock()) {
				try {
					System.out.println("Student handed in assignment");
					tutor.notifyAll();
				} finally {
					studentLock.unlock();
				}
			}
		}
	}
}

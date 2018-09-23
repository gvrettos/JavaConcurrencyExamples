package gr.mastro.concurrency.threads.challenges.challenge_9;

import java.util.concurrent.locks.ReentrantLock;

class NewTutor {

	private NewStudent student;
	private ReentrantLock studentLock;

	public NewTutor(ReentrantLock studentLock) {
		this.studentLock = studentLock;
	}

	public void setStudent(NewStudent student) {
		this.student = student;
	}

	public void studyTime() {
//		addDelayOnpurpose();
		
		synchronized (this) {
			System.out.println("Tutor has arrived");
			try {
				studentLock.lock();
				try {
					if (studentLock.isHeldByCurrentThread()) {
						studentLock.unlock();
					}
					// wait for student to arrive
					// add a timeout in order to avoid deadlock in case student thread starts first
					// and notifyAll() is called before wait()
					this.wait(5000);
				} catch (InterruptedException e) {

				}
				if (studentLock.tryLock()) {
					student.startStudy();
					System.out.println("Tutor is studying with student");
				}
			} finally {
				studentLock.unlock();
			}
		}
	}

	public void getProgressReport() {
		// get progress report
		System.out.println("Tutor gave progress report");
	}

	private void addDelayOnpurpose() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {

		}
	}
}

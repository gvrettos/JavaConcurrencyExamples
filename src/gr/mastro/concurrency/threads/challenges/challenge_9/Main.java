package gr.mastro.concurrency.threads.challenges.challenge_9;

/**
 * Challenge #9: Spot the problem with this piece of code and provide solution
 *
 */
public class Main {
	public static void main(String[] args) {
		final NewTutor tutor = new NewTutor();
		final NewStudent student = new NewStudent(tutor);
		tutor.setStudent(student);

		Thread tutorThread = new Thread(new Runnable() {
			@Override
			public void run() {
				tutor.studyTime();
			}
		});

		Thread studentThread = new Thread(new Runnable() {
			@Override
			public void run() {
				student.handInAssignment();
			}
		});

		tutorThread.start();
		studentThread.start();
	}
}

package gr.mastro.concurrency.threads.challenges.challenge_9;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Challenge #9: Spot the problem with this piece of code and provide solution
 * Solution: We have a deadlock here. We should look for the following:
 * 			 1. Is a set of locks being obtained in a different order by multiple threads? That's the case here.
 * 				If so, can we force all threads to obtain the locks in the same order?
 * 			 2. Are we over-synchronizing the code?
 * 			 3. Can we rewrite the code to break any circular call patterns?
 * 			 4. Would using ReentrantLock objects help?
 * 			 5. Take a look at places where the code calls wait() and see if that may cause a deadlock.
 * 				The wait() method results in a thread releasing a lock before it has exited the synchronized block 
 * 				and this premature release can lead to problems if we're not careful. 
 * 				That is the case in this challenge.
 * 				There is also a race condition issue: If student thread starts first then wait() will wait forever 
 * 				unless a timeout is defined.
 *
 */
public class Main {
	public static void main(String[] args) {
		ReentrantLock studentLock = new ReentrantLock();
		
		final NewTutor tutor = new NewTutor(studentLock);
		final NewStudent student = new NewStudent(tutor, studentLock);
		tutor.setStudent(student);

		Thread tutorThread = new Thread(() -> tutor.studyTime());
		Thread studentThread = new Thread(() ->	student.handInAssignment());

		tutorThread.start();
		studentThread.start();
	}
}

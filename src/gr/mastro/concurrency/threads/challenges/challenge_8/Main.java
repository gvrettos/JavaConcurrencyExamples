package gr.mastro.concurrency.threads.challenges.challenge_8;

/**
 * Challenge #8: Spot the problem with this piece of code and provide solution
 * Note: It is not possible for two invocations of synchronized methods on the same object to interleave. 
 * 		 When one thread is executing a synchronized method for an object, all other threads that invoke 
 * 		 synchronized methods for the same object block until the first thread is done with the object.
 * 		 This is what happens with "concurrent" calls on tutor.getProgressReport() and student.startStudy().
 * Solution: We have a deadlock here. We should look for the following:
 * 			 1. Is a set of locks being obtained in a different order by multiple threads? That's the case here.
 * 				If so, can we force all threads to obtain the locks in the same order?
 * 			 2. Are we over-synchronizing the code?
 * 			 3. Can we rewrite the code to break any circular call patterns?
 * 			 4. Would using ReentrantLock objects help?
 */
public class Main {
	 
    public static void main(String[] args) {
        Tutor tutor = new Tutor();
        Student student = new Student(tutor);
        tutor.setStudent(student);
 
        Thread tutorThread = new Thread(() -> tutor.studyTime());
        Thread studentThread = new Thread(() -> student.handInAssignment());
 
        tutorThread.start();
        studentThread.start();
    }
}

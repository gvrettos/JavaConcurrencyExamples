package gr.mastro.concurrency.threads.challenges.challenge_8;

class Student {
	 
    private Tutor tutor;
 
    Student(Tutor tutor) {
        this.tutor = tutor;
    }
 
    public void startStudy() {
        // study
        System.out.println("Student is studying");
    }
 
    public synchronized void handInAssignment() {
        tutor.getProgressReport();
        System.out.println("Student handed in assignment");
    }
}

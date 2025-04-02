package ExamAss.Nin;

class PrintMessage implements Runnable {
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Hello from thread");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
    public static void main(String[] args) {
        Thread thread = new Thread(new PrintMessage());
        thread.start();
    }
}

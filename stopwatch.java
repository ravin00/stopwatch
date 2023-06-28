import java.util.Timer;
import java.util.TimerTask;

public class stopwatch {
    private Timer timer;
    private int seconds;

    public stopwatch() {
        timer = new Timer();
        seconds = 0;
    }

    public void start() {
        TimerTask task = new TimerTask() {
            public void run() {
                seconds++;
                System.out.println("Elapsed time: " + seconds + " seconds");
            }
        };

        // Schedule the task to run every second
        timer.scheduleAtFixedRate(task, 1000, 1000);
        System.out.println("Stopwatch started.");
    }

    public void stop() {
        timer.cancel();
        System.out.println("Stopwatch stopped. Elapsed time: " + seconds + " seconds");
    }

    public void reset() {
        timer.cancel();
        seconds = 0;
        System.out.println("Stopwatch reset.");
    }

    public static void main(String[] args) {
        stopwatch stopwatch = new stopwatch();
        stopwatch.start();

        // Let the stopwatch run for 5 seconds
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        stopwatch.stop();
        stopwatch.reset();
    }
}

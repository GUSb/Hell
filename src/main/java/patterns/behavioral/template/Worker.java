package patterns.behavioral.template;

public abstract class Worker {

    public void usualWorkingDayActivity() {
        wakeUp();
        doWork();
        enjoyFreeTime();
        sleep();
    }

    protected abstract void wakeUp();

    protected abstract void doWork();

    protected abstract void enjoyFreeTime();

    protected abstract void sleep();
}

import java.util.concurrent.atomic.AtomicInteger;

public class Foo {
    private  int atomic=1;
    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        atomic++;
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while(atomic!=2){
            ;
        }
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        atomic++;
    }

    public void third(Runnable printThird) throws InterruptedException {
        while(atomic!=3){
            ;
        }
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}

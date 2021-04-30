import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 1115. 交替打印FooBar
 * 执行结果： 通过
 * 显示详情
 *
 * 执行用时：24 ms, 在所有 Java 提交中击败了99.23%的用户
 * 内存消耗：38.8 MB, 在所有 Java 提交中击败了29.12%的用户
 */
public class FooBar {
    private int n;
    private ReentrantLock lock=new ReentrantLock() ;
    private Condition foo=lock.newCondition();
    private Condition bar=lock.newCondition();
    private volatile boolean flag=true;
    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            lock.tryLock();
            if(!flag){
                bar.await();
            }
            printFoo.run();
            flag=false;
            foo.signalAll();
            lock.unlock();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            lock.tryLock();
            if(flag){
                foo.await();
            }
            printBar.run();
            flag=true;
            bar.signalAll();
            lock.unlock();
        }
    }
}


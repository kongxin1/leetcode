import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 1116. 打印零与奇偶数
 * 执行结果：通过
 * * 显示详情
 *
 * 执行用时：9 ms, 在所有 Java 提交中击败了99.90%的用户
 * 内存消耗：37.8 MB, 在所有 Java 提交中击败了31.41%的用户
 */
public class ZeroEvenOdd {
    private int n;
    private Lock lock=new ReentrantLock();
    private Condition zero=lock.newCondition();
    private Condition even=lock.newCondition();
    private Condition odd=lock.newCondition();
    private volatile int i=1;
    private volatile boolean flag=true;

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        while(i<=n) {
            lock.lock();
            if (!flag && i<=n) {
                zero.await();
            }
            if(i>n){
                lock.unlock();
                break;
            }
            printNumber.accept(0,"zero");
            flag = false;
            if(i%2==1){
                odd.signalAll();
            }else{
                even.signalAll();
            }
            lock.unlock();
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        while(i<=n) {
            lock.lock();
            if ((flag||i%2==1) && i<=n) {
                even.await();
            }
            if(i>n){
                lock.unlock();
                break;
            }
            printNumber.accept(i,"even");
            i++;
            flag = true;
            if(i>n){
                odd.signalAll();
            }
            zero.signalAll();
            lock.unlock();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        while(i<=n) {
            lock.lock();
            if ((flag||i%2==0) && i<=n ) {
                odd.await();
            }
            if(i>n){
                lock.unlock();
                break;
            }
            printNumber.accept(i,"odd");
            i++;
            flag = true;
            if(i>n){
                even.signalAll();
            }
            zero.signalAll();
            lock.unlock();
        }
    }
}
class IntConsumer{
    public void accept(int x,String s){
        System.out.println(s+x);
    }
}

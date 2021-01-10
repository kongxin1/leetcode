package interfaceDefault;

public interface B {
    default void sayHello(){
        System.out.println("i am b");
    }
}

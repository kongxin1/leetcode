package interfaceDefault;

public interface A {
    default void sayHello(){
        System.out.println("i am a");
    }
}

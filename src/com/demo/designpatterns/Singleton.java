package com.demo.designpatterns;




/**
 * <h2>4 Ways to implement Singleton pattern</h2>
 * {@link https://www.notion.so/yonderwire/Architecture-Design-Patterns-Principles-8563e1037f9d4d45bcf27441a34144fa?pvs=4}
 * <li>1. Eager</li>
 * <li>2. Lazy</li>
 * <li>3. Synchronized Method</li>
 * <li>4. Double Locking</li>
 * @author yonderwire</li>
 */
public class Singleton {



    /**
     * 1. Private static instance - This holds the single instance of the Singleton class.
     */
    private static Singleton instance;

    /**
     * 2. Private constructor - Prevents instantiation from other classes
     */
    private Singleton(){}

    /**
     * 3. Public static method to provide the single instance of the class
     *    <p>This implementation uses double-checked locking to ensure that the
     *    instance is created only once in a thread-safe manner.</p>
     *    <p>This GameService.class object contains metadata about the Example class,
     *    such as its : </p>
     *    <li>methods</li>
     *    <li>fields</li>
     *    <li>constructors</li>
     *    <li>and more</li>
     *    <h3>Usages</h3>
     *    <li>Reflection - Inspecting the class's metadata at runtime.</li>
     *    <li>Synchronization - Using it as a lock to ensure thread safety, like in the Singleton example we discussed.</li>
     */
    public Singleton getInstance(){

        // check happens outside the synchronized block.
        // This is a performance optimization
        // We don’t want to lock the method every time it’s called if the instance is already created.
        if (instance == null) {
            // Thread-safe code block
            // Allows only 1 thread to create an instance
            synchronized (Singleton.class) { // refers to teh class object
                // ensures that only one thread actually creates the instance.
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}

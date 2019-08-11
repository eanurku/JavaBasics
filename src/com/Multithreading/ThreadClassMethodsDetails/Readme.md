1. Use of yield method:

*Whenever a thread calls java.lang.Thread.yield method, it gives hint to the thread scheduler 
 that it is ready to pause its execution. Thread scheduler is free to ignore this hint.

*If any thread executes yield method , thread scheduler checks if there is any thread with same or 
 high priority than this thread. If processor finds any thread with higher or same priority then it 
 will move the current thread to Ready/Runnable state and give processor to other thread and 
 if not then current thread will keep executing.

2.Join method
 
* it block the current thread from where join method is called on another thread.

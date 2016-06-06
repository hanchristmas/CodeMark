import java.util.*;
import java.util.concurrent.locks.*;

/*****************************************************************/
//wait--notify
public class ProducerConsumer {
	public int queueSize=10;
	public PriorityQueue<Integer> queue=new PriorityQueue<Integer>(queueSize);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ProducerConsumer pc=new ProducerConsumer();
		Thread producer=new Thread(pc.new Producer());
		Thread consumer=new Thread(pc.new Consumer());
		producer.start();
		consumer.start();
		
	}

	
	class Consumer implements Runnable{

		public void run(){
			consume();
		}
		
		private void consume(){
			while(true){
				synchronized(queue){
					while(queue.size()==0)
					{
						try{
							System.out.println("队列已空~！");
							queue.wait();
						}
						catch(InterruptedException e){
							e.printStackTrace();
							queue.notify();
						}
					}
					queue.poll();
					queue.notify();
					System.out.println("已从队列取走一个~！");
				}
			}
		}
	}
	
	class Producer implements Runnable{
		
		public void run(){
			produce();
		}
		
		private void produce(){
			while(true){
				synchronized(queue){
				while(queue.size()==queueSize){
					try{
						System.out.println("队列已满");
						queue.wait();
					}
					catch(InterruptedException e){
						e.printStackTrace();
						queue.notify();
					}
				}
				queue.offer(1);
				queue.notify();
				System.out.println("向队列取中插入一个元素，队列剩余空间："+(queueSize-queue.size()));
				}
			}
		}
	}
}
/*****************************************************************/



/*****************************************************************/
// await--signal
public class ProducerConsumer{
	public int queueSize=10;
	public PriorityQueue<Integer> queue=new PriorityQueue<Integer>();
	public Lock lock=new ReentrantLock();
	public Condition notEmpty=lock.newCondition();
	public Condition notFull=lock.newCondition();
	public static void main(String[] args){
			ProducerConsumer pc=new ProducerConsumer();
			Thread producer=new Thread(pc.new Producer());
			Thread consumer=new Thread(pc.new Consumer());
			producer.start();
			consumer.start();
	}
	
	
	class Producer implements Runnable{
		public void run(){
			produce();
		}
		private void produce(){
			while(true){
				lock.lock();
				try{
					while(queue.size()==queueSize){
						try{
						System.out.println("队列满，等待有空余空间");
						notFull.await();
						}
						catch(InterruptedException e){
							e.printStackTrace();
						}
					}
					queue.add(1);
					notEmpty.signal();
					System.out.println("向队列取中插入一个元素，队列剩余空间："+(queueSize-queue.size()));
				}
				finally{
					lock.unlock();
				}
				
				
			}
		}
	}

	class Consumer implements Runnable{
		public void run(){
			consume();
		}
		
		private void consume(){
			while(true){
				lock.lock();
				try{
					while(queue.size()==0){
						try{
							System.out.println("队列空，等待数据");
							notEmpty.await();
						}
						catch(InterruptedException e){
							e.printStackTrace();
						}
					}
					queue.poll();
					notFull.signalAll();
					System.out.println("从队列取走一个元素，队列剩余"+queue.size()+"个元素");
				}
				finally{
					lock.unlock();
				}
			}
		}
	}
}

/*****************************************************************/
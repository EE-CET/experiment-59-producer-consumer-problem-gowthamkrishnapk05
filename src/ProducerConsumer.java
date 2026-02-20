class SharedBuffer {
    private int item;
    private boolean available = false;

    public synchronized void produce(int value) throws InterruptedException {
        while (available) {
            wait();
        }

        item = value;
        System.out.println("Produced: " + item);

        available = true;
        notifyAll();   // safer than notify
    }

    public synchronized void consume() throws InterruptedException {
        while (!available) {
            wait();
        }

        System.out.println("Consumed: " + item);

        available = false;
        notifyAll();   // safer than notify
    }
}

class Producer extends Thread {
    private SharedBuffer buffer;

    Producer(SharedBuffer buffer) {
        this.buffer = buffer;
    }

    public void run() {
        try {
            for (int i = 1; i <= 5; i++) {
                buffer.produce(i);
                Thread.sleep(100); // helps console ordering
            }
        } catch (InterruptedException e) {}
    }
}

class Consumer extends Thread {
    private SharedBuffer buffer;

    Consumer(SharedBuffer buffer) {
        this.buffer = buffer;
    }

    public void run() {
        try {
            for (int i = 1; i <= 5; i++) {
                buffer.consume();
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {}
    }
}

public class ProducerConsumer {
    public static void main(String[] args) {
        SharedBuffer buffer = new SharedBuffer();

        Consumer c = new Consumer(buffer);
        Producer p = new Producer(buffer);

        c.start();   // start consumer first
        p.start();
    }
}
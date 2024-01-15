import java.util.ArrayList;

class Main {
   public static void main(String[] args) {
       Dashboard dashboard = new Dashboard();
       Thread t1 = new Thread(1);
       t1.subscribe(dashboard);
       t1.start();
       t1.stop();
   }
}

class Thread {
   int id;
   String state;
   String priority;
   String culture;
   ArrayList<IObserver> observers;

   Thread(int id) {
       this.id = id;
       this.state = "created";
       this.priority = "default";
       this.culture = "default";
       System.out.println("Thread: " + this.id + " " + this.state);
       observers = new ArrayList<>();
   }

   void start() {
       this.state = "started";
       notifyObservers();
   }
   
    void sleep(){
        this.state="sleep";
        notifyObservers();
    }
 
     void aborted(){
         this.state="aborted";
         notifyObservers();
    }
     void suspended(){
         this.state="suspended";
         notifyObservers();
    }
   void stop() {
       this.state = "stopped";
       notifyObservers();
   }

   private void notifyObservers() {
       for (IObserver observer : observers) {
           observer.update(this.state);
       }
   }

   void subscribe(IObserver observer) {
       observers.add(observer);
   }

   void unsubscribe(IObserver observer) {
       observers.remove(observer);
   }
}

class Dashboard implements IObserver {
   @Override
   public void update(String state) {
       System.out.println("Changed State of thread: " + state);
   }
}

interface IObserver {
   void update(String state);
}

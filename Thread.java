// Online Java Compiler
// Use this editor to write, compile and run your Java code online

class Main {
    public static void main(String[] args) {
        Thread t1 = new Thread(1);
        t1.start();
        t1.stopped();
    }
}
class Thread{
    int id;
    String state;
    String priority;
    String culture;
    
    Thread(int id){
        this.id = id;
        this.state = "created";
        this.priority = "default";
        this.culture = "default";
        System.out.println("Thread: "+this.id+" "+ this.state);
    }
    void start(){
        this.state="started";
        System.out.println("Thread: "+this.id+" "+ this.state);
    }
    void sleep(){
        this.state="sleep";
        System.out.println("Thread: "+this.id+" "+ this.state);
    }
 
     void aborted(){
         this.state="aborted";
        System.out.println("Thread: "+this.id+" "+ this.state);
    }
     void suspended(){
         this.state="suspended";
        System.out.println("Thread: "+this.id+" "+ this.state);
    }
      void stopped(){
         this.state="stopped";
        System.out.println("Thread: "+this.id+" "+ this.state);
    }
    
}

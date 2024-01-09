import java.util.stream.Stream;
import java.util.function.Predicate;

public class Main {
 public static Predicate<String> checkStringStartWithAny(string startString){
    Predicate<String> preciateFunctionObj =str -> str.startsWith(startString);
    return preciateFunctionObj;
  }
  
  public static String[] filterItems(String[] items, Predicate<String> criteria) {
      return Stream.of(items)
              .filter(criteria)
              .toArray(String[]::new);
  }

  
  public static void main(String[] args) {
      String[] items = {"Apple", "Car", "Toy", "Today"};
      
      // check for starting character
      String[] filteredStartswithItems = filterItems(items, str -> str.startsWith("T"));
       filteredStartswithItems = filterItems(items,checkStringStartWithAny("T"));
       filteredStartswithItems = filterItems(items,checkStringStartWithAny("U"));
    filteredStartswithItems = filterItems(items,checkStringStartWithAny("V"));
    
      // check for length
      String[] filterLengthItems = filterItems(items, str -> str.length()>4);
      
      //display result
    display(filteredStartswithItems,filterLengthItems);
   
  }
 

 
 public static void display(String [] filteredStartswithItems,String [] filterLengthItems){
             System.out.println("String Items that start with T:-");
      for(String item: filteredStartswithItems){
          System.out.println(item);
      }
      System.out.println();
       System.out.println("String Items that have length > 4:-");
      for(String item: filterLengthItems){
         
          System.out.println(item);
      }
  }

import java.util.stream.Stream;
import java.util.Arrays;


public class Main {
public static void main(String[] args) {
  String [] items = {"Apple", "Car","Today","Toy"};
  FilterController filter = new FilterController();
  String[] filteredStartswithItems = filter.filterItems(items, "T");
   ContentDisplayController displayer = new ContentDisplayController();
   displayer.setContent(filteredStartswithItems);
   displayer.disp();
}
}

class FilterController {
 private StartsWithStrategy string;

 public FilterController() {
     this.string = new StartsWithStrategy();
 }

 public String[] filterItems(String[] items, String c) {
     this.string.setStartsWith(c);
     return Arrays.stream(items)
             .filter(item -> string.execute(item))
             .toArray(String[]::new);
 }
}


class ContentDisplayController {
  private String[] content;

  public void setContent(String[] content) {
      this.content = content;
  }

  public void disp() {
      System.out.println("String Items that start with T:-");
      for (String stringItem : content) {
          System.out.println(stringItem);
      }
  }
}

class StartsWithStrategy  {
  private String key;

  public void setStartsWith(String c) {
      this.key = c;
  }

  public boolean execute(String item) {
      return item.startsWith(key);
  }
}

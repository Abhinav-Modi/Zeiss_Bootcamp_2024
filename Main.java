// Online Java Compiler
// Use this editor to write, compile and run your Java code online

import java.util.stream.Stream;
import java.util.function.Predicate;
import java.util.Arrays;


public class Main {
  public static void main(String[] args) {
      Item[] items = {new Item("Apple"), new Item("Car"), new Item("Toy"), new Item("Today")};

      PredicateController predicate = new PredicateController();
      predicate.setStartsWith('T');
      FilterController filter = new FilterController();
      Item[] filteredStartswithItems = filter.filterItems(items, predicate);

      ContentDisplayController displayer = new ContentDisplayController();
      displayer.setContent(filteredStartswithItems);
      displayer.disp();
  }
}

class Item {
  private String name;

  public Item(String name) {
      this.name = name;
  }

  public String getName() {
      return name;
  }

  public boolean startsWith(char c) {
      return name.charAt(0) == c;
  }
}

class FilterController {
  public Item[] filterItems(Item[] items, PredicateController predicate) {
      return Arrays.stream(items)
              .filter(item -> predicate.execute(item))
              .toArray(Item[]::new);
  }
}

class ContentDisplayController {
  private Item[] content;

  public void setContent(Item[] content) {
      this.content = content;
  }

  public void disp() {
      System.out.println("String Items that start with T:-");
      for (Item item : content) {
          System.out.println(item.getName());
      }
  }
}

class PredicateController {
  private char keyChar;

  public void setStartsWith(char c) {
      this.keyChar = c;
  }

  public boolean execute(Item item) {
      return item.startsWith(keyChar);
  }
}

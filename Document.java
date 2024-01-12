import java.util.List;
import java.util.ArrayList;

public class Main {
   public static void main(String[] args) {
       Document doc = new Document();
       doc.addPart(new Header("Header", 1, "Title"));
       doc.addPart(new Paragraph("Paragraph ", 2, "Hi this is Abhinav, this is my github Id"));
       doc.addPart(new Hyperlink("GithubID: ", 3, "https://github.com/Abhinav-Modi/"));
       
       doc.addPart(new Footer("Footer ", 4, "This is a footer"));
       doc.open();
   }
}

class Document {
   private List<DocumentPart> parts;
   public Document() {
       this.parts = new ArrayList<>();
   }

   public void addPart(DocumentPart part) {
       parts.add(part);
   }

   public void open() {
       System.out.println("Opening Document");
       for (DocumentPart part : parts) {
           part.save();
          
       }
   }
}

abstract class DocumentPart {
   protected String name;
   protected int position;
   abstract void save();
}

class Paragraph extends DocumentPart {
   private String content;

   public Paragraph(String name, int position, String content) {
       this.name = name;
       this.position = position;
       this.content = content;
   }

   @Override
   public void save() {
       System.out.println(name + content);
   }
}

class Hyperlink extends DocumentPart {
   private String url;

   public Hyperlink(String name, int position, String url) {
       this.name = name;
       this.position = position;
       this.url = url;
   }

   @Override
   public void save() {
       System.out.println(name + url);
   }
}

class Header extends DocumentPart {
   private String title;

   public Header(String name, int position, String title) {
       this.name = name;
       this.position = position;
       this.title = title;
   }

   @Override
   public void save() {
       System.out.println(name + title);
   }
}

class Footer extends DocumentPart {
   private String text;

   public Footer(String name, int position, String text) {
       this.name = name;
       this.position = position;
       this.text = text;
   }

   @Override
   public void save() {
       System.out.println("\n"+name + text+"\n");
       
   }
}

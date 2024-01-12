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
       doc.convert();
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
   public void convert(){
       System.out.println("Converting DOC to HTML");
       ICconverter converter = new HTMLConverter();
       for(DocumentPart part:parts){
           part.convert(converter);
       }
   }
}

abstract class DocumentPart {
   protected String name;
   protected int position;
   abstract void save();
   abstract void convert(ICconverter converter);
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
   
   @Override
   public void convert(ICconverter converter){
       converter.convert(this);
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
   public void convert(ICconverter converter){
       converter.convert(this);
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
   public void convert(ICconverter converter){
       converter.convert(this);
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
   public void convert(ICconverter converter){
       converter.convert(this);
   }
}

interface ICconverter{
   void convert(Header h);
   void convert(Footer f);
   void convert(Paragraph p);
   void convert(Hyperlink h);
}

class HTMLConverter implements ICconverter{
  public void convert(Header header){
      System.out.println("Converting Header to HTML");
  }
  public void convert(Footer footer){
      System.out.println("Converting Footer to HTML");
  }
  public void convert(Paragraph paragraph){
      System.out.println("Converting Paragraph to HTML");
  }
  public void convert(Hyperlink hyperlink){
      System.out.println("Converting Hyperlink to HTML");
  }
}


using System;
using System.Collections.Generic;

class HelloWorld {

  static void Main() {
    List < Product > products = new List < Product > ();
    Console.WriteLine("\tProduct Creation Program\n\n");
    Console.WriteLine("Choose an Option\n");
    Console.WriteLine("1. Add Product\n");
    Console.WriteLine("2. Display Products\n");
    Console.WriteLine("3. Search Product\n");
    Console.WriteLine("4. Exit\n");

    int option = Convert.ToInt32(Console.ReadLine());
    do {
      switch (option) {
      case 1:
        addProduct(products);
        break;
      case 2:
        displayProducts(products);
        break;
      case 3:
        searchProductbyId(products);
        break;
      case 4:
        Environment.Exit(0);
        break;
      default:
        Console.WriteLine("Invalid Option: ");
        break;
      }
      Console.WriteLine("Choose an Option\n");
      Console.WriteLine("1. Add Product\n");
      Console.WriteLine("2. Display Products\n");
      Console.WriteLine("3. Search Product\n");
      Console.WriteLine("4. Exit\n");
      option = Convert.ToInt32(Console.ReadLine());
    } while (option != 4);
  }

  static void addProduct(List < Product > products) {
    Console.WriteLine("Enter product details:");
    Product product = new Product();
    Console.Write("ID: ");
    product.id = Convert.ToInt32(Console.ReadLine());
    Console.Write("Name: ");
    product.name = Console.ReadLine();
    Console.Write("Manufacturing Date (yyyy-mm-dd): ");
    product.mfgDate = DateTime.Parse(Console.ReadLine());
    Console.Write("Warranty (yyyy-mm-dd): ");
    product.warranty = DateTime.Parse(Console.ReadLine());
    Console.Write("Price: ");
    product.price = Convert.ToInt32(Console.ReadLine());
    Console.Write("Stock: ");
    product.stock = Convert.ToInt32(Console.ReadLine());
    Console.Write("GST: 5, 12, 18, 28: ");
    product.gst = Convert.ToInt32(Console.ReadLine());
    Console.Write("Discount (<= 30): ");
    product.discount = Convert.ToInt32(Console.ReadLine());

    products.Add(product);
    Console.WriteLine("Product added successfully!");
  }

  static void displayProducts(List < Product > products) {
    Console.WriteLine("Products:\n");
    foreach(var product in products) {
      Console.WriteLine($"ID: {product.id}\nName: {product.name}\nManufacturing Date: {product.mfgDate}\nWarranty: {product.warranty}\nPrice: {product.price}\nStock: {product.stock}\nGST: {product.gst}\nDiscount: {product.discount}\nTotal Price: {product.totalPrice}\n");
    }
  }

  static void searchProductbyId(List < Product > products) {
    Console.WriteLine("Enter Product Id to search");
    int id = Convert.ToInt32(Console.ReadLine());
    foreach(var product in products) {
      if (product.id == id) {
        Console.WriteLine("\nProduct Found:");

        Console.WriteLine($"ID: {product.id}\nName: {product.name}\nManufacturing Date: {product.mfgDate}\nWarranty: {product.warranty}\nPrice: {product.price}\nStock: {product.stock}\nGST: {product.gst}\nDiscount: {product.discount}\nTotal Price: {product.totalPrice}\n");

      } else throw new Exception("No such Product Exist");
    }
  }
}

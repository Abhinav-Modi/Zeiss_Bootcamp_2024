using System;

class Product {
  private int m_id;
  private string m_name;
  private DateTime m_mfgDate;
  private DateTime m_warranty;
  private int m_price;
  private int m_stock;
  private int m_gst;
  private int m_discount;
  private int m_taxPrice;
  private int m_discountPrice;
  private int m_totalPrice;
  public int id {
    get {
      return m_id;
    }
    set {
      if (value > 0) m_id = value;
      else throw new Exception("Invalid Product Id, enter only positive id");
    }
  }
  public string name {
    get {
      return m_name;
    }
    set {
      if (value.Length > 3) m_name = value;
      else throw new Exception("Name must be greater than 3 characters");
    }
  }
  public DateTime mfgDate {
    get {
      return m_mfgDate;
    }
    set {
      if (value < DateTime.Now) m_mfgDate = value;
      else throw new Exception("Manufacturing date must be before today");
    }
  }
  public DateTime warranty {
    get {
      return m_warranty;
    }
    set {
      if (value > DateTime.Now) m_warranty = value;
      else throw new Exception("Warranty date must be after today");
    }
  }
  public int price {
    get {
      return m_price;
    }
    set {
      if (value > 0) {
        m_price = value;
        UpdatePrices();
      } else throw new Exception("Price must be greater than 0");
    }
  }
  public int gst {
    get {
      return m_gst;
    }
    set {
      if (value == 5 || value == 12 || value == 18 || value == 28) {
        m_gst = value;
        UpdatePrices();
      } else throw new Exception("Select appropriate GST bracket");
    }
  }
  public int discount {
    get {
      return m_discount;
    }
    set {
      if (value <= 30) {
        m_discount = value;
        UpdatePrices();
      } else throw new Exception("Select appropriate discount");
    }
  }
  public int stock {
    get {
      return m_stock;
    }
    set {
      if (value > 0) m_stock = value;
      else throw new Exception("Stock must be greater than 0");
    }
  }

  public int totalPrice {
    get {
      return m_totalPrice;
    }
  }

  private void UpdatePrices() {
    m_taxPrice = m_price + (m_price * (m_gst / 100));
    m_discountPrice = m_taxPrice * m_discount/100;
    m_totalPrice = m_taxPrice - m_discountPrice;
  }

}

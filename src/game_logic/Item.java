package game_logic;

import org.newdawn.slick.geom.Rectangle;

public class Item extends Entity
{
   protected boolean stackable;
   protected int quantity;
   protected int maxQuantity;
   protected String description;
   protected boolean onScreen;
//   protected Image
   
   public static final int ITEM_WIDTH = 31, ITEM_HEIGHT = 31;
   
   public Item(String name, boolean stackable, int quantity, int maxQuantity, 
      String description)
   {
      this.name = name;
      this.stackable = stackable;
      this.description = description;
      this.quantity = quantity;
      this.maxQuantity = maxQuantity;
      this.onScreen = true;
      setShape(new Rectangle(64, 32*6, ITEM_WIDTH, ITEM_HEIGHT));   //TODO must fix later
   }
   
   /**
    * increase item quantity if stackable
    */
   public boolean increaseQuantity()
   {
      if(stackable == true && quantity < maxQuantity)
      {
         this.quantity ++;
         return true;
      }
      else
         return false;
   }
   
   /**
    * decrease item quantity
    */
   public boolean decreaesQuantity()
   {
      if(quantity > 1)
      {
         this.quantity --;
         return true;
      }
      else
         return false;    
   }
   
   public void onCollision(Entity ent)
   {
      // TODO for testing
//      String otherObject = ent.getClass().toString();
//      System.out.println(otherObject);
      Bowser myBow = (Bowser)ent;
      if(myBow.getInventory().addItem(this))
         this.setOnScreen(false);
   } 
   
   public String toString()
   {
      String details = "\nItem Name: " + this.name + "\nstackable: " + this.stackable 
         + "\nquantity: " + this.quantity + "\nmax Quantity: " + this.maxQuantity
         + "\ndescription: " + this.description;
      return details;
   }
   
   public boolean isStackable()
   {
      return this.stackable;
   }
   
   //Do we need this method???
   public Item getItem()
   {
      return this;
   }
   
   public int getQuantity()
   {
      return quantity;
   }
   
   public String getDescription()
   {
      return description;
   }
   
   public boolean getOnScreen() { return onScreen; }
   public void setOnScreen(Boolean state) { onScreen = state;}
   
   public static void main(String[] args)
   {
      // TODO Auto-generated method stub
      
      System.out.println("Non-stackable item test");
      Item itemOne = new Item("item one", false, 1, 10, "test item one");
      System.out.println(itemOne.toString());
      itemOne.increaseQuantity();
      System.out.println(itemOne.toString());
      
      System.out.println("Stackable item test");
      Item itemTwo = new Item("BF Sword", true, 1, 3, "this item is stackable, yay");
      System.out.println(itemTwo.toString());
      itemTwo.increaseQuantity();
      itemTwo.increaseQuantity();
      System.out.println(itemTwo.toString());
      itemTwo.increaseQuantity();
      System.out.println(itemTwo.toString());
   }
}

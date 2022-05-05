public class Node {
   protected int id;          // identitas
   protected String nama;     // identitas
   protected double ipk;      // identitas
   protected Node link;       // reference to next node

    /*  Constructor  */
   public Node(){
      id = 0;
      nama="";
      ipk=0.0;
      link = null;
   }    
    /*  Constructor  */
   public Node(int id, String nama, double ipk, Node n){
      this.id = id;
      this.nama= nama;
      this.ipk=ipk;
      link = n;
   }
   
   public String display(){ 
      String s ="{" + id + ", " + nama+ ", " + ipk+ "} ";
      return s;
   }
   
}        //akhir dari class
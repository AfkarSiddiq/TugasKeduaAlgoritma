import java.io.*;
import java.util.*;

/**
 * <h1>Tugas 2 INF-218 Struktur Data dan Algoritma</h1>
 * <h3>Semester Genap 2021/2022</h3>
 * Class ini adalah class yang harus diimplementasikan sebagai tugas 2 INF-218 Struktur Data dan Algoritma.
 * <br> Tugas ini tentang implementasi Linear linked list.
 * <br> Anda harus mengisi method-method yang masih kosong sehingga menjadi method yang benar.
 * <br> Setiap method yang berhasil diimplementasikan dengan baik bernilai 10 poin dan jika gagal berniali 0 poin..
 * <br> Jangan merubah nama method, tipe data yang di-return dan parameter-parameter dari headernya.
 * <br> Caranya mengimplementasikannya adalah dengan menghapus throw new TidakDiimplementasiException
 * <br> dan menggantinya dengan code program anda yang benar.
 * <br> Selamat mencoba dan Semoga berhasil.......
 *
 * <p>Author     : Zahnur
 * <br>Version   : 1.0  (5 April 2022)
 ********************************************************************************************/

public class TugasKeduaINF218{		

   protected Node first;   //Class Node memuat sebuah link dengan tiga item data.
   protected Node last;    //Item data terdiri dari (int id, String nama, double ipk).
   public int size;        //size adalah ukuran/jumlah node dari linked list. Jika linked list kosong maka size = 0.
   
 /**
 * Method konstruktor untuk TugasKeduaINF218.
 * <br> Jangan mengubah apapapun pada method ini.
 *********************************************************************************************/
   public TugasKeduaINF218(){
      first = null;
      last = null;
      size = 0;
   }

/**
 * Method displayList adalah method untuk menyimpan node-node dari linked list ke array String.
 * <br> Method ini digunakan dalam testing.
 * <br> Jangan mengubah apapapun pada method ini.
 *********************************************************************************************/   
   public String [] displayList(TugasKeduaINF218 tl)
   {
      String [] node = new String[size];
      int i=0;
      Node cur = tl.first;       // dimulai dari node pertama
      while(cur != null) {       // periksa apakah node sekarang null
         node[i]= cur.display();   // insert node ke array
         cur = cur.link;         // berpindah ke link selanjutnya
         i++;
      }
      return node;                 // me-return array node di linked list
   }
  
/**
 * Method insertFirst adalah method untuk memasukkan sebuah node pada posisi pertama dari linked list.
 * <br> Node yang dimasukkan memiliki item data: id, nama dan ipk.
 * <br> Linked list awalnya dapat kosong ataupun sudah memiliki elemen node.
 * <p> Setiap kali sebuah node ditambahkan, size dari linked list bertambah satu. 
 * @param id : item data id yang diberikan.
 * @param nama : item data nama yang diberikan.
 * @param ipk : item data ipk yang diberikan.
 *********************************************************************************************/       
   public void insertFirst(int id, String nama, double ipk){
         Node n = new Node(id, nama, ipk, first);
         first = n;
         if(last == null) last = n;
         size++; 
   }
   
/**
 * Method insertLast adalah method untuk memasukkan sebuah node pada posisi terakhir dari linked list.
 * <br> Node yang dimasukkan memiliki item data: id, nama dan ipk.
 * <br> Linked list awalnya dapat kosong ataupun sudah memiliki elemen node.
 * <p> Setiap kali sebuah node ditambahkan, size dari linked list bertambah satu. 
 * @param id : item data id yang diberikan.
 * @param nama : item data nama yang diberikan.
 * @param ipk : item data ipk yang diberikan.
 *********************************************************************************************/
   public void insertLast(int id, String nama, double ipk){
      Node n = new Node(id, nama, ipk, null);
      if(first == null) first = n;
      else last.link = n;
      last = n;
      size++;  
   }

/**
 * Method insertAtPost adalah method untuk memasukkan sebuah node pada posisi tertentu dari linked list.
 * <br> Node yang dimasukkan memiliki item data: id, nama dan ipk.
 * <br> pos adalah lokasi yang dihitung dari posisi head/first dari linked list.
 * <br> Jadi pos dimulai dari 0 sampai size-1. pos dari node first adalah 0 dan pos dari node last adalah size-1.
 * <br> Linked list awalnya dapat kosong ataupun sudah memiliki elemen node.
 * <p> Setiap kali sebuah node diinsert, size dari linked list bertambah satu. 
 * @param id : item data id yang diberikan.
 * @param nama : item data nama yang diberikan.
 * @param ipk : item data ipk yang diberikan.
 * @param pos : posisi node yang diberikan.
 *********************************************************************************************/
 
   public void insertAtPos(int id, String nama, double ipk,int pos) {
      if(pos < 0 || pos > size) throw new IndexOutOfBoundsException("Index out of bounds");
      if(pos == 0) insertFirst(id, nama, ipk);
      else if(pos == size) insertLast(id, nama, ipk);
      else {
         Node n = new Node(id, nama, ipk, null);
         Node cur = first;
         for(int i=0; i<pos-1; i++) cur = cur.link;
         n.link = cur.link;
         cur.link = n;
         size++;
      }       
   }   
  
/**
 * Method updateAtPost adalah method untuk merubah item data sebuah node pada posisi tertentu dari linked list.
 * <br> Node yang dirubah/update memiliki item data: id, nama dan ipk.
 * <br> pos adalah lokasi yang dihitung dari posisi head/first dari linked list.
 * <br> Jadi pos dimulai dari 0 sampai size-1. pos dari node first adalah 0 dan pos dari node last adalah size-1.
 * <br> Linked list yang di update dipastikan tidak kosong dan dipastikan juga posisi pos berada dalam jangkauan.
 * <br> Anda tidak perlu memeriksa apakah linked list kosong dan pos di luar jangkauan.
 * <p> Size dari linked list tetap tidak berubah.
 * @param tl : instan dari class TugasKeduaINF218 yang memuat linked list. 
 * @param pos : posisi node yang diberikan.
 * @param id : item data id yang diberikan.
 * @param nama : item data nama yang diberikan.
 * @param ipk : item data ipk yang diberikan.
 *********************************************************************************************/ 
   public void updateAtPos(TugasKeduaINF218 tl,int pos, int id, String nama, double ipk){
      Node n = new Node(id, nama, ipk, null);
      Node cur = tl.first;
      int i = 0;
      while(i < pos) {
         cur = cur.link;
         i++;
      }
      cur.id = id;
      cur.nama = nama;
      cur.ipk = ipk;
   }     
 
/**
 * Method reverseList adalah method untuk merubah urutan node-node dari linked list.
 * <br> Linked list yang di-return memiliki urutan terbalik yaitu node pertama adalah node terakhir dari linked list awal.
 * <br> Demikian juga urutan selanjutnya. 
 * <br> Misal linked list awal adalah [{7, Endang, 3.5} , {5, Danu, 1.5} , {2, Badu, 3.5} , {1, Ali, 1.5} , {3, Cici, 2.5} ] 
 * <br> maka yang di-return adalah [{3, Cici, 2.5} , {1, Ali, 1.5} , {2, Badu, 3.5} , {5, Danu, 1.5} , {7, Endang, 3.5} ]
 * <br> Linked list awal dipastikan tidak kosong dan tidak harus terurut.
 * <p> Size dari linked list tetap tidak berubah.
 * @param tl : instan dari class TugasKeduaINF218 yang memuat linked list (awal). 
 * @return TugasKeduaINF218 : linked list dimana urutan node-nodenya sudah dalam urutan terbalik.
 *********************************************************************************************/     
   public static TugasKeduaINF218 reverseList(TugasKeduaINF218 tl) {
      TugasKeduaINF218 tlReverse = new TugasKeduaINF218();
      Node cur = tl.first;
      while(cur != null) {
         tlReverse.insertFirst(cur.id, cur.nama, cur.ipk);
         cur = cur.link;
      }
      return tlReverse;
   }

/**
 * Method reverseSubList adalah method untuk merubah urutan node-node dalam jangkauan tertentu pada suatu linked list.
 * <br> Linked list yang di-return memiliki urutan terbalik hanya pada jangkauan tertentu (dari indeks i sampai j) dari linked list awal. 
 * <br> Indeks dimulai dari 0 sampai size-1. Indeks dari node first adalah 0 dan indeks dari node last adalah size-1.
 * <br> Misal linked list awal adalah [{7, Endang, 3.5} , {5, Danu, 1.5} , {2, Badu, 3.5} , {1, Ali, 1.5} , {3, Cici, 2.5} ] dan i=1, j=3 
 * <br> maka yang di-return adalah [{7, Endang, 3.5} , {1, Ali, 1.5} , {2, Badu, 3.5} , {5, Danu, 1.5} , {3, Cici, 2.5} ]
 * <br> Linked list awal dipastikan tidak kosong dan tidak harus terurut.
 * <p> Size dari linked list tetap tidak berubah.
 * @param tl : instan dari class TugasKeduaINF218 yang memuat linked list (awal). 
 * @param i : indeks awal jangkauan.
 * @param j : indeks akhir jangkauan.
 * @return TugasKeduaINF218 : linked list dimana urutan node-nodenya sudah dalam urutan terbalik.
 *********************************************************************************************/     
public static TugasKeduaINF218 reverseSubList(TugasKeduaINF218 tl,int i, int j) {
   TugasKeduaINF218 tlReverse = new TugasKeduaINF218();
   Node cur = tl.first;
   int pos = 0;
   int posInsert = 0;
   while(cur != null) {
      if (pos < i) {
         tlReverse.insertLast(cur.id, cur.nama, cur.ipk);
         pos++;
         posInsert++;
      }
      else if (pos <= j) {
         tlReverse.insertAtPos(cur.id, cur.nama, cur.ipk, posInsert);
         pos++;
      } else {
         tlReverse.insertLast(cur.id, cur.nama, cur.ipk);
      }

      cur = cur.link;
   }
      
   return tlReverse;
   }  

/**
 * Method subListIPK adalah method untuk menampilkan array dari id dari node-node dimana item data ipk-nya nilainya lebih besar dari nilai d.
 * <br> Misal linked list awal adalah [{7, Endang, 3.5} , {5, Danu, 1.5} , {2, Badu, 3.5} , {1, Ali, 1.5} , {3, Cici, 2.5} ] dan nilai d=2.0 
 * <br> maka array yang di-return adalah [7, 2, 3]
 * <br> Linked list awal dipastikan tidak kosong dan tidak harus terurut.
 * @param tl : instan dari class TugasKeduaINF218 yang memuat linked list (awal). 
 * @param d : nilai ipk pembanding.
 * @return int[] : array dari item data id dari node-node yang item data id dari node-nya lebih besar dari nilai d  .
 *********************************************************************************************/   
   public static int [] subListIPK(TugasKeduaINF218 tl, double d) {
      ArrayList<Integer> subList = new ArrayList<Integer>();
      Node cur = tl.first;
      while(cur != null) {
         if (cur.ipk > d) {
            subList.add(cur.id);
         }
         cur = cur.link;
      }

      int[] arrSubList = new int[subList.size()];
      for (int i=0; i<subList.size();i++) {
         arrSubList[i] = subList.get(i);
      }
      return arrSubList;
   } 
  
/**
 * Method removeSubList adalah method untuk menghapus node-node dalam jangkauan tertentu pada suatu linked list.
 * <br> Linked list yang di-return memuat node-node yang tersisa dari linked list awal. 
 * <br> Indeks dimulai dari 0 sampai size-1. Indeks dari node first adalah 0 dan indeks dari node last adalah size-1.
 * <br> Misal linked list awal adalah [{7, Endang, 3.5} , {5, Danu, 1.5} , {2, Badu, 3.5} , {1, Ali, 1.5} , {3, Cici, 2.5} ] dan i=1, j=2 
 * <br> maka yang di-return adalah [{7, Endang, 3.5} , {1, Ali, 1.5} , {3, Cici, 2.5} ]
 * <br> Linked list awal dipastikan tidak kosong dan tidak harus terurut.
 * <p> Size dari linked list yang di-return menurut jumlah node yang tersisa. Size = 0 jika semua node diremove.
 * @param tl : instan dari class TugasKeduaINF218 yang memuat linked list (awal). 
 * @param i : indeks awal jangkauan.
 * @param j : indeks akhir jangkauan.
 * @return TugasKeduaINF218 : linked list dimana urutan node-nodenya sudah dalam urutan terbalik.
 *********************************************************************************************/        
   public static TugasKeduaINF218 removeSubList(TugasKeduaINF218 tl,int i, int j) {
      
      Node cur = tl.first;
      int pos = 0;
      if(i == 0){
         while(pos >= j) {
            cur = cur.link;
            pos++;
            if(pos == j) {
               tl.first = cur.link;
            }
            tl.size--;
         }
      }
      else{
         Node tmp = null;
         while(cur != null){
            pos ++;
            if(pos == i){
               int ltk = j;
               while (pos <= ltk) {
                  tmp = cur.link;
                  cur.link = tmp.link;
                  tl.size--;
                  ltk--;                 
               }
            }
            cur = cur.link;
         }
      }
      return tl;
   }
/**
 * Method insertSortingListId adalah method untuk memasukkan sebuah node pada linked list terurut menurut id.
 * <br> Node yang dimasukkan memiliki item data: id, nama dan ipk.
 * <br> Misal linked list awal adalah [{1, Ali, 1.5} , {2, Badu, 3.5} , {3, Cici, 2.5} , {5, Danu, 1.5} , {7, Endang, 3.5} ]
 * <br> dan ditambahkan node {4, xxxx, 4.0} dan node {6, yyyy, 4.0} maka linked list setelah node-node ditambahkan adalah 
 * <br> [{1, Ali, 1.5} , {2, Badu, 3.5} , {3, Cici, 2.5} , {4, xxxx, 4.0} , {5, Danu, 1.5} , {6, yyyy, 4.0} , {7, Endang, 3.5} ]
 * <br> Linked list awalnya dapat kosong ataupun sudah memiliki elemen node terurut menurut item data id.
 * <p> Setiap kali sebuah node ditambahkan, size dari linked list bertambah satu. 
 * @param id : item data id yang diberikan.
 * @param nama : item data nama yang diberikan.
 * @param ipk : item data ipk yang diberikan.
 *********************************************************************************************/ 
   public void insertSortingListId(int id, String nama, double ipk) {
      if(first == null){
         insertFirst(id, nama, ipk);
      }
      else {
         Node cur = first;
         int pos = 0;
         while(cur != null) {
            if(cur.id > id) {
               insertAtPos(id, nama, ipk, pos);
               break;
            }
            else if(cur.link == null) {
               insertLast(id, nama, ipk);
               break;
            }
            else {
               cur = cur.link;
               pos++;
            }
         }
      }
   } 
   
/**
 * Method sortingListId adalah method untuk mengurutkan node-node dari linked list menurut id-nya.
 * <br> Linked list yang di-return memiliki urutan ascending berdasarkan urutan item data id dari linked list awal. 
 * <br> Misal linked list awal adalah [{7, Endang, 3.5} , {5, Danu, 1.5} , {2, Badu, 3.5} , {1, Ali, 1.5} , {3, Cici, 2.5} ] 
 * <br> maka yang di-return adalah [{1, Ali, 1.5} , {2, Badu, 3.5} , {3, Cici, 2.5} , {5, Danu, 1.5} , {7, Endang, 3.5} ]
 * <br> Linked list awal dipastikan tidak kosong dan tidak terurut.
 * <p> Size dari linked list tetap tidak berubah.
 * @param tl : instan dari class TugasKeduaINF218 yang memuat linked list (awal). 
 * @return TugasKeduaINF218 : linked list dimana urutan node-nodenya sudah terurut ascending berdasarkan item data id-nya.
 *********************************************************************************************/     
   public TugasKeduaINF218 sortingListId(TugasKeduaINF218 tl) {
      if(tl.first != null) {
         Node cur = tl.first;
         Node next = null;
         while(cur != null) {
            next = cur.link;
            while(next != null) {
               if(cur.id > next.id) {
                  int id = cur.id;
                  String nama = cur.nama;
                  double ipk = cur.ipk;
                  cur.id = next.id;
                  cur.nama = next.nama;
                  cur.ipk = next.ipk;
                  next.id = id;
                  next.nama = nama;
                  next.ipk = ipk;
               }
               next = next.link;
            }
            cur = cur.link;
         }
      }
      return tl;
   }
}

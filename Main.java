//Enkap(y), Inher(y), Poly(y), this(y), interface(y), Keyword super(y), final (y), abstract class (y), abstract method (y), overriding method(y), overloading method (y), constructor (y)

//Penggunaan Encapsulation
class Mahasiswa {
  public String Nama,NPM, Name = "Joko";
  private int Nilaiku;
  protected int Semesterku;

  // Setter
  public void setNilai(int Nilaiku) {
      this.Nilaiku = Nilaiku;
  }

  // Getter
  public int getNilai() {
      return Nilaiku;
  }
  
    // Penggunaan Polimorphism
  public String Ketuntasan(){
    return "Setiap Matkul Memiliki Nilai Ketuntasan Masing-masing";
  }
}

// Penggunaan Inheritance
class Matkul extends Mahasiswa{
  // Setter
  String Name = "Akuntansi 3";

  public void setSemester(int Semester) {
    Semesterku = Semester;
  }

  // Getter
  public int getSemester(){
    return Semesterku;
  }

  // Penggunaan Polimorphism (Overriding)
  public String Ketuntasan(){
    return "Absensi juga berpengaruh terhadap ketuntasan";
  }

  // Penggunaan super
  public void Cetak(){
    // Penggunaan super
    System.out.println("Nama Mahasiswa = " + super.Name);
    // Penggunaan this
    System.out.println("Mata Kuliah Favorit = " + this.Name);
  }
}

// superclass abstract (Abstract Class)
abstract class Penilaian{
  int Kehadiran, UjianAkhir;
  // Abstract Method
  abstract double Hitung();
}

//subclass dari superclass abstract
class PBO extends Penilaian {

  //PBO itu constructor
  public PBO (int Kehadiran, int UjianAkhir) {
    this.Kehadiran = Kehadiran;
    this.UjianAkhir = UjianAkhir;
  }

  double Hitung() {
    return ((0.9*Kehadiran)+(0.1*UjianAkhir));
  }
}

//subclass dari superclass abstract
class IMK extends Penilaian {

  //IMK itu constructor
  public IMK (int Kehadiran, int UjianAkhir) {
    this.Kehadiran = Kehadiran;
    this.UjianAkhir = UjianAkhir;
  }
  
  double Hitung() {
    return ((0.1*Kehadiran)+(0.9*UjianAkhir));
  }
}

// Penerapan Interface
interface Lepkom {
  public float cekNilaiAkhir(int Posttest, int Activity, int Pretest);
  public String cekKelulusan(int NilaiAkhir);
}

class Praktikan {
  private Lepkom lep;

  public Praktikan(Lepkom lep) {
    this.lep = lep;
  }

  void prosesCekNilaiAkhir(int Posttest, int Activity, int Pretest){
    // Menampilkan hasil akhir ujian lepkom (56.0)
    System.out.println("Nilai akhir ujian Lepkom anda = "+ this.lep.cekNilaiAkhir(Posttest, Activity, Pretest));
  }

  void prosesCekKelulusan(int NilaiAkhir){
    System.out.println("Status Kelulusan Lepkom = "+this.lep.cekKelulusan(NilaiAkhir));
  }
}

class Proses implements Lepkom {
  float NilaiAkhir;
  String StatusKelulusan;

  public float cekNilaiAkhir(int Posttest, int Activity, int Pretest){
    return (Posttest + Activity + Pretest)/3;
  }
  
  public String cekKelulusan(int NilaiAkhir) {
    if (NilaiAkhir <= 80) {
      return "Anda Tidak Lulus";
    } else {
      return "Anda Lulus";
    }
  } 
}

// Penggunaan Overloading
class UKM {
  public final void namaUKM() {
    String ukm = "Silat";
    System.out.println("UKM yang sudah diikuti = " + ukm);
  }

  public final void namaUKM(String ukm) {
    System.out.println("UKM yang akan diikuti = " + ukm);
  }
}

// //Pembuktian method final
// class UKMExt extends UKM {
//    public void namaUKM() {
//     String ukm = "Basket";
//     System.out.println("Nama UKM dari Method pertama di class UKM = " + ukm);
//   }
// }

class Main {
  public static void main(String[] args) {
    System.out.println("==========================");
    System.out.println("      DATA MAHASISWA");
    System.out.println("==========================");
    Mahasiswa Biodata = new Mahasiswa();
    Matkul M1 = new Matkul();
    
    // Hasil dari Encapsulation, Inheritance, 
    Biodata.Nama = "Joko";
    Biodata.NPM = "12121212";
    Biodata.setNilai(90);
    M1.setSemester(5);
    
    System.out.println(" ");
    System.out.println("Nama     = " + Biodata.Nama);
    System.out.println("NPM      = " + Biodata.NPM);
    System.out.println("Nilai    = " + Biodata.getNilai());
    System.out.println("Semester = " + M1.getSemester());
    System.out.println(" ");

    // Hasil dari super
    M1.Cetak();
    System.out.println(" ");

    // Hasil dari Polymorphism, Overriding Method
    // Class Mahasiswa
    System.out.println("Catatan 1 = " + Biodata.Ketuntasan());
    // Class Matkul
    System.out.println("Catatan 2 = " + M1.Ketuntasan());

    System.out.println(" ");
    // Hasil dari Abstract Class, Abstract Method, dan Constructor
    Penilaian PBOB = new PBO(2,10);
    Penilaian IMKO = new IMK(2,10);

    System.out.println("Nilai Mata Kuliah PBO = " + PBOB.Hitung());
    System.out.println("Nilai Mata Kuliah IMK = " + IMKO.Hitung());

    // // Hasil dari Interface
    System.out.println(" ");
    Lepkom Periksa = new Proses();
    Praktikan Bambanks = new Praktikan(Periksa);
    Bambanks.prosesCekNilaiAkhir(30,40,100);
    Bambanks.prosesCekKelulusan(56);

    // // Hasil dari Overloading
    System.out.println(" ");
    UKM Badrul = new UKM();
    Badrul.namaUKM();
    Badrul.namaUKM("Futsal");

    // // Hasil Penggunaan dan Pembuktian Final Keyword
    // UKMExt Badril = new UKMExt();
    // Badril.namaUKM();
  }
}
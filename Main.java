//Enkap(y), Inher(y), Poly(y), this(y), interface, Keyword super, final, abstract class (y), abstract method (y), overriding method(y), overloading method, constructor (y)

//Penggunaan Encapsulation
class Mahasiswa {
    public String Nama;
    public String NPM;
    private int Nilaiku;
    protected int SemesterQ;

    //setter
    public void setNilai(int Nilaiku) {
        this.Nilaiku = Nilaiku;
    }

    //getter
    public int getNilai() {
        return Nilaiku;
    }
     //polimorphism
    public String Ketuntasan(){
      return "Setiap Matkul Memiliki Nilai Ketuntasan Masing-masing";
    }
}

//Penggunaan Inheritance
class Matkul extends Mahasiswa{
  //setter
  public void setSemester(int Semester) {
    SemesterQ = Semester;
  }

  //getter
  public int getSemester(){
    return SemesterQ;
  }

  //polimorphism
  public String Ketuntasan(){
    return "Matkul ini sudah tuntas.";
  }
}

//superclass abstract
abstract class Penilaian{
  abstract double Hitung();
}

//subclass dari superclass abstract
class PBO extends Penilaian {
  int Kehadiran, UjianAkhir;

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
  int Kehadiran, UjianAkhir;

  //IMK itu constructor
  public IMK (int Kehadiran, int UjianAkhir) {
    this.Kehadiran = Kehadiran;
    this.UjianAkhir = UjianAkhir;
  }
  
    double Hitung() {
      return ((0.1*Kehadiran)+(0.9*UjianAkhir));
    }
}

class Main {
    public static void main(String[] args) {
        // Mahasiswa Biodata = new Mahasiswa();
        // Matkul Smstr = new Matkul();
        
        // // Hasil dari Encapsulation, Inheritance, 
        // Biodata.Nama = "Shiddiq";
        // Biodata.NPM = "12121212";
        // Biodata.setNilai(90);
        // Smstr.setSemester(5);
        
        // System.out.println("Nama  = " + Biodata.Nama);
        // System.out.println("NPM   = " + Biodata.NPM);
        // System.out.println("Nilai = " + Biodata.getNilai());
        // System.out.println("Semester = " + Smstr.getSemester());
        
        // // Hasil dari Polymorphism, Overriding Method
        // System.out.println("Isi dari method Ketuntasan di class nilai = " + Biodata.Ketuntasan());
        // System.out.println("Isi dari method Ketuntasan di class matkul = " + Smstr.Ketuntasan());


        // // Hasil dari Abstract Class, Abstract Method, dan Constructor
        // Penilaian PBOB = new PBO(2,10);
        // Penilaian IMKO = new IMK(2,10);

        // System.out.println("Nilai Mata Kuliah PBO = " + PBOB.Hitung());
        // System.out.println("Nilai Mata Kuliah IMK = " + IMKO.Hitung());
    }
}
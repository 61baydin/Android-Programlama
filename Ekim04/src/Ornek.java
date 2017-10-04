//paket sinir disi erisim yasak
/*public */ class Kutu{
	// 1) Kapsulleme
	private double genislik;  //default public tek tek degiskenlere 
	private double yukseklik; //private yazmak gerekiyor.
	private double derinlik;
	
	//tasarimci metota overloading
	Kutu(Kutu nesne){  // ref. la kopya olusturulmaz
		genislik= nesne.genislik;
		yukseklik= nesne.yukseklik;
		derinlik= nesne.derinlik;
	}
	
	Kutu(double genislik,double yukseklik,double derinlik){
		this.genislik=genislik;
		this.yukseklik =yukseklik;
		this.derinlik= derinlik;
	}
	
	//varsayilan
	Kutu(){
		genislik=-1;
		yukseklik= -1;
		derinlik= -1;
	}
	//kup
	Kutu(double uzunluk){
		genislik=uzunluk;
		yukseklik=uzunluk;
		derinlik=uzunluk;
	}
	//metot 
	double hacim() {
		return genislik * yukseklik * derinlik;
	}	
}

// 2) Miras 

class KutuAgirlik extends Kutu{
	private double agirlik;
	double x=0;
	KutuAgirlik(KutuAgirlik nesne){
		super(nesne);  // ust sinifin tasarimcisi cagrildi.
		agirlik=nesne.agirlik;
	}
	KutuAgirlik(double agirlik,double genislik,double yukseklik,double derinlik){
	super(genislik,yukseklik,derinlik);
	this.agirlik=agirlik;
	}
	
	KutuAgirlik(){
		super();
		agirlik= -1;
	}
	KutuAgirlik(double agirlik,double uzunluk){
		super(uzunluk);
		this.agirlik=agirlik;
	}
	double agirlikAl() {
		return agirlik;
	}
}
class Nakliye extends KutuAgirlik{
	private double masraf;
	double x=1;
	Nakliye(Nakliye nesne){
		super(nesne);
		masraf = nesne.masraf;
	}
	Nakliye(double masraf,double agirlik,double genislik,double yukseklik,double derinlik){
		super(agirlik,genislik,yukseklik,derinlik);
		this.masraf=masraf;
	}
		
	Nakliye(){
		super();
		masraf= -1;
	}
		
	Nakliye(double masraf,double agirlik,double uzunluk){
		super(agirlik,uzunluk);
		this.masraf=masraf;
	}
	
	double masrafAl() {
		
		System.out.println("x="+super.x);
		System.out.println(x);
		return masraf;
	}
	static int deg =0;
	final double PI = 3.14;
	static void duragan() {
		deg++;
		//System.out.println("Static method");
		// this.masraf= 8; static in icinde this kullanilmaz
		//super.x(); static icine this kullanilmaz
	}
}
	
	
abstract class Sekil{ //soyut tanımladık
	double taban;
	double yukseklik;
	
	Sekil(double t,double y){
		taban= t;
		yukseklik= y;
	}
abstract double alan();/* {
		 return 0; 
	 }*/
}
class Ucgen extends Sekil {
	
	Ucgen(double t,double y){
		super(t,y);
	}
	//overriding
	double alan() {
		return taban *yukseklik /2;
	}
}
class Dikdortgen extends Sekil {
	
	Dikdortgen(double t,double y){
		super(t,y);
	}
	//overriding
	double alan() {
		return taban *yukseklik ;
	}
}
public class Ornek { //class ismi ile dosya ismi ayni olmali

	public static void main(String[] args) {
		
	//	Sekil sekil = new Sekil(3,2);
	//	System.out.println(sekil.alan());
		
		Sekil ref;//referans
		Ucgen  ucgen = new Ucgen(3,2);
		ref=ucgen;
		System.out.println(ref.alan());
		
		Dikdortgen  dikdortgen = new Dikdortgen(3,2);
		ref=dikdortgen;
		System.out.println(ref.alan());
		
		// static uye fonksiyonlara ... belirtilmeden erisilebiliyor.
		//Kutu nesne =new Kutu(); // varsayilan constr. çagriliyor
		// nesne.genislik= 3.2; private tanimli gormez. 
		
/*		Nakliye nesne1 = new Nakliye(); Nakliye.duragan(); //Nakliye yerine nesne1 yazılabilir.
		Nakliye nesne2 = new Nakliye(); Nakliye.duragan(); 
		Nakliye nesne3 = new Nakliye(); Nakliye.duragan(); 
		System.out.println(Nakliye.deg);
		System.out.println(nesne3.PI);   */
		//Nakliye nesne = new Nakliye();
		//nesne.masrafAl();
		//Nakliye.duragan();
	}
}

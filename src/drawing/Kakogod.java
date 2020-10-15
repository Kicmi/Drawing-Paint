package drawing;

/*public jer je javna metoda, static jer promenljiva ili metoda (u ovom slucaju) pripada klasi,
  a ne objektu (ne mora da se pravi objekat neke klase da bi pozvali metodu) */
public class Kakogod {

	public static void main(String[] args) {
		/*Point p=new Point(5,10);
		System.out.println(p);
		
		
		Line l=new Line(new Point(5,5), new Point(10,10));
		/*jedan nacin je da se prvo naprave tacke i da se te dve tacke proslede metodi, a drugi nacin je 
		da se direktno u njemu naprave tacke
		System.out.println(l);
		
		Rectangle r = new Rectangle (new Point(2,2), 5, 10);
		System.out.println(r);
		
		Circle c = new Circle (new Point(4,4), 10);
		System.out.println(c);
		
		Donut d = new Donut (new Point(2,2, true), 10, 15,true);
		System.out.println(d);*/
		
		Rectangle r1 = new Rectangle (new Point(1,1),5,5);
		Rectangle r2 = new Rectangle (new Point(1,1),10,10);
		System.out.println(r1.area());
		System.out.println(r2.area());
		System.out.println(r1.compareTo(r2));
	}
	

}

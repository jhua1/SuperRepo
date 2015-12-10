//James Hua
//APCS1 pd10
//HW45 -- Come Together
//2015-12-09

public class Rational implements Comparable {

    // Instance Vars
    private int numerator;
    private int denominator;

    public Rational() {
	numerator = 0;
	denominator = 1;
    }

    public Rational(int n, int d) {
	if ( d == 0 ) { // denominator can't be zero
	    System.out.println("Nope.");
	    numerator = 0;
	    denominator = 1;
	}
	else {
	    numerator = n;
	    denominator = d;
	}
    }


    public String toString() { 
	return numerator + " / " + denominator;
    }

    public double floatValue() { 
	return numerator/(double)denominator;
    }

    public void multiply(Rational s) {
	numerator *= s.numerator;
	denominator *= s.denominator;
    }

    public void divide(Rational s) {
	numerator *= s.denominator;
	denominator *= s.numerator;
    }

    public void add(Rational s) {
	if ( denominator == s.denominator ) { // if denominators are equal there is no need for LCD
	    numerator += s.numerator;
	}
	else {
	    numerator *= s.denominator;
	    numerator += s.numerator * denominator;
	    denominator *= s.denominator;
	}
    }

    public void subtract(Rational s) {
	if ( denominator == s.denominator ) {
	    numerator -= s.numerator;
	}
	else {
	    numerator *= s.denominator;
	    numerator -= s.numerator * denominator;
	    denominator *= s.denominator;
	}
    }

    public int gcd(){
	int min;
	int max;
	int stor;
	if ((numerator == 0) || (denominator == 0)){ // if either of them is 0 gcd is automatically 0.
	    return 0;
	}
	else {
	    if ( numerator >= denominator ) {
		max = numerator;
		min = denominator;
	    }
	    else {
		max = denominator;
		min = numerator;
	    }
	    while (min != 0){
	        stor = min;
		min = max % min;
		max = stor;
	    }
	    return max;
	}
    }

    public static int gcds(int n, int d) {
	int min;
	int max;
	int stor;
	if ((n == 0) || (d == 0)){
	    return 0;
	}
	else {
	    if ( n >= d ) {
		max = n;
		min = d;
	    }
	    else {
		max = d;
		min = n;
	    }
	    while (min != 0){
	        stor = min;
		min = max % min;
		max = stor;
	    }
	    return max;
	}
    }


    public void reduce() {
	int g = this.gcd();
	if ( g != 0 ) {
	    numerator /= g;
	    denominator /= g;
	}
    }

    public int compareTo(Object o) {
	
	if (!( o instanceof Comparable)){
		throw new ClassCastException("My first error message!\n"+
					     "compareTo() input not a Comparable");
	    }
	else{
	    this.reduce();
	    ((Rational)o).reduce();
	    //Stimulates the idea of cross-multiplication so that the fractions have the same denominator, and then compares a and b which are the numerator values
	    int a = this.numerator * ((Rational)o).denominator;
	    int b = this.denominator *((Rational)o).numerator;
	    if ( a == b ) {
		return 0;
	    }
	    else if ( a < b ) {
		return -1;
	    }
	    else {
		return 1;
	    }
	}
    }

    public boolean equals(Object r) {
	if(this == (Rational)r){
	    return true;
	}
	if(this.compareTo((Rational)r) == 0){
	    return true;
	}
	return false;
    }

    public static void main( String[] args ) { // main method

	// testing!

	System.out.println( "=====Rational a=====" );
	Rational a = new Rational(15,30);
	System.out.println( "a: " + a );
	System.out.println( "a.floatValue(): " + a.floatValue() );
	System.out.println( "a.gcd(): " + a.gcd() );
	a.reduce();
	System.out.println( "a.reduce(): " + a );

	System.out.println( "\n=====Rational B=====" );
	Rational b = new Rational(3,6);
	System.out.println( "b: " + b );
	System.out.println( "b.floatValue(): " + b.floatValue());
	System.out.println( "b.gcd(): " + b.gcd());
	b.reduce();
	System.out.println( "b.reduce(): " + b);

	System.out.println( "\n=====Rational C=====" );
	Rational c = new Rational(5,6);
	System.out.println( "c: " + c);
	System.out.println( "c.floatValue(): " + c.floatValue());
	System.out.println( "c.gcd(): " + c.gcd());
	c.reduce();
	System.out.println( "c.reduce(): " + c);

	
	c.add(b);
	System.out.println( "\nc + b = " + c);
	a.subtract(b);
	System.out.println( "\na - b = " + a);

	a = new Rational(15,30);
	b = new Rational(3,6);
	c = new Rational(5,6);
	
	System.out.println( "\n Testing Comparable..." );
	System.out.println( "a.compareTo(b): " + a.compareTo(b));
	System.out.println( "a.compareTo(c): " + a.compareTo(c));
	System.out.println( "a.equals(b): " + a.equals(b));
	System.out.println( "a.equals(c): " + a.equals(c));
	
    }
}
    
    

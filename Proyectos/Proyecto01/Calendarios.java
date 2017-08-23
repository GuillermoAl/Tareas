import java.util.GregorianCalendar;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;


public class Calendarios{
     
	public static void main(String []args){
		Calendar cal1 = new GregorianCalendar();
		Calendar cal2 = new GregorianCalendar();
		Scanner s = new Scanner(System.in);
		boolean prueba = true;
		int x;
		int z = 0;
		int y = 0;
		String an, m;
		System.out.printf("Dame el anio: ");
		an = s.nextLine();
		do{
			System.out.printf("Dame el mes: ");
            m = s.nextLine();
            y = mesEntero(m.toUpperCase());
            System.out.printf("Dame el dia: ");
            z = s.nextInt();
            System.out.println(an +m+y +z+m.toUpperCase());
            if(an.length() == 4 && m.length() == 3 && y != 0 && z <= 99){
            	prueba = false;
            }else{
                System.out.println("Informacion Fallida");
                System.out.printf("Dame el anio: ");
                an = s.nextLine();
            }
		}while(prueba);
		x = anioNum(an);
		Date date = new Date(x, y, z);
		cal1.setTime(date);
		date = new Date (1521, 8, 13);
		cal2.setTime(date);
		int numdias = numeroDias(cal1.getTime(),cal2.getTime());
		int dia = 1;
		int simbolodia = 5;
		int anio = 3;
		int simboloanio = 3;
		if( x > 1521 || (x == 1521 && y > 8) || (x == 1521 && y == 8 && x > 13) ){
			for (int i= 1; i<= numdias; i++ ){
				if(dia >= 14){
					dia = 1;
				}if(simbolodia >= 21){
					simbolodia = 1;
					if(dia == 1){
						anio++;
						simboloanio += 5;
						if(simboloanio > 20){
							simboloanio = 3;
						}
					}
				}if(anio >= 14){
        			 anio = 1;
				}
				dia++;
				simbolodia++;
			}
		}
		else if(x < 1521 || (x == 1521 && y < 8) || (x == 1521 && y == 8 && x < 13)){
			for (int i= 1; i<= numdias; i++ ){
				if(dia <= 0){
					dia = 13;
				}if(simbolodia <= 0){
					simbolodia = 20;
					if(dia == 13){
						anio--;
						simboloanio -= 5;
						if(simboloanio < 0){
							simboloanio = 18;
						}
					}
				}if(anio <= 0){
					anio = 13;
				}
				dia--;
				simbolodia--;
			}
		}
		imprimirFecha(dia, simbolodia, anio, simboloanio);
	}
	
	public static void imprimirFecha(int dia, int sdia, int anio, int sanio){
		String nahuatl = ("dia " + dia);
		String espaniol = ("dia " + dia);
		switch(sdia){
			case 1:
				nahuatl = nahuatl.concat("-Cipatli");
				espaniol = espaniol.concat("-Caiman");
				break;
			case 2:
				nahuatl = nahuatl.concat("-Ehecatl");
				espaniol = espaniol.concat("-Viento");				
				break;
			case 3:
				nahuatl = nahuatl.concat("-Calli");
				espaniol = espaniol.concat("-Casa");
				break;
			case 4:
				nahuatl = nahuatl.concat("-Cuetzpallin");
				espaniol = espaniol.concat("-Lagartija");
				break;
			case 5:
				nahuatl = nahuatl.concat("-Coatl");
				espaniol = espaniol.concat("-Serpiente");
				break;
			case 6:
				nahuatl = nahuatl.concat("-Miquiztli");
				espaniol = espaniol.concat("-Muerte");
				break;
			case 7:
				nahuatl = nahuatl.concat("-Mazatl");
				espaniol = espaniol.concat("-Venado");
				break;
			case 8:
				nahuatl = nahuatl.concat("-Tochtli");
				espaniol = espaniol.concat("-Conejo");
				break;
			case 9:
				nahuatl = nahuatl.concat("-Atl");
				espaniol = espaniol.concat("-Agua");
				break;
			case 10:
				nahuatl = nahuatl.concat("-Itzcuintli");
				espaniol = espaniol.concat("-Perro");
				break;
			case 11:
				nahuatl = nahuatl.concat("-Ozomatli");
				espaniol = espaniol.concat("-Mono");
				break;
			case 12:
				nahuatl = nahuatl.concat("-Malinalli");
				espaniol = espaniol.concat("-Hierba");
				break;
			case 13:
				nahuatl = nahuatl.concat("-Acatl");
				espaniol = espaniol.concat("-Flecha");
				break;
			case 14:
				nahuatl = nahuatl.concat("-Ocelotl");
				espaniol = espaniol.concat("-Jaguar");
				break;
			case 15:
				nahuatl = nahuatl.concat("-Cuauhtli");
				espaniol = espaniol.concat("-Aguila");
				break;
			case 16:
				nahuatl = nahuatl.concat("-Cozcacuauhtli");
				espaniol = espaniol.concat("-Buitre");
				break;
			case 17:
                             	nahuatl = nahuatl.concat("-Ollin");
				espaniol = espaniol.concat("-Movimiento");
				break;
			case 18:
				nahuatl = nahuatl.concat("-Tecpatl");
				espaniol = espaniol.concat("-Pedernal");
				break;
			case 19:
				nahuatl = nahuatl.concat("-Quiahuitl");
				espaniol = espaniol.concat("-Lluvia");
				break;
			case 20:
				nahuatl = nahuatl.concat("-Xochitl");
				espaniol = espaniol.concat("-Flor");
				break;		
		}
		nahuatl = nahuatl.concat(", " + anio);
		espaniol = espaniol.concat(" del anio " + anio);
		switch(sanio){
			case 1:
				nahuatl = nahuatl.concat("-Cipatli");
				espaniol = espaniol.concat("-Caiman");
				break;
			case 2:
				nahuatl = nahuatl.concat("-Ehecatl");
				espaniol = espaniol.concat("-Viento");				
				break;
			case 3:
				nahuatl = nahuatl.concat("-Calli");
				espaniol = espaniol.concat("-Casa");
				break;
			case 4:
				nahuatl = nahuatl.concat("-Cuetzpallin");
				espaniol = espaniol.concat("-Lagartija");
				break;
			case 5:
				nahuatl = nahuatl.concat("-Coatl");
				espaniol = espaniol.concat("-Serpiente");
				break;
			case 6:
				nahuatl = nahuatl.concat("-Miquiztli");
				espaniol = espaniol.concat("-Muerte");
				break;
			case 7:
				nahuatl = nahuatl.concat("-Mazatl");
				espaniol = espaniol.concat("-Venado");
				break;
			case 8:
				nahuatl = nahuatl.concat("-Tochtli");
				espaniol = espaniol.concat("-Conejo");
				break;
			case 9:
				nahuatl = nahuatl.concat("-Atl");
				espaniol = espaniol.concat("-Agua");
				break;
			case 10:
				nahuatl = nahuatl.concat("-Itzcuintli");
				espaniol = espaniol.concat("-Perro");
				break;
			case 11:
				nahuatl = nahuatl.concat("-Ozomatli");
				espaniol = espaniol.concat("-Mono");
				break;
			case 12:
				nahuatl = nahuatl.concat("-Malinalli");
				espaniol = espaniol.concat("-Hierba");
				break;
			case 13:
				nahuatl = nahuatl.concat("-Acatl");
				espaniol = espaniol.concat("-Flecha");
				break;
			case 14:
				nahuatl = nahuatl.concat("-Ocelotl");
				espaniol = espaniol.concat("-Jaguar");
				break;
			case 15:
				nahuatl = nahuatl.concat("-Cuauhtli");
				espaniol = espaniol.concat("-Aguila");
				break;
			case 16:
				nahuatl = nahuatl.concat("-Cozcacuauhtli");
				espaniol = espaniol.concat("-Buitre");
				break;
			case 17:
				nahuatl = nahuatl.concat("-Ollin");
				espaniol = espaniol.concat("-Movimiento");
				break;
			case 18:
				nahuatl = nahuatl.concat("-Tecpatl");
				espaniol = espaniol.concat("-Pedernal");
				break;
			case 19:
				nahuatl = nahuatl.concat("-Quiahuitl");
				espaniol = espaniol.concat("-Lluvia");
				break;
			case 20:
				nahuatl = nahuatl.concat("-Xochitl");
				espaniol = espaniol.concat("-Flor");
				break;		
		}
		System.out.println("Utilizando como punto de partida" +
		" el dia propuesto por Alfonso Caso, el dia en el calendario tonalpohualli es: ");
		System.out.printf(espaniol + "\n");
		System.out.printf(nahuatl + "\n");
	}
	
	public static int anioNum(String a) {
		int anio= Integer.parseInt(a);
		return anio;
	}
     
	public static int numeroDias(Date d1, Date d2){
		int numd =(int)( (d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24));
		if (numd<0){
			numd *= -1;
		}
		return numd;
	}
     
	public static int mesEntero(String a){
		int mes=0;
		if(a.equals("ENE")){
			mes=1;
		}else if(a.equals("FEB")){
			mes=2;
		}else if(a.equals("MAR")){
			mes=3;
		}else if(a.equals("ABR")){
			mes=4;
		}else if(a.equals("MAY")){
			mes=5;
		}else if(a.equals("JUN")){
            mes=6;
		}else if(a.equals("JUL")){
            mes=7;
		}else if(a.equals("AGO")){
			mes=8;
		}else if(a.equals("SEP")){
			mes=9;
		}else if(a.equals("OCT")){
            mes=10;
		}else if(a.equals("NOV")){
            mes=11;
		}else if(a.equals("DIC")){
            mes=12;
		}
		return mes;
     }
	
}

import java.util.Scanner;

/**
 *Clase que trabaja con mensajes ocultos así bien misteriosos 
 *@author Jorge Miguel Aaron Barrientos Alvarez. NC:421111666
 *@since Proyecto del curso de ICC 2021-1
 *@version 1.0 diciembre 2020 
 */
public class Proyecto2{
    /**
     *Metodo auxiliar que elimina los espacios innecesarios en una lista.
     *Estos son espacios al principio y al final de la lista, y entre las palabras.
     *Deja un solo espacio al inicio de la lista y un solo espacio entre palabras. 
     *
     *@param original Lista original a la que se le van a eliminar
     *                los espacios innecesarios.
     *@return lista Lista sin espacios al final
     */
    
    public static String eliminaEspacios(String original){
	int i=original.length()-1;
	String lista="";
	
	while(original.charAt(i)==' ')
	    i--;

	for(int k=0; k<i+1;k++)
	    lista+=original.charAt(k);

	String lista2=" ";
	int j=0;
	
	while(lista.charAt(j)==' ')
	    j++;

	for(int k=j; k<lista.length(); k++)
	    lista2+=lista.charAt(k);
	lista="";

	for(int m=0; m<lista2.length();m++){
	    if(lista2.charAt(m)==' ' && lista2.charAt(m+1)==' ')
		continue;

	    lista+=lista2.charAt(m);
	}
	return lista;
    }
    
    /**
     *Toma la n-ésima letra de cada palabra para obtener el mensaje 
     *oculto.
     *
     *@param original El mansaje original
     *@param n El indice que se tiene que tomar de cada palabra
     *@return El mensaje oculto, sin espacios 
     */

    public String descifraNulo(String original, int n){
	n++;
	original=eliminaEspacios(original);
	original=original.replace(".", "");
	original=original.replace(",","");
	String mensaje="";
		    	
	for(int i=0; i<original.length(); i++){
	    if(original.charAt(i)==' ' && original.charAt(i+1)!=' '){
		int contador=0;
		for(int k=i+1; k<i+n; k++){
		    if(original.charAt(k)==' ')
			contador++;
		}

		if(contador==0)
		    mensaje+=original.charAt(i+n);
	    }
		 
	}
	mensaje=mensaje.replace(" ","");
	return mensaje;
    }

    /**
     *Toma la n-ésima letra de cada palabra para obtener el mesaje 
     *oculto
     *
     *@param original El mensaje original con n espacios al final
     *@return el mensaje oculto, sin espacios
     */
    public String descifraNulo(String original){
	Proyecto2 llamar=new Proyecto2();
	original=original.replace(".", "");
	original=original.replace(",","");
	int n=0;
	int i=original.length()-1;

	while(original.charAt(i)==' '){
	    n++;
	    i--;
	}

	String mensaje=llamar.descifraNulo(original, n);
	return mensaje;
	
    }
    

    /**
     *Busca un nombre oculto en un texto arbitrario ignorando
     *espacios, signos de puntuacion y sin hacer distinciones 
     *entre mayusculas y minúsculas.
     *
     *@param mensaje Una cadena arbitraria donde se hará la 
     *               búsqueda.
     *@param nombre El nombre que se buscará en el texto.
     *@return true si el mensaje está contenido, false en otro 
     *        caso 
     */
    public boolean contieneNombre(String mensaje, String nombre){
	boolean respuesta=false;
	
	//Eliminar todos los espacios de las listas
	mensaje=mensaje.replaceAll("\\s","");
	nombre=nombre.replaceAll("\\s", "");

	//Se cambian todas las letras a minusculas
	mensaje=mensaje.toLowerCase();
	nombre=nombre.toLowerCase();

	//Se eliminan signos de puntuacion y vocales asentuadas
	mensaje=mensaje.replace(",", "");
	mensaje=mensaje.replace(".", "");
	mensaje=mensaje.replace("'", "");
	mensaje=mensaje.replace("á", "a");
	mensaje=mensaje.replace("é", "e");
	mensaje=mensaje.replace("í", "i");
	mensaje=mensaje.replace("ó", "o");
	mensaje=mensaje.replace("ú", "u");
	mensaje=mensaje.replace("ü","u");

	nombre=nombre.replace(",", "");
	nombre=nombre.replace(".", "");
	nombre=nombre.replace("'", "");
	nombre=nombre.replace("á","a");
	nombre=nombre.replace("é","e");
	nombre=nombre.replace("í","i");
	nombre=nombre.replace("ó","o");
	nombre=nombre.replace("ú","u");
	nombre=nombre.replace("ü","u");

	for(int i=0; i<mensaje.length(); i++){
	    if(mensaje.charAt(i)==nombre.charAt(0)){
		if(mensaje.substring(i, i+nombre.length()).equals(nombre)){
		    respuesta=true;
		    break;
		}	    
	    }
	}
	    	
        return respuesta;
    }

    /**
     *Reconstruye el mensaje oculto a partir de las palabras
     *especiales que se obtienen al comparar dos textos.
     *
     *@param m Un texto arbitrario.
     *@param e Un texto similar al primero, pero con algunas 
     *         palabras especiales
     *@return El mensaje oculto
     */
    public String descifraPalabrasMarcadas(String m, String e){
	String mensaje="";
        m=eliminaEspacios(m);
        e=eliminaEspacios(e);
        m+=" salvador";
        e+=" salvador";
        System.out.println(m);
        System.out.println(e);
        int k=0;
        int l=0;
        int i=0;
        int m_longitud=0;
        int e_longitud=0;
        
	while(i<m.length()){
                
            if(m.charAt(i)==' ' && m.charAt(i+1)!=' ' && m.charAt(i+1)!='s'){
                k=i+1;
            }
            
            for(m_longitud=k; m_longitud<m.length(); m_longitud++){
                if(m.charAt(m_longitud)==' ')
                    break;
	    }
                
                
            if(e.charAt(i)==' ' && e.charAt(i+1)!=' ' && e.charAt(i+1)!='s'){
                l=i+1;
            }
            
            for(e_longitud=l; e_longitud<e.length(); e_longitud++){
                if(e.charAt(e_longitud)==' ')
                    break;
	    }
            
         
           
            if(m.charAt(i)==' ' && m.charAt(i+1)!='s'){
		if(m_longitud!=e_longitud){
		    mensaje+=m.substring(k, m_longitud);
		    mensaje+=" ";
		}
                
                
		else{
		    int cont=0;
		    for(int jol=0; jol<m_longitud-k+1; jol++){
			if(m.charAt(k+jol)!=e.charAt(l+jol))
			    cont++;
		    }
                
		    if(cont!=0){
			mensaje+=m.substring(k, m_longitud);
			mensaje+=" ";
		    }
                    
                
		}
            }
            
            i++;
        }
        mensaje=mensaje.replace(",","");
        mensaje=mensaje.replace(".","");
        return mensaje;

    }
    
    /**
     *Reconstruye el mensaje oculto a partir de las letras
     *especiales que se obtienen al comparar dos textos
     *
     *@param m Un texto arbitrario
     *@param e Un texto similar al primero, pero con algunas
     *         letras especiales
     *@return El mensaje oculto
     */
    public String descifraLetrasMarcadas(String m, String e){
	m=m.replaceAll("\\s","");
	e=e.replaceAll("\\s","");
	String mensaje="";
	for(int i=0; i<m.length(); i++){
	    if(m.charAt(i)!=e.charAt(i))
		mensaje+=m.charAt(i);
	}
	return mensaje;
    }
    
    //Método main
    public static void main(String [] args){
	Scanner sc=new Scanner(System.in);
       	Proyecto2 llamador=new Proyecto2();
	
	int opcion=0;
	do{
	    System.out.print("\nMensajes ocultos\n"+
			     "[1] Cifrado nulo con la n-esima letra (desde teclado, cont desde 0)\n"+
			     "[2] Cifrado nulo con la n-esima letra (espacios al final)\n"+
			     "[3] Nombre oculto\n"+
			     "[4] Marcando palabras\n"+
			     "[5] Marcando letras\n"+
			     "[6] Salir del programa\n"+
			     "Elige una opcion: ");
	    opcion=sc.nextInt();
	    sc.nextLine();

	    switch(opcion){
	    case 1:
		System.out.print("\nIngresa el mensaje original: ");
		String cadena1=sc.nextLine();
		System.out.print("Ingresa que posicion tiene la letra que forma el mensaje: ");
		int n=sc.nextInt();
		String mensaje1=llamador.descifraNulo(cadena1, n);
		System.out.println("\nEl mensaje oculto es el siguiente: ");
		System.out.println("\n"+mensaje1);
		break;

	    case 2:
		System.out.print("\nIngresa el mensaje original: ");
		String cadena2=sc.nextLine();
		String mensaje2=llamador.descifraNulo(cadena2);
		System.out.println("\nEl mensaje oculto es el siguiente: ");
		System.out.println("\n"+mensaje2);
		break;
		
	    case 3:
		System.out.print("\nIngresa el mensaje original: ");
		String cadena3=sc.nextLine();
		System.out.print("Ingresa el nombre que quieres buscar: ");
		String nombre=sc.nextLine();
		System.out.println("\nEl nombre se encuentra oculto en el mensaje? "+
				   llamador.contieneNombre(cadena3, nombre));
		break;

	    case 4:
		System.out.print("\nIngresa el primer mensaje: ");
		String cadena4=sc.nextLine();
		System.out.print("Ingresa el segundo mensaje: ");
		String cadena5=sc.nextLine();
		String mensaje3=llamador.descifraPalabrasMarcadas(cadena4, cadena5);
		System.out.println("El mensaje oculto es: ");
		System.out.println(mensaje3);
		break;

	    case 5:
		System.out.print("\nIngresa el primer mensaje: ");
		String cadena6=sc.nextLine();
		System.out.print("Ingresa el segundo mensaje: ");
		String cadena7=sc.nextLine();
		String mensaje4=llamador.descifraPalabrasMarcadas(cadena6, cadena7);
		System.out.println("El mensaje oculto es: ");
		System.out.println(mensaje4);
        
		break;

	    case 6:
		System.out.println("Sale master te me kuidas");
		System.out.println("Que no se te olvide tomar awita");
		break;

	    default:
		System.out.println("No se cuenta con esa opcion.");
	    }


	}while(opcion!=6);
	
    }
}

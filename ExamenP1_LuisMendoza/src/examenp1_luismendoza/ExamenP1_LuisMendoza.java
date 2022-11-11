/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package examenp1_luismendoza;
import java.util.Scanner;

public class ExamenP1_LuisMendoza {

public static void Conjunto(){
    Scanner entrada = new Scanner(System.in);
        
        int n = 0;
    
        String coma = ",";
        String espacio = " ";
        String nada = "";
        String c1 = "{";
        String c2 = "}";
        
        String acu1 = "";
        String acu2="";
        String acu3="";
        String acuInicio = "";
        
        String A;
        String B;
        
        do{
        System.out.println("Ingrese las cadenas de la siguiente forma: ");
        System.out.println("{a,b,c,d,e} sin espacios");
        System.out.println("Ingrese el primer conjunto:");
        A = entrada.next();
        A += entrada.nextLine();
        System.out.println("Ingrese el segundo conjunto:");
        B = entrada.next();
        B+= entrada.nextLine();
        
        if(A.charAt(0)!= '{' && B.charAt(B.length()-1) != '{'){
            System.out.println("Ingrese los conjuntos nuevamente");
        } else{
        A = A.replaceAll(coma, nada);
        A = A.replace(c1, nada);
        A = A.replace(c2, nada);
        
        
        B = B.replaceAll(coma, nada);
        B = B.replace(c1, nada);
        B = B.replace(c2, nada);
        
        n++;
        }
        } while(n!=1);
        
        acu1 = A+B;
     
        for (int i = 0; i < acu1.length();i++){
        char a = acu1.charAt(i);
        int indx = acu1.indexOf(a, i + 1);
        if (indx == -1) {
            acu2 += a + ",";
        }
    }

    String Union = "{" + acu2 + "}";

    for (int i = 0; i < A.length(); i++) {
        char a = A.charAt(i);
        for (int j = 0; j < B.length(); j++) {
            char b = B.charAt(j);
            if (a == b) {
                acu3 += b + ",";
            }
        }
    }

    String Interseccion = "{" + acu3 + "}";

    if(A.equalsIgnoreCase(B)){
        
        System.out.println("Son el mismo conjunto!");
    
    }else{
        
    System.out.println("La Unión es " + Union);
    System.out.println("La intersección es " + Interseccion); 
    
    }
}

public static String Cifrado(String cadena){
    
    int int3 = 0;
    char conv1;
    char conv2;
    String acu = "";
    
    
    cadena = cadena.toLowerCase();
    
    for (int i = 0; i < cadena.length();i++){
        char a = cadena.charAt(i);
        int int1 = a;
        int int2 = int1 - 96;

        int3 = 0;

        if (int2 >= 1 && int2 <= 13) {

            int3 = 27 - int2;
            int3 += 96;
            conv1 = (char) int3;

            acu += conv1;

        } else {
            int3 = 27 - int2;
            int3 += 96;
            conv2 = (char) int3;

            acu += conv2;

        }

    }
    
    
    
    return acu;
}

public static void Sobre(){
    Scanner entrada = new Scanner(System.in);
    
    System.out.println("Ingrese una figura con que formar el sobre: ");
    System.out.println("Ejemplo *");
    String figura = entrada.next();
    figura += entrada.nextLine();
    
    int m = 0;
    int n;

    do {
        System.out.println("Ingrese un numero par: ");
        n = entrada.nextInt();
        System.out.println("");
        if (n % 2 == 0) {
            n = n;
            break;
        } else {
            System.out.println("El numero que ingreso en impar!");
        }

    } while (true);

    int altura = (2 * n) - 1;
    for (int fila = 0; fila < altura; fila++) {
        for (int columna = 0; columna < altura; columna++) {
            if (fila == 0 || fila == altura - 1) {
                if (columna % 2 == 0) {
                    System.out.print(figura);
                } else {
                    System.out.print(" ");
                }
            } else {

                if (fila == columna && columna >= altura / 2 || ((fila + columna == altura - 1) && columna >= altura / 2) || columna == 0 || columna == altura - 1) {

                    System.out.print(figura);

                } else {
                    System.out.print(" ");
                }

            }
        }
        System.out.println("");
    }
    
    System.out.println("");
    
}
     
public static void Menu(){
    Scanner entrada = new Scanner(System.in);
    
    int n = 0;
    
    do{
        System.out.println("Bienvenido al Examen Parcial I");
        System.out.println("Elija una de las siguientes opciones: ");
        System.out.println("1. Conjuntos, 2. Cifrado por Sustitución, 3. Sobre, 4. Salir");
        int opcionUsuario = entrada.nextInt();
        
        switch(opcionUsuario){
            
            case 1:
                
                Conjunto();
                
                break;
                
            case 2: 
                
                System.out.println("Ingrese una cadena: ");
                
                String cadena = entrada.next();
                cadena += entrada.nextLine();
                
                String acu = Cifrado(cadena);
                
                System.out.println(acu);
                
                break;
                
            case 3: 
                
                Sobre();
                
                break;
            
            case 4: 
                System.out.println("Bye Bye!");
                n = 1;
                break;
                
                
            default:
                System.out.println("Opción no valida, intentelo nuevamente!");
                break;
        }
        
        
    } while(n!=1);
}
   
    public static void main(String[] args) {
        
        Menu();
       
        
    }
    
}

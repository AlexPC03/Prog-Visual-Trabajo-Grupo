/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pracgrupalgrupob;

import java.util.Scanner;

/**
 *
 * @author alex,dani,carlos
 */
public class PracGrupalGrupoB {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner entrada = new Scanner(System.in);
        int opcion;
        do 
        {
           System.out.println("Bienvenido a Ihnoldur");
           System.out.println("Menú:");
           System.out.println("1. Insertar pócima e ítem");
           System.out.println("2. Insertar pócima o ítem en posición determinada");
           System.out.println("3. Usar pócima");
           System.out.println("4. Tirar un ítem");
           System.out.println("5. Mostrar pócimas e ítems");
           System.out.println("6. Mostrar pócimas e ítems ordenados alfabéticamente");
           System.out.println("7. Buscar pócima e ítem");
           System.out.println("8. Subida de nivel");
           System.out.println("9. Guardar las pócimas e ítems a fichero de texto");
           System.out.println("10. Cargar última partida desde texto");
           System.out.println("11. Guardar pócimas e ítems a disco");           
           System.out.println("12. Cargar pócimas e ítems desde disco");
           System.out.println("13. Mostrar puntos de un tipo de pócima");           
           System.out.println("14. Terminar");
           System.out.println("");           
           opcion = entrada.nextInt();
           switch (opcion) 
           {
               case 1:
                System.out.println("----------------------------------------------------------");
                
                break;
               case 2:
                System.out.println("----------------------------------------------------------");
                
                break;
               case 3:
                System.out.println("----------------------------------------------------------");
                
                break;
               case 4:
                System.out.println("----------------------------------------------------------");
                
                break;
               case 5:
                System.out.println("----------------------------------------------------------");
                
                break;
               case 6:
                System.out.println("----------------------------------------------------------");
                
                break;
               case 7:
                System.out.println("----------------------------------------------------------");
                
                break;
               case 8:
                System.out.println("----------------------------------------------------------");
                
                break;
               case 9:
                System.out.println("----------------------------------------------------------");
                
                break;
               case 10:
                System.out.println("----------------------------------------------------------");
                
                break;
               case 11:
                System.out.println("----------------------------------------------------------");
                
                break;
               case 12:
                System.out.println("----------------------------------------------------------");
                
                break;
               case 13:                
                System.out.println("----------------------------------------------------------");
                
                break;
               case 14:                
                System.out.println("¡Hasta pronto!");                
                break;
               default:
                System.out.println("Opción no válida");
            }
        }while (opcion != 14);
    }
}

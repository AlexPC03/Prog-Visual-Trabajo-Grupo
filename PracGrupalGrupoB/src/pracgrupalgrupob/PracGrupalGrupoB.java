/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pracgrupalgrupob;

import java.util.Scanner;
import java.io.*;
/**
 *
 * @author alex,dani,carlos
 */

class Potion implements Serializable
{
    int id;
    String name,description;
    int type;//1-Life,2-Magic,3-Poison
    int points;
}
class Item implements Serializable
{
    int id;
    String name,description;
    int type;//1-Weapon,2-Armour,3-Miscellany
    int experience;
}
public class PracGrupalGrupoB {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        final String nombreArchivoTextoPocimas="pjpotions.txt";
        final String nombreArchivoTextoItems="pjitems.txt";
        final String nombreArchivoBinPocimas="potions.dat";
        final String nombreArchivoBinItems="items.dat";
        
        Scanner entrada = new Scanner(System.in);
        
        final int MAXPOTIONS= 10;
        final int MAXITEMS= 10;
        final int EXPERIENCE= 10;

        int topePotions=0;
        int topeItems=0;
        
        Potion[] potionList= new Potion[MAXPOTIONS];
        for(int i=0;i<potionList.length;i++)
        {
            potionList[i]=new Potion();
        }
        
        Item[] itemList = new Item[MAXITEMS];
        for(int i=0;i<itemList.length;i++)
        {
            itemList[i]=new Item();
        }

        int raza;//1-humano,2-orco,3-elfo,4-enano
        int opcion;
        int eleccion;

        do 
        {
           System.out.println("Bienvenido a Ihnildur");
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

           opcion = obtenerNumero(entrada,"",1,14);
           switch (opcion) 
           {
               case 1:
                //Alejandro
                System.out.println("----------------------------------------------------------");
                eleccion = obtenerNumero(entrada,"¿Qué quieres introducir? 1-Pócimas 2-Items",1,2);
                if (eleccion == 1)
                {
                    topePotions = crearPocima(entrada, potionList, topePotions);
                }
                else if (eleccion == 2)
                {
                    topeItems = crearItem(entrada, itemList, topeItems);
                }
                break;
               case 2:
                //Alejandro
                System.out.println("----------------------------------------------------------");
                raza=obtenerNumero(entrada, "¿Cual es tu raza de personaje 1-Humano,2-Orco,3-Elfo,4-Enano?",1,4);
                if(raza==3 || raza==4 )
                {
                    eleccion = obtenerNumero(entrada,"¿Qué quieres introducir? 1-Pócimas 2-Items",1,2);
                    if (eleccion == 1)
                    {
                        insertarPocima(entrada, potionList, topePotions);
                    }
                    else if (eleccion == 2)
                    {
                        insertarItem(entrada, itemList, topeItems);
                    }
                }
                else
                {
                    System.out.println("No tienes esta ventaja");
                }
                break;
               case 3:
                //Alejandro
                System.out.println("----------------------------------------------------------");
                topePotions = usarPocima(entrada, potionList, topePotions);
                break;
               case 4:
                //Alejandro
                System.out.println("----------------------------------------------------------");
                topeItems = tirarItem(entrada, itemList, topeItems);
                break;
               case 5:
                //Carlos
                System.out.println("----------------------------------------------------------");
                mostrarPocimaEItem(potionList, topePotions, itemList, topeItems);
                break;
               case 6:
                //Carlos
                System.out.println("----------------------------------------------------------");
                mostrarPocimaEItemAlfabeticamente(potionList, topePotions, itemList, topeItems);
                break;
               case 7:
                //Carlos
                System.out.println("----------------------------------------------------------");
                System.out.println("----------------------------------------------------------");
                eleccion = obtenerNumero(entrada,"¿Qué desea buscar? 1-Pócimas 2-Items",1,2);
                if (eleccion == 1)
                {
                    buscarPocima(entrada, potionList, topePotions);
                }
                else if (eleccion == 2)
                {
                    buscarItem(entrada, itemList, topeItems);
                }
                break;
               case 8:
                //Carlos
                System.out.println("----------------------------------------------------------");
                subidaNivel(EXPERIENCE,potionList, topePotions, itemList, topeItems);
                break;
               case 9:
                //Dani
                System.out.println("----------------------------------------------------------");
                guardarEnFicheroTexto(entrada,nombreArchivoTextoPocimas,potionList, topePotions, nombreArchivoTextoItems,itemList, topeItems);
                break;
               case 10:
                //Dani
                System.out.println("----------------------------------------------------------");
                mostrarDesdeFicheroTexto(nombreArchivoTextoPocimas,potionList, topePotions, nombreArchivoTextoItems,itemList, topeItems);
                break;
               case 11:
                //Dani
                System.out.println("----------------------------------------------------------");
                guardarEnFicheroBin(nombreArchivoBinPocimas,potionList, topePotions, nombreArchivoBinItems,itemList, topeItems);
                break;
               case 12:
                //Dani
                System.out.println("----------------------------------------------------------");
                topePotions= cargarDesdeFicheroBinPotions(nombreArchivoBinPocimas,potionList);
                topeItems= cargarDesdeFicheroBinItems(nombreArchivoBinItems, itemList);
                break;
               case 13:                
                //Alejandro
                System.out.println("----------------------------------------------------------");
                mostrarPuntosPocimas(entrada, potionList, topePotions);
                break;
               case 14:                
                System.out.println("¡Hasta pronto!");                
                break;
               default:
                System.out.println("Opción no válida");
            }
        }while (opcion != 14);
    }
    
    
    public static int crearPocima(Scanner entrada, Potion[] potionList, int topePotions)
    {       
        if(topePotions < potionList.length)
        {
            potionList[topePotions].id = obtenerIdPocion(entrada, "Introduzca el identificador de la pócima", potionList, topePotions);                    
            potionList[topePotions].name = obtenerLinea(entrada, "Introduzca el nombre de la pócima");                    
            potionList[topePotions].description = obtenerLinea(entrada, "Introduzca la descripción de la pócima");                                        
            potionList[topePotions].type = obtenerNumero(entrada, "Introduzca el tipo de pócima: 1-Vida, 2-Magia, 3-Veneno",1);
            potionList[topePotions].points = obtenerNumero(entrada, "Introduzca el número de puntos de la pócima",0);   
            topePotions++;
        }
        else
        {
            System.out.println("No queda espacio para más pociones");
        }
        return topePotions;
    }

    public static int crearItem(Scanner entrada, Item[] itemList, int topeItems)
    {       
        if(topeItems < itemList.length)
        {
            itemList[topeItems].id = obtenerIdItem(entrada, "Introduzca el identificador del item", itemList, topeItems);
            itemList[topeItems].name = obtenerLinea(entrada, "Introduzca el nombre del item");
            itemList[topeItems].description = obtenerLinea(entrada, "Introduzca la descripción del item");                    
            itemList[topeItems].type = obtenerNumero(entrada, "Introduzca el tipo de pócima: 1-Arma, 2-Armadura, 3-Miscelanea",1);    
            itemList[topeItems].experience=obtenerNumero(entrada, "Introduzca el número de puntos de experiencia del item",0);            
            topeItems++;
        }
        else
        {
            System.out.println("No queda espacio para más items");
        }
        return topeItems;
    }

    public static void insertarPocima(Scanner entrada, Potion[] potionList, int topePotions)
    {
        if (topePotions>0)
        {
            int pocionId = obtenerIdPocion(entrada, "Introduzca el identificador de la pócima", potionList, topePotions);
            String pocionName = obtenerLinea(entrada, "Introduzca el nombre de la pócima");                    
            String pocionDescription = obtenerLinea(entrada, "Introduzca la descripción de la pócima");                                        
            int pocionType = obtenerNumero(entrada, "Introduzca el tipo de pócima: 1-Vida, 2-Magia, 3-Veneno",1);
            int pocionPoints = obtenerNumero(entrada, "Introduzca el número de puntos de la pócima",0);

            int pos=obtenerNumero(entrada, "¿Que poción quieres sustituir?",0,topePotions);

            potionList[pos].id = pocionId;                    
            potionList[pos].name = pocionName;                    
            potionList[pos].description = pocionDescription;                                        
            potionList[pos].type = pocionType;
            potionList[pos].points = pocionPoints;                    
        }
        else
        {
            System.out.println("No hay pociones definidas");
        }
    }

    public static void insertarItem(Scanner entrada, Item[] itemList, int topeItems)
    {
        if (topeItems>0)
        {
            int itemId = obtenerIdItem(entrada, "Introduzca el identificador del item", itemList, topeItems);                    
            String pocionName = obtenerLinea(entrada, "Introduzca el nombre del item");                    
            String itemDescription = obtenerLinea(entrada, "Introduzca la descripción del item");                                        
            int itemType = obtenerNumero(entrada, "Introduzca el tipo de item: 1-Arma, 2-Armadura, 3-Miscelanea",1);
            int itemPoints = obtenerNumero(entrada, "Introduzca el número de puntos de experiencia del item",0);

            int pos=obtenerNumero(entrada, "¿Que item quieres sustituir?",0,topeItems);

            itemList[pos].id = itemId;
            itemList[pos].name = pocionName;
            itemList[pos].description = itemDescription;                    
            itemList[pos].type = itemType;
            itemList[pos].experience=itemPoints;                    
        }
        else
        {
            System.out.println("No hay Items definidos");
        }
    }
    
    public static int obtenerNumero(Scanner entrada, String texto,int min, int max)
    {
        int num;       
        do
        {
            System.out.println(texto);
            num = entrada.nextInt();
            if(num>max || num<min)
            {
                System.out.println("Valor no válido");
            }
        }while(num>max || num<min);
        return num;
    } 
    public static int obtenerNumero(Scanner entrada, String texto,int min)
    {
        int num;       
        do
        {
            System.out.println(texto);
            num = entrada.nextInt();
            if(num<min)
            {
                System.out.println("Valor no válido");
            }
        }while(num<min);
        return num;
    }
    public static int obtenerIdPocion(Scanner entrada, String texto, Potion[] potionList, int topePotions)
    {
        int num;       
        do
        {
            System.out.println(texto);
            num = entrada.nextInt();
            if(num<1)
            {
                System.out.println("Valor no válido");
            }
            //Verificamos que no se repita
            for (int f=0;f<topePotions;f++)
            {
                if (potionList[f].id == num)
                {
                    System.out.println("Indice Repetido");
                    num=0;
                }
            }
        }while(num<1);        
        return num;
    }
    public static int obtenerIdItem(Scanner entrada, String texto, Item[] itemList, int topeItems)
    {
        int num;       
        do
        {
            System.out.println(texto);
            num = entrada.nextInt();
            if(num<1)
            {
                System.out.println("Valor no válido");
            }
            //Verificamos que no se repita
            for (int f=0;f<topeItems;f++)
            {
                if (itemList[f].id == num)
                {
                    System.out.println("Indice Repetido");
                    num=0;
                }
            }
        }while(num<1);        
        return num;
    }
    public static String obtenerLinea(Scanner entrada, String texto)
    {
        String linea;
        do
        {
            System.out.println(texto);    
            linea=entrada.nextLine();
            if(linea.trim().length() == 0)
            {
                System.out.println("Nombre no válido");
            }
        }while(linea.trim().length() == 0);
        return linea;
    }

     public static int usarPocima(Scanner entrada, Potion[] potionList, int topePotions)
    {        
        if(topePotions!=0)
        {
            for(int i=0;i<topePotions;i++)
            {
                if(i==topePotions-1)
                {
                    potionList[i]=new Potion();
                }
                else
                {
                potionList[i] = potionList[i+1];                                        
                }
            }
            return topePotions-1;
        }
        else
        {
            System.out.println("No hay pociones");    
            return topePotions;
        }        
    }
    public static int tirarItem(Scanner entrada, Item[] itemList, int topeItems)
    {
        int pos;
        int asegurar;
        if(topeItems!=0)
        {
            pos=obtenerNumero(entrada,"¿Qué item quieres tirar?",0,topeItems);
            asegurar=obtenerNumero(entrada,"¿Estas seguro de que quieres este item: 1-Si 2-No?",1,2);
            if(asegurar==1)
            {
                for(int i=0;i<topeItems;i++)
                {
                    if(i==topeItems-1)
                    {
                        itemList[i]=new Item();
                    }
                    else
                    {
                    itemList[i] = itemList[i+1];                    
                       
                    }
                }
                return topeItems-1;
            }
        }
        else
        {
            System.out.println("No hay items");    
            return topeItems;
        }        
        return topeItems;
    }
    public static void mostrarPocimaEItem(Potion[] potionList, int topePotions, Item[] itemList, int topeItems)
    {
        int i, maxP = 0, maxI = 0;
        int minP = potionList[0].points;
        int minI = itemList[0].experience;
        System.out.println("El numero de pócimas son: " + topePotions);
        for(i = 0; i < topePotions; i++){
            if(potionList[i].points > maxP){
                maxP = potionList[i].points;
            }
        }
        System.out.println("La pocima com mayor numero de puntos es: " + maxP);
        for(i = 0; i < topePotions; i++){        
            if(potionList[i].points < minP){
                minP = potionList[i].points;
            }
        }
        System.out.println("La pócima con menor numero de puntos es: " + minP);
        for(i = 0; i < topePotions; i++){
            System.out.println("----------------------");
            System.out.println("ID: " + potionList[i].id);
            System.out.println("Nombre: " + potionList[i].name);
            System.out.println("Descripción " + potionList[i].description);
            System.out.println("Tipo: " + potionList[i].type);
            System.out.println("Puntos: " + potionList[i].points);
            System.out.println("----------------------");
        }
        System.out.println("El numero de items son: " + topeItems);
        for(i = 0; i < topeItems; i++){
            if(itemList[i].experience > maxI){
                maxI = itemList[i].experience;
            }
        }
        System.out.println("El item com mayor experiencia es: " + maxI);
        for(i = 0; i < topeItems; i++){        
            if(itemList[i].experience < minI){
                minI = itemList[i].experience;
            }
        }
        System.out.println("La pócima con menor experiencia es: " + minI);
        for(i = 0; i < topeItems; i++){
            System.out.println("----------------------");
            System.out.println("ID: " + itemList[i].id);
            System.out.println("Nombre: " + itemList[i].name);
            System.out.println("Descripción " + itemList[i].description);
            System.out.println("Tipo: " + itemList[i].type);
            System.out.println("Experiencia: " + itemList[i].experience);
            System.out.println("----------------------");
        }
    }
    public static void mostrarPocimaEItemAlfabeticamente(Potion[] potionList, int topePotions, Item[] itemList, int topeItems)
    {
        //Clonamos el array de Potion para no alterar el array original
       Potion[] potionListClon = new Potion[topePotions]; 
       for (int f = 0;f<potionListClon.length;f++)
       {
           potionListClon[f] = potionList[f];
       }

        //Clonamos el array de Item para no alterar el array original
       Item[] itemListClon = new Item[topeItems]; 
       for (int f = 0;f<itemListClon.length;f++)
       {
           itemListClon[f] = itemList[f];
       }

       //Ordenamos el array clon de Potion con el método de la burbuja
       for (int i = 1; i < potionListClon.length; i++) 
       {
            for (int j = 0; j < potionListClon.length - i; j++) 
            {
                if (Comparador(potionListClon[j], potionListClon[j+1]))
                {
                    Potion aux = potionListClon[j];
                    potionListClon[j] = potionListClon[j+1];
                    potionListClon[j+1] = aux;
                }
            }
        }

       //Ordenamos el array clon de Item con el método de la burbuja
       for (int i = 1; i < itemListClon.length; i++) 
       {
            for (int j = 0; j < itemListClon.length - i; j++) 
            {
                if (Comparador(itemListClon[j], itemListClon[j+1]))
                {
                    Item aux = itemListClon[j];
                    itemListClon[j] = itemListClon[j+1];
                    itemListClon[j+1] = aux;
                }
            }
        }

       //Reutilizamos la función de mostrar pocimas e items pasandole los arrays clon ya ordenados
       mostrarPocimaEItem(potionListClon, potionListClon.length, itemListClon, itemListClon.length);
    }
    
    public static boolean Comparador(Potion potion1, Potion potion2)
    {
        return potion1.name.compareTo(potion2.name)>0;
    } 

    public static boolean Comparador(Item item1, Item item2)
    {
        return item1.name.compareTo(item2.name)>0;
    } 

    public static void buscarPocima(Scanner entrada, Potion[] potionList, int topePotions)    
    {
        int pocima;
        System.out.println("Por favor, Introduzca una posición existente para la lista seleccionada: ");
        pocima = entrada.nextInt();
        if(pocima < topePotions){
            System.out.println("----------------------");
            System.out.println("ID: " + potionList[pocima].id);
            System.out.println("Nombre: " + potionList[pocima].name);
            System.out.println("Descripción " + potionList[pocima].description);
            System.out.println("Tipo: " + potionList[pocima].type);
            System.out.println("Puntos: " + potionList[pocima].points);
            System.out.println("----------------------");
        }else{
            System.out.println("La posicion seleccionada no existe ");
        }
    }
    public static void buscarItem(Scanner entrada, Item[] itemList, int topeItems)    
    {
        int objeto;
        System.out.println("Por favor, Introduzca una posición existente para la lista seleccionada: ");
        objeto = entrada.nextInt();
        if(objeto < topeItems){
            System.out.println("----------------------");
            System.out.println("ID: " + itemList[objeto].id);
            System.out.println("Nombre: " + itemList[objeto].name);
            System.out.println("Descripción " + itemList[objeto].description);
            System.out.println("Tipo: " + itemList[objeto].type);
            System.out.println("Experiencia: " + itemList[objeto].experience);
            System.out.println("----------------------");
        }else{
            System.out.println("La posicion seleccionada no existe ");
        }
    }
    public static void subidaNivel(int incremento, Potion[] potionList, int topePotions, Item[] itemList, int topeItems)
    {
        for(int i = 0; i < topePotions; i++){
            potionList[i].points = potionList[i].points + 10;
        }
        System.out.println("Todas las pociones han ganado 10 puntos");
        for(int i = 0; i < topeItems; i++){
            itemList[i].experience = itemList[i].experience + 10;
        }
        System.out.println("Todos los Items han ganado 10 de Experiencia");
    }
    //da
    public static void guardarEnFicheroTexto(Scanner entrada,String nombreArchivoTextoPocimas,Potion[] potionList, int topePotions, String nombreArchivoTextoItems, Item[] itemList, int topeItems)
    {
        int opcion=obtenerNumero(entrada,"¿Que quieres guardar? 1-Pócimas 2-Items 3-Ambos",1,3);

        try
        {
            if (opcion == 1 || opcion == 3)
            {
                //Pocimas
                BufferedWriter writeP= new BufferedWriter(new FileWriter(nombreArchivoTextoPocimas));
                for (int i=0; i< topePotions; i++)
                {
                    Potion potion = potionList[i];
                    String s = "ID: "+potion.id + "\tNombre: " + potion.name + "\tDescripción: " + potion.description + "\tTipo:" + potion.type + "\tPuntos: " + potion.points;
                    writeP.write(s);
                    writeP.newLine();
                }
                writeP.close();
            }
            if (opcion == 2 || opcion == 3)
            {
                //Items
                BufferedWriter writeI= new BufferedWriter(new FileWriter(nombreArchivoTextoItems));
                for (int i=0; i< topePotions; i++)
                {
                Item item = itemList[i];
                String s = "ID: "+item.id + "\tNombre: " + item.name + "\tDescripción: " + item.description + "\tTipo:" + item.type + "\tExperiencia: " + item.experience;
                writeI.write(s);
                writeI.newLine();
                }
                writeI.close();
            }
            System.out.println("Fichero creado");
        }
        catch(IOException ex)
        {
            System.out.println(ex.getMessage());
        }
    }
    public static void mostrarDesdeFicheroTexto(String nombreArchivoTextoPocimas,Potion[] potionList,int topePotions, String nombreArchivoTextoItems, Item[] itemList, int topeItems)
    {
        try
        {
            String potion;
            BufferedReader readP= new BufferedReader(new FileReader(nombreArchivoTextoPocimas));
            do
            {
                potion=readP.readLine();
                System.out.println(potion);
            }while(potion!=null);
            readP.close();
            String item;
            BufferedReader readI= new BufferedReader(new FileReader(nombreArchivoTextoItems));
            do
            {
                item=readI.readLine();
                System.out.println(item);
            }while(item!=null);
            readI.close();
        }
        catch(IOException ex)
        {
            System.out.println(ex.getMessage());
        }
    }
    public static void guardarEnFicheroBin(String nombreArchivoBinPocimas,Potion[] potionList, int topePotions, String nombreArchivoBinItems, Item[] itemList, int topeItems)
    {
        try
        {
            ObjectOutputStream outP = new ObjectOutputStream(new FileOutputStream(nombreArchivoBinPocimas));
            ObjectOutputStream outI = new ObjectOutputStream(new FileOutputStream(nombreArchivoBinItems));
            for(int i=0;i<topePotions;i++)
            {
                outP.writeObject(potionList[i]);
            }
            for(int i=0;i<topeItems;i++)
            {
                outI.writeObject(itemList[i]);
            }
            outP.close();
            outI.close();
        } 
        catch(IOException e)
        {
            System.out.println(e.getMessage());
        }
        System.out.println("Fichero creado");
    }
    //da
    public static int cargarDesdeFicheroBinPotions(String nombreArchivoBinPocimas,Potion[] potionList)
    {
        int leidos=0;
        try
        {
            ObjectInputStream inP = new ObjectInputStream(new FileInputStream(nombreArchivoBinPocimas));            
            Potion potion;   
            
            do
            {
                potion=(Potion) inP.readObject();
                potionList[leidos]=potion;
                leidos++;                
            }while(leidos<potionList.length);             
        } 
        catch(EOFException eof)
        {
            //Final de fichero
        }
        catch(IOException e)
        {
            System.out.println(e.getMessage());
        } 
        catch(ClassNotFoundException ex) 
        {
            System.out.println(ex.getMessage());
        }
        System.out.println("Fichero cargado");
        return leidos;   
    }
    public static int cargarDesdeFicheroBinItems(String nombreArchivoBinItems, Item[] itemList)
    {
        int leidos=0;
        try
        {
            ObjectInputStream inI = new ObjectInputStream(new FileInputStream(nombreArchivoBinItems));            
            Item item;                   
            do
            {
                item=(Item) inI.readObject();
                itemList[leidos]=item;
                leidos++; 
            }while(leidos<itemList.length);       
        } 
        catch(EOFException eof)
        {
            //Final de fichero
        }
        catch(IOException e)
        {
            System.out.println(e.getMessage());
        } 
        catch(ClassNotFoundException ex) 
        {
            System.out.println(ex.getMessage());
        }
        System.out.println("Fichero cargado");
        return leidos;  
    }
    public static void mostrarPuntosPocimas(Scanner entrada, Potion[] potionList, int topePotions)
    {
        int pos=obtenerNumero(entrada,"¿De que poción quieres saber los puntos?", 0, topePotions);
        System.out.println("La posión de la posición "+pos+" tiene " +potionList[pos].points+" puntos");
    }
}

package Logica;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese la expresión generalizada para almacenarla:");
        String expresion = scanner.nextLine();
        scanner.close();

        List<Object> listaGeneralizada = new ArrayList<>();
 
        CrearLista crearLista = new CrearLista();
        crearLista.crearListaGeneralizada(expresion, listaGeneralizada);
 
        System.out.println(listaGeneralizada);
     }
 }
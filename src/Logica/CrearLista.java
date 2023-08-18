package Logica;

import java.util.ArrayList;
import java.util.List;

public class CrearLista {
     public void crearListaGeneralizada(String expresion, List<Object> listaGeneralizada) {
        int indice = 0;
        while (indice < expresion.length()) {

            char caracterActual = expresion.charAt(indice);

            if (caracterActual == '(') {

                int indiceCierre = encontrarCierreParentesis(expresion, indice);
                
                if (indiceCierre != -1) {
                    String subExpresion = expresion.substring(indice + 1, indiceCierre);
                    List<Object> subListaGeneralizada = new ArrayList<>();
                    crearListaGeneralizada(subExpresion, subListaGeneralizada);
                    listaGeneralizada.add(subListaGeneralizada);
                    indice = indiceCierre + 1;
                }

            } else if (caracterActual != ',' && caracterActual != ' ') {

                int indiceFinValor = encontrarFinValor(expresion, indice);
                String valor = expresion.substring(indice, indiceFinValor);
                listaGeneralizada.add(valor);
                indice = indiceFinValor;
            }
            indice++;
        }
    }

    public int encontrarCierreParentesis(String expresion, int indiceInicio) {
        int contador = 1;
        int indice = indiceInicio + 1;
        while (indice < expresion.length()) {
            if (expresion.charAt(indice) == '(') {
                contador++;
            } else if (expresion.charAt(indice) == ')') {
                contador--;
                if (contador == 0) {
                    return indice;
                }
            }
            indice++;
        }
        return -1; 
    }

    public int encontrarFinValor(String expresion, int indiceInicio) {
        int indice = indiceInicio;
        while (indice < expresion.length()) {
            char caracterActual = expresion.charAt(indice);
            if (caracterActual == ',' || caracterActual == ' ' || caracterActual == ')') {
                break;
            }
            indice++;
        }
        return indice;
    }
}

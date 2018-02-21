import Utils.Matriz;

import java.util.Arrays;
import java.util.LinkedList;

public class Horarios {

    public Matriz horarioMetodo(int[] arr) {
        Matriz m = new Matriz(arr.length, arr.length);
        for (int i = 0; i < m.getFilas(); i++) {
            m.set(i, 0, arr[i]);
        }
        return horariosRec(m);
    }

    public Matriz horariosRec(Matriz m) {
        int mitad = m.getFilas()/2;
        if(m.getFilas() == 2) {
            return HorarioSimplePar(m);
        } if(m.getFilas() == 3) {
            return HorarioSimpleImpar(m);
        } else {
            Matriz m1 = horariosRec(DividirMatriz(m, 0));
            Matriz m2 = horariosRec(DividirMatriz(m, mitad));
            return CombinarMatrices(m1, m2);
        }
    }

    private Matriz HorarioSimpleImpar(Matriz m) {
        // aux es 3x4
        Matriz aux = new Matriz(m.getFilas(), m.getFilas()+1);
        // Colocar la primera columna e inicializa la
        for (int i = 0; i < m.getFilas(); i++) {
            aux.set(i, 0, m.get(i, 0));
        }
        // Primera columna
        aux.set(0, 1, m.get(1, 0));
        aux.set(1, 1, m.get(0, 0));
        // Segunda columna
        aux.set(0, 2, m.get(2, 0));
        aux.set(2, 2, m.get(0, 0));
        // Tercera columna
        aux.set(1, 3, m.get(2, 0));
        aux.set(2, 3, m.get(1, 0));
        return aux;
    }

    private Matriz HorarioSimplePar(Matriz m) {
        // m es 2x2
        m.set(0,0, m.get(0,0));
        m.set(1, 0, m.get(1, 0));
        m.set(0, 1, m.get(1, 0));
        m.set(1, 1, m.get(0, 0));
        return m;
    }

    private Matriz DividirMatriz(Matriz m, int inicio) {
        int mitad = m.getColumnas()/2;
        Matriz m1 = new Matriz(m.getFilas()/2, mitad);
        for (int i = 0; i < mitad; i++) {
            for (int j = 0; j < mitad; j++) {
                m1.set(i, j, m.get(inicio + i, j));
            }
        }
        return m1;
    }

    public Matriz CombinarMatrices(Matriz m1, Matriz m2) {
        //Si ambos son impares
        if(m1.getFilas() % 2 != 0 && m2.getFilas() % 2 != 0) {
            // TODO
            // Para cada matriz
                // Colocar una encima de la otra
                // Crear lista circular con la primera columna de la otra matriz
                //Rellenar los 0s de la diagonal con esa lista
            // Añadir el resto de partidos sacándolos de ambas listas circulares

            return m1;
        } else {
            //Si son pares
            int nuevasColumnas = m1.getColumnas() + m2.getColumnas();
            int nuevasFilas = m1.getFilas() + m2.getFilas();

            // Creo una matriz del doble de tamaño
            Matriz m = new Matriz(nuevasFilas, nuevasColumnas);

            // Coloco las matrices originales una encima de otra
            for (int j = 0; j < nuevasColumnas/2; j++) {
                for (int i = 0; i < m1.getFilas(); i++) {
                    m.set(i, j, m1.get(i, j));
                }
                for (int i = 0; i < m2.getFilas(); i++) {
                    m.set(i + m1.getFilas(), j, m2.get(i, j));
                }
            }

            //Coloco las columnas a la inversa en el resto de columnas;
            for (int k = m1.getColumnas(); k < nuevasColumnas; k++) {
                for (int i = 0; i < m1.getFilas(); i++) {
                    m.set(i, k, m2.get(i, k - m1.getColumnas()));
                }
                for (int i = 0; i < m2.getFilas(); i++) {
                    m.set(i + m2.getFilas(), k, m1.get(i, k - m1.getColumnas()));
                }
            }

            return m;
        }
    }
}


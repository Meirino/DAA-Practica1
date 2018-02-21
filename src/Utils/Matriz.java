package Utils;

public class Matriz {
    private int filas, columnas;
    private int[][] datos;

    public Matriz(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
        this.datos = new int[filas][columnas];
        for (int i = 0; i < this.getFilas(); i++) {
            for (int j = 0; j < this.getColumnas(); j++) {
                this.set(i, j, 0);
            }
        }
    }

    public int getFilas() {
        return filas;
    }

    public void setFilas(int filas) {
        this.filas = filas;
    }

    public int getColumnas() {
        return columnas;
    }

    public void setColumnas(int columnas) {
        this.columnas = columnas;
    }

    public int[][] getDatos() {
        return datos;
    }

    public void setDatos(int[][] datos) {
        this.datos = datos;
    }

    public void set(int fila, int columna, int dato) {
        this.datos[fila][columna] = dato;
    }

    public int get(int fila, int columna) {
        return this.datos[fila][columna];
    }

    public void mostrarMatriz() {
        for (int i = 0; i < this.filas; i++) {
            for (int j = 0; j < this.columnas; j++) {
                System.out.print(this.datos[i][j] + " ");
            }
            System.out.println();
        }
    }
}

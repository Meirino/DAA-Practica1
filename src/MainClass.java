import Utils.Matriz;

public class MainClass {
    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 5 ,6};
        Horarios h = new Horarios();
        long t1 = System.currentTimeMillis();
        h.horarioMetodo(array).mostrarMatriz();
        long t2 = System.currentTimeMillis();
        System.out.println(t2 - t1);
    }
}

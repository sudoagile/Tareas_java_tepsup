import java.util.Scanner;

public class Ejercicio5 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese un número para sumar sus dígitos:");
        int numero = scanner.nextInt();

        int suma = 0;

        while (numero > 0) {
            suma += numero % 10; // Sumar el último dígito del número a la suma
            numero /= 10; // Eliminar el último dígito del número
        }

        System.out.println("La suma de los dígitos es: " + suma);

        scanner.close();
    }
}


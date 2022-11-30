
package tallerrepaso;

import java.util.Scanner;
import java.util.Locale;

public class TallerRepaso {
    public static void main(String[] args) {
        
        Scanner entrada = new Scanner(System.in);
        entrada.useLocale(Locale.US);
        
        String nombre;
        String ciudad;
        int cedula;
        int horasMatutinas;
        int horasNocturnas;
        String opcion;
        boolean bandera = true;
        double salarioFinal;
        double subTotal;
        double adicional = 10;
        double descuento = 18;
        double costoMatutina = 10;
        double costoNocturna = 15;
        double totalMatutina;
        double totalNocturna;
        int empleados = 0;
        String mensaje = "";
        
        mensaje = mensaje + "\nNómina de Trabajadores\n\n";
        while(bandera){
            System.out.println("Ingrese el nombre del empleado: ");
            nombre = entrada.nextLine();
            System.out.println("Ingrese la cedula del empleado: ");
            cedula = entrada.nextInt();
            System.out.println("Ingrese las horas matutinas trabajadas: ");
            horasMatutinas = entrada.nextInt();
            System.out.println("Ingrese las horas nocturnas trabajdas: ");
            horasNocturnas = entrada.nextInt();
            entrada.nextLine();
            System.out.println("Ingrese la ciudad de la empresa: ");
            ciudad = entrada.nextLine();
            totalMatutina = horasMatutinas * costoMatutina;
            totalNocturna = horasNocturnas * costoNocturna;
            subTotal = totalMatutina + totalNocturna;
            descuento = (subTotal * 18)/100;
            if(horasNocturnas >= 10){
                adicional = (costoNocturna * adicional)/100;
                costoNocturna = costoNocturna + adicional;
                totalNocturna = horasNocturnas * costoNocturna;
            }
            salarioFinal = totalMatutina + totalNocturna;
            salarioFinal = salarioFinal - descuento;
            mensaje = String.format("%sRol del trabajador de nombre %s y "
                    + "cedula %d\n\tHoras matutinas trabajadas: %d."
                    + "\n\tHoras Nocturnas trabajadas: %d.\n\tSubtotal $%.0f."
                    + "\n\tSeguro Social $%.1f.\n\tTotal a cancelar $%.1f\n\n", 
                    mensaje, nombre, cedula, horasMatutinas, horasNocturnas, 
                    subTotal, descuento, salarioFinal);
            empleados = empleados + 1;
            System.out.println("Si desea terminar el programa, presione (si). "
                    + "De lo contrario (no).");
            opcion = entrada.nextLine();
            if(opcion.equals("si")){
                bandera = false;
            }
        }
        System.out.println(mensaje + "Numero de empleados: " + empleados);
        
    }
    
}

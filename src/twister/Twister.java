package twister;

import javax.swing.JOptionPane;
import java.util.Random;
import java.util.Scanner;

public class Twister {

    public static void main(String[] args) {
        Random rand = new Random();
        Scanner input = new Scanner(System.in);
        
        System.out.println("-------------------------------");
        System.out.println("           TWISTER");
        System.out.println("-------------------------------");
            

        // Bucle infinito
        while (true) {
            String[] shelter = {"Tu sotano", "el Subterraneo", "las Montañas", "el Bosque"};
            String[] inventory = new String[5];
            int supply_choice;
            int inventoryCount = 0;
            int twister_fury = rand.nextInt(9);

            JOptionPane.showMessageDialog(null, "ADVERTENCIA, SE HA EMITIDO UNA ADVERTENCIA DE TORNADO.");
            JOptionPane.showMessageDialog(null, "Al ver la noticia, al principio crees que estarás a salvo con esconderte en tu sótano.");
            JOptionPane.showMessageDialog(null, "...");
            JOptionPane.showMessageDialog(null, "Decides ver por la ventana.");
            JOptionPane.showMessageDialog(null, "...");
            JOptionPane.showMessageDialog(null, "Nunca habías visto una célula de tormenta de tal magnitud. Las nubes y los relámpagos estallan sobre el cielo.");
            JOptionPane.showMessageDialog(null, "En el centro de la tormenta ves como un remolino se está formando en las nubes.");
            JOptionPane.showMessageDialog(null, "..Tienes un mal presentimiento sobre esta tormenta.");

            // Suministros
            String[] supplies = {"Comida enlatada", "Filtro de agua", "Cobija", "Encendedor", "Manta termica", "Linterna", "Botiquín basico", "Herramientas", "Kit de primeros auxilios"};
            String[][] important_supply = {
                {"Filtro de agua", "Linterna", "Manta termica"}, // Subterraneo
                {"Manta termica", "Encendedor", "Herramientas"}, // En las Montañas
                {"Cobija", "Radio", "Botiquin basico"} // En el Bosque
            };

            // Elegir refugios
            String mensaje = "Tienes varios lugares en mente para refugiarte:\n";
            JOptionPane.showMessageDialog(null, mensaje);
            String shelter_choiceSTR = JOptionPane.showInputDialog("Elige el refugio al que deseas ir. \n 1. Tu Sotano. \n 2. El Subterraneo \n 3. Las Montañas \n 4. El Bosque");
            int shelter_choice = Integer.parseInt(shelter_choiceSTR);
            

            if (shelter_choice < 1 || shelter_choice > 3) {
                System.out.println("Debes elegir uno de esos 3 refugios.");
                continue; // Vuelve al inicio del bucle
            } else if (shelter_choice == 1) {
                JOptionPane.showMessageDialog(null, "Decides apostar por tu sotano. Resulta ser una decisión fatal.");
                JOptionPane.showMessageDialog(null, "Tu casa es completamente arrancada de sus cimientos y el viento te arrastra de tu sotano.");
                JOptionPane.showMessageDialog(null, "Game over, el tornado te llevó consigo.");
                continue; // Vuelve al inicio del bucle
            }

            JOptionPane.showMessageDialog(null,"Decides no apostar por tu sótano e ir hacia un refugio, decides por " + shelter[shelter_choice - 1] + ".");
            JOptionPane.showMessageDialog(null,"Para aumentar tus chances de supervivencia decides salir a buscar suministros. \nUsa la consola para seleccionar suministros");

            // Mostrar lista de suministros
            System.out.println("Encuentras varios suministros en los alrededores, solo puedes cargar 5 en tu mochila:");
            System.out.println("-------------------------------");
            for (int i = 0; i < supplies.length; i++) {
                System.out.println((i + 1) + ". " + supplies[i]);
            }

            // Recolectar suministros.
            System.out.println("-------------------------------");
            while (inventoryCount < 5) {
                System.out.print("Selecciona un numero (o 0 para terminar): ");
                supply_choice = input.nextInt();

                if (supply_choice == 0) {
                    break;
                } else if (supply_choice > 0 && supply_choice <= supplies.length) {
                    String selection = supplies[supply_choice - 1];

                    // Verificar si el suministro ya esta en el inventario
                    boolean picked_up = false;
                    for (int i = 0; i < inventoryCount; i++) {
                        if (inventory[i] != null && inventory[i].equals(selection)) {
                            picked_up = true;
                            break;
                        }
                    }

                    if (!picked_up) {
                        inventory[inventoryCount] = selection;
                        inventoryCount++;
                        System.out.println(selection + " agregado a tu inventario.");
                        System.out.println(" ");
                    } else {
                        System.out.println("Ya tienes " + selection + " en tu inventario.");
                        System.out.println(" ");
                    }
                } else {
                    System.out.println("Opcion invalida. Intenta nuevamente.");
                }
            }

            JOptionPane.showMessageDialog(null, "Tu mochila ya no puede cargar mas objetos, decides retirarte.");
            for (int i = 0; i < inventoryCount; i++) {
                System.out.println(inventory[i]);
            }

            // Fortalecer el refugio
            boolean isSafe = false;
            String suministro_clave = important_supply[shelter_choice - 1][twister_fury % important_supply[shelter_choice - 1].length];

            // Verificar si el suministro clave esta en el inventario
            for (int i = 0; i < inventoryCount; i++) {
                if (inventory[i] != null && inventory[i].equals(suministro_clave)) {
                    isSafe = true;
                    break;
                }
            }
            JOptionPane.showMessageDialog(null, "El tornado se acerca, decides correr hacia tu refugio.");
            JOptionPane.showMessageDialog(null, "Un tornado impresionante se acerca a tu refugio.");
            JOptionPane.showMessageDialog(null, "Tu refugio está temblando. El viento está chillando por las paredes.");
            JOptionPane.showMessageDialog(null, "...");

            // Evaluación final
            if (isSafe) {
                JOptionPane.showMessageDialog(null, "Está dejando de temblar.");
                JOptionPane.showMessageDialog(null, "Dejó de temblar. Tu refugio logró aguantar y lograste sobrevivir.");
                JOptionPane.showMessageDialog(null, "Bien hecho, has ganado.");
            } else {
                switch (shelter_choice) {
                case 2:
                    JOptionPane.showMessageDialog(null,"El temblor sobre tu techo está comenzando colapsar");
                    JOptionPane.showMessageDialog(null,"...");
                    JOptionPane.showMessageDialog(null,"El techo del subterraneo colapsa completamente sobre ti. Eres aplastado por los escombros");
                    JOptionPane.showMessageDialog(null,"Game over, camarada, fuiste aplastado por tu refugio.");
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null,"Tus paredes empiezan a romperse");
                    JOptionPane.showMessageDialog(null,"...");
                    JOptionPane.showMessageDialog(null,"Tus paredes son azotadas completamente y vuelan de sus cimientos.");
                    JOptionPane.showMessageDialog(null,"Eres arrastrado completamente por los escompros y el viento."
                            + " Eres lanzado al vacio al costado de la montaña.");
                    JOptionPane.showMessageDialog(null,"Game over, Camarada.");
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null,"Tu carpa empieza a romperse");
                    JOptionPane.showMessageDialog(null,"...");
                    JOptionPane.showMessageDialog(null,"Tu carpa es completamente lanzada al aire por los fuertes vientos.");
                    JOptionPane.showMessageDialog(null,"Escombros junto con trocos de arboles atraviesan y despedazan tu carpa");
                    JOptionPane.showMessageDialog(null,"Eres arrastrado junto con los escombros.");
                    JOptionPane.showMessageDialog(null,"Game over, Camarada.");
                    break;
                default:
                    break;
                }
            }

            // Preguntar si el jugador quiere jugar de nuevo
            int playAgain = JOptionPane.showConfirmDialog(null,"¿Deseas intentar de nuevo?");
            if (playAgain == JOptionPane.NO_OPTION) {
                JOptionPane.showMessageDialog(null, "Muchas Gracias por jugar.");
                return; // Termina el codigo sin detonarlo completamente.
            }
        }
    }
}
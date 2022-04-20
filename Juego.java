import java.util.Scanner;

public class Juego {
    char tablero[][] = new char[3][3];
    char turno;
    int jugadas;
    boolean finalizar;

    public Juego() {
        turno = 'O';
        jugadas = 0;
        finalizar = false;

        inicializarTablero();
        mostrarTablero();
        
        while(finalizar == false) {
            cambiarTurno();
            pedirMovimiento();
            mostrarTablero();

            if(determinarGanador() == true) {
                finalizar = true;
            }

            jugadas++;
        }

        System.out.println("GANADOR JUGADOR: " + turno + "\n");
    }

    private void mostrarTablero() {
        System.out.println("\n-------------");
        System.out.println("| " + tablero[0][0] + " | " + tablero[0][1] + " | " + tablero[0][2] + " |");
        System.out.println("------------");
        System.out.println("| " + tablero[1][0] + " | " + tablero[1][1] + " | " + tablero[1][2] + " |");
        System.out.println("------------");
        System.out.println("| " + tablero[2][0] + " | " + tablero[2][1] + " | " + tablero[2][2] + " |");
        System.out.println("-------------\n");
    }

    private void inicializarTablero() {
        tablero[0][0] = ' ';
        tablero[0][1] = ' ';
        tablero[0][2] = ' ';
        tablero[1][0] = ' ';
        tablero[1][1] = ' ';
        tablero[1][2] = ' ';
        tablero[2][0] = ' ';
        tablero[2][1] = ' ';
        tablero[2][2] = ' ';
    }

    private void cambiarTurno() {
        if(turno == 'X') {
            turno = 'O';
        }
        else {
            turno = 'X';
        }
    }

    private void pedirMovimiento() {
        boolean movimientoValido = false;

        do {
            if(jugadas <= 6) {
                System.out.print("Seleccionar casilla: ");
                Scanner entrada = new Scanner(System.in);
                int posicion = entrada.nextInt();
    
                if(posicion < 10 && posicion > 0) {
                    if(posicion == 1 && tablero[2][0] == ' ') {
                        tablero[2][0] = turno;
                        break;
                    }
                    if(posicion == 2 && tablero[2][1] == ' ') {
                        tablero[2][1] = turno;
                        break;
                    }
                    if(posicion == 3 && tablero[2][2] == ' ') {
                        tablero[2][2] = turno;
                        break;
                    }
                    if(posicion == 4 && tablero[1][0] == ' ') {
                        tablero[1][0] = turno;
                        break;
                    }
                    if(posicion == 5 && tablero[1][1] == ' ') {
                        tablero[1][1] = turno;
                        break;
                    }
                    if(posicion == 6 && tablero[2][0] == ' ') {
                        tablero[1][2] = turno;
                        break;
                    }
                    if(posicion == 7 && tablero[0][0] == ' ') {
                        tablero[0][0] = turno;
                        break;
                    }
                    if(posicion == 8 && tablero[0][1] == ' ') {
                        tablero[0][1] = turno;
                        break;
                    }
                    if(posicion == 9 && tablero[0][2] == ' ') {
                        tablero[0][2] = turno;
                        break;
                    }
                }

                System.out.println("\nMovimiento invalido, intente nuevamente\n");
            }
            else {

            }
        } while(movimientoValido == false);
    }

    private boolean determinarGanador() {
        if(tablero[0][0] == turno && tablero[0][1] == turno && tablero[0][2] == turno) {
            return true;
        }
        if(tablero[1][0] == turno && tablero[1][1] == turno && tablero[1][2] == turno) {
            return true;
        }
        if(tablero[2][0] == turno && tablero[2][1] == turno && tablero[2][2] == turno) {
            return true;
        }
        if(tablero[0][0] == turno && tablero[1][0] == turno && tablero[2][0] == turno) {
            return true;
        }
        if(tablero[0][1] == turno && tablero[1][1] == turno && tablero[2][1] == turno) {
            return true;
        }
        if(tablero[0][2] == turno && tablero[1][2] == turno && tablero[2][2] == turno) {
            return true;
        }
        if(tablero[0][0] == turno && tablero[1][1] == turno && tablero[2][2] == turno) {
            return true;
        }
        if(tablero[2][0] == turno && tablero[1][1] == turno && tablero[0][2] == turno) {
            return true;
        }

        return false;
    }
}
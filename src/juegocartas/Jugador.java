package juegocartas;

import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Jugador {

    public int TOTAL_CARTAS = 10;
    private int MARGEN_SUPERIOR = 10;
    private int MARGEN_IZQUIERDA = 10;
    private int DISTANCIA = 50;
    private int MAYOR_PUNTAJE = 50;

    private Carta[] cartas = new Carta[TOTAL_CARTAS];
    private Random r;

    public Jugador() {
        r = new Random();
    }

    public void repartir() {
        for (int i = 0; i < TOTAL_CARTAS; i++) {
            cartas[i] = new Carta(r);
        }
    }

    public void mostrar(JPanel pnl) {
        pnl.removeAll();
        //for (int i = 0; i < cartas.length; i++) {

        int x = MARGEN_IZQUIERDA;
        for (Carta c : cartas) {
            //cartas[i].mostrar(pnl, 10, 5);
            c.mostrar(pnl, x, MARGEN_SUPERIOR);
            x += DISTANCIA;
        }
        pnl.repaint();
    }

    public String getGrupos() {
        String mensaje = "No se encontraron grupos";

        //verificar que haya cartas
        if (cartas[0] != null) {
            //iniciar los contadores
            int[] contadores = new int[NombreCarta.values().length];

            //recorrer las cartas para contarlas de acuerdo a su nombre
            for (Carta c : cartas) {
                contadores[c.ObtenerNombre().ordinal()]++;
            }

            //contar cuantos grupos se hallaron
            int totalGrupos = 0;
            for (int i = 0; i < contadores.length; i++) {
                if (contadores[i] > 1) {
                    totalGrupos++;
                }
            }

            if (totalGrupos > 0) {
                mensaje = "Los grupos encontrador fueron:\n";
                for (int i = 0; i < contadores.length; i++) {
                    if (contadores[i] > 1) {
                        mensaje += Grupo.values()[contadores[i]] + " de " + NombreCarta.values()[i] + "\n";
                    }
                }
            }
        } else {
            mensaje = "No se han repartido cartas";
        }
        return mensaje;
    }

    public String getPuntaje() {
        String mensaje = "No se encontraron grupos";

        //verificar que haya cartas
        if (cartas[0] != null) {
            //iniciar los contadores
            int[] contadores = new int[NombreCarta.values().length];
            int puntos = 0;
            //recorrer las cartas para contarlas de acuerdo a su nombre
            for (Carta c : cartas) {
                contadores[c.ObtenerNombre().ordinal()]++;
                if (c.ObtenerNombre().name() == "AS") {
                    puntos = puntos + 1;
                } else if (c.ObtenerNombre().name() == "DOS") {
                    puntos = puntos + 2;
                } else if (c.ObtenerNombre().name() == "TRES") {
                    puntos = puntos + 3;
                } else if (c.ObtenerNombre().name() == "CUATRO") {
                    puntos = puntos + 4;
                } else if (c.ObtenerNombre().name() == "CINCO") {
                    puntos = puntos + 5;
                } else if (c.ObtenerNombre().name() == "SEIS") {
                    puntos = puntos + 6;
                } else if (c.ObtenerNombre().name() == "SIETE") {
                    puntos = puntos + 7;
                } else if (c.ObtenerNombre().name() == "OCHO") {
                    puntos = puntos + 8;
                } else if (c.ObtenerNombre().name() == "NUEVE") {
                    puntos = puntos + 9;
                } else if (c.ObtenerNombre().name() == "DIEZ") {
                    puntos = puntos + 10;
                } else if (c.ObtenerNombre().name() == "JACK") {
                    puntos = puntos + 10;
                } else if (c.ObtenerNombre().name() == "QUEEN") {
                    puntos = puntos + 10;
                } else if (c.ObtenerNombre().name() == "KING") {
                    puntos = puntos + 10;
                }
            }

            JOptionPane.showMessageDialog(null, "Total de puntos: " + puntos);
            //contar cuantos grupos se hallaron
            int totalGrupos = 0;
            for (int i = 0; i < contadores.length; i++) {
                if (contadores[i] > 1) {
                    totalGrupos++;
                }
            }

            int puntaje = 0;
            if (totalGrupos > 0) {

                for (int i = 0; i < contadores.length; i++) {

                    if (contadores[i] > 1) {
                        if (contadores[i] > 10) {
                            NombreCarta.values()[i + 1].retornarNumero();

                        } else {
                            //(mensaje += Grupo.values()[contadores[i]].ordinal() + " de " + NombreCarta.values()[i].retornarNumero() + "\n";
                            puntaje += Grupo.values()[contadores[i]].ordinal() * NombreCarta.values()[i].retornarNumero();
                        }

                    }
                }

                //mensaje += "El puntaje en grupo es: " + puntaje;
                int puntajet = 0;
                puntajet = puntos - puntaje;
                mensaje = "Puntos de cartas sobrantes: " + puntajet;
            } else {
                mensaje = "No se han repartido cartas";
            }

        }

        return mensaje;
    }

    public void organizar(JPanel pnl) {
        pnl.removeAll();
        //for (int i = 0; i < cartas.length; i++) {

        int x = MARGEN_IZQUIERDA;
        for (Carta c : cartas) {

          
    //----------------------------------------------------------------------------
            for (int i = 0; i < cartas.length-1 ; i++) {
            int minimo = i;

            for (int j = i+1; j < cartas.length; j++) {
                if (cartas[j].getIndice() < cartas[minimo].getIndice()) {
                    minimo = j;
                }

            }
            Carta ct = cartas[i];
            cartas[i] = cartas[minimo];
            cartas[minimo] = ct;
        }
     //-------------------------------------------------------------
            
                c.mostrar(pnl, x, MARGEN_SUPERIOR);
                x += DISTANCIA;
            }
            pnl.repaint();
        }

    }


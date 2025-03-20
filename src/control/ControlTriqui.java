package control;

import javax.swing.JButton;

public class ControlTriqui {

    private JButton[][] campos;
    private int contadorTurno;

    public ControlTriqui(JButton[][] campos) {
        this.campos = campos;
    }

    public void comprobarGanador() {
        for (int i = 0; i < 3; i++) {
            if (esLineaGanadora(campos[i][0], campos[i][1], campos[i][2]) || esLineaGanadora(campos[0][i], campos[1][i], campos[2][i])) {
                return;
            }
        }
        if (esLineaGanadora(campos[0][0], campos[1][1], campos[2][2]) || esLineaGanadora(campos[0][2], campos[1][1], campos[2][0])) {
            return;
        }
        if (contadorTurno == 9){
            System.out.println("Empate");
            nuevoJuego();
        }
    }   

    private boolean esLineaGanadora(JButton c1, JButton c2, JButton c3) {
        String texto1 = c1.getText();
        if (!texto1.isEmpty() && texto1.equals(c2.getText()) && texto1.equals(c3.getText())) {
            System.out.println("Gano " + texto1);
            nuevoJuego();
            return true;
        }
        return false;
    }

    public void ponerLetra(JButton campo) {
        if (!campo.getText().isEmpty()) {
            return;
        }
        campo.setText(contadorTurno % 2 == 0 ? "X" : "O");
        contadorTurno++;
        comprobarGanador();
    }

    public void nuevoJuego() {
        for (JButton[] listaCampos : campos) {
            for (JButton campo : listaCampos) {
                campo.setText("");
            }
        }
        contadorTurno = 0;
    }
}
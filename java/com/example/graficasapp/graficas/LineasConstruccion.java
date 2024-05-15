package com.example.graficasapp.graficas;

import java.util.List;

public class LineasConstruccion {

    int numeroGrafica;
    String identificadores;
    String estructurasGraficas;

    public LineasConstruccion(int numeroGrafica, String identificadores, String estructurasGraficas) {
        this.numeroGrafica = numeroGrafica;
        this.identificadores = identificadores;
        this.estructurasGraficas = estructurasGraficas;
    }

    public void agregarLineas(List<String> listaTokens) {
        numeroGrafica++;
        identificadores += "\t\t<h1>" + listaTokens.get(listaTokens.size() - 3) + "</h1>\n";
        identificadores += "\t\t<h3>X=" + listaTokens.get(listaTokens.size() - 2) + "</h3>\n";
        identificadores += "\t\t<h3>Y=" + listaTokens.get(listaTokens.size() - 1) + "</h3>\n";
        identificadores += "\t\t<canvas id=\"graficaLineas" + numeroGrafica + "\"></canvas>\n";
        identificadores += "\t\t<br><br><br><br><br><br>\n";
        estructurasGraficas += "\t\t\tvar lineas = document.getElementById('graficaLineas" + numeroGrafica + "').getContext('2d');\n"
                + "\t\t\tvar chart = new Chart(lineas,{\n"
                + "\t\t\t\ttype: 'line',\n"
                + "\t\t\t\tdata: {\n"
                + "\t\t\t\t\tlabels: [";

        int contador = 1;
        while (contador < listaTokens.size()) {
            estructurasGraficas += listaTokens.get(contador);
            contador += 2;

            String palabra[] = listaTokens.get(contador).split("");
            if (!"\"".equals(palabra[0])) {
                estructurasGraficas += ", ";
            } else {
                estructurasGraficas += "],\n";
                break;
            }
        }
        estructurasGraficas += "\t\t\t\t\tdatasets: [\n";

        contador = 0;
        boolean primero = false, hayContenidoPrevio = false;

        while (contador < listaTokens.size()) {
            String palabra[] = listaTokens.get(contador).split("");

            if (!"\"chart\"".equals(listaTokens.get(contador))) {
                if ("\"".equals(palabra[0])) {

                    if (!hayContenidoPrevio) {
                        hayContenidoPrevio = true;
                    } else {
                        estructurasGraficas += "],\n";
                        estructurasGraficas += "\t\t\t\t\t\tborderColor: [\"#ff5733\"],\n";
                        estructurasGraficas += "\t\t\t\t\t\tborderWidth: 2,\n";
                        estructurasGraficas += "\t\t\t\t\t},\n";
                        primero = false;
                    }
                    estructurasGraficas += "\t\t\t\t\t{\n";
                    estructurasGraficas += "\t\t\t\t\t\tlabel: " + listaTokens.get(contador) + ",\n";
                } else {
                    contador++;
                    if (!primero) {
                        estructurasGraficas += "\t\t\t\t\t\tdata: [" + listaTokens.get(contador) + ", ";
                        primero = true;
                    } else {
                        String palabra1[] = listaTokens.get(contador + 1).split("");

                        if (!"\"chart\"".equals(listaTokens.get(contador + 1))) {
                            if (!"\"".equals(palabra1[0])) {
                                estructurasGraficas += listaTokens.get(contador) + ", ";
                            } else {
                                estructurasGraficas += listaTokens.get(contador);
                            }
                        } else {
                            estructurasGraficas += listaTokens.get(contador)+ "],\n";
                            estructurasGraficas += "\t\t\t\t\t\tborderColor: [\"#ff5733\"],\n";
                            estructurasGraficas += "\t\t\t\t\t\tborderWidth: 2,\n";
                            estructurasGraficas += "\t\t\t\t\t}]\n";
                        }
                    }
                }
            } else {
                break;
            }
            contador++;
        }
        estructurasGraficas += "\n\t\t\t\t}\n\t\t\t});\n";
        System.out.println(estructurasGraficas);
    }

    public int getNumeroGrafica() {
        return numeroGrafica;
    }

    public String getIdentificadores() {
        return identificadores;
    }

    public String getEstructurasGraficas() {
        return estructurasGraficas;
    }
}

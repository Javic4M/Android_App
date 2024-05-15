package com.example.graficasapp.graficas

import android.util.Log
import com.example.graficasapp.analizadores.LexicoKoltlin
import com.example.graficasapp.analizadores.sym
import java.io.IOException
import java.io.StringReader


@Suppress("DEPRECATED_IDENTITY_EQUALS")
class ConstruccionHTML(private val contenido: String) {

    private var identificadores = ""
    private var estructurasGraficas = ""
    private val codigo: MutableList<String> = ArrayList()
    private var informacionPrincipalTerminada = false
    private var barraActiva = false
    private var pastelActivo = false
    private var puntosActivos = false
    private var lineasActivas = false
    private var numeroGrafica = 0
    private var nombrePagina: String = ""

    fun analizarTokens(): String {
        val lexico = LexicoKoltlin(StringReader(contenido))
        var listaTokens: MutableList<String> = ArrayList()
        try {
            while (!lexico.yyatEOF()) {
                val symbol = lexico.next_token()
                if (!informacionPrincipalTerminada) {
                    if (sym.PALABRA === symbol.sym || sym.ENCABEZADO === symbol.sym || sym.NUMERO_COLOR === symbol.sym || sym.PIXEL === symbol.sym) {
                        listaTokens.add(symbol.value.toString())
                        if (sym.PIXEL === symbol.sym) {
                            nombrePagina = listaTokens[0]
                            construirHTMLBase(listaTokens) // Construimos el Html Base
                            listaTokens = ArrayList()
                            informacionPrincipalTerminada = true
                        }
                    }
                } else if (sym.DATA === symbol.sym) {
                    if (listaTokens.isNotEmpty()) {
                        agregar(listaTokens) // Agregar
                        listaTokens = ArrayList()
                        marcarTodosFalsos()
                    }
                } else if (sym.CATEGORIA === symbol.sym) {
                    marcarTodosFalsos()
                    barraActiva = true
                } else if (sym.LABEL === symbol.sym) {
                    marcarTodosFalsos()
                    pastelActivo = true
                } else if (sym.X === symbol.sym && !lineasActivas) {
                    marcarTodosFalsos()
                    puntosActivos = true
                } else if (sym.NOMBRE === symbol.sym) {
                    marcarTodosFalsos()
                    lineasActivas = true
                }
                if (barraActiva || pastelActivo || puntosActivos || lineasActivas) {
                    if (sym.PALABRA === symbol.sym || sym.TIPO === symbol.sym || sym.NUMERO === symbol.sym || sym.NUMERO_COLOR === symbol.sym || sym.CHART === symbol.sym) {
                        listaTokens.add(symbol.value.toString())
                    }
                }
            }
            if (listaTokens.isNotEmpty()) {
                agregar(listaTokens) // Agregar
            }
        } catch (ex: IOException) {
            // Manejar Excepción
        }
        return armarTodoElHTML()
    }

    private fun construirHTMLBase(listaTokens: List<String>) {
        var indice = 1
        codigo.add("<!DOCTYPE html>\n")
        codigo.add("<html lang=\"es\">\n")
        codigo.add("\t<head>\n")
        codigo.add("\t\t<meta charset=\"UTF-8\">\n")
        if ("\"description\"" == listaTokens[indice]) {
            indice++
            codigo.add(("\t\t<meta name=\"description\" content=" + listaTokens[indice]) + ">\n")
            indice++
        }

        var claves: String? = "\t\t<meta name=\"keywords\" content=\""
        while (true) {
            val clave = quitarComillas(listaTokens[indice])
            claves += clave
            indice++
            if ("\"header\"" == listaTokens[indice]) {
                claves += "\">\n"
                codigo.add(claves!!)
                indice++
                break
            } else {
                claves += ", "
            }
        }
        codigo.add(("\t\t<title>" + listaTokens[indice]) + "</title>\n")
        codigo.add("\t\t<style>\n")
        codigo.add("\t\t\tbody {\n")
        if ("\"backgroundColor\"" == listaTokens[listaTokens.size - 4]) {
            codigo.add("\t\t\t\tbackground-color: " + quitarComillas(listaTokens[listaTokens.size - 3]) + ";\n")
        } else {
            codigo.add("\t\t\t\tbackground-color: #fefefe;\n")
        }
        codigo.add(("\t\t\t\tfont-family: " + listaTokens[listaTokens.size - 2]) + ";\n")
        codigo.add("\t\t\t\tfont-size: " + quitarComillas(listaTokens[listaTokens.size - 1]) + ";\n")
        codigo.add("\t\t\t}\n")
        codigo.add("\t\t</style>\n")
        codigo.add("\t\t<script src=\"https://cdn.jsdelivr.net/npm/chart.js\"></script>\n")
        codigo.add("\t</head>\n")
        codigo.add("\t<body>\n")
        codigo.add("\t\t<script>\n")
        codigo.add("\t\t</script>\n")
        codigo.add("\t\t<footer>\n")
        codigo.add(("\t\t\t<p>" + listaTokens[indice + 1]) + "</p>\n")
        codigo.add("\t\t</footer>\n")
        codigo.add("\t</body>\n")
        codigo.add("</html>")
    }

    private fun quitarComillas(palabra: String): String {
        val partes = palabra.split("".toRegex()).dropLastWhile { it.isEmpty() }
            .toTypedArray()
        var union = ""
        for (i in 2 until partes.size - 1) {
            union += partes[i]
        }
        return union
    }

    private fun armarTodoElHTML(): String {
        var codigoCompleto = ""
        for (codigoParte in codigo) {
            codigoCompleto += codigoParte
            if ("\t<body>\n" == codigoParte) {
                codigoCompleto += identificadores
            } else if ("\t\t<script>\n" == codigoParte) {
                codigoCompleto += estructurasGraficas
            }
        }
        return codigoCompleto
    }

    private fun agregar(listaTokens: List<String>) {
        if (barraActiva) {
            agregarBarra(listaTokens)
        } else if (pastelActivo) {
            agregarPastel(listaTokens)
        } else if (puntosActivos) {
            agregarPuntos(listaTokens)
        } else if (lineasActivas) {
            agregarLineas(listaTokens)
        }
    }

    private fun agregarBarra(listaTokens: List<String>) {
        var sencillo = true
        numeroGrafica++
        for (token in listaTokens) {
            if ("\"chart\"" == token) {
                sencillo = false
                identificadores += "\t\t<h3>X=" + listaTokens[listaTokens.size - 2] + "</h3>\n"
                identificadores += "\t\t<h3>Y=" + listaTokens[listaTokens.size - 1] + "</h3>\n"
                break
            }
        }
        identificadores += "\t\t<canvas id=\"graficaBarras$numeroGrafica\"></canvas>\n"
        identificadores += "\t\t<br><br><br><br><br><br>\n"
        estructurasGraficas += ("\t\t\tvar barras = document.getElementById('graficaBarras" + numeroGrafica + "').getContext('2d');\n"
                + "\t\t\tvar chart = new Chart(barras,{\n"
                + "\t\t\t\ttype: 'bar',\n"
                + "\t\t\t\tdata: {\n"
                + "\t\t\t\t\tlabels: [")
        if (sencillo) {
            var contador = 0
            while (contador < listaTokens.size) {
                estructurasGraficas += listaTokens[contador]
                contador += 2
                estructurasGraficas += if (contador < listaTokens.size) {
                    ", "
                } else {
                    "],\n"
                }
            }
            estructurasGraficas += "\t\t\t\t\tdatasets: [{\n" +
                    "\t\t\t\t\t\tdata: ["
            contador = 1
            while (contador < listaTokens.size) {
                estructurasGraficas += listaTokens[contador]
                contador += 2
                estructurasGraficas += if (contador < listaTokens.size) {
                    ", "
                } else {
                    "],\n"
                }
            }
            estructurasGraficas += "\t\t\t\t\t\tbackgroundColor: [\"#ff5733\"],\n"
        } else {
            var contador = 0
            var numeroElementos = 0
            while (contador < listaTokens.size) {
                estructurasGraficas += listaTokens[contador]
                contador += 3
                if ("\"chart\"" != listaTokens[contador]) {
                    estructurasGraficas += ", "
                } else {
                    estructurasGraficas += "],\n"
                    break
                }
                numeroElementos++
            }
            estructurasGraficas += "\t\t\t\t\tdatasets: [{\n"
            estructurasGraficas += "\t\t\t\t\t\tlabel: [" + listaTokens[listaTokens.size - 3] + "],\n"
            estructurasGraficas += "\t\t\t\t\t\tdata: ["
            var contadorInicial = numeroElementos
            contador = 1
            while (contador < listaTokens.size) {
                estructurasGraficas += listaTokens[contador]
                contador += 3
                if (contadorInicial != 0) {
                    estructurasGraficas += ", "
                } else {
                    estructurasGraficas += "],\n"
                    break
                }
                contadorInicial--
            }
            estructurasGraficas += "\t\t\t\t\t\tbackgroundColor: ["
            contadorInicial = numeroElementos
            contador = 2
            while (contador < listaTokens.size) {
                estructurasGraficas += listaTokens[contador]
                contador += 3
                if (contadorInicial != 0) {
                    estructurasGraficas += ", "
                } else {
                    estructurasGraficas += "],\n"
                    break
                }
                contadorInicial--
            }
        }
        estructurasGraficas += "\t\t\t\t\t}]\n\t\t\t\t}\n\t\t\t});\n"
    }

    private fun agregarPastel(listaTokens: List<String>) {
        var sencillo = true
        numeroGrafica++
        for (token in listaTokens) {
            if ("\"chart\"" == token) {
                sencillo = false
                break
            }
        }
        if ("\"top\"" == listaTokens[listaTokens.size - 1]) {
            identificadores += "\t\t<h1>" + listaTokens[listaTokens.size - 2] + "</h1>\n"
        }
        identificadores += "\t\t<canvas id=\"graficaPastel$numeroGrafica\"></canvas>\n"
        if ("\"bottom\"" == listaTokens[listaTokens.size - 1]) {
            identificadores += "\t\t<h1>" + listaTokens[listaTokens.size - 2] + "</h1>\n"
        }
        identificadores += "\t\t<br><br><br><br><br><br>\n"
        estructurasGraficas += ("\t\t\tvar pastel = document.getElementById('graficaPastel" + numeroGrafica + "').getContext('2d');\n"
                + "\t\t\tvar chart = new Chart(pastel,{\n"
                + "\t\t\t\ttype: 'pie',\n"
                + "\t\t\t\tdata: {\n"
                + "\t\t\t\t\tlabels: [")
        if (sencillo) {
            var contador = 0
            while (contador < listaTokens.size) {
                estructurasGraficas += listaTokens[contador]
                contador += 2
                estructurasGraficas += if (contador < listaTokens.size) {
                    ", "
                } else {
                    "],\n"
                }
            }
            estructurasGraficas += ("\t\t\t\t\tdatasets: [{\n"
                    + "\t\t\t\t\t\tdata: [")
            contador = 1
            while (contador < listaTokens.size) {
                estructurasGraficas += listaTokens[contador]
                contador += 2
                estructurasGraficas += if (contador < listaTokens.size) {
                    ", "
                } else {
                    "],\n"
                }
            }
            estructurasGraficas += "\t\t\t\t\t\tbackgroundColor: [\"#ff5733\"],\n"
            estructurasGraficas += "\t\t\t\t\t\tborderWidth: 3\n"
        } else {
            var contador = 0
            var numeroElementos = 0
            while (contador < listaTokens.size) {
                estructurasGraficas += listaTokens[contador]
                contador += 3
                if ("\"chart\"" != listaTokens[contador]) {
                    estructurasGraficas += ", "
                } else {
                    estructurasGraficas += "],\n"
                    break
                }
                numeroElementos++
            }
            estructurasGraficas += ("\t\t\t\t\tdatasets: [{\n"
                    + "\t\t\t\t\t\tdata: [")
            var contadorElementos = numeroElementos
            contador = 1
            while (contador < listaTokens.size) {
                estructurasGraficas += listaTokens[contador]
                contador += 3
                if (contadorElementos != 0) {
                    estructurasGraficas += ","
                } else {
                    estructurasGraficas += "],\n"
                    break
                }
                contadorElementos--
            }
            estructurasGraficas += "\t\t\t\t\t\tbackgroundColor: ["
            contadorElementos = numeroElementos
            contador = 2
            while (contador < listaTokens.size) {
                estructurasGraficas += listaTokens[contador]
                contador += 3
                if (contadorElementos != 0) {
                    estructurasGraficas += ","
                } else {
                    estructurasGraficas += "],\n"
                    break
                }
                contadorElementos--
            }
            estructurasGraficas += "\t\t\t\t\t\tborderWidth: 3\n"
        }
        estructurasGraficas += "\t\t\t\t\t}]\n\t\t\t\t}\n\t\t\t});\n"
    }

    private fun agregarPuntos(listaTokens: List<String>) {
        var sencillo = true
        numeroGrafica++
        for (token in listaTokens) {
            if ("\"chart\"" == token) {
                sencillo = false
                identificadores += "\t\t<h3>X=" + listaTokens[listaTokens.size - 2] + "</h3>\n"
                identificadores += "\t\t<h3>Y=" + listaTokens[listaTokens.size - 1] + "</h3>\n"
                break
            }
        }
        identificadores += "\t\t<canvas id=\"graficaPuntos$numeroGrafica\"></canvas>\n"
        identificadores += "\t\t<br><br><br><br><br><br>\n"
        estructurasGraficas += ("\t\t\tvar puntos = document.getElementById('graficaPuntos" + numeroGrafica + "').getContext('2d');\n"
                + "\t\t\tvar chart = new Chart(puntos,{\n"
                + "\t\t\t\ttype: 'scatter',\n"
                + "\t\t\t\tdata: {\n"
                + "\t\t\t\t\tdatasets: [{\n")
        if (!sencillo) {
            estructurasGraficas += "\t\t\t\t\t\tlabel: " + listaTokens[listaTokens.size - 3] + ",\n"
        }
        estructurasGraficas += "\t\t\t\t\t\tdata: [\n"
        if (sencillo) {
            var contador = 0
            while (contador < listaTokens.size) {
                estructurasGraficas += "\t\t\t\t\t\t\t{ x: " + listaTokens[contador] + ", y: " + listaTokens[contador + 1] + "}"
                contador += 2
                estructurasGraficas += if (contador < listaTokens.size) {
                    ",\n"
                } else {
                    "\n\t\t\t\t\t\t],\n"
                }
            }
            estructurasGraficas += "\t\t\t\t\t\tbackgroundColor: [\"#ff5733\"],\n"
        } else {
            var contador = 0
            var numeroElementos = 0
            while (contador < listaTokens.size) {
                estructurasGraficas += "\t\t\t\t\t\t\t{ x: " + listaTokens[contador] + ", y: " + listaTokens[contador + 1] + "}"
                contador += 4
                if ("\"chart\"" != listaTokens[contador]) {
                    estructurasGraficas += ",\n"
                } else {
                    estructurasGraficas += "\n\t\t\t\t\t\t],\n"
                    break
                }
                numeroElementos++
            }
            estructurasGraficas += "\t\t\t\t\t\tbackgroundColor: ["
            var contadorElementos = numeroElementos
            contador = 3
            while (contador < listaTokens.size) {
                estructurasGraficas += listaTokens[contador]
                contador += 4
                if (contadorElementos != 0) {
                    estructurasGraficas += ","
                } else {
                    estructurasGraficas += "],\n"
                    break
                }
                contadorElementos--
            }
            estructurasGraficas += "\t\t\t\t\t\tpointRadius: ["
            contadorElementos = numeroElementos
            contador = 2
            while (contador < listaTokens.size) {
                estructurasGraficas += listaTokens[contador]
                contador += 4
                if (contadorElementos != 0) {
                    estructurasGraficas += ","
                } else {
                    estructurasGraficas += "],\n"
                    break
                }
                contadorElementos--
            }
        }
        estructurasGraficas += "\t\t\t\t\t}]\n\t\t\t\t}\n\t\t\t});\n"
    }

    private fun agregarLineas(listaTokens: List<String>) {
        val crearLineas = LineasConstruccion(numeroGrafica, identificadores, estructurasGraficas)
        crearLineas.agregarLineas(listaTokens)
        numeroGrafica = crearLineas.getNumeroGrafica()
        identificadores = crearLineas.getIdentificadores()
        estructurasGraficas = crearLineas.getEstructurasGraficas()
    }

    private fun marcarTodosFalsos() {
        barraActiva = false
        pastelActivo = false
        puntosActivos = false
        lineasActivas = false
    }

    fun obtenerNombre(): String {
        return "${quitarComillas(nombrePagina)}.html"
    }
}
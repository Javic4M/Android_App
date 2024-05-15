package com.example.graficasapp.graficas

class GraficaCodigo(private var opcion: Int, private var tipo: Int) {

    fun obtenerCodigo(): String {
        var contenido = ""
        when (opcion) {
            1 -> contenido = obtenerBarras()
            2 -> contenido = obtenerPastel()
            3 -> contenido = obtenerPuntos()
            4 -> contenido = obtenerLineas()
            else -> {}
        }
        return contenido
    }

    private fun obtenerBarras(): String {
        var codigo = ""
        codigo = if (tipo == 1) {
            "\n\t{\n" +
                    "\t\t\"data\": [\n" +
                    "\t\t\t{ \"category\": \"A\", \"value\": 10 },\n" +
                    "\t\t\t{ \"category\": \"B\", \"value\": 20 },\n" +
                    "\t\t\t{ \"category\": \"C\", \"value\": 30 },\n" +
                    "\t\t\t{ \"category\": \"D\", \"value\": 40 },\n" +
                    "\t\t\t{ \"category\": \"E\", \"value\": 50 }\n" +
                    "\t\t]\n" + "\t}"
        } else {
            "\n\t{\n" +
                    "\t\t\"data\": [\n" +
                    "\t\t\t{ \"category\": \"A\", \"value\": 10, \"color\": \"#ff5733\" },\n" +
                    "\t\t\t{ \"category\": \"B\", \"value\": 20, \"color\": \"#33ff57\" },\n" +
                    "\t\t\t{ \"category\": \"C\", \"value\": 30, \"color\": \"#5733ff\" },\n" +
                    "\t\t\t{ \"category\": \"D\", \"value\": 40, \"color\": \"#ffff33\" },\n" +
                    "\t\t\t{ \"category\": \"E\", \"value\": 50, \"color\": \"#33ffff\" }\n" +
                    "\t\t],\n" +
                    "\t\t\"chart\": {\n" +
                    "\t\t\t\"title\": \"Gráfica\",\n" +
                    "\t\t\t\"xAxisLabel\": \"Horizontal\",\n" +
                    "\t\t\t\"yAxisLabel\": \"Vertical\"\n" +
                    "\t\t}\n" + "\t}"
        }
        return codigo
    }

    private fun obtenerPastel(): String {
        var codigo = ""
        codigo = if (tipo == 1) {
            "\n\t{\n" +
                    "\t\t\"data\": [\n" +
                    "\t\t\t{ \"label\": \"A\", \"value\": 30 },\n" +
                    "\t\t\t{ \"label\": \"B\", \"value\": 40 },\n" +
                    "\t\t\t{ \"label\": \"C\", \"value\": 30 }\n" +
                    "\t\t]\n" + "\t}"
        } else {
            "\t{\n" +
                    "\t\t\"data\": [\n" +
                    "\t\t\t{ \"label\": \"A\", \"value\": 30, \"color\": \"#ff5733\" },\n" +
                    "\t\t\t{ \"label\": \"B\", \"value\": 40, \"color\": \"#33ff57\" },\n" +
                    "\t\t\t{ \"label\": \"C\", \"value\": 30, \"color\": \"#5733ff\" }\n" +
                    "\t\t],\n" +
                    "\t\t\"chart\": {\n" +
                    "\t\t\t\"title\": \"Gráfica\",\n" +
                    "\t\t\t\"legendPosition\": \"top\"\n" +
                    "\t\t}\n" + "\t}"
        }
        return codigo
    }

    private fun obtenerPuntos(): String {
        var codigo = ""
        codigo = if (tipo == 1) {
            "\n\t{\n" +
                    "\t\t\"data\": [\n" +
                    "\t\t\t{ \"x\": 10, \"y\": 50 },\n" +
                    "\t\t\t{ \"x\": 20, \"y\": 40 },\n" +
                    "\t\t\t{ \"x\": 30, \"y\": 30 },\n" +
                    "\t\t\t{ \"x\": 40, \"y\": 20 },\n" +
                    "\t\t\t{ \"x\": 50, \"y\": 10 }\n" +
                    "\t\t]\n" + "\t}"
        } else {
            "\n\t{\n" +
                    "\t\t\"data\": [\n" +
                    "\t\t\t{ \"x\": 10, \"y\": 50, \"size\": 10, \"color\": \"#ff5733\" },\n" +
                    "\t\t\t{ \"x\": 20, \"y\": 40, \"size\": 9, \"color\": \"#33ff57\" },\n" +
                    "\t\t\t{ \"x\": 30, \"y\": 30, \"size\": 8, \"color\": \"#5733ff\" },\n" +
                    "\t\t\t{ \"x\": 40, \"y\": 20, \"size\": 7, \"color\": \"#ffff33\" },\n" +
                    "\t\t\t{ \"x\": 50, \"y\": 10, \"size\": 6, \"color\": \"#33ffff\" }\n" +
                    "\t\t],\n" +
                    "\t\t\"chart\": {\n" +
                    "\t\t\t\"title\": \"Gráfico de Puntos\",\n" +
                    "\t\t\t\"xAxisLabel\": \"Horizontal\",\n" +
                    "\t\t\t\"yAxisLabel\": \"Vertical\"\n" +
                    "\t\t}\n" + "\t}"
        }
        return codigo
    }

    private fun obtenerLineas(): String {
        return "\n\t{\n" +
                "\t\t\"data\": [\n" +
                "\t\t\t{\n" +
                "\t\t\t\"name\": \"Serie 1\",\n" +
                "\t\t\t\"points\": [\n" +
                "\t\t\t\t{ \"x\": 1, \"y\": 10 },\n" +
                "\t\t\t\t{ \"x\": 2, \"y\": 20 },\n" +
                "\t\t\t\t{ \"x\": 3, \"y\": 30 },\n" +
                "\t\t\t\t{ \"x\": 4, \"y\": 40 },\n" +
                "\t\t\t\t{ \"x\": 5, \"y\": 50 }\n" +
                "\t\t\t]\n" +
                "\t\t\t},\n" +
                "\t\t\t{\n" +
                "\t\t\t\"name\": \"Serie 2\",\n" +
                "\t\t\t\"points\": [\n" +
                "\t\t\t\t{ \"x\": 1, \"y\": 15 },\n" +
                "\t\t\t\t{ \"x\": 2, \"y\": 25 },\n" +
                "\t\t\t\t{ \"x\": 3, \"y\": 35 },\n" +
                "\t\t\t\t{ \"x\": 4, \"y\": 25 },\n" +
                "\t\t\t\t{ \"x\": 5, \"y\": 15 }\n" +
                "\t\t\t]\n" +
                "\t\t\t}\n" +
                "\t\t],\n" +
                "\t\t\"chart\": {\n" +
                "\t\t\t\"title\": \"Gráfico\",\n" +
                "\t\t\t\"xAxisLabel\": \"Horizontal\",\n" +
                "\t\t\t\"yAxisLabel\": \"Vertical\"\n" +
                "\t\t}\n" +
                "\t}"
    }
}
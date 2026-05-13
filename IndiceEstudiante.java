public class IndiceEstudiante {
    private clase_estudiante[] tabla;
    private int tamaño;
    private double factorCargaMaximo;
    private int cantidadActual;

    public IndiceEstudiante (int tamaño, double factorCargaMaximo){
      this.tamaño= tamaño;
      this.factorCargaMaximo=factorCargaMaximo;
      this.tabla = new clase_estudiante[tamaño];
      this.cantidadActual=0;
    }

private int hash(String clave) {
        int suma = 0;
        for (int i = 0; i < clave.length(); i++) {
            suma += (int) clave.charAt(i); 
        }
        return suma % tamaño;
    }

public void insertar(clase_estudiante e) { // e = estudiante
        if ((double) (cantidadActual + 1) / tamaño > factorCargaMaximo) { //verifico que la cantidad no sea mayor al factor carga
            System.out.println(" ERROR, Factor de carga superado. No se puede insertar el legajo: " + e.getLegajo());
            return;
        }

        int hashBase = hash(e.getLegajo());
        int i = 0;
        int posicion = hashBase;

        // Exploración cuadrática por si hay colision
        while (tabla[posicion] != null) {
            i++;
            posicion = (hashBase + (i * i)) % tamaño; // h(k,i) = (h(k) + i^2) mod 17
        }

        tabla[posicion] = e;
        cantidadActual++;
        System.out.println("✅ Insertado: " + e.getLegajo() + " en posición " + posicion + " (Intentos extra: " + i + ")");
    }

    public clase_estudiante buscar(String legajo) {
        int hashBase = hash(legajo);
        int i = 0;
        int posicion = hashBase;

        while (tabla[posicion] != null) {
            // Si coincide el legajo, lo encontramos
            if (tabla[posicion].getLegajo().equals(legajo)) {
                return tabla[posicion];
            }
            i++;
            posicion = (hashBase + (i * i)) % tamaño;
        }
        return null;
    }

}

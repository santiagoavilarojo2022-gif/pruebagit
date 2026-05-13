public class App {
    public static void main(String[] args) {
        // Instanciamos la universidad (que ya contiene el índice hash)
        universidad uni = new universidad();

        System.out.println("--- REGISTRANDO ESTUDIANTES ---");
        // Nota: Le agregamos el legajo al final de cada constructor
        clase_estudiante e1 = new clase_estudiante("Ana", "Gomez", 20, "111", "Sistemas", 8.5f, "Matemáticas", "AB12");
        clase_estudiante e2 = new clase_estudiante("Luis", "Perez", 21, "222", "Sistemas", 7.0f, "Física", "CD34");
        clase_estudiante e3 = new clase_estudiante("Marta", "Ruiz", 22, "333", "Sistemas", 9.0f, "Química", "EF56");
        
        // Vamos a forzar una colisión si sus sumas ASCII caen en la misma posición base
        clase_estudiante e4 = new clase_estudiante("Pedro", "Diaz", 23, "444", "Sistemas", 6.0f, "Redes", "AB12"); // Mismo legajo para forzar colisión/exploración

        uni.registrarEstudiante(e1);
        uni.registrarEstudiante(e2);
        uni.registrarEstudiante(e3);
        uni.registrarEstudiante(e4); 

        System.out.println("\n--- BUSCANDO ESTUDIANTES ---");
        
        // Búsqueda exitosa
        System.out.println("Buscando AB12...");
        clase_estudiante encontrado = uni.buscarEstudiante("AB12");
        if (encontrado != null) {
            System.out.println("Encontrado: " + encontrado.toString());
        } else {
            System.out.println("No se encontró.");
        }

        // Búsqueda fallida
        System.out.println("\nBuscando ZZ99...");
        clase_estudiante noEncontrado = uni.buscarEstudiante("ZZ99");
        if (noEncontrado != null) {
            System.out.println("Encontrado: " + noEncontrado.toString());
        } else {
            System.out.println("Estudiante ZZ99 no registrado en la Universidad.");
        }
    }
}
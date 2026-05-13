public class universidad {
    private IndiceEstudiante indice;

    public universidad(){
        // Como ahora usamos double, el 0.7 entra sin problemas
        this.indice = new IndiceEstudiante(17, 0.7);
    }

    // Tenías un pequeño error de tipeo en el nombre del método (reigstrar en vez de registrar)
    public void registrarEstudiante(clase_estudiante e){
        indice.insertar(e);
    }

    public clase_estudiante buscarEstudiante (String legajo){
        return indice.buscar(legajo);
    }
}
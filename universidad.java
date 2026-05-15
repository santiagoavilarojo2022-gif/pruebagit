public class universidad {
    private IndiceEstudiante indice;

    public universidad(){
        this.indice = new IndiceEstudiante(17, 0.7);
    }

    public void registrarEstudiante(clase_estudiante e){
        indice.insertar(e);
    }

    public clase_estudiante buscarEstudiante (String legajo){
        return indice.buscar(legajo);
    }
}

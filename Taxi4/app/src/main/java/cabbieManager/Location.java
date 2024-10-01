package cabbieManager;

/**
     * Uma tabela de localizações com coordenadas X e Y
     * 
     * Ela sera usada para calcular a distancias entre os destinos.
     * 
     */
public enum Location {
    
    // IMPLEMENTAÇÃO ENUM LOCATION
    
    AEROPORTO("Aeroporto", 5, 18),
    ESTAÇÃODETREM("Estação de Trem", 12, 8),
    SHOPPING("Shopping", 20, 7),
    ESCOLA("Escola", 6, 23),
    PARQUE("Parque", 0, 4),
    HOSPITAL("Hospital", 15, 11),
    BIBLIOTECA("Biblioteca", 3, 19),
    ESTADIO("Estádio", 22, 25);

    private final String nome;
    private final int coordenadaX;
    private final int coordenadaY;

    Location(String nome,int x, int y){
        this.nome =  nome;
        this.coordenadaX = x;
        this.coordenadaY = y;

    }
    /**
     * Geters dos atributos de cada localização
     * @return retorna o atributo da localização que foi chamado.
     * Pode retornar nome,coordenadaX e coordenadaY.
     */
    public String getNome() {
        return nome;
    }
    public int getCoordenadaX() {
        return coordenadaX;
    }
    public int getCoordenadaY() {
        return coordenadaY;
    }




    
}

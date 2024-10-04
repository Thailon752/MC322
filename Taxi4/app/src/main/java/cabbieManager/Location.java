package cabbieManager;

/**
     * Uma tabela de localizações com coordenadas X e Y.
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
     * Pega o atributo nome da Localização.
     * @return retorna uma String com o nome da localização.
     */
    public String getNome() {
        return nome;
    }
    /**
     * Pega o atributo coordenada X da Localização.
     * @return retorna um int com o valor da coordenada X da localização.
     */
    public int getCoordenadaX() {
        return coordenadaX;
    }
    /**
     * Pega o atributo coordenada Y da Localização.
     * @return retorna um int com o valor da coordenada Y da localização.
     */
    public int getCoordenadaY() {
        return coordenadaY;
    }




    
}

package torusristinolla.logic;

public class Gameboard {
    
    private Square[]lauta;
    private int width;
    private int height;
    
    public Gameboard(int width, int height) {
        width = width;
        height = height;
        createBoard(width, height);
    }
    
    private void createBoard(int width, int height) {
        lauta = new Square[width*height];
        
        for(int i=0; i < lauta.length; i++) {
            lauta[i] = new Square();
        }
    }
    
    public int getWidth() {
        return width;
    }
    
    public int getHeight() {
        return height;
    }
    
    public Square[] getLauta() {
        return lauta;
    }
    
    
}

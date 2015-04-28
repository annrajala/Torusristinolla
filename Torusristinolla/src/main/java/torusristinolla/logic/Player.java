package torusristinolla.logic;

/**
* Huolehtii pelaajan nimestä ja merkistä
*/
public class Player {
    
    private Token token;
    private String nickname;
    
    /**
     * Pelaajan konstruktori
     * @param merkki pelaajan pelimerkki
     * @param name pelaajan nimi
     */
    public Player(Token merkki, String name) {
        this.token = merkki;
        this.nickname = name;
    }
    
    public String getName() {
        return this.nickname;
    }
    
    public Token getToken() {
        return this.token;
    }
    
    /**
     * @return pelaajan merkkiä vastaava String
     */
    public String getTokenString() {
        if(this.token == Token.CIRCLE) {
            return "O";
        } else if (this.token == Token.CROSS) {
            return "X";
        } else {
            return " ";
        }
    }
    
    /**
     * vaihtaa pelaajan merkkiä ympyrästä rastiksi tai päinvastoin
     */
    public void changeToken() {
        if(this.token == Token.CIRCLE) {
            this.token = Token.CROSS;
        } else {
            this.token = Token.CIRCLE;
        }
    }
}

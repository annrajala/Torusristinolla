package torusristinolla.logic;

public class Pelaaja {
    private Token token;
    private String nickname;
    
    public Pelaaja(Token merkki, String name) {
        this.token = merkki;
        this.nickname = name;
    }
    
    public String getName() {
        return this.nickname;
    }
    
    public Token getToken() {
        return this.token;
    }
}

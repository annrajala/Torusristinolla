Aihe: Torusristinolla

Toteutetaan peli, jonka avulla pystyy pelaamaan ristinollaa, kuten sitä pelattaisiin toruspinnalla. Torus on matemaattinen rakenne, josta voi lukea lisää mm. tästä Wikipedia-artikkelista: http://fi.wikipedia.org/wiki/Torus. Pelattaessa siis toruspinnalla pelaajan täytyy huomioida rakenne ja nähdä monet voittomahdollisuudet, sillä voittosuora ei välttämättä visuaalisesti ole suora.

Peli tarjoaa käyttäjälle tavan lisätä haastetta erikokoisten pelilautojen avulla, säilyttäen kuitenkin voiton saamisen kolmen saman merkin suoralla. Peli pitää myös kirjaa pelaajien voitoista ja siitä, monesko peli on menossa.


Käyttäjät: Pelaajat

Kaikkien käyttäjien toiminnot:
- voi pelata ristinollaa toruspintaa imitoivalla pelilaudalla toisen käyttäjän kanssa
- voi valita pelilaudan koon
- pelaa joko merkillä x tai o
- voi asettaa merkin omalla vuorollaan haluamaansa ruutuun pelilaudalla, mikäli lauta ei ole vielä täynnä ja mikäli toinen pelaaja ei ole vielä saanut pelin voittoon oikeuttavaa kolmen suoraa
- ei voi asettaa merkkiään ruutuun, jossa on jo oma tai toisen pelaajan pelimerkki
- voi seurata voittomääriä ja pelikertaa
- voi resetata pelilaudan

Sovelluksen rakenne:

Sovelluksen oleellisimpana komponenttina toimii luokka Game, joka huolehtii vuorojen pelaamisista, merkkien asettamisesta laudalle (Gameboard-luokan metodien kautta) ja voittojen tarkistamisista (luokan WinnerChecker välityksellä).
WinnerChecker-luokka sisältää kaiken voittosuorien tarkistamiseen liittyvän logiikan, joka on toteutettu käyttäen ehtolauseita. Tulevaisuudessa logiikalle kannattaisi keksiä jokin muu tarkistustapa, jotta voittosuora saataisiin skaalautumaan pelilaudan koon mukana. Jokaiselle Game-luokalle luodaan WinnerChecker-olio konstruktorissa.
Jokaiseen Game-olioon liittyy kaksi Player-oliota, jotka edustavat pelin kahta pelaajaa. Kummallakin pelaajalla on nimi ja pelimerkki. Game-luokka tarkistaa konstruktorissaan, ettei pelaajilla ole samaa merkkiä, ja tarpeen tullen vaihtaa toisen pelaajan merkkiä.
Pelin kaikki kolme mahdollista merkkiä on määritelty omassa listassaan (Token). 
Jokaiseen Game-olioon linkittyy aina myös yksi Gameboard-olio, joka huolehtii pelilaudan organisoinnista. Pelilauta on aina vähintäään 3x3-kokoinen ja neliönmuotoinen sekä koostuu tarvittavasta määrästä Square-olioita.
Square-olio on ainoastaan tietoinen omasta tilastaan. Pelilaudan Square-oliot luodaan Gameboard-luokan konstruktorissa. Lisäksi luokkien Gameboard ja WinnerChecker välillä on yhteys, sillä tarkistajan tulee olla tietoinen pelilaudan nykyisestä tilanteesta.

Game-luokka linkittyy suoraan käyttöliittymään (UI), ja siksi pelin tässä versiossa ei ole esimerkiksi mahdollista käyttöliittymästä suoraan vaihtaa eri pelaajien ja pelilautakokojen välillä.
UI-luokkaan liittyy yksi Layout-olio, joka huolehtii komponenttien piirtämisestä ruudulle. Jokaiseen ruudulla näkyvään ruutuun liittyy TextManager-olio, joka kuuntelee ruutua esittävän painikkeen toimintaa ja piirtää tarvittaessa merkin ruutuun.
Ruudulla näkyvään "New game"-painikkeeseen liittyy lisäksi oma kuuntelijansa. Painiketta painaessa kuuntelija huolehtii pelin resettauksen Game-luokan metodin kautta ja piirtää komponentit uudelleen ruudulle.




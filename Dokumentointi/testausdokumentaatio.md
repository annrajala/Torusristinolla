TESTAUSDOKUMENTAATIO

Ohjelman automaatiotestauksessa on testattu kaikki oleelliset metodit (eli esim. settereitä ja gettereitä on jätetty testaamatta) mahdollisimman monelta kantilta. Käyttöliittymää ei ole testattu.

Game-luokan testauksessa tärkeimmät testit huolehtivat siitä, että voittaja löytyy oikeaan aikaan, eli esimerkiksi pelin alussa ja pelin resettauksen jälkeen voittajaa ei saa olla. Testaus myös katsoo, että pelaajilla on pelin alkaessa eri pelimerkit, vaikka heille olisi ilmoitettu samat merkit, että kierros vaihtuu oikein, että voitot kertyvät oikeille pelaajille, että merkit asetetaan laudalle ja että oikea pelaaja on vuorossa.

Gameboard-luokan testauksella pidetään huoli, että pelilauta on aina vähintään 3x3-kokoinen ja että merkkejä asetetaan laudalle oikein.

Player-luokan testaus on lyhyt, kuten itse luokkakin, ja tärkeimpänä testauksen kohteena on merkinvaihtometodin toimivuus.

Square-luokan testauksella varmistetaan, että luotu ruutu on tyhjä ja että ruutuun asetettava merkki todella päätyy ruutuun.

WinnerChecker-luokan massiivisella testauksella varmistetaan, että kaikilla mahdollisilla voittotavoilla voidaan voittaa. Jokainen mahdollinen voittotapaus on siis testattu erikseen ja testauksessa on käytetty 4x4-kokoista lautaa, sillä se on tarpeeksi suuri (3x3-kokoinen lauta muistuttaa liikaa tavallista ristinollaa) testauksen hyödyllisyyden kannalta, mutta mukavan pieni käsiteltäväksi.
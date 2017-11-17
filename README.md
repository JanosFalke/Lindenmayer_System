# Lindenmayer_System
Quelques exemples sur le LSystem (Lindenmayer) en Java.


J'ai fait quelques exemples avec des commentaires sur le LSystem en Java (Netbeans).
Dans ce readme je vais egalement mettre quelque explication concernant le System de Lindenmayer (1968).

![GrandArbreLSystem](https://i.imgur.com/SeZZImQ.png) ![FormesLSystem](https://i.imgur.com/KaJltKo.png)

*Les couleurs signifient les differentes dérivations de l'axiome de début*


## Etape 1 : Grammaire formelle décrivant la croissance (code ADN)

*(En prenant exemple à droite)*
La grammaire formelle sera constituée :

  * X = X+Y++Y-X--XX-Y+
  * Y = -X+YY++Y+X--X-Y
  * + = +
  * - = -

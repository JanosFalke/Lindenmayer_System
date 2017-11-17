# Lindenmayer_System
Quelques exemples sur le LSystem (Lindenmayer) en Java.


J'ai fait quelques exemples avec des commentaires sur le LSystem en Java (Netbeans).
Dans ce readme je vais egalement mettre quelque explication concernant le System de Lindenmayer (1968).

![GrandArbreLSystem](https://i.imgur.com/SeZZImQ.png) ![FormesLSystem](https://i.imgur.com/KaJltKo.png)

*Les couleurs signifient les differentes dérivations de l'axiome de début*


**Expliquant maintenant comment avoir ces derivations.**

## Etape 1 : Grammaire formelle décrivant la croissance (code ADN)

La grammaire formelle sera constituée :
  * D'un alphabet A={ X, Y, F }
  * D'un axiome point de départ de l'expression u0 = X
  * De règles:  
    + X = XFXYYXFX
    + Y = Y
    + F = F
    
    
## Etape 2 : Dérivation de l'expression

u0 = X

u1 = XFXYYXFX

u2 = XFXYYXFX F XFXYYXFX Y Y XFXYYXFX F XFXYYXFX


## Etape 3 : interprétation graphique

X : avancer et tracer un trait 

Y : tourner à gauche de 60° 

F : tourner à droite de 60°



![ExempleU0](https://i.imgur.com/nRF1oX2.png) 
![ExempleU1](https://i.imgur.com/vRExKIL.png) 
![ExempleU2](https://i.imgur.com/DXpZrO8.png) 

*L'angle de départ du dessin est 0° donc nous commencerons à tracer en allant vers la droite de l’écran.*

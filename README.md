# FanaticApp
FanaticApp es una aplicación que lista peliculas en formato de lista y grilla con el uso de Material Design.

Para desarrolla este trabajo se usó 4 Fragment, 1
MainActivity, 1 Adapter,1 modelo y utlidades(un java class
simple para el cambio de Lista a Grid).
En el activity hay 3 botones cada uno direcciona a su 
respectivo fragmento.
ListaFragment y GrillaFragment como usan casi el mismo 
código se usa el mismo adapter, en Utilidades están
declaradas variables estáticas su valor cambia según el 
fragmento seleccionado y eso pasa al adapter donde se 
realiza un if-else para cambiar las líneas de código respectivo.
El dialogFragment contiene el AlertDialog para cuando se 
haga clic en cualquier item del recycleview.
También se ha implementado un ItemDecoration se usa el mismo ya sea para lista o 
grid.

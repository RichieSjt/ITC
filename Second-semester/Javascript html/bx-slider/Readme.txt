La carpeta images y el archivo css
deben de ir en la carpeta css.

El bxslider js va dentro de la carpeta
de javascript, requiere jquery para
funcionar correctamente.

/* Código que se debe incluir */

<div class="carousel">
        <div><img src="image/carousel01.jpg"></div>
        <div><img src="image/carousel02.jpg"></div>
        <div><img src="image/carousel03.jpg"></div>
        <div><img src="image/carousel04.jpg"></div>
        <div><img src="image/carousel05.jpg"></div>
</div>

<script src="js/jquery-3.3.1.min.js"></script>
<script src="js/jquery.bxslider.min.js"></script>

<script>
    $('.carousel').bxSlider();
</script>

/* Al final del html, antes de cerrar el </body> */

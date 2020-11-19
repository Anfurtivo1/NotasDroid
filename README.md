NotasDroid
SE PIDE:
Comenzaremos con una pantalla de presentación. 
Si es la primera vez que entramos debemos registrarnos en el sistema con nuestro nombre, email, contraseña (cifrada) y fotografía (desde la cámara o galería), ciclo que se cursa a elegir entre DAM, DAW y ASIR y el curso 1º o 2º. Esa fotografía será privada. Una vez nos hayamos registrado, podemos identificarnos con el correo electrónico y la contraseña. La sesión se mantendrá abierta hasta que pulsemos salir.
 Para ello usaremos Navigation Drawer donde mostraremos la foto y datos del usuario registrado e identificado.
 A partir de aquí tendremos una opción llamada Mi Matrícula con la lista con nuestros módulos en los que estamos matriculados. Esta lista de módulos existe en el sistema y está organizada por ciclo, curso y nombre de módulo y una imagen asociada como recurso existente. Puedes sacar el nombre de los módulos de cada ciclo y su curso en la sección de materiales de ayuda. 
Cada elemento de la lista se representará usando un CardView donde mostraremos la imagen, el nombre del módulo y la nota media de las pruebas realizadas de dicho módulo. Además, tendremos un spinner o combo box en la parte superior para poder organizar la lista de CardView por notas descendente (por defecto) o ascendentemente o nombre de módulo, ascendente/descendente. Podremos refrescar la lista para ver los cambios en ella. Deslizando a la derecha o pulsando pasaremos a ver las distintas pruebas calificables de cada módulo.
 Por cada módulo tendremos una lista de pruebas con su CarView, Podremos ordenarlas por fecha (por defecto), por calificación y si está realizada o no. A partir de aquí podremos borrar una prueba, editarla y crearla nueva, así como recargar la lista. La información relevante para una prueba es: 
- Nombre - Fecha (DD/MM/AAAA) 
- Realizada (sí o no)
 - Calificación obtenida (con dos decimales)
-No es obligatorio completarla, pues podemos dar de alta una prueba y luego completar su información editándola, pero sí tendremos que saber que si no se ha realizado no cuenta para la media que obtenemos en lso resúmenes y listados, pero sí la visualizamos.
- Podemos exportar e importar pruebas usando QR, es decir, generar el QR de la prueba, salvarlo y poder compartirlo. Y de la misma manera escanear el QR y dar de alta la prueba. 
- Podemos compartir una prueba por correo electrónico.
 
Además, tendremos una sección llamada Mi expediente que mostrará nuestros datos, imagen, nuestro ciclo, nuestro curso y la calificación media total de nuestro expediente, es decir la calificación media de los módulos cursados con dos decimales. Estos datos se pueden enviar por correo electrónico o compartir si quisiésemos en redes.
 Finalmente tendremos en un menú superior la opción de exportar los datos salvando estos datos en el directorio público y podremos importar los datos reconstruyendo la información existente. Es importante tener en cuenta que lo lógico es usar un lenguaje de intercambio conocido como puede ser XML/JSON. 
En todo momento se debe asegurar que nuestra aplicación es usable, cumple con los estándares de diseño de Material Desing y adaptable a cualquier orientación y resolución. Además debemos tener en cuenta que la interfaz debe adaptarse a distintos idiomas: castellano e ingles. Por supuesto, debemos filtrar los errores y asegurar la consistencia de la información. No debemos cuidar nuestros aspectos gráficos, iconos y colores que darán identidad a nuestro producto.

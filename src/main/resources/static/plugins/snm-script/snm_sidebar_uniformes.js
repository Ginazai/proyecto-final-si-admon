//Script de JavaScript Entregas
    // Espera a que el documento esté listo
    $(document).ready(function () {
        // Captura el evento clic del enlace con la ID "miEnlace" y la clase "nav-item"
        $("#entregas.nav-link").click(function () {
            // Ejecuta el fragmento Thymeleaf utilizando una petición AJAX al servidor
            $.ajax({
                url: "/wrapperEntregas", // Ruta del archivo fragmento.html en el servidor
                method: "GET",
                success: function (data) {
                    // Cuando la petición sea exitosa, inserta el contenido del fragmento en el div con ID "resultado"
                    $("#resultado").html(data);
                },
                error: function () {
                    // Maneja aquí el caso de error si la petición falla
                    alert("Error al obtener el fragmento.");
                }
            });

            // Evita que el enlace redireccione a otra página
            return false;
        });
    });
//Script de JavaScript Devoluciones
    // Espera a que el documento esté listo
    $(document).ready(function () {
        // Captura el evento clic del enlace con la ID "miEnlace" y la clase "nav-item"
        $("#devoluciones.nav-link").click(function () {
            // Ejecuta el fragmento Thymeleaf utilizando una petición AJAX al servidor
            $.ajax({
                url: "/wrapperDevoluciones", // Ruta del archivo fragmento.html en el servidor
                method: "GET",
                success: function (data) {
                    // Cuando la petición sea exitosa, inserta el contenido del fragmento en el div con ID "resultado"
                    $("#resultado").html(data);
                },
                error: function () {
                    // Maneja aquí el caso de error si la petición falla
                    alert("Error al obtener el fragmento.");
                }
            });

            // Evita que el enlace redireccione a otra página
            return false;
        });
    });
//Script de JavaScript Cambios-->
    // Espera a que el documento esté listo
    $(document).ready(function () {
        // Captura el evento clic del enlace con la ID "miEnlace" y la clase "nav-item"
        $("#cambios.nav-link").click(function () {
            // Ejecuta el fragmento Thymeleaf utilizando una petición AJAX al servidor
            $.ajax({
                url: "/wrapperCambios", // Ruta del archivo fragmento.html en el servidor
                method: "GET",
                success: function (data) {
                    // Cuando la petición sea exitosa, inserta el contenido del fragmento en el div con ID "resultado"
                    $("#resultado").html(data);
                },
                error: function () {
                    // Maneja aquí el caso de error si la petición falla
                    alert("Error al obtener el fragmento.");
                }
            });

            // Evita que el enlace redireccione a otra página
            return false;
        });
    });

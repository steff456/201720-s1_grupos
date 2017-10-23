(function (ng) {

    var mod = ng.module("multimediaModule");

    mod.controller('multimediaCtrl', ['$scope', '$state', '$http', 'multimediaContext','noticiasContext', function ($scope, $state, $http, context,noticiaContext) {

            
            // inicialmente el listado de multimdia está vacio
            $scope.multimediaRecords = {};
            // carga la multimedia
            $http.get(noticiaContext+"/"+$state.params.noticiaId+"/"+context).then(function (response) {
                $scope.multimediaRecords = response.data;
            });

            // el controlador recibió un id ??
            // revisa los parámetros (ver el :id en la definición de la ruta)
            if ($state.params.multimediaLink !== null && $state.params.multimediaLink !== undefined) {

                // toma el id del parámetro
                link = $state.params.multimediaLink;
                // obtiene el dato del recurso REST
                $http.get(noticiaContext+"/"+$state.params.noticiaId+"/"+context+"/"+ link)
                        .then(function (response) {
                            // $http.get es una promesa
                            // cuando llegue el dato, actualice currentMultimedia
                            $scope.currentMultimedia = response.data;
                        });

                // el controlador no recibió un cityId
            } else {
               
               
                $scope.alerts = [];
            }
            this.saveRecord = function (link) {
                currentMultimedia = $scope.currentMultimedia;

                // si el id es null, es un registro nuevo, entonces lo crea
                if (link == null) {
                    currentMultimedia.link="aaabbb";
                    // ejecuta POST en el recurso REST
                    console.log(noticiaContext+"/"+$state.params.noticiaId+"/"+context+";;;"+currentMultimedia);
                    return $http.post(noticiaContext+"/"+$state.params.noticiaId+"/"+context, currentMultimedia)
                            .then(function () {
                                // $http.post es una promesa
                                // cuando termine bien, cambie de estado
                                $state.go('noticiaMultimediaList');
                            });
                    currentMultimedia.link=null;
                    // si el id no es null, es un registro existente entonces lo actualiza
                } else {

                    // ejecuta PUT en el recurso REST
                    return $http.put(noticiaContext+"/"+$state.params.noticiaId+"/"+context+"/" + currentMultimedia.link, currentMultimedia)
                            .then(function () {
                                // $http.put es una promesa
                                // cuando termine bien, cambie de estado
                                $state.go('noticiaMultimediaList');
                            });
                }
                ;
            }
            this.deleteRecord= function(link)
            {
                if(link!=null)
                {
                    return $http.delete(noticiaContext+"/"+$state.params.noticiaId+"/"+context+"/"+link).then (function()
                    {
                        $state.reload();
                    })
                }
            }
            this.prueba = function(){
                console.log("HOLA Q HACE");
            }

// Código continua con las funciones de despliegue de errores


        }]);
})(angular);

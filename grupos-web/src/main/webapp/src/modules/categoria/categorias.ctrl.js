(function (ng) {
    var mod = ng.module("categoriaModule");
    mod.constant("categoriaContext", "Stark/categorias");
    mod.controller('categoriaCtrl', ['$scope', '$http', 'categoriaContext', '$state',
        function ($scope, $http, categoriaContext, $state) {
            $http.get(categoriaContext).then(function (response) {
                $scope.categoriaRecords = response.data;
            });
            
            if ($state.params.categoriaId !== undefined) {
                $scope.opcionesGrupo=true;
                console.log("llegue "+ $scope.opcionesGrupo);
                $http.get(categoriaContext + '/' + $state.params.categoriaId).then(function (response) {
                    $scope.categoriaActual = response.data;
                    $scope.grupoRecords = response.data.grupos;
                });
            }
        }
    ]);
}
)(angular);
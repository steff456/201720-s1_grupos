(function (ng) {
    var mod = ng.module("tarjetaModule");
    mod.constant("tarjetasContext", "tarjetas");
    mod.constant("usuariosContext", "Stark/usuarios");
    mod.controller('tarjetaDeleteCtrl', ['$scope', '$http', 'usuariosContext', '$state', 'tarjetasContext',
        function ($scope, $http, usuariosContext, $state, tarjetasContext) {
            var numTarjeta = $state.params.numTarjeta;
            $scope.deleteTarjeta = function () {
                $http.delete(usuariosContext + '/' + $state.params.usuarioId + '/' + tarjetasContext + '/' + numTarjeta, {}).then(function (response) {
                    $state.go('tarjetasList', {numTarjeta: response.data.id}, {reload: true});
                });
            };
        }
    ]);
}
)(angular);
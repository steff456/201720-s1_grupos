(function (ng) {
    var mod = ng.module("comentarioModule");
   
    mod.controller('comentarioCreateCtrl', ['$scope', '$http', 'comentarioContext', 'blogContext', 'grupoContext', '$state',
        function ($scope, $http, comentarioContext, blogContext, grupoContext, $state) {
            
            /**
             * Crea un nuevo comentario
             */
            $scope.createComentario = function () {
                $http.post(grupoContext+'/'+$state.params.grupoId+'/'+blogContext + '/' +
                        $state.params.blogId + '/' + comentarioContext, {
                    autor: sessionStorage.getItem("nickname"),
                    comentario: $scope.comentario
                }).then(function () {
                    $scope.goComentarioList();
                }, function () {
                    $scope.goError();
                });
            };
        } ]);
}
)(angular);

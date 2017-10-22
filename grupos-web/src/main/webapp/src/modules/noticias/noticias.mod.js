(function (ng) {
var mod = ng.module("noticiasModule", ['ui.router']);
    mod.constant("noticiasContext", "Stark/usuarios/1/noticias");
    mod.constant("usuarioContext","Stark/usuarios");
    mod.constant("grupoContext","Stark/grupos")
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/noticias/';
            $urlRouterProvider.otherwise("/noticiasList");

            $stateProvider.state('noticiasList', {
                url: '/noticias',
                views: {
                    'mainView': {
                        controller: 'noticiasCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'noticiasEditables.list.html'
                    }
                }
            }).state('noticiaCreate', {
                url: '/noticias/create',
                views: {
                    'mainView': {
                        controller: 'noticiasCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'noticias.create.html'
                    }
                }

            }).state('noticiaEdit', {
                url: '/noticias/:noticiaId',
                param: {
                    noticiaId: null
                },
                views: {
                    'mainView': {
                        controller: 'noticiasCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'noticias.update.html'
                    }
                }
            }).state('noticiaDetail',{
                url:'/noticias/:noticiaId/detail',
                param: {
                    noticiaId: null
                },
                views: {
                    'mainView': {
                        controller: 'noticiasCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'noticias.detail.html'
                    }
                }
            });
        }]);

})(window.angular);


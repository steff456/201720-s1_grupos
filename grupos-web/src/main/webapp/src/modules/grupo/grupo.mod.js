/*
 * Modulo que guarda los estados de un grupo
 */
(function (ng) {
    var mod = ng.module("grupoModule", []);
    mod.config(['$stateProvider', function ($stateProvider) {
            //Paths útiles
            var basePath = 'src/modules/grupo/';
            
            //Estado general del que los demás heredan
            $stateProvider.state('grupos', {
                url: '/grupos',
                abstract: true,
                views: {
                    'mainView': {
                        templateUrl: basePath + 'grupos.html',
                        controller: 'grupoCtrl',
                        controllerAs: 'ctrl'
                    }
                },
                data: {
                    requireLogin: false,
                    roles: []
                }
            }).state('listaGrupos', {
                //Estado que muestra la lista de grupos
                url: '/list',
                parent: 'grupos',
                views: {
                    'listView': {
                        templateUrl: basePath + 'grupos.list.html'
                    }
                }
            }).state('grupoDetail', {
                //Estado que muestra un grupo detalladamente
                url: '/{grupoId:int}/detail',
                parent: 'grupos',
                param: {
                    grupoId: null
                },
                views: {
                    'detailView': {
                        templateUrl: basePath + 'grupos.detail.html',
                        controller: 'grupoCtrl',
                        controllerAs: 'ctrl'
                    }
                },
                data: {
                    requireLogin: false,
                    roles: []
                }
            }).state('grupoCreate', {
                //Estado que permite crear un grupo
                url: '/create',
                parent: 'grupos',
                views: {
                    'detailView': {
                        templateUrl: basePath + 'new/grupos.new.html',
                        controller: 'grupoNewCtrl'
                    }
                }
            }).state('grupoUpdate', {
                //Estado que permite actualizar un grupo
                url: '/update/{grupoId:int}',
                parent: 'grupos',
                param: {
                    grupoId: null
                },
                views: {
                    'detailView': {
                        templateUrl: basePath + 'new/grupos.new.html',
                        controller: 'grupoUpdateCtrl'
                    }
                }
            }).state('grupoDelete', {
                //Estado que permite borrar un grupo
                url: '/delete/{grupoId:int}',
                parent: 'grupos',
                param: {
                    grupoId: null
                },
                views: {
                    'detailView': {
                        templateUrl: basePath + 'delete/grupos.delete.html',
                        controller: 'grupoDeleteCtrl'
                    }
                }
            });
        }]);
})(window.angular);

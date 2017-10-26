(function (ng) {
var mod = ng.module("multimediaModule", ["noticiasModule","ui.router"]);
    mod.constant("multimediaContext", "multimedia");
    mod.constant("noticiaContext","Stark/usuarios/1/noticias");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/multimedia/';
            $urlRouterProvider.otherwise("/multimediaList");
            
            $stateProvider.state('noticiaNoEditableMultimediaList', {
                url: '/multimedia',
                parent: 'noticiaDetail',
                views: {
                    'noticiaMultimediaView': {
                        controller: 'multimediaCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'multimediaNoEditable.list.html'
                    }
                }
            }).state('noticiaMultimediaList', {
                url: '/multimedia/editable',
                parent: 'noticiaDetail',
                views: {
                    'noticiaMultimediaView': {
                        controller: 'multimediaCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'multimedia.list.html'
                    }
                }
            }).state('noticiaMultimediaCreate', {
                url: '/multimedia/create',
                parent:'noticiaDetail',
                views: {
                    'multimediaCreate': {
                        controller: 'multimediaCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'multimedia.create.html'
                    }
                }

            }).state('noticiaMultimediaEdit', {
                url: '/multimedia/:multimediaLink',
                parent:'noticiaDetail',
                param: {
                    multimediaLink:null
                },
                views: {
                    'multimediaCreate': {
                        controller: 'multimediaCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'multimedia.create.html'
                    }
                }
            }).state('blogMultimediaList', {
                url: '/multimedia/editable',
                parent: 'blodDetail',
                views: {
                    'childrenView': {
                        controller: 'multimediaCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'multimedia.list.html'
                    }
                }
            }).state('blogMultimediaCreate', {
                url: '/multimedia/create',
                parent:'blogDetail',
                views: {
                    'multimediaCreate': {
                        controller: 'multimediaCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'multimedia.create.html'
                    }
                }

            }).state('blogMultimediaEdit', {
                url: '/multimedia/:multimediaLink',
                parent:'blogDetail',
                param: {
                    multimediaLink:null
                },
                views: {
                    'multimediaCreate': {
                        controller: 'multimediaCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'multimedia.create.html'
                    }
                }
            });
        }]);

})(window.angular);


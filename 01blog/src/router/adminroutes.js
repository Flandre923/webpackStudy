const AdminHome = () => import("../views/admin/Home/AdminHome")
const Anime = () => import("../views/admin/anime/Anime")
const EditArticle = () => import("../views/admin/editarticle/EditArticle")
const Friends = () => import("../views/admin/friends/Friends")
const AlterArticle = () => import("../views/admin/alterarticle/AlterArticle")
const Tags = () => import("../views/admin/tags/Tags")

export  const admin_routes = [
    {
        path: '/admin/home',
        name:'adminindex',
        component:AdminHome,
        meta:{
            title:'后台首页'
        }
    },
    {
        path: '/admin/anime',
        name:'Anime',
        component:Anime,
        meta:{
            title:'管理番剧'
        }
    },
    {
        path: '/admin/editarticle/:blogId',
        name:'EditArticle',
        component:EditArticle,
        meta:{
            title:'编辑博客'
        }
    },
    {
        path: '/admin/editarticle/',
        name:'EditArticle',
        component:EditArticle,
        meta:{
            title:'编辑博客'
        }
    },
    {
        path: '/admin/friends',
        name:'friends',
        component:Friends,
        meta:{
            title:'管理友人帐'
        }
    },
    {
        path: '/admin/alterarticle',
        name:'AlterArticle',
        component:AlterArticle,
        meta:{
            title:'管理文章'
        }
    },
    {
        path: '/admin/tags',
        name:'Tags',
        component:Tags,
        meta:{
            title:'管理标签'
        }
    },
]


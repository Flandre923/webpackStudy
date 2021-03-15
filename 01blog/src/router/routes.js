const Home = () => import("../views/home/Home")
const Blog = () => import("../views/blog/Blog")
const Anime = () => import("../views/anime/Anime")
const Friends = () => import("../views/friends/Friends")
const About = () => import("../views/about/about")


export const index_routes_children = [
    {
        path:'/home',
        name:'home',
        component:Home,
        meta:{
            title:'首页'
        }
    },
    {
        path: '/blog',
        name:'blog',
        component:Blog,
        meta:{
            title:'博客归档和标签'
        }
    },
    {
        path: '/anime',
        name: 'anime',
        component: Anime,
        meta: {
            title: '番剧'
        },
    },
    {
        path: '/friends',
        name:'friends',
        component:Friends,
        meta:{
            title:'友人帐'
        }
    },
    {
        path: '/about',
        name:'about',
        component:About,
        meta:{
            title:'关于我'
        }
    }
]
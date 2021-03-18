const Photo =()=> import("../views/photo/Photo")
const Home = () => import("../views/home/Home")
const Blog = () => import("../views/blog/Blog")
const Anime = () => import("../views/anime/Anime")
const Friends = () => import("../views/friends/Friends")
const About = () => import("../views/about/about")
const SearchContent = () => import("../views/SearchContent")
const BlogContent = () => import("../views/BlogContent")


export const index_routes_children = [
    {
        path:'/blog/:blogId',
        name:'博客详情页',
        component:BlogContent,
        meta:{
            title:'博客详情'
        }
    },
    {
        path:'/search/:search',
        name:'search',
        component:SearchContent,
        meta:{
            title:'搜索页面'
        }
    },
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
    },
    {
        path: '/photo',
        name:'Photo',
        component:Photo,
        meta:{
            title:'图片'
        }
    },
]
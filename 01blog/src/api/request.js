import axios from 'axios'

export function request(config){

    const instance = axios.create({
        baseURL:'http://localhost:8090',
        timeout:5000
    })
    //axios的拦截器
    // 请求拦截
    instance.interceptors.request.use(config=>{
        return config
    }, err=>{

    })

    //响应拦截
    instance.interceptors.response.use(res=>{
        return res.data
    },err=>{
        console.log(err)
    })
    return instance(config)
}
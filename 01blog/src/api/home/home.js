import {request} from "../request";
export function getBlogs(){
    return request({
        url:'/index'
    })
}
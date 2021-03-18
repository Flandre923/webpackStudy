import {request} from "../request";
export function get_tags(){
    return request({
        url:'/blog/tags'
    })
}

export function get_blogs_date(){
    return request({
        url:'/blog/artdate'
    })
}


export function submit_blogs(blog){
    return request({
        url:'/admin/blog',
        method:'post',
        data:blog
    })
}
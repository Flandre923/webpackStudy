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
import {request} from "../request"
export function get_animes(){
    return request({
        url:"/anime/anime",
    })
}
import {request} from "../request"
export function get_friends(){
    return request({
        url:"/friends/fri",
    })
}
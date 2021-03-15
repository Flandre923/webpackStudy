import {request} from "../../request";
export function login(user){
    return request({
        url:'/login',
        method:'post',
        params:user
    })
}
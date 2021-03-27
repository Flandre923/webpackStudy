import {request} from "../request";
export function getBlogs(page){
    return request({
        url:'/index',
        method:"get",
        params:{
            page_size : page.page_size,
            current : page.current,
        }
    })
}
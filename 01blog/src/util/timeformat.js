import monent from 'moment'

export function timefomat(date){
    return monent(date).format("YYYY-MM-DD HH:mm:ss")
}
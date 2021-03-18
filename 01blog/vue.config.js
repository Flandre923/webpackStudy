let proxyObj={

}
proxyObj['/']={
    //webSocket
    ws:false,
    //目标地址
    target:'http://localhost:8090',
    // 发送请求的地址更改为8090
    changeOrigin:true,
    //不重写请求地址
    pathReWrihe:{
        '^/':'/'
    }

}

module.exports = {
    devServer: {
        host:'localhost',
        port:8081,
        proxy:proxyObj,
        disableHostCheck: true
    }
}
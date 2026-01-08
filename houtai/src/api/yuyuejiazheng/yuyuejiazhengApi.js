import request from '@/utils/request';
// list
export const yuyuejiazhengList = (params) => {
    return request({
        url: '/yuyuejiazheng/page',
        method: 'post',
        data: params,
    })
};
export const yuyuejiazhengDetail = (id) => {
    return request({
        url: '/yuyuejiazheng/'+id,
        method: 'get',
    })
};
// add
export const yuyuejiazhengSave = (params) => {
    return request({
        url: '/yuyuejiazheng',
        method: 'post',
        data: params,
    })
};
// updt
export const yuyuejiazhengEdit = (params) => {
    return request({
        url: '/yuyuejiazheng',
        method: 'put',
        data: params,
    })
};
// delete
export const yuyuejiazhengDelete = (id) => {
    return request({
        url: '/yuyuejiazheng/'+id,
        method: 'delete',
    })
};
// pldel
export const yuyuejiazhengDeleteList = (yuyuejiazhengs) => {
    return request({
        url: '/yuyuejiazheng/deleteList',
        data:{list:yuyuejiazhengs},
        method: 'post',
    })
};
// all
export const yuyuejiazhengAllList = () => {
    return request({
        url: '/yuyuejiazheng',
        method: 'get',
    })
};

export const yuyuejiazheng_tj_leibie = () => {return request({url: '/yuyuejiazheng/yuyuejiazheng_tj_leibie',method: 'get',})};export const yuyuejiazheng_tj_mingzi = () => {return request({url: '/yuyuejiazheng/yuyuejiazheng_tj_mingzi',method: 'get',})};
import request from '@/utils/request';
// list
export const fuwupingjiaList = (params) => {
    return request({
        url: '/fuwupingjia/page',
        method: 'post',
        data: params,
    })
};
export const fuwupingjiaDetail = (id) => {
    return request({
        url: '/fuwupingjia/'+id,
        method: 'get',
    })
};
// add
export const fuwupingjiaSave = (params) => {
    return request({
        url: '/fuwupingjia',
        method: 'post',
        data: params,
    })
};
// updt
export const fuwupingjiaEdit = (params) => {
    return request({
        url: '/fuwupingjia',
        method: 'put',
        data: params,
    })
};
// delete
export const fuwupingjiaDelete = (id) => {
    return request({
        url: '/fuwupingjia/'+id,
        method: 'delete',
    })
};
// pldel
export const fuwupingjiaDeleteList = (fuwupingjias) => {
    return request({
        url: '/fuwupingjia/deleteList',
        data:{list:fuwupingjias},
        method: 'post',
    })
};
// all
export const fuwupingjiaAllList = () => {
    return request({
        url: '/fuwupingjia',
        method: 'get',
    })
};

export const fuwupingjia_tj_gonghao = () => {return request({url: '/fuwupingjia/fuwupingjia_tj_gonghao',method: 'get',})};

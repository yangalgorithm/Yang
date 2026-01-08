import request from '@/utils/request';
// list
export const fuwuleibieList = (params) => {
    return request({
        url: '/fuwuleibie/page',
        method: 'post',
        data: params,
    })
};
export const fuwuleibieDetail = (id) => {
    return request({
        url: '/fuwuleibie/'+id,
        method: 'get',
    })
};
// add
export const fuwuleibieSave = (params) => {
    return request({
        url: '/fuwuleibie',
        method: 'post',
        data: params,
    })
};
// updt
export const fuwuleibieEdit = (params) => {
    return request({
        url: '/fuwuleibie',
        method: 'put',
        data: params,
    })
};
// delete
export const fuwuleibieDelete = (id) => {
    return request({
        url: '/fuwuleibie/'+id,
        method: 'delete',
    })
};
// pldel
export const fuwuleibieDeleteList = (fuwuleibies) => {
    return request({
        url: '/fuwuleibie/deleteList',
        data:{list:fuwuleibies},
        method: 'post',
    })
};
// all
export const fuwuleibieAllList = () => {
    return request({
        url: '/fuwuleibie',
        method: 'get',
    })
};


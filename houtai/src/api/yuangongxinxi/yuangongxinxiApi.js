import request from '@/utils/request';
// list
export const yuangongxinxiList = (params) => {
    return request({
        url: '/yuangongxinxi/page',
        method: 'post',
        data: params,
    })
};
export const yuangongxinxiDetail = (id) => {
    return request({
        url: '/yuangongxinxi/'+id,
        method: 'get',
    })
};
// add
export const yuangongxinxiSave = (params) => {
    return request({
        url: '/yuangongxinxi',
        method: 'post',
        data: params,
    })
};
// updt
export const yuangongxinxiEdit = (params) => {
    return request({
        url: '/yuangongxinxi',
        method: 'put',
        data: params,
    })
};
// delete
export const yuangongxinxiDelete = (id) => {
    return request({
        url: '/yuangongxinxi/'+id,
        method: 'delete',
    })
};
// pldel
export const yuangongxinxiDeleteList = (yuangongxinxis) => {
    return request({
        url: '/yuangongxinxi/deleteList',
        data:{list:yuangongxinxis},
        method: 'post',
    })
};
// all
export const yuangongxinxiAllList = () => {
    return request({
        url: '/yuangongxinxi',
        method: 'get',
    })
};
export const yuangongxinxiUpdatePassword = (params) =>{ return request({ url: `/yuangongxinxi/updatePassword`, method: 'put',data: {...params,mima:params.password}, })};

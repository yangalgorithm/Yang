import request from '@/utils/request';
// list
export const jiazhengfuwuList = (params) => {
    return request({
        url: '/jiazhengfuwu/page',
        method: 'post',
        data: params,
    })
};
export const jiazhengfuwuDetail = (id) => {
    return request({
        url: '/jiazhengfuwu/'+id,
        method: 'get',
    })
};
// add
export const jiazhengfuwuSave = (params) => {
    return request({
        url: '/jiazhengfuwu',
        method: 'post',
        data: params,
    })
};
// updt
export const jiazhengfuwuEdit = (params) => {
    return request({
        url: '/jiazhengfuwu',
        method: 'put',
        data: params,
    })
};
// delete
export const jiazhengfuwuDelete = (id) => {
    return request({
        url: '/jiazhengfuwu/'+id,
        method: 'delete',
    })
};
// pldel
export const jiazhengfuwuDeleteList = (jiazhengfuwus) => {
    return request({
        url: '/jiazhengfuwu/deleteList',
        data:{list:jiazhengfuwus},
        method: 'post',
    })
};
// all
export const jiazhengfuwuAllList = () => {
    return request({
        url: '/jiazhengfuwu',
        method: 'get',
    })
};


import request from '@/utils/request'

// 查询账号列表
export function listAccount(query) {
  return request({
    url: '/employee/account/list',
    method: 'get',
    params: query
  })
}

// 查询账号详细
export function getAccount(id) {
  return request({
    url: '/employee/account/' + id,
    method: 'get'
  })
}

// 新增账号
export function addAccount(data) {
  return request({
    url: '/employee/account',
    method: 'post',
    data: data
  })
}

// 修改账号
export function updateAccount(data) {
  return request({
    url: '/employee/account',
    method: 'put',
    data: data
  })
}

// 删除账号
export function delAccount(id) {
  return request({
    url: '/employee/account/' + id,
    method: 'delete'
  })
}

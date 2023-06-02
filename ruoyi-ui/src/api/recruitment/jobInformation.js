import request from '@/utils/request'

// 查询职位信息列表
export function listJobInformation(query) {
  return request({
    url: '/recruitment/jobInformation/list',
    method: 'get',
    params: query
  })
}

// 查询职位信息详细
export function getJobInformation(positionId) {
  return request({
    url: '/recruitment/jobInformation/' + positionId,
    method: 'get'
  })
}

// 新增职位信息
export function addJobInformation(data) {
  return request({
    url: '/recruitment/jobInformation',
    method: 'post',
    data: data
  })
}

// 修改职位信息
export function updateJobInformation(data) {
  return request({
    url: '/recruitment/jobInformation',
    method: 'put',
    data: data
  })
}

// 删除职位信息
export function delJobInformation(positionId) {
  return request({
    url: '/recruitment/jobInformation/' + positionId,
    method: 'delete'
  })
}

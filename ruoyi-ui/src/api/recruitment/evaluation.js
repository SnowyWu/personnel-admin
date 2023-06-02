import request from '@/utils/request'

// 查询面试评价列表
export function listEvaluation(query) {
  return request({
    url: '/recruitment/evaluation/list',
    method: 'get',
    params: query
  })
}

// 查询面试评价详细
export function getEvaluation(evaluationId) {
  return request({
    url: '/recruitment/evaluation/' + evaluationId,
    method: 'get'
  })
}

// 新增面试评价
export function addEvaluation(data) {
  return request({
    url: '/recruitment/evaluation',
    method: 'post',
    data: data
  })
}

// 修改面试评价
export function updateEvaluation(data) {
  return request({
    url: '/recruitment/evaluation',
    method: 'put',
    data: data
  })
}

// 删除面试评价
export function delEvaluation(evaluationId) {
  return request({
    url: '/recruitment/evaluation/' + evaluationId,
    method: 'delete'
  })
}

-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('员工', '3', '1', 'employee', 'employee/employee/index', 1, 0, 'C', '0', '0', 'employee:employee:list', '#', 'admin', sysdate(), '', null, '员工菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('员工查询', @parentId, '1',  '#', '', 1, 0, 'F', '0', '0', 'employee:employee:query',        '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('员工新增', @parentId, '2',  '#', '', 1, 0, 'F', '0', '0', 'employee:employee:add',          '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('员工修改', @parentId, '3',  '#', '', 1, 0, 'F', '0', '0', 'employee:employee:edit',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('员工删除', @parentId, '4',  '#', '', 1, 0, 'F', '0', '0', 'employee:employee:remove',       '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('员工导出', @parentId, '5',  '#', '', 1, 0, 'F', '0', '0', 'employee:employee:export',       '#', 'admin', sysdate(), '', null, '');
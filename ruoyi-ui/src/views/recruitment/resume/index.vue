<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="应聘者姓名" prop="applicantName">
        <el-input
          v-model="queryParams.applicantName"
          placeholder="请输入应聘者姓名"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="性别" prop="gender">
        <el-select v-model="queryParams.gender" placeholder="请选择性别" clearable>
          <el-option
            v-for="dict in dict.type.sys_user_sex"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="联系方式" prop="contactInfo">
        <el-input
          v-model="queryParams.contactInfo"
          placeholder="请输入联系方式"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="籍贯" prop="nativePlace">
        <el-input
          v-model="queryParams.nativePlace"
          placeholder="请输入籍贯"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="学历" prop="education">
        <el-select v-model="queryParams.education" placeholder="请选择学历" clearable>
          <el-option
            v-for="dict in dict.type.educate"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="能力特长" prop="skills">
        <el-input
          v-model="queryParams.skills"
          placeholder="请输入能力特长"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="提交日期" prop="submitDate">
        <el-date-picker clearable
          v-model="queryParams.submitDate"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择提交日期">
        </el-date-picker>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['recruitment:resume:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['recruitment:resume:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['recruitment:resume:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['recruitment:resume:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="resumeList" @selection-change="handleSelectionChange" border="true">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="应聘者姓名" align="center" prop="applicantName" />
      <el-table-column label="性别" align="center" prop="gender">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.sys_user_sex" :value="scope.row.gender"/>
        </template>
      </el-table-column>
      <el-table-column label="联系方式" align="center" prop="contactInfo" />
      <el-table-column label="政治面貌" align="center" prop="politicalStatus" />
      <el-table-column label="籍贯" align="center" prop="nativePlace" />
      <el-table-column label="学历" align="center" prop="education">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.educate" :value="scope.row.education"/>
        </template>
      </el-table-column>
      <el-table-column label="工作经历" align="center" prop="workExperience" />
      <el-table-column label="能力特长" align="center" prop="skills" />
      <el-table-column label="工作意向" align="center" prop="jobIntentions" />
      <el-table-column label="提交日期" align="center" prop="submitDate" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.submitDate, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['recruitment:resume:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['recruitment:resume:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改简历信息对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="应聘者姓名" prop="applicantName">
          <el-input v-model="form.applicantName" placeholder="请输入应聘者姓名" />
        </el-form-item>
        <el-form-item label="性别" prop="gender">
          <el-select v-model="form.gender" placeholder="请选择性别">
            <el-option
              v-for="dict in dict.type.sys_user_sex"
              :key="dict.value"
              :label="dict.label"
              :value="dict.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="联系方式" prop="contactInfo">
          <el-input v-model="form.contactInfo" placeholder="请输入联系方式" />
        </el-form-item>
        <el-form-item label="政治面貌" prop="politicalStatus">
          <el-input v-model="form.politicalStatus" placeholder="请输入政治面貌" />
        </el-form-item>
        <el-form-item label="籍贯" prop="nativePlace">
          <el-input v-model="form.nativePlace" placeholder="请输入籍贯" />
        </el-form-item>
        <el-form-item label="学历" prop="education">
          <el-select v-model="form.education" placeholder="请选择学历">
            <el-option
              v-for="dict in dict.type.educate"
              :key="dict.value"
              :label="dict.label"
              :value="dict.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="工作经历" prop="workExperience">
          <el-input v-model="form.workExperience" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="能力特长" prop="skills">
          <el-input v-model="form.skills" placeholder="请输入能力特长" />
        </el-form-item>
        <el-form-item label="工作意向" prop="jobIntentions">
          <el-input v-model="form.jobIntentions" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="提交日期" prop="submitDate">
          <el-date-picker clearable
            v-model="form.submitDate"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择提交日期">
          </el-date-picker>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>

  </div>


</template>

<script>
import { listResume, getResume, delResume, addResume, updateResume } from "@/api/recruitment/resume";


export default {
  name: "Resume",
  dicts: ['educate', 'sys_user_sex'],
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 简历信息表格数据
      resumeList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        applicantName: null,
        gender: null,
        contactInfo: null,
        politicalStatus: null,
        nativePlace: null,
        education: null,
        workExperience: null,
        skills: null,
        jobIntentions: null,
        submitDate: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        applicantName: [
          { required: true, message: "应聘者姓名不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询简历信息列表 */
    getList() {
      this.loading = true;
      listResume(this.queryParams).then(response => {
        this.resumeList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        resumeId: null,
        applicantName: null,
        gender: null,
        contactInfo: null,
        politicalStatus: null,
        nativePlace: null,
        education: null,
        workExperience: null,
        skills: null,
        jobIntentions: null,
        submitDate: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.resumeId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加简历信息";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const resumeId = row.resumeId || this.ids
      getResume(resumeId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改简历信息";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.resumeId != null) {
            updateResume(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addResume(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const resumeIds = row.resumeId || this.ids;
      this.$modal.confirm('是否确认删除简历信息编号为"' + resumeIds + '"的数据项？').then(function() {
        return delResume(resumeIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('recruitment/resume/export', {
        ...this.queryParams
      }, `resume_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>

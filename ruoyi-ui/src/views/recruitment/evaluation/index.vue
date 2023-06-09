<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="面试担当" prop="interviewer">
        <el-input v-model="queryParams.interviewer" placeholder="请输入面试担当" clearable @keyup.enter.native="handleQuery" />
      </el-form-item>
      <el-form-item label="面试日期" prop="interviewDate">
        <el-date-picker clearable v-model="queryParams.interviewDate" type="date" value-format="yyyy-MM-dd"
          placeholder="请选择面试日期">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="面试结果" prop="interviewResult">
        <el-select v-model="queryParams.interviewResult" placeholder="请选择面试结果" clearable>
          <el-option v-for="dict in dict.type.interview_result" :key="dict.value" :label="dict.label"
            :value="dict.value" />
        </el-select>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button type="success" plain icon="el-icon-edit" size="mini" :disabled="single" @click="handleUpdate"
          v-hasPermi="['recruitment:evaluation:edit']">修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button type="danger" plain icon="el-icon-delete" size="mini" :disabled="multiple" @click="handleDelete"
          v-hasPermi="['recruitment:evaluation:remove']">删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button type="warning" plain icon="el-icon-download" size="mini" @click="handleExport"
          v-hasPermi="['recruitment:evaluation:export']">导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="evaluationList" @selection-change="handleSelectionChange" border="true">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="面试人姓名" align="center" prop="applicantName" />
      <el-table-column label="面试担当" align="center" prop="interviewer" />
      <el-table-column label="面试日期" align="center" prop="interviewDate" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.interviewDate, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="面试结果" align="center" prop="interviewResult">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.interview_result" :value="scope.row.interviewResult" />
        </template>
      </el-table-column>
      <el-table-column label="评价内容" align="center">
        <template slot-scope="scope">
          <div class="contentClass">{{ delTag(scope.row.evaluationContent) }}</div>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button size="mini" type="text" icon="el-icon-edit" @click="handleUpdate(scope.row)"
            v-hasPermi="['recruitment:evaluation:edit']">修改</el-button>
          <el-button size="mini" type="text" icon="el-icon-delete" @click="handleDelete(scope.row)"
            v-hasPermi="['recruitment:evaluation:remove']">删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <pagination v-show="total > 0" :total="total" :page.sync="queryParams.pageNum" :limit.sync="queryParams.pageSize"
      @pagination="getList" />

    <!-- 添加或修改面试评价对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="面试担当" prop="interviewer">
          <el-input v-model="form.interviewer" placeholder="请输入面试担当" />
        </el-form-item>
        <el-form-item label="面试日期" prop="interviewDate">
          <el-date-picker clearable v-model="form.interviewDate" type="date" value-format="yyyy-MM-dd"
            placeholder="请选择面试日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="面试结果" prop="interviewResult">
          <el-select v-model="form.interviewResult" placeholder="请选择面试结果">
            <el-option v-for="dict in dict.type.interview_result" :key="dict.value" :label="dict.label"
              :value="parseInt(dict.value)"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="评价内容">
          <editor v-model="form.evaluationContent" :min-height="192" />
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
import { listEvaluation, getEvaluation, delEvaluation, addEvaluation, updateEvaluation } from "@/api/recruitment/evaluation";

export default {
  name: "Evaluation",
  dicts: ['interview_result'],
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
      // 面试评价表格数据
      evaluationList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        resumeId: null,
        interviewer: null,
        interviewDate: null,
        interviewResult: null,
        evaluationContent: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询面试评价列表 */
    getList() {
      this.loading = true;
      listEvaluation(this.queryParams).then(response => {
        this.evaluationList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
      console.log(this.evaluationList)
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        evaluationId: null,
        resumeId: null,
        interviewer: null,
        interviewDate: null,
        interviewResult: null,
        evaluationContent: null
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
      this.ids = selection.map(item => item.evaluationId)
      this.single = selection.length !== 1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加面试评价";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const evaluationId = row.evaluationId || this.ids
      getEvaluation(evaluationId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改面试评价";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.evaluationId != null) {
            updateEvaluation(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addEvaluation(this.form).then(response => {
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
      const evaluationIds = row.evaluationId || this.ids;
      this.$modal.confirm('是否确认删除面试评价编号为"' + evaluationIds + '"的数据项？').then(function () {
        return delEvaluation(evaluationIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => { });
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('recruitment/evaluation/export', {
        ...this.queryParams
      }, `evaluation_${new Date().getTime()}.xlsx`)
    },
    //移除HTML标签
    delTag(str) {
      return str === null ? "" : str.replace(/<[^>]+>/g, "");

    },
  }
};
</script>

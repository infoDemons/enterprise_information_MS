<template>
    <el-container>
        <el-header style="margin-top: 25px; text-align: left">
            <el-input
                    placeholder="请输入商标名称"
                    v-model="trademarkToSearch.name" style="width: 350px; margin-right: 15px">
            </el-input>
            <el-button type="info" size="medium" style="margin-left: 15px" @click="search_direct">按商标搜</el-button>
            <el-button type="info" size="medium" style="margin-left: 15px" @click="search_by_applicant">按申请人搜</el-button>
            <el-button type="info" size="medium" style="margin-left: 15px" @click="search_by_registration">按注册号搜</el-button>
        </el-header>

        <el-main class="with_shadow">
            <el-table
                    ref="multipleTable"
                    :data="trademark"
                    tooltip-effect="dark"
                    style="width: 100%;"
                    max-height="510">

                <el-table-column
                        prop="trademarkId"
                        label="商标id"
                        width="100"
                        align="left">
                </el-table-column>

                <el-table-column
                        prop="trademarkName"
                        label="商标名称"
                        width="150"
                        align="left">
                </el-table-column>

                <el-table-column
                        prop="applicantName"
                        label="申请人"
                        width="150"
                        align="left">
                </el-table-column>

                <el-table-column
                        prop="registrationNumber"
                        label="注册号"
                        width="150"
                        align="left">
                </el-table-column>

                <el-table-column label="操作" width="220" align="left">
                    <template slot-scope="scope">
                        <el-button size="small" type="danger" icon="el-icon-delete"
                                   @click="delete_trademark_dialog(scope.row)">
                        </el-button>
                        <el-button size="small" type="warning" icon="el-icon-edit"
                                   @click="modify_trademark_dialog(scope.row)">
                        </el-button>
                    </template>
                </el-table-column>

            </el-table>
        </el-main>

        <el-dialog title="删除后不可恢复，确定要删除吗？" :visible.sync="dialogDeleteConfirmVisible">
            <el-button type="warning" @click="delete_trademark">确 定</el-button>
            <el-button type="info" @click="dialogDeleteConfirmVisible = false">取 消</el-button>
        </el-dialog>

        <el-dialog title="更改商标详情" :visible.sync="dialogModifyVisible">
            <el-form :model="form">
                <el-form-item label="商标id:" :label-width="formLabelWidth">
                    <el-input v-model="form.trademarkId" autocomplete="off"/>
                </el-form-item>
                <el-form-item label="商标名称:" :label-width="formLabelWidth">
                    <el-input v-model="form.trademarkName" autocomplete="off"/>
                </el-form-item>
                <el-form-item label="申请人:" :label-width="formLabelWidth">
                    <el-input v-model="form.applicantName" autocomplete="off"/>
                </el-form-item>
                <el-form-item label="地址:" :label-width="formLabelWidth">
                    <el-input v-model="form.trademarkAddress" autocomplete="off"/>
                </el-form-item>
                <el-form-item label="注册号:" :label-width="formLabelWidth">
                    <el-input v-model="form.registrationNumber" autocomplete="off"/>
                </el-form-item>
                <el-form-item label="类别:" :label-width="formLabelWidth">
                    <el-input v-model="form.classification" autocomplete="off"/>
                </el-form-item>
                <el-form-item label="状态:" :label-width="formLabelWidth">
                    <el-input v-model="form.trademarkStatus" autocomplete="off"/>
                </el-form-item>
                <el-form-item label="网址:" :label-width="formLabelWidth">
                    <el-input v-model="form.trademarkProcess" autocomplete="off"/>
                </el-form-item>
            </el-form>
            <div slot="footer" class="dialog-footer">
                <el-button type="primary" @click="modify_trademark">确定</el-button>
            </div>
        </el-dialog>

    </el-container>
</template>

<script>
    export default {
        name: "TrademarkSearch",
        data() {
            return {
                trademark: [],
                dialogFormVisible: false,
                form: {
                    trademarkId: 0,
                    trademarkName: '',
                    applicantName: '',
                    trademarkAddress: '',
                    registrationNumber: '',
                    classification: '',
                    trademarkStatus: '',
                    trademarkProcess: '',
                },
                formLabelWidth: '100px',
                trademarkToSearch: {
                    name: '',
                },
                dialogDeleteConfirmVisible: false,
                dialogModifyVisible: false,
                trademarkToDelete: {
                    id: 0
                },
                last_search_direct: false
            }
        },
        methods: {
            search_direct() {
                if (this.trademarkToSearch.name === '') {
                    this.$message({type: 'error', message: '请先输入'});
                    return;
                }
                let _this = this;
                this.getRequest("/trademark/trademarkName/" + _this.trademarkToSearch.name).then(resp => {
                    if (resp && resp.status === 200) {
                        if (resp.data.length === 0) {
                            _this.trademark = [];
                            _this.$message({type: 'error', message: '没有结果'});
                        } else if (resp.data.length < 999) {
                            _this.trademark = resp.data;
                        } else {
                            _this.trademark = [];
                            _this.$message({type: 'error', message: '搜索目标过于泛化 请尝试更精确的搜索'});
                        }
                    }
                });
            },
            search_by_applicant() {
                if (this.trademarkToSearch.name === '') {
                    this.$message({type: 'error', message: '请先输入'});
                    return;
                }
                this.trademarkToSearch.name = false;
                let _this = this;
                this.getRequest("/trademark/applicantName/" + _this.trademarkToSearch.name).then(resp => {
                    if (resp && resp.status === 200) {
                        if (resp.data.length === 0) {
                            _this.trademark = [];
                            _this.$message({type: 'error', message: '没有结果'});
                        } else if (resp.data.length < 1999) {
                            _this.trademark = resp.data;
                        } else {
                            _this.trademark = [];
                            _this.$message({type: 'error', message: '搜索目标过于泛化 请尝试更精确的搜索'});
                        }
                    }
                });
            },
            search_by_registration() {
                if (this.trademarkToSearch.name === '') {
                    this.$message({type: 'error', message: '请先输入'});
                    return;
                }
                this.trademarkToSearch.name = false;
                let _this = this;
                this.getRequest("/trademark/registration/" + _this.trademarkToSearch.name).then(resp => {
                    if (resp && resp.status === 200) {
                        if (resp.data.length === 0) {
                            _this.trademark = [];
                            _this.$message({type: 'error', message: '没有结果'});
                        } else if (resp.data.length < 1999) {
                            _this.trademark = resp.data;
                        } else {
                            _this.trademark = [];
                            _this.$message({type: 'error', message: '搜索目标过于泛化 请尝试更精确的搜索'});
                        }
                    }
                });
            },
            itemClick(row) {
                this.form.trademarkId = row.trademarkId;
                this.form.trademarkName = row.trademarkName;
                this.form.applicantName = row.applicantName;
                this.form.trademarkAddress = row.trademarkAddress;
                this.form.registrationNumber = row.registrationNumber;
                this.form.classification = row.classification;
                this.form.trademarkStatus = row.trademarkStatus;
                this.form.trademarkProcess = row.trademarkProcess;
                this.dialogFormVisible = true;
            },
            delete_trademark_dialog(row) {
                this.trademarkToDelete.id = row.trademarkId;
                this.dialogDeleteConfirmVisible = true;
            },
            delete_trademark() {
                let _this = this;
                this.postRequest("/trademark/delete", {"trademarkId": _this.trademarkToDelete.id}).then(resp => {
                    if (resp && resp.status === 200) {
                        if (this.trademarkToSearch.name === true) {
                            _this.search_direct();
                        } else {
                            _this.search_by_applicant();
                        }
                        _this.dialogDeleteConfirmVisible = false;
                        _this.$message({type: 'success', message: '删除成功'});
                    } else {
                        _this.dialogDeleteConfirmVisible = false;
                        _this.$message({type: 'error', message: '删除失败'});
                    }
                });
            },
            modify_trademark_dialog(row) {
                this.form.trademarkId = row.trademarkId;
                this.form.trademarkName = row.trademarkName;
                this.form.applicantName = row.applicantName;
                this.form.trademarkAddress = row.trademarkAddress;
                this.form.registrationNumber = row.registrationNumber;
                this.form.classification = row.classification;
                this.form.trademarkStatus = row.trademarkStatus;
                this.form.trademarkProcess = row.trademarkProcess;
                this.dialogModifyVisible = true;
            },
            modify_trademark() {
                let _this = this;
                this.postRequest("/trademark/modify", {
                    "trademarkId": _this.form.trademarkId,
                    "trademarkName": _this.form.trademarkName,
                    "applicantName": _this.form.applicantName,
                    "trademarkAddress": _this.form.trademarkAddress,
                    "registrationNumber": _this.form.registrationNumber,
                    "classification": _this.form.classification,
                    "trademarkStatus": _this.form.trademarkStatus,
                    "trademarkProcess": _this.form.trademarkProcess,
                }).then(resp => {
                    if (resp && resp.status === 200) {
                        if (this.trademarkToSearch.name === true) {
                            _this.search_direct();
                        } else {
                            _this.search_by_applicant();
                        }
                        _this.dialogModifyVisible = false;
                        _this.$message({type: 'success', message: '修改成功'});
                    } else {
                        _this.dialogUpdateVisible = false;
                        _this.$message({type: 'error', message: '修改失败'});
                    }
                });
            },
        },
    }
</script>

<style scoped>
    .el-input {
        width: 500px;
    }
</style>
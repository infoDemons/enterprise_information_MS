<template>
    <el-container>
        <el-header style="margin-top: 25px; text-align: left">
            <el-input
                    placeholder="请输入要查询变更信息的企业名称"
                    v-model="enterpriseChangeToSearch.name" style="width: 350px; margin-right: 15px">
            </el-input>
            <el-button type="info" size="medium" style="margin-left: 15px" @click="search_direct">按企业搜索</el-button>
            <el-button type="primary" size="medium" style="margin-left: 15px" @click="addFormVisible=true">增加变更</el-button>
        </el-header>

        <el-main class="with_shadow">
            <el-table
                    ref="multipleTable"
                    :data="enterpriseChange"
                    tooltip-effect="dark"
                    style="width: 100%;"
                    max-height="510">

                <el-table-column
                        prop="enterpriseInformationChangeId"
                        label="变更信息id"
                        width="100"
                        align="left">
                </el-table-column>

                <el-table-column
                        prop="enterpriseId"
                        label="企业id"
                        width="100"
                        align="left">
                </el-table-column>

                <el-table-column
                        prop="enterpriseName"
                        label="企业名称"
                        align="left">
                </el-table-column>

                <el-table-column
                        prop="informationChangeDate"
                        label="变更日期"
                        align="left">
                </el-table-column>

                <el-table-column
                        prop="informationChangeType"
                        label="变更项目"
                        align="left">
                </el-table-column>

                <el-table-column
                        prop="informationBefore"
                        label="变更前"
                        align="left">
                </el-table-column>

                <el-table-column
                        prop="informationAfter"
                        label="变更后"
                        align="left">
                </el-table-column>

                <el-table-column
                        prop="createDate"
                        label="创建日期"
                        align="left">
                </el-table-column>

                <el-table-column label="操作" width="220" align="left">
                    <template slot-scope="scope">
                        <el-button size="small" type="danger" icon="el-icon-delete"
                                   @click="delete_enterprise_change_dialog(scope.row)">
                        </el-button>
                        <el-button size="small" type="warning" icon="el-icon-edit"
                                   @click="modify_enterprise_change_dialog(scope.row)">
                        </el-button>
                    </template>
                </el-table-column>

            </el-table>
        </el-main>

        <el-dialog title="删除后不可恢复，确定要删除吗？" :visible.sync="dialogDeleteConfirmVisible">
            <el-button type="warning" @click="delete_enterprise_change">确 定</el-button>
            <el-button type="info" @click="dialogDeleteConfirmVisible=false">取 消</el-button>
        </el-dialog>

        <el-dialog title="更改企业变更信息" :visible.sync="dialogModifyFormVisible">
            <el-form>
                <el-form-item label="变更日期:">
                    <el-input v-model="form.informationChangeDate" autocomplete="off"/>
                </el-form-item>
                <el-form-item label="变更项目:">
                    <el-input v-model="form.informationChangeType" autocomplete="off"/>
                </el-form-item>
                <el-form-item label="变更前:">
                    <el-input v-model="form.informationBefore" autocomplete="off"/>
                </el-form-item>
                <el-form-item label="变更后:">
                    <el-input v-model="form.informationAfter" autocomplete="off"/>
                </el-form-item>
                <el-form-item label="创建日期:">
                    <el-input v-model="form.createDate" autocomplete="off"/>
                </el-form-item>
            </el-form>
            <div slot="footer" class="dialog-footer">
                <el-button type="primary" @click="modify_enterprise_change">确定</el-button>
            </div>
        </el-dialog>

        <el-dialog title="增加企业变更信息" :visible.sync="addFormVisible">
            <el-form>
                <el-form-item label="企业id:">
                    <el-input v-model="form2.enterpriseId" autocomplete="off"/>
                </el-form-item>
                <el-form-item label="变更日期:">
                    <el-input v-model="form2.informationChangeDate" autocomplete="off"/>
                </el-form-item>
                <el-form-item label="变更项目:">
                    <el-input v-model="form2.informationChangeType" autocomplete="off"/>
                </el-form-item>
                <el-form-item label="变更前:">
                    <el-input v-model="form2.informationBefore" autocomplete="off"/>
                </el-form-item>
                <el-form-item label="变更后:">
                    <el-input v-model="form2.informationAfter" autocomplete="off"/>
                </el-form-item>
                <el-form-item label="创建日期:">
                    <el-input v-model="form2.createDate" autocomplete="off"/>
                </el-form-item>
            </el-form>
            <div slot="footer" class="dialog-footer">
                <el-button type="primary" @click="add_change">确定</el-button>
            </div>
        </el-dialog>

    </el-container>
</template>

<script>
    export default {
        name: "EnterpriseChangeManagement",
        data() {
            return {
                enterpriseChange: [],
                enterpriseChangeToSearch: {
                    name: '',
                },
                dialogDeleteConfirmVisible: false,
                dialogModifyFormVisible: false,
                addFormVisible: false,
                form: {
                    enterpriseInformationChangeId: '',
                    enterpriseId: '',
                    enterpriseName: '',
                    informationChangeDate: '',
                    informationChangeType: '',
                    informationBefore: '',
                    informationAfter: '',
                    createDate: '',
                },
                form2: {
                    enterpriseInformationChangeId: '',
                    enterpriseId: '',
                    enterpriseName: '',
                    informationChangeDate: '',
                    informationChangeType: '',
                    informationBefore: '',
                    informationAfter: '',
                    createDate: '',
                },
                formLabelWidth: '120px',
                enterpriseChangeToDelete: {
                    id: 0
                },
                last_search_direct: false
            }
        },
        methods: {
            search_direct() {
                if (this.enterpriseChangeToSearch.name === '') {
                    this.$message({type: 'error', message: '请先输入'});
                    return;
                }
                let _this = this;
                this.getRequest("/change/enterprise_name/" + _this.enterpriseChangeToSearch.name).then(resp => {
                    if (resp && resp.status === 200) {
                        if (resp.data.length === 0) {
                            _this.enterpriseChange = [];
                            _this.$message({type: 'error', message: '没有结果'});
                        } else if (resp.data.length < 999) {
                            _this.enterpriseChange = resp.data;
                        } else {
                            _this.enterpriseChange = [];
                            _this.$message({type: 'error', message: '搜索目标过于泛化 请尝试更精确的搜索'});
                        }

                    }
                });
            },
            delete_enterprise_change_dialog(row) {
                this.enterpriseChangeToDelete.id = row.enterpriseInformationChangeId;
                this.dialogDeleteConfirmVisible = true;
            },
            delete_enterprise_change() {
                let _this = this;
                this.postRequest("/change/delete", {"enterpriseInformationChangeId": _this.enterpriseChangeToDelete.id}).then(resp => {
                    if (resp && resp.status === 200) {
                        _this.search_direct();
                        _this.$message({type: 'success', message: '删除成功'});
                    } else {
                        _this.$message({type: 'error', message: '删除失败'});
                    }
                    _this.dialogDeleteConfirmVisible = false;
                });
            },
            modify_enterprise_change_dialog(row) {
                this.form.enterpriseInformationChangeId = row.enterpriseInformationChangeId;
                this.form.enterpriseId = row.enterpriseId;
                this.form.enterpriseName = row.enterpriseName;
                this.form.informationChangeDate = row.informationChangeDate;
                this.form.informationChangeType = row.informationChangeType;
                this.form.informationBefore = row.informationBefore;
                this.form.informationAfter = row.informationAfter;
                this.form.createDate = row.createDate;
                this.dialogModifyFormVisible = true;
            },
            modify_enterprise_change() {
                let _this = this;
                this.postRequest("/change/modify", {
                        "enterpriseInformationChangeId": _this.form.enterpriseInformationChangeId,
                        "enterpriseId": _this.form.enterpriseId,
                        "enterpriseName": _this.form.enterpriseName,
                        "informationChangeDate": _this.form.informationChangeDate,
                        "informationChangeType": _this.form.informationChangeType,
                        "informationBefore": _this.form.informationBefore,
                        "informationAfter": _this.form.informationAfter,
                        "createDate": _this.form.createDate,
                    }
                ).then(resp => {
                    if (resp && resp.status === 200) {
                        _this.search_direct();
                        _this.$message({type: 'success', message: '更改成功'});
                    } else {
                        _this.$message({type: 'error', message: '更改失败'});
                    }
                    _this.dialogModifyFormVisible = false;
                });
            },
            add_change() {
                let _this = this;
                this.postRequest("/change/add", {
                        "enterpriseId": _this.form2.enterpriseId,
                        "informationChangeDate": _this.form2.informationChangeDate,
                        "informationChangeType": _this.form2.informationChangeType,
                        "informationBefore": _this.form2.informationBefore,
                        "informationAfter": _this.form2.informationAfter,
                        "createDate": _this.form2.createDate,
                    }
                ).then(resp => {
                    if (resp && resp.status === 200) {
                        // _this.search_direct();
                        _this.$message({type: 'success', message: '添加成功'});
                    } else {
                        _this.$message({type: 'error', message: resp.msg});
                    }
                    _this.addFormVisible = false;
                });
            }
        },
    }
</script>

<style scoped>

</style>
